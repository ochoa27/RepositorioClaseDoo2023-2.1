package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public class SQLServerDAOFactory extends DAOFactory {
	
	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		try {
            String url = "jdbc:sqlserver://<server>:<port>;databaseName=<database>";
            String user = "<username>";
            String password = "<password>";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        	var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000024);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
        } catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000025);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
        }
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
		
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final  void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public ClienteDAO obtenerclienteDAO() {
		 if(!UtilSQL.conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000027);
				throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);		
	        }
			return new ClienteSQLServerDAO(conexion);
		}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		if(!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000027);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);		
        }
		return new TipoIdentificacionSQLServerDAO(conexion);
	}
	}


