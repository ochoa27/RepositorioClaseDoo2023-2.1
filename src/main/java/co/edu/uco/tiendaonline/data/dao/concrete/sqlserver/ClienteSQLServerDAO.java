package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;

public class ClienteSQLServerDAO extends SQLDAO implements ClienteDAO  {

	public  ClienteSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final  void modificar(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final  Optional<ClienteEntity> consultarPorId(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
