package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;


public class ClienteEntity {
	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompletoEntity;
	private CorreoElectronicoClienteEntity correoElectronicoEntity;
	private NumeroTelefonoMovilClienteEntity numeroTelofonoMovilEntity;
	private Date fechaNacimiento;
	
	private ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteEntity nombreCompletoEntity, final CorreoElectronicoClienteEntity correoElectronicoEntity,
			final NumeroTelefonoMovilClienteEntity numeroTelofonoMovilEntity, final Date fechaNacimiento) {
		super();
		this.id = id;
		this.tipoIdentificacion = tipoIdentificacion;
		this.identificacion = identificacion;
		this.nombreCompletoEntity = nombreCompletoEntity;
		this.correoElectronicoEntity = correoElectronicoEntity;
		this.numeroTelofonoMovilEntity = numeroTelofonoMovilEntity;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public static ClienteEntity crear(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteEntity nombreCompletoEntity, final CorreoElectronicoClienteEntity correoElectronicoEntity,
			final NumeroTelefonoMovilClienteEntity numeroTelofonoMovilEntity, final Date fechaNacimiento) {
		return new ClienteEntity(id, tipoIdentificacion, identificacion, nombreCompletoEntity, correoElectronicoEntity, numeroTelofonoMovilEntity, fechaNacimiento);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}

	private final void setNombreCompletoEntity(final NombreCompletoClienteEntity nombreCompletoEntity) {
		this.nombreCompletoEntity = nombreCompletoEntity;
	}

	private final void setCorreoElectronicoEntity(final CorreoElectronicoClienteEntity correoElectronicoEntity) {
		this.correoElectronicoEntity = correoElectronicoEntity;
	}

	private final void setNumeroTelofonoMovilEntity(final NumeroTelefonoMovilClienteEntity numeroTelofonoMovilEntity) {
		this.numeroTelofonoMovilEntity = numeroTelofonoMovilEntity;
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final UUID getId() {
		return id;
	}

	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final NombreCompletoClienteEntity getNombreCompletoEntity() {
		return nombreCompletoEntity;
	}

	public final CorreoElectronicoClienteEntity getCorreoElectronicoEntity() {
		return correoElectronicoEntity;
	}

	public final NumeroTelefonoMovilClienteEntity getNumeroTelofonoMovilEntity() {
		return numeroTelofonoMovilEntity;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
}
