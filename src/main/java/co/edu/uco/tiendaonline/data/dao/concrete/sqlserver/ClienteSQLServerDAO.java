package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;

public class ClienteSQLServerDAO extends SQLDAO implements ClienteDAO  {

	public  ClienteSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final ClienteEntity cliente) {
		final var sentencia = new StringBuilder();

		sentencia.append("INSERT INTO TipoIdentificacion (id, tipoIdentificacion, identificacion, nombreCompletoEntity, correoElectronicoEntity, numeroTelofonoMovilEntity, fechaNacimiento) ");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentenciaPreparada.toString())){
			sentenciaPreparada.setObject(1,cliente.getId());
			sentenciaPreparada.setObject(2,cliente.getTipoIdentificacion());
			sentenciaPreparada.setString(3,cliente.getIdentificacion());
			sentenciaPreparada.setObject(4,cliente.getNombreCompletoEntity());
			sentenciaPreparada.setObject(5,cliente.getCorreoElectronicoEntity());
			sentenciaPreparada.setObject(6,cliente.getNumeroTelofonoMovilEntity());
			sentenciaPreparada.setDate(7,cliente.getFechaNacimiento());
			
			
			sentenciaPreparada.executeUpdate();
		}catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000007);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
		}catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000009);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
		}
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
	public final  Optional<ClienteEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, tipoIdentificacion, identificacion, nombreCompletoEntity, correoElectronicoEntity, numeroTelofonoMovilEntity, fechaNacimiento ");
		sentencia.append("FROM  Cliente ");
		sentencia.append("WHERE  id = ? ");

		Optional<ClienteEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, id);

			try (final var resultados = sentenciaPreparada.executeQuery()) {

				if (resultados.next()) {
					var clienteEntity = ClienteEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()), resultados.getObject("tipoIdentificacion"),
							resultados.getObject("tipoIdentificacion"),
							resultados.getObject("identificacion"),
							resultados.getString("nombreCompletoEntity"),
							resultados.getObject("correoElectronicoEntity"),
							resultados.getObject("numeroTelofonoMovilEntity"),
							resultados.getDate("fechaNacimiento"));
					resultado = Optional.of(clienteEntity);
				}
			} catch (SQLException e) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000009);
				throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
			}

		} catch (DataTiendaOnlineException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000009);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000010);
			throw DataTiendaOnlineException.crear( mensajeUsuario, mensajeTecnico,e);
		}

		return resultado;
	}
		
	

	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
