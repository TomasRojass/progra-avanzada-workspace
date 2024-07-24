package Entidades;

import Excepciones.MonticuloVacioException;

public interface Monticulo<T extends Comparable<T>> {

	void agregarElemento(T elemento);

	T sacarElemento() throws MonticuloVacioException;

	T verRaiz() throws MonticuloVacioException;

	public T[] getVector();

	int getTope();

	void mostrarMonticuloEnFormaDeArray();

	void mostrarMonticuloEnFormaDeArbol();

}
