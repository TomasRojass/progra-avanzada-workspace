package Entidades;

public class MonticuloDeMinimos<T extends Comparable<T>> extends MonticuloImplementacion<T> {

	private T[] vector;

	private int tope = 1;

	@SuppressWarnings("unchecked")
	public MonticuloDeMinimos() {
		this.vector = (T[]) new Comparable[TAMANIO_INICIAL];
	}

	// Públicos

	@Override
	public T[] getVector() {
		return this.vector;
	}

	@Override
	public int getTope() {
		return this.tope;
	}

	// Protegidos

	@Override
	protected boolean comparar(T elemento1, T elemento2) {
		return elemento1.compareTo(elemento2) < 0;
	}

	@Override
	protected int obtenerPosicionHijoExtremo(int indiceActual) {
		int indiceHijoIzquierdo = indiceActual * 2;
		int indiceHijoDerecho = indiceHijoIzquierdo + 1;

		if (indiceHijoIzquierdo >= this.tope) {
			return POSICION_FUERA_DEL_TOPE;
		}

		if (indiceHijoDerecho >= this.tope
				|| comparar(this.vector[indiceHijoIzquierdo], this.vector[indiceHijoDerecho])) {
			return indiceHijoIzquierdo;
		}

		return indiceHijoDerecho;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void redimensionarVector() {
		T[] nuevoVector = (T[]) new Comparable[this.vector.length * 2];
		System.arraycopy(this.vector, 0, nuevoVector, 0, this.vector.length);
		this.vector = nuevoVector;
	}

	@Override
	protected void incrementarTope() {
		this.tope++;
	}

	@Override
	protected void decrementarTope() {
		this.tope--;
	}

}
