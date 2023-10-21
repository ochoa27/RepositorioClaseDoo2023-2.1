package co.edu.uco.tiendaonline.service.domain;

public interface ValidationRule<T> {
	void validar(T dato);
}
