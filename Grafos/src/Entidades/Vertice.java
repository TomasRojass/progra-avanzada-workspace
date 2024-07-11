package Entidades;

public class Vertice<T> implements Comparable<Vertice<T>> {

	public static final boolean VISITADO = true;

	private int grado;

	private T valor;

	public Vertice(T valor) {
		this.valor = valor;
		this.grado = 0;
	}

	public void incrementarGrado() {
		this.grado++;
	}

	public T getValor() {
		return this.valor;
	}

	public int getGrado() {
		return this.grado;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor.toString();
	}

	@Override
	@SuppressWarnings("unchecked")
	public int compareTo(Vertice<T> otro) {
		if (this.valor instanceof Comparable) {
			return ((Comparable<T>) this.valor).compareTo(otro.getValor());
		} else {
			throw new IllegalArgumentException("El valor no es comparable");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Vertice<?> vertice = (Vertice<?>) obj;
		return valor.equals(vertice.valor);
	}

	@Override
	public int hashCode() {
		return valor.hashCode();
	}

}
