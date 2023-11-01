package co.edu.uco.tiendaonline.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final  class TipoIdentificacionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoIdentificacionController.class);
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDymmy() {
		return TipoIdentificacionDTO.crear();
	}
	
	@GetMapping
	public final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping ("/{id}")
	public final UUID consultarPorId(@PathVariable("id") UUID id) {
		return id;
	}
	
	@PostMapping
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatusCode codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación fue registrado exitosamente");
			logger.debug("Registrando tipos de identificacion");
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMesajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			logger.error(excepcion.getLocalizedMessage(),excepcion);;
		} catch (final Exception excepcion) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el tipo "
					+ "de identificación.");
			excepcion.printStackTrace();
			logger.error(excepcion.getLocalizedMessage());
			
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PutMapping
	public final TipoIdentificacionDTO modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
	
	@DeleteMapping("/{id}")
	public final UUID eliminar(@PathVariable("id") UUID id) {
		return id;
	}
}
