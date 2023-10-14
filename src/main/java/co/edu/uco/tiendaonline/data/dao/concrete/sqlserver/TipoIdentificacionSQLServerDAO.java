package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineEXception;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionDTO;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
		
	}

	@Override
	public final void crear(final TipoIdentificacionDTO entity) {
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
	public final void modificar(final TipoIdentificacionDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TipoIdentificacionDTO> consultarPorId(final UUID id) {
		final var sentencia =new StringBuilder();
		sentencia.append("SELECT  id,codigo,nombre,estado ");
		sentencia.append("FROM tipoIdentificacion ");
		sentencia.append("WHERE id= ? ");
		
		Optional<TipoIdentificacionDTO> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.setObject(1, id);
			
			
		}catch (final DataTiendaOnlineException excepcion) {
			
		
		} catch (final SQLException excepcion) {
			
		}catch (final Exception excepcion) {
			var mensajeUSuario= "se ha presentado un problema tratando de consultar la informacion del tipo de identtificacion deseado";
			var mensajeTecnico= "se ha presentado un problema inesperado de tipo EXCEPCION de calse SQLSERVER tratando de recuperar la consulta del tipo de identificacion deseado  ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
		
		return resultado;
	}

	private Optional<TipoIdentificacionDTO>ejecutarConsula(final PreparedStatement sentenciaPreparada){
		try(final var  resultados = sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var tipoIdentificacionEntity= TipoIdentificacionDTO.crear(
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
		}catch (final Exception excepcion) {
			var mensajeUSuario= "se ha presentado un problema tratando de consultar la informacion del tipo de identtificacion deseado";
			var mensajeTecnico= "se ha presentado un problema de tipo SQLECEPCION de calse SQLSERVER tratando de recuperar la consulta del tipo de identificacion deseado  ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
		return resultado;
	}
	
	private final String formarSentenciaConsulta(final TipoIdentificacionDTO  entity, final List<Object> parametros) {
		final StringBuilder sentencia=new StringBuilder();
		String  operadorCondicional = "WHERE";
		
		sentencia.append("SELECT id, codigo, nombre , estado )");
		sentencia.append("FROM TipoIdentificacion ");
		if(!UtilObjeto.esNulo(entity)) {
			
			if(!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id=? ");
				operadorCondicional="AND";
				parametros.add(entity.getId());
				
			}
			if(UtilTexto.estaVacio(entity.getCodigo())) {
				sentencia.append(operadorCondicional).append(" coodigo = ? ");
				operadorCondicional="AND";
				parametros.add(entity.getCodigo());
			}
		}if(UtilTexto.estaVacio(entity.getNombre())) {
			sentencia.append(operadorCondicional).append(" nombre = ? ");
			operadorCondicional="AND";
			parametros.add(entity.getNombre());
		}if(UtilObjeto.esNulo(entity.isEstado())) {
			sentencia.append(operadorCondicional).append(" estado = ? ");
			parametros.add(entity.isEstado());
		}
	sentencia.append("ORDER BY codigo ASC ");
	return sentencia.toString();
	}
	
	private final List<TipoIdentificacionDTO>    prepararEjecutarSentenciaConsulta(final TipoIdentificacionDTO entity) {
		final var parametros= new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity,parametros);
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			colocarParametrosConsulta(sentenciaPreparada,parametros);
			return ejecutarConsula(sentenciaPreparada);
		}catch (final DataTiendaOnlineException excepcion) {
			
			throw excepcion;
			
		}catch (final SQLException excepcion) {
			var mensajeUSuario= " se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion ";
			var mensajeTecnico= "se ha presentado un problema SQLEXEPCION en el metodo preparar consulta tratando de preparar las consultas   ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
			
		}catch (Exception excepcion) {
			var mensajeUSuario= " se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion ";
			var mensajeTecnico= "se ha presentado un problema EXEPCION en el metodo preparar consulta tratando de preparar las consultas   ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
	}
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada,final List<Object> parametros) {
		try {
			for (int indice =0;indice< parametros.size();indice++) {
				sentenciaPreparada.setObject(indice+1, parametros.get(indice));
			}
			
		} catch (SQLException excepcion) {
			var mensajeUSuario= " se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion ";
			var mensajeTecnico= "se ha presentado un problema en el metodo colocar parametros consulta de la clase TipoIdentificacionSQLSERVERDAO tratando de colocar parametros de la consulta SQL  ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}catch (final Exception excepcion) {
			var mensajeUSuario= " se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion ";
			var mensajeTecnico= "se ha presentado un problema  EXCEPCION en el metodo colocar parametros consulta de la clase TipoIdentificacionSQLSERVERDAO tratando de colocar parametros de la consulta SQL  ";
			throw DataTiendaOnlineException.crear(mensajeUSuario,mensajeTecnico,excepcion);
		}
		
	}
	private final List<TipoIdentificacionDTO> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		return null;
	}
}
