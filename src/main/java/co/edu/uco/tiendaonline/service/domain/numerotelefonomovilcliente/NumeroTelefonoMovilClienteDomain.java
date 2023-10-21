package co.edu.uco.tiendaonline.service.domain.numerotelefonomovilcliente;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class NumeroTelefonoMovilClienteDomain {
	private String numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	public NumeroTelefonoMovilClienteDomain() {
		setNumeroTelefonoMovil(UtilTexto.VACIO);
		setNumeroTelefonoMovilConfirmado(false);
	}
	
	public NumeroTelefonoMovilClienteDomain(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}

	public static final NumeroTelefonoMovilClienteDomain crear(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilClienteDomain(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}

	private final NumeroTelefonoMovilClienteDomain setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = UtilTexto.obtenerValorDefecto(numeroTelefonoMovil, UtilTexto.VACIO);
		return this;
	}

	private final NumeroTelefonoMovilClienteDomain setNumeroTelefonoMovilConfirmado(final boolean numeroTelefonoMovilConfirmado) {
		this.numeroTelefonoMovilConfirmado = UtilObjeto.obtenerValorDefecto(numeroTelefonoMovilConfirmado, false);
		return this;
	}

	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final boolean isNumeroTelefonoMovilConfirmado() {
		return numeroTelefonoMovilConfirmado;
	}
}

