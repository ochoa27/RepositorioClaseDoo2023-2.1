package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineEXception;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public class UtilSQL {
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico="no es posible cerrar una conexion que esta nula  ";
			throw CrossCuttingTiendaOnlineEXception.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			return UtilObjeto.esNulo(null)&& !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrossCuttingTiendaOnlineEXception.crear(excepcion,mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrossCuttingTiendaOnlineEXception.crear(excepcion,mensajeUsuario, mensajeTecnico);
		}
	}
	public static final void cerrarConexion(final Connection conexion) {
		try {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico="no es posible cerrar una conexion que esta nula ";
			throw CrossCuttingTiendaOnlineEXception.crear(mensajeUsuario, mensajeTecnico);
		}
		if(!conexionAbierta(conexion)) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico="no es posible cerrar una conexion que ya fue cerrada ";
			throw CrossCuttingTiendaOnlineEXception.crear(mensajeUsuario, mensajeTecnico);
		}
		conexion.close();
		}catch(final CrossCuttingTiendaOnlineEXception exception) {
			throw exception;
		}catch (final SQLException excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico="";
			throw CrossCuttingTiendaOnlineEXception.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico="";
			throw CrossCuttingTiendaOnlineEXception.crear(excepcion, mensajeUsuario, mensajeTecnico);
			}
		}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		
	}
	
}
