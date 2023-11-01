package co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.enumerator.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.bussineslogic.concrete.tipoidentificacion.ConsultarTipoIdentificacionUseCase;
import co.edu.uco.tiendaonline.service.bussineslogic.validator.concrete.tipoidentificacion.ConsultarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.FacadeFind;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class ConsultarTipoIdentificacionFacade implements FacadeFind<TipoIdentificacionDTO>{

	@Override
	public List<TipoIdentificacionDTO> execute(final TipoIdentificacionDTO dto) {
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);
		ConsultarTipoIdentificacionValidator.ejecutar(domain);
		List<TipoIdentificacionDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarTipoIdentificacionUseCase(daofactory);
			resultados = TipoIdentificacionDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (TiendaOnlineException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000132);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}
