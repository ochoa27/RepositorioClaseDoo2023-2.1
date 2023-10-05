package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class ControllerTiendaOnlineException extends TiendaOnlineException{

	private static final long serialVersionUID = 7008202307513041484L;
	
	protected ControllerTiendaOnlineException(final  Throwable exceptionRaiz,final  String mendajeUsuario,
			final String mendajeTecnico) {
		super(LugarException.CONTROLLER, exceptionRaiz, mendajeUsuario, mendajeTecnico);
		
	}
	
	public static final TiendaOnlineException crear (final String mensajeUsuario) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	public static final TiendaOnlineException crear(final String mensajeUsuario,final String mensajeTecnico, final Throwable  ExceptionRaiz) {
		return new ControllerTiendaOnlineException(ExceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

	

	
}
