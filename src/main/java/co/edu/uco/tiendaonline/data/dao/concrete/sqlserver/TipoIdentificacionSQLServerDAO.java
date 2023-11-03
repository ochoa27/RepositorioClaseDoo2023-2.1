package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.BooleanEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoIdentificacionEntity tipoIdentificacion) {
		final var sentencia = new StringBuilder();

		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado) ");
		sentencia.append("VALUES (?, ?, ?, ?) ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, tipoIdentificacion.getId());
			sentenciaPreparada.setString(2, tipoIdentificacion.getCodigo());
			sentenciaPreparada.setString(3, tipoIdentificacion.getNombre());
			sentenciaPreparada.setBoolean(4, tipoIdentificacion.isEstado().isValor());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000053);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000053);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000034);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity tipoIdentificacion) {
		final var sentencia = new StringBuilder();

		sentencia.append("UPDATE TipoIdentificacion " );
		sentencia.append("SET	codigo = ?, ");
		sentencia.append("		nombre = ?, ");
		sentencia.append("		estado = ? ");
		sentencia.append("WHERE id = ? ");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setString(1, tipoIdentificacion.getCodigo());
			sentenciaPreparada.setString(2, tipoIdentificacion.getNombre());
			sentenciaPreparada.setBoolean(3, tipoIdentificacion.isEstado().isValor());
			sentenciaPreparada.setObject(4, tipoIdentificacion.getId());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000041);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000039);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000041);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");

		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000044);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000042);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000044);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {

		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM  TipoIdentificacion ");
		sentencia.append("WHERE  id = ? ");

		Optional<TipoIdentificacionEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		} catch (DataTiendaOnlineException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000035);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000036);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}

		return resultado;
	}
	
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity tipoIdentificacion) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(tipoIdentificacion, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataTiendaOnlineException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000049);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000050);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}
	}
	
	private final Optional<TipoIdentificacionEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			if (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
						UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
						resultados.getString("nombre"), BooleanEntity.crear(resultados.getBoolean("estado"), false));
				resultado = Optional.of(tipoIdentificacionEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000038);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000045);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);		
		}
		
		return resultado;
	}
	
	private String formarSentenciaConsulta(final TipoIdentificacionEntity tipoIdentificacion, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		
		if(!UtilObjeto.esNulo(tipoIdentificacion)) {
			if(!UtilUUID.esNulo(tipoIdentificacion.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(tipoIdentificacion.getId());
			}
			
			if(!UtilTexto.estaVacio(tipoIdentificacion.getCodigo())) {
				sentencia.append(operadorCondicional).append(" codigo = ? ");
				operadorCondicional = "AND";
				parametros.add(tipoIdentificacion.getCodigo());
			}
			
			if(!UtilTexto.estaVacio(tipoIdentificacion.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(tipoIdentificacion.getNombre());
			}
			
			if(!tipoIdentificacion.isEstado().isValorDefecto()) {
				sentencia.append(operadorCondicional).append(" estado = ? ");
				parametros.add(tipoIdentificacion.isEstado().isValor());
			}			
		}
		
		
		sentencia.append("ORDER BY codigo");
		return sentencia.toString();
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000047);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000048);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		}
	}
	
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<TipoIdentificacionEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
						UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
						resultados.getString("nombre"), BooleanEntity.crear(resultados.getBoolean("estado"), false));
				listaResultados.add(tipoIdentificacionEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000051);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000052);
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico,e);		
		}
		
		return listaResultados;
	}
}
