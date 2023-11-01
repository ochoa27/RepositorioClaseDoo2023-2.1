package co.edu.uco.tiendaonline.crosscutting.exception;

import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class TiendaOnlineException extends RuntimeException{


	private static final long serialVersionUID = -551425372694998396L;
	private LugarException lugar;
	private Throwable excepcionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;
	
	
	
	protected TiendaOnlineException(final LugarException lugar, final Throwable exceptionRaiz, final String mendajeUsuario,
			final String mendajeTecnico) {
		super();
		setLugar(lugar);
		setExcepcionRaiz(excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}
	
	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}
	
	private final void setExcepcionRaiz(final Throwable exceptionRaiz) {
		setTieneExcepcionRaiz(!UtilObjeto.esNulo(exceptionRaiz));
		this.excepcionRaiz = UtilObjeto.obtenerValorDefecto(exceptionRaiz, new Exception());
	}
	
	private final void setMensajeUsuario(final String mendajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	
	private final void setMensajeTecnico(final String mendajeTecnico) {
		this.mensajeTecnico =UtilTexto.aplicarTrim(mensajeTecnico);
	}
	
	private void setTieneExcepcionRaiz(boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz = tieneExcepcionRaiz;
	}
	
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public final LugarException getLugar() {
		return lugar;
	}
	
	public final Throwable getExceptionRaiz() {
		return excepcionRaiz;
	}
	
	public final String getMesajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}
	
	public boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}
	
	
}
