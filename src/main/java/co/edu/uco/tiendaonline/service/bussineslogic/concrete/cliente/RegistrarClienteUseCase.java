package co.edu.uco.tiendaonline.service.bussineslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.bussineslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.tiendaonline.service.dto.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.NombreCompletoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.NumeroTelefonoMovilClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public class RegistrarClienteUseCase implements UseCase<ClienteDomain> {

	private DAOFactory factoria;
	
	public RegistrarClienteUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ClienteDomain domain) {
		validarNoExistenciaMismoNombre(domain.getNombreCompleto());
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		validarNoExistenciaNumeroTelefonoMovil(domain.getNumeroTelefonoMovil());
		validarNoExistenciaIdentificacion(domain);
		validarExistenciaTipoIdentificacion(domain.getTipoIdentificacion().getId());
		domain = obtenerIdentificadorCliente(domain);
		registrar(domain);
	}
	
	private final ClienteDomain obtenerIdentificadorCliente(ClienteDomain domain) {
		Optional<ClienteEntity> optional;
		UUID uuid;
		
		do {
			uuid = UtilUUID.generarRandomUUID();
			optional = getClienteDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return ClienteDomain.crear(uuid, domain.getTipoIdentificacion(), domain.getIdentificacion(), domain.getNombreCompleto(), 
				domain.getCorreoElectronico(), domain.getNumeroTelefonoMovil(), domain.getFechaNacimiento());
	}
	
	private final void validarNoExistenciaMismoNombre(final NombreCompletoClienteDomain nombre) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null, nombre,
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()),
				NumeroTelefonoMovilClienteDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000101);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null,
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), correoElectronico,
				NumeroTelefonoMovilClienteDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000102);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDomain numeroTelefono) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null,
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), numeroTelefono,
				null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000103);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaIdentificacion(final ClienteDomain cliente) {
		final var domain = ClienteDomain.crear(null, TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), cliente.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()),
				NumeroTelefonoMovilClienteDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000104);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarExistenciaTipoIdentificacion(final UUID tipoIdentificacion) {
		Optional<TipoIdentificacionEntity> optional;
		optional = getTipoIdentificacionDAO().consultarPorId(tipoIdentificacion);
		
		if(!optional.isPresent()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000184);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void registrar(final ClienteDomain domain) {
		getClienteDAO().crear(ClienteEntityMapper.convertToEntity(domain));
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000099);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000100);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerclienteDAO();
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
}
