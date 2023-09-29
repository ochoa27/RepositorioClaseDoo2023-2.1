package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public class SQLServerDAOFactory extends DAOFactory {
	
	private Connection conexion;

	@Override
	protected final void abrirConexion() {
		// TODO Auto-generated method stub
		conexion=null;
		
	}

	@Override
	public final void cerrarConexion() {
		// TODO cerrar la transaccion 
		conexion=null;
		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO iniciar transaccion 
		
	}

	@Override
	public final  void confirmarTransaccion() {
		// TODO tarea hacer el commit
		
	}

	@Override
	public final void cancelarTransaccion() {
		// TODO la tarea es hacer el rollback
		
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
