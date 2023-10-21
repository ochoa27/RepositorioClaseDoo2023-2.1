package co.edu.uco.tiendaonline.service.bussineslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;

public final class RegistrarTipoIdentificacionValidator implements  Validator<Tipo> {
	
	public final void execute (final TipoIdentificacionDomain data) {
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		
	}

}
