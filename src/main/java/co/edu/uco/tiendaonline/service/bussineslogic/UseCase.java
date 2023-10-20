package co.edu.uco.tiendaonline.service.bussineslogic;

public interface UseCase<D> {
	void execute(D domain);
}
