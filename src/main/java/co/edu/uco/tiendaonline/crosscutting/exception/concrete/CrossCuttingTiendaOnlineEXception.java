package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class CrosscuttingTiendaOnlineException extends TiendaOnlineException {
	
	private static final long serialVersionUID = -9177484194126685659L;
	
	protected CrosscuttingTiendaOnlineException( final Throwable exceptionRaiz,final  String mendajeUsuario,
			final String mendajeTecnico) {
		super(LugarException.CROSSCUTTING, exceptionRaiz, mendajeUsuario, mendajeTecnico);
		
	}
	
	public static final TiendaOnlineException crear (final String mensajeUsuario) {
		return new CrosscuttingTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new CrosscuttingTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	public static final TiendaOnlineException crear(final Throwable  ExceptionRaiz,final String mensajeUsuario,final String mensajeTecnico) {
		return new CrosscuttingTiendaOnlineException(ExceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
