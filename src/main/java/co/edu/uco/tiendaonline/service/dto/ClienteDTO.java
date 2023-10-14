package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteDTO;


public class ClienteDTO {
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompletoDTO;
	private CorreoElectronicoClienteDTO correoElectronicoDTO;
	private NumeroTelefonoMovilClienteDTO numeroTelofonoMovilDTO;
	private Date fechaNacimiento;
	
	
	public ClienteDTO() {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompletoDTO(nombreCompletoDTO);
		setCorreoElectronicoDTO(correoElectronicoDTO);
		setNumeroTelofonoMovilDTO(numeroTelofonoMovilDTO);
		setFechaNacimiento(fechaNacimiento);
		
	}
	
	public  ClienteDTO(final UUID id, final TipoIdentificacionDTO tipoIdentificacion,final String identificacion,
			final NombreCompletoClienteDTO nombreCompletoDTO,final  CorreoElectronicoClienteDTO correoElectronicoDTO,
			final NumeroTelefonoMovilClienteDTO numeroTelofonoMovilDTO,final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompletoEntity(nombreCompletoDTO);
		setCorreoElectronicoEntity(correoElectronicoDTO);
		setNumeroTelofonoMovilEntity(numeroTelofonoMovilDTO);
		setFechaNacimiento(fechaNacimiento);
		
	}
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteDTO getNombreCompletoEntity() {
		return nombreCompletoDTO;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectronicoEntity() {
		return correoElectronicoDTO;
	}
	public final NumeroTelefonoMovilClienteDTO getNumeroTelofonoMovilEntity() {
		return numeroTelofonoMovilDTO;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final ClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}
	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final ClienteDTO setNombreCompletoEntity(final NombreCompletoClienteDTO nombreCompletoEntity) {
		this.nombreCompletoDTO = nombreCompletoEntity;
		return this;
	}
	public final ClienteDTO setCorreoElectronicoEntity(final CorreoElectronicoClienteDTO correoElectronicoEntity) {
		this.correoElectronicoDTO = correoElectronicoEntity;
		return this;
	}
	public final ClienteDTO setNumeroTelofonoMovilEntity(final NumeroTelefonoMovilClienteDTO numeroTelofonoMovilEntity) {
		this.numeroTelofonoMovilDTO = numeroTelofonoMovilEntity;
		return this;
	}
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	
	

}
