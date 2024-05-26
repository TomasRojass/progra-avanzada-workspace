package colaDePrioridad;

public interface ColaDePrioridad <T extends Comparable<T>>{
	public void insertarElemento(T elemento);
	public T eliminarElemento();
	public T getPrimerElemento();	
	public void mostrarElementos();
}
