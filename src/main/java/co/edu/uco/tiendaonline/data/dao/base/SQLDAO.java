package co.edu.uco.tiendaonline.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	private Connection conexion;
	
	
	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
	}

	protected final Connection getConexion() {
		return conexion;
	}

	private final void setConexion(final Connection conexion) {
		//Todo: controlar que la conexion no sea null o que no este cerrada, o que no se haya confirmado una transaccion 
		this.conexion = conexion;
	}

}
