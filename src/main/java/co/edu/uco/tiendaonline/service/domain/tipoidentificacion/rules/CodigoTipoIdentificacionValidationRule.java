package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;



import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class CodigoTipoIdentificacionValidationRule implements ValidationRule<String> {
	private static final ValidationRule<String> instancia=new CodigoTipoIdentificacionValidationRule();
	
	private 
	
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	@Override
	public void validar(String dato) {
		validarFormato(dato);
		validarLongitud(dato);
		validarObligatoridad(dato);
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudValida(dato, 0, 50)){
		var mensajeUsuario="la kibgitud del codigo del tipo de identificcion no es valida ";
		throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoridad(final String dato) {
		if (UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="el codigo de tipo de identificacion no es valido ";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			var mensajeUsuario="el codigo de tipo de identificacion solo puede contener letras";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

	
	

}
