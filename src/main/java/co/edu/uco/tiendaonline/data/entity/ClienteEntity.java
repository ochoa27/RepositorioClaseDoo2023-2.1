package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteDTO;


public class ClienteEntity {
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompletoEntity;
	private CorreoElectronicoClienteDTO correoElectronicoEntity;
	private NumeroTelefonoMovilClienteDTO numeroTelofonoMovilEntity;
	private Date fechaNacimiento;
	
	private ClienteEntity(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompletoEntity, final CorreoElectronicoClienteDTO correoElectronicoEntity,
			final NumeroTelefonoMovilClienteDTO numeroTelofonoMovilEntity, final Date fechaNacimiento) {
		super();
		this.id = id;
		this.tipoIdentificacion = tipoIdentificacion;
		this.identificacion = identificacion;
		this.nombreCompletoEntity = nombreCompletoEntity;
		this.correoElectronicoEntity = correoElectronicoEntity;
		this.numeroTelofonoMovilEntity = numeroTelofonoMovilEntity;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public static ClienteEntity crear(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompletoEntity, final CorreoElectronicoClienteDTO correoElectronicoEntity,
			final NumeroTelefonoMovilClienteDTO numeroTelofonoMovilEntity, final Date fechaNacimiento) {
		return new ClienteEntity(id, tipoIdentificacion, identificacion, nombreCompletoEntity, correoElectronicoEntity, numeroTelofonoMovilEntity, fechaNacimiento);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}

	private final void setNombreCompletoEntity(final NombreCompletoClienteDTO nombreCompletoEntity) {
		this.nombreCompletoEntity = nombreCompletoEntity;
	}

	private final void setCorreoElectronicoEntity(final CorreoElectronicoClienteDTO correoElectronicoEntity) {
		this.correoElectronicoEntity = correoElectronicoEntity;
	}

	private final void setNumeroTelofonoMovilEntity(final NumeroTelefonoMovilClienteDTO numeroTelofonoMovilEntity) {
		this.numeroTelofonoMovilEntity = numeroTelofonoMovilEntity;
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
		return nombreCompletoEntity;
	}

	public final CorreoElectronicoClienteDTO getCorreoElectronicoEntity() {
		return correoElectronicoEntity;
	}

	public final NumeroTelefonoMovilClienteDTO getNumeroTelofonoMovilEntity() {
		return numeroTelofonoMovilEntity;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
}
