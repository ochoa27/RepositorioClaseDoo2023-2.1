package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> {
	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000128);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(), BooleanDTOMapper.convertToDomain(dto.isEstado()));
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000129);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return TipoIdentificacionDTO.crear()
			.setId(domain.getId())
			.setCodigo(domain.getCodigo())
			.setNombre(domain.getNombre())
			.setEstado(BooleanDTOMapper.convertToDTO(domain.isEstado()));
	}
	
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<TipoIdentificacionDTO>  convertToListDTO(final List<TipoIdentificacionDomain> dto){
		List<TipoIdentificacionDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
