package co.edu.uco.tiendaonline.crosscutting.util;

public class UtilTexto {
	
	public static final String VACIO="";
	public static final String  PATTERN_SOLO_LETRAS ="[A-Za-záéíóúÄËÏÖÜ]";
	public static final String  PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS ="^[0-9AZa-záéíóúÄËÏÖÜ]+$";
	private static final String PATTERN_CORREO_ELECTRONICO = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	private static final String PATTERN_NUMERO_TELEFONO = "^(\\+[0-9]{1,3}[-.\\s]?|[0-9]{1,4}[-.\\s]?)([0-9]{1,4}[-.\\s]?){1,12}$";
	
	
	private UtilTexto() {
		super();
	}
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto ) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor,VACIO);
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	public static final boolean igualSinTrim (final String valorUno,final String valorDos) {
		return obtenerValorDefecto(valorUno).equals(obtenerValorDefecto(valorDos));
	}
	public static final boolean igualConTrim (final String valorUno,final String valorDos) {
		return aplicarTrim(valorUno).equals(aplicarTrim(valorDos));
	}
	public static final boolean igualSinTrimIgnoreCase (final String valorUno,final String valorDos) {
		return obtenerValorDefecto(valorUno).equalsIgnoreCase(obtenerValorDefecto(valorDos));
	}
	public static final boolean igualConTrimIgnoreCase (final String valorUno,final String valorDos) {
		return aplicarTrim(valorUno).equalsIgnoreCase(aplicarTrim(valorDos));
	}
	public static final boolean estaNulo(final String valor ) {
		return UtilObjeto.esNulo(valor);
		
	}
	public static final boolean estaVacio(final String valor ) {
		return igualConTrim(valor, VACIO);
		
	}
	
	public static final boolean longitudMinimaValida(final String valor,final int longitud) {
		return aplicarTrim(valor).length()>=longitud;
	}
	public static final boolean longitudMaximaValida(final String valor,final int longitud) {
		return aplicarTrim(valor).length()<=longitud;
	}
	
	public static final boolean longitudValida ( final String valor, final int longitudMinima,final int longitudMaxima) {
		return longitudMinimaValida(valor, longitudMaxima)
				&& longitudMaximaValida(valor, longitudMaxima);
	}
	
	public static final boolean contieneSoloLetras(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS);
	}
	
	public static final boolean contieneSoloLetrasDigitosEspacios(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
	
	public static final boolean contieneFormatoCorreo(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_CORREO_ELECTRONICO);
	}
	
	public static final boolean contieneSoloDigitos(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_NUMERO_TELEFONO);
	}
}
	
	
	
	
	
	

