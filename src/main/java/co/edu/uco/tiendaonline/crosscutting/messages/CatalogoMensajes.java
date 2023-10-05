package co.edu.uco.tiendaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineEXception;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	
	
	private static final Map<CodigoMensaje,Mensaje> MENSAJES = new HashMap<>();
	
	private static final void cargarMensaje() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No se recibio el codigo de mensaje..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No existe un mensaje con el codigo indicado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No es posible obtener un mensaje con codigo vacio o nulo..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "se ha presentado un sistema inesperado tratando de llevar a cabo la operacion ..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "se ha presentado un problema tratrando de validar si la conexion SQL estaba abierta..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "se ha presentado un problema tratrando de validar si la conexion SQL estaba abierta, se presento una exepcion generica de tipo inesperado ..."));

	}
	
	private static void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUSuario= obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico= obtenerContenidoMensaje(CodigoMensaje.M0000000003);
			throw CrossCuttingTiendaOnlineEXception.crear(mensajeUSuario,mensajeTecnico);
		}
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUSuario= obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico= obtenerContenidoMensaje(CodigoMensaje.M0000000003);
			throw CrossCuttingTiendaOnlineEXception.crear(mensajeUSuario,mensajeTecnico);
		}
		return MENSAJES.get(codigo);
	}
	
	public static final String  obtenerContenidoMensaje(final CodigoMensaje codigo ) {
		return obtenerMensaje(codigo).getContenido();
	}
	
}
