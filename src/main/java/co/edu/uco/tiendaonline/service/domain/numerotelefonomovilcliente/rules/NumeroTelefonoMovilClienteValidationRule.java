package co.edu.uco.tiendaonline.service.domain.numerotelefonomovilcliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;

public class NumeroTelefonoMovilClienteValidationRule implements ValidationRule<NumeroTelefonoMovilClienteDomain> {
	private static final ValidationRule<NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteValidationRule();
	
	private NumeroTelefonoMovilClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NumeroTelefonoMovilClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(NumeroTelefonoMovilClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000158);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
}
