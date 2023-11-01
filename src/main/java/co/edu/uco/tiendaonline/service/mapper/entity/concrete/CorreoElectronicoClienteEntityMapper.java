package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public class CorreoElectronicoClienteEntityMapper implements EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> {

	private static final EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteEntityMapper();
	
	private CorreoElectronicoClienteEntityMapper() {
		super();
	}
	
	@Override
	public final CorreoElectronicoClienteDomain toDomain(final CorreoElectronicoClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000080);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),
				BooleanEntityMapper.convertToDomain(entity.isCorreoElectronicoConfirmado()));
	}

	@Override
	public final CorreoElectronicoClienteEntity toEntity(final CorreoElectronicoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000081);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return CorreoElectronicoClienteEntity.crear(domain.getCorreoElectronico(),
				BooleanEntityMapper.convertToEntity(domain.isCorreoElectronicoConfirmado()));
	}

	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoClienteEntity convertToEntity(final CorreoElectronicoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
