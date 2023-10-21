package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class TipoIdentificacionValidationRule implements ValidationRule<TipoIdentificacionDomain> {
	private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();
	
	private TipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(TipoIdentificacionDomain data) {
		if(UtilObjeto.esNulo(data)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000124);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
}
