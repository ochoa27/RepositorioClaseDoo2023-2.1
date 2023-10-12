package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineEXception;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
		
	}

	@Override
	public final void crear(final TipoIdentificacionEntity entity) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("INSERT INITO TipoIdentificacion (id,codigo,nombre,estado)");
		sentencia.append("VALUES (?,?,?,?)");
		
		try (final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3,entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUSuario= "se ha presentado un problema tratando de registrar la informacion de tipo identificacion";
			var mensajeTecnico= "se ha presentado un problema tratando de implementar un tipo de identificacion ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
			
		} catch (final Exception excepcion) {
			var mensajeUSuario= "se ha presentado un problema tratando de registrar la informacion de tipo identificacion";
			var mensajeTecnico= "se ha presentado un problema inesperado de tipo exepcion tratando de implementar un tipo de identificacion ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
		
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		final var sentencia =new StringBuilder();
		sentencia.append("SELECT  id,codigo,nombre,estado ");
		sentencia.append("FROM tipoIdentificacion ");
		sentencia.append("WHERE id= ? ");
		
		Optional<TipoIdentificacionEntity> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			
			try(final var  resultados = sentenciaPreparada.executeQuery()){
				if(resultados.next()) {
					var tipoIdentificacionEntity= TipoIdentificacionEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()),
							resultados.getString("codigo"),
							resultados.getString("nombre"),
							resultados.getBoolean("estado"));
					
					resultado=Optional.of(tipoIdentificacionEntity);
					
				}
			}catch (final SQLException excepcion) {
				var mensajeUSuario= "se ha presentado un problema tratando de consultar la informacion del tipo de identtificacion deseado";
				var mensajeTecnico= "se ha presentado un problema de tipo SQLECEPCION de calse SQLSERVER tratando de recuperar la consulta del tipo de identificacion deseado  ";
				throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
			}
		}catch (final DataTiendaOnlineException excepcion) {
			
		
		} catch (final SQLException excepcion) {
			
		}catch (final Exception excepcion) {
			var mensajeUSuario= "se ha presentado un problema tratando de consultar la informacion del tipo de identtificacion deseado";
			var mensajeTecnico= "se ha presentado un problema inesperado de tipo EXCEPCION de calse SQLSERVER tratando de recuperar la consulta del tipo de identificacion deseado  ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
		
		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
