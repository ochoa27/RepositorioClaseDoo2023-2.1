package co.edu.uco.tiendaonline.data.dao.daofactory;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;

public abstract class DAOFactory {
	protected abstract void abrirConexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaccion();

	public abstract  ClienteDAO obtenerclienteDAO();
	public abstract  TipoIdentificacionDAO obtenrTipoIdentificacionDAO();
}
