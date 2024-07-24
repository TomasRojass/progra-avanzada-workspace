package ColaDePrioridad;

import java.util.Arrays;

public class MonticuloDeMinimosInt implements ColaDePrioridad<Integer>{
	private Integer[] array;
	private int tope;
	
	public MonticuloDeMinimosInt(Integer[] otroArray) {
		this.agrandarMonticulo(otroArray.length);
		this.transformarListaEnMonticulo(otroArray);
	}
	
	public MonticuloDeMinimosInt() {
		 this.array = new Integer[50];
		 this.tope = 1;
	}

	@Override
	public void insertarElemento(Integer elemento) {
		if(this.tope == this.array.length) {
			this.agrandarMonticulo();
		}
		
		this.array[this.tope] = elemento;
		
		int posActual = this.tope;
		int posPadre = posActual / 2;
		while(posActual > 1 && this.array[posPadre] != null && this.array[posActual] < this.array[posPadre] ) {
			this.intercambioElementos(posActual, posPadre);
			posActual = posPadre;
			posPadre = posActual / 2;
		}
		this.tope ++;
	}

	@Override
	public Integer eliminarElemento() {
		if(this.tope == 1) {
			System.out.println("Monticulo vacio. No hay elementos para eliminar");
			return null;
		}
		Integer elemEliminado = this.array[1];
		this.tope --;
		if(this.tope == 1) {
			return elemEliminado;
		}
		
		// traigo ultimo elemento al primero para luego re-ordenar
		this.array[1] = this.array[tope];
		int posActual = 1;
		int posHijoMenor = this.getPosHijoMenor(posActual);		
		
		// hasta que se termine el monticulo o el hijo menor sea menor o igual al elemento a ordenar
		while(posHijoMenor != -1 && array[posHijoMenor] <= array[posActual]) {
			this.intercambioElementos(posActual, posHijoMenor);
			posActual = posHijoMenor;
			posHijoMenor = this.getPosHijoMenor(posActual);	
		}		
		
		return elemEliminado;
	}

	@Override
	public Integer getPrimerElemento() {
		return this.array[0];
	}
	
	@Override
	public void mostrarElementos() {
		this.mostrarElementosRecursivo(1, 0, "");
		System.out.println();
	}
	
	private void mostrarElementosRecursivo(int indice, int nivel, String prefijo) {
		if (indice < tope && this.array[indice] != null) {
			mostrarElementosRecursivo(indice * 2 + 1, nivel + 1, "  " + prefijo);
			System.out.print(prefijo);
			for (int i = 0; i < nivel; i++) {
				System.out.print("\t");
			}
			System.out.println(this.array[indice]);
			mostrarElementosRecursivo(indice * 2, nivel + 1, "  " + prefijo);
		} else {
			System.out.println();
		}
	}
	
	private void agrandarMonticulo(int tamOtroArray) {
		this.tope = 1;
		int nuevaCantidad;
		if(tamOtroArray == 0) {
			nuevaCantidad = 50;
		}
		else {
			nuevaCantidad = (int) (tamOtroArray * 1.3);
		}
		Integer[] nuevoMonticulo = new Integer[nuevaCantidad];
		
		this.array = nuevoMonticulo;
	}
	
	private void agrandarMonticulo() {
		int nuevaCantidad = (int) (this.tope * 1.3);
		Integer[] nuevoMonticulo = Arrays.copyOf(this.array, nuevaCantidad);
		
		this.array = nuevoMonticulo;
	}
	
	private Integer getPosHijoMenor(int posPadre) {
		Integer posHijoIzq = posPadre * 2;
		Integer posHijoDer = posHijoIzq + 1;
		
		if(posHijoIzq >= this.tope) {
			return -1;
		}
		if(posHijoDer >= this.tope || this.array[posHijoIzq] <= this.array[posHijoDer]) {
			return posHijoIzq;
		}
		return posHijoDer;
	}
	
	private void intercambioElementos(int posUno, int posDos) {
		int aux = this.array[posUno];
		this.array[posUno] = this.array[posDos];
		this.array[posDos] = aux;
	}
	
	private void transformarListaEnMonticulo(Integer[] lista) {
		for(Integer elemento: lista) {
			this.insertarElemento(elemento);
		}
	}

}
