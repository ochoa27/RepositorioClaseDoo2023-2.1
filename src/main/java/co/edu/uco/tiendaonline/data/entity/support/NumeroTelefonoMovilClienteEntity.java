package co.edu.uco.tiendaonline.data.entity.support;

public class NumeroTelefonoMovilClienteEntity {
	
		public int numeroTelefonoMovil;
		public boolean numeroTelefonoMovilConfirmado;
		
		private NumeroTelefonoMovilClienteEntity(final int numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
			super();
			setNumeroTelefonoMovil(numeroTelefonoMovil);
			setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
		}

		
		
		public final int getNumeroTelefonoMovil() {
			return numeroTelefonoMovil;
		}



		public final boolean isNumeroTelefonoMovilConfirmado() {
			return numeroTelefonoMovilConfirmado;
		}



		private final void setNumeroTelefonoMovil(int numeroTelefonoMovil) {
			this.numeroTelefonoMovil = numeroTelefonoMovil;
		}

		private final void setNumeroTelefonoMovilConfirmado(boolean numeroTelefonoMovilConfirmado) {
			this.numeroTelefonoMovilConfirmado = numeroTelefonoMovilConfirmado;
		}

		
	}

