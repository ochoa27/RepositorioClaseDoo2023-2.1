package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;



import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class idTipoIdentificacionValidationRule implements ValidationRule<String> {

	@Override
	public void validar(String dato) {
		validarPorDefecto(dato);
		validarObligatoridad(dato);
	}
	
	private void validarPorDefecto(String dato) {
		
	}

	
	private final void validarObligatoridad(final String dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario="el id de tipo de identificacion no es valido ";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	

	
	

}
