package co.edu.uco.tiendaonline.service.bussineslogic.concrete.cliente;

import java.util.List;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.bussineslogic.UseCaseFind;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public class ConsultarClienteUseCase implements UseCaseFind<ClienteDomain>{

	private DAOFactory factoria;
	
	public ConsultarClienteUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<ClienteDomain> execute(ClienteDomain domain) {
		final var resultadosTmp = getClienteDAO().consultar(ClienteEntityMapper.convertToEntity(domain));
		
		return ClienteEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000115);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000116);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerclienteDAO();
	}
}
