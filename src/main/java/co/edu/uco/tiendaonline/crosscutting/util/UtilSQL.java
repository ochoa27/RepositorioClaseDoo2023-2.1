package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;

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
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			return UtilObjeto.esNulo(null)&& !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario, mensajeTecnico);
		}
	}
	public static final void cerrarConexion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000007);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000008);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			conexion.close();
		} catch (final CrosscuttingTiendaOnlineException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000011);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000012);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000013);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000014);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.setAutoCommit(false);
		} catch (final CrosscuttingTiendaOnlineException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000014);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000015);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	public static final void confirmarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000016);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000019);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000020);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.commit();
		} catch (final CrosscuttingTiendaOnlineException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000021);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000022);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	public static final void cancelarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000028);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000029);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000030);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.rollback();
		} catch (final CrosscuttingTiendaOnlineException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000031);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000032);
			throw CrosscuttingTiendaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
}

	

