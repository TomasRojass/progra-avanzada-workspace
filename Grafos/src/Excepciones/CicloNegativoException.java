package Excepciones;

public class CicloNegativoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CicloNegativoException(String mensaje) {
		super(mensaje);
	}

}
