package co.edu.uco.tiendaonline.service.facade.concrete.cliente;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.enumerator.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.bussineslogic.concrete.cliente.ConsultarClienteUseCase;
import co.edu.uco.tiendaonline.service.bussineslogic.validator.concrete.cliente.ConsultarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.facade.FacadeFind;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.ClienteDTOMapper;

public final class ConsultarClienteFacade implements FacadeFind<ClienteDTO>{

	@Override
	public List<ClienteDTO> execute(final ClienteDTO dto) {
		final ClienteDomain domain = ClienteDTOMapper.convertToDomain(dto);
		ConsultarClienteValidator.ejecutar(domain);
		List<ClienteDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarClienteUseCase(daofactory);
			resultados = ClienteDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (TiendaOnlineException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000170);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}

