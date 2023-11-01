package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilFecha;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;


public class ClienteDTO {
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private NumeroTelefonoMovilClienteDTO numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	public ClienteDTO() {
		setId(UtilUUID.UUIDDEFECTO);
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectronico(new CorreoElectronicoClienteDTO());
		setNumeroTelefonoMovil(new NumeroTelefonoMovilClienteDTO());
		setFechaNacimiento(UtilFecha.FECHADEFECTO);
	}
	
	public ClienteDTO(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto, final CorreoElectronicoClienteDTO correoElectronico,
			final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}

	public static final ClienteDTO crear(){
		return new ClienteDTO();
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
	
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	
	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}
	
	public final NumeroTelefonoMovilClienteDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public final ClienteDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return this;
	}
	
	public final ClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDTO());
		return this;
	}
	
	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = UtilTexto.obtenerValorDefecto(identificacion, UtilTexto.VACIO);
		return this;
	}
	
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = UtilObjeto.obtenerValorDefecto(nombreCompleto, new NombreCompletoClienteDTO());
		return this;
	}
	
	public final ClienteDTO setCorreoElectronico(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = UtilObjeto.obtenerValorDefecto(correoElectronico, new CorreoElectronicoClienteDTO());
		return this;
	}
	
	public final ClienteDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil) {
		this.numeroTelefonoMovil = UtilObjeto.obtenerValorDefecto(numeroTelefonoMovil, new NumeroTelefonoMovilClienteDTO());
		return this;
	}
	
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = UtilFecha.obtenerValorDefecto(fechaNacimiento, UtilFecha.FECHADEFECTO);
		return this;
	}
}
	


