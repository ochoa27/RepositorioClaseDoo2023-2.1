package co.edu.uco.tiendaonline.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionDTO;


public interface TipoIdentificacionDAO {
	
		void crear(TipoIdentificacionDTO entity);
		void modificar(TipoIdentificacionDTO entity);
		void eliminar(UUID id);
	
		Optional<TipoIdentificacionDTO> consultarPorId(UUID id);
		List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO entity);
		
}
