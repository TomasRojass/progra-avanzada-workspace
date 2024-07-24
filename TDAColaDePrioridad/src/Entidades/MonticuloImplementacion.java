package Entidades;

import Excepciones.MonticuloVacioException;

abstract class MonticuloImplementacion<T extends Comparable<T>> implements Monticulo<T> {

	protected static final int POSICION_FUERA_DEL_TOPE = -1;

	protected static final int TAMANIO_INICIAL = 100;

	// Publicos

	@Override
	public void agregarElemento(T elemento) {
		if (this.getVector().length == this.getTope()) {
			this.redimensionarVector();
		}
		int indiceHijo = this.getTope();
		int indicePadre = indiceHijo / 2;
		this.getVector()[this.getTope()] = elemento;
		this.incrementarTope();
		while (indicePadre >= 1 && this.comparar(this.getVector()[indiceHijo], this.getVector()[indicePadre])) {
			this.intercambiar(indiceHijo, indicePadre);
			indiceHijo = indicePadre;
			indicePadre = indicePadre / 2;
		}
	}

	@Override
	public T sacarElemento() throws MonticuloVacioException {
		if (this.getTope() == 1) {
			throw new MonticuloVacioException("El montículo se encuentra vacío.");
		}
		int indiceRaiz = 1;
		T elementoRaiz = this.getVector()[indiceRaiz];
		this.decrementarTope();
		if (this.getTope() == indiceRaiz) {
			return elementoRaiz;
		}
		this.getVector()[indiceRaiz] = this.getVector()[getTope()];
		int indiceActual = indiceRaiz;
		int indiceHijoExtremo = this.obtenerPosicionHijoExtremo(indiceActual);
		while (indiceHijoExtremo != POSICION_FUERA_DEL_TOPE
				&& comparar(this.getVector()[indiceHijoExtremo], this.getVector()[indiceActual])) {
			this.intercambiar(indiceActual, indiceHijoExtremo);
			indiceActual = indiceHijoExtremo;
			indiceHijoExtremo = this.obtenerPosicionHijoExtremo(indiceActual);
		}
		return elementoRaiz;
	}

	@Override
	public T verRaiz() throws MonticuloVacioException {
		if (this.getTope() == 1) {
			throw new MonticuloVacioException("El montículo se encuentra vacío.");
		}
		return this.getVector()[1];
	}

	@Override
	public void mostrarMonticuloEnFormaDeArray() {
		T[] vector = getVector();
		int tope = getTope();
		for (int i = 1; i < tope; i++) {
			System.out.println(vector[i]);
		}
	}

	@Override
	public void mostrarMonticuloEnFormaDeArbol() {
		mostrarMonticuloEnFormaDeArbol(1, 0, "");
		System.out.println();
	}

	// Privados

	private void intercambiar(int indiceInferior, int indiceSuperior) {
		T auxiliar = this.getVector()[indiceInferior];
		this.getVector()[indiceInferior] = this.getVector()[indiceSuperior];
		this.getVector()[indiceSuperior] = auxiliar;
	}

	private void mostrarMonticuloEnFormaDeArbol(int indice, int nivel, String prefijo) {
		T[] vector = getVector();
		int tope = getTope();
		if (indice < tope) {
			mostrarMonticuloEnFormaDeArbol(indice * 2 + 1, nivel + 1, "\t");
			for (int i = 0; i < nivel; i++) {
				System.out.print("\t");
			}
			System.out.println(vector[indice]);
			mostrarMonticuloEnFormaDeArbol(indice * 2, nivel + 1, "\t");
		} else {
			System.out.println();
		}
	}

	// Abstractos

	protected abstract boolean comparar(T elemento1, T elemento2);

	protected abstract int obtenerPosicionHijoExtremo(int indiceActual);

	protected abstract void incrementarTope();

	protected abstract void decrementarTope();

	protected abstract void redimensionarVector();

}
