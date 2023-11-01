package co.edu.uco.tiendaonline.service.bussineslogic.concrete.tipoidentificacion;

import java.util.List;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.bussineslogic.UseCaseFind;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class ConsultarTipoIdentificacionUseCase implements UseCaseFind<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	
	public ConsultarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<TipoIdentificacionDomain> execute(TipoIdentificacionDomain domain) {
		final var resultadosTmp = getTipoIdentificacionDAO().consultar(TipoIdentificacionEntityMapper.convertToEntity(domain));
		return TipoIdentificacionEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000088);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000089);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
	
}