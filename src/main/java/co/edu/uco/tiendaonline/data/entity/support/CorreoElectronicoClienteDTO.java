package co.edu.uco.tiendaonline.data.entity.support;

public final  class CorreoElectronicoClienteDTO {
	
		public String correoElectronico;
		public boolean correoElectronicoConfirmado;
		
		
		private CorreoElectronicoClienteDTO(final String correoElectronico, final boolean correoElectronicoConfirmado) {
			super();
			setCorreoElectronico(correoElectronico);
			setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}


		public final String getCorreoElectronico() {
			return correoElectronico;
		}


		public final boolean isCorreoElectronicoConfirmado() {
			return correoElectronicoConfirmado;
		}


		private final void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}


		private final void setCorreoElectronicoConfirmado(boolean correoElectronicoConfirmado) {
			this.correoElectronicoConfirmado = correoElectronicoConfirmado;
		}
		
	}

