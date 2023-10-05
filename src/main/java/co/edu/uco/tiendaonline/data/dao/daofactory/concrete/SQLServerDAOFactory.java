package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            //TODO create personalized exception
        }
	}

	@Override
	public final void cerrarConexion() {
		try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            //TODO create personalized exception
        }
		
	}

	@Override
	public final void iniciarTransaccion() {
		try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
        } catch (SQLException e) {
            //TODO create personalized exception
        }
	}

	@Override
	public final  void confirmarTransaccion() {
		try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.commit();
            }
        } catch (SQLException e) {
            //TODO create personalized exception
        }
	}

	@Override
	public final void cancelarTransaccion() {
		try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.rollback();
            }
        } catch (SQLException e) {
            //TODO create personalized exception
        }
	}

	@Override
	public ClienteDAO obtenerclienteDAO() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenrTipoIdentificacionDAO() {
		// TODO Auto-generated method stub
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

}
