package ProblemaMochila;

import java.util.HashMap;
import java.util.Map;

public class Robo {

	// Método TopDown

	public double gananciaMaximaTopDown(Item[] items, int capacidad) {
		HashMap<Mochila, Double> mapa = new HashMap<>();
		return gananciaMaximaTopDown(capacidad, 0, items, mapa);

		// Descomentar solo para ver como se armo el mapa
		// double resultado = gananciaMaximaTopDown(capacidad, 0, items, mapa);
		// imprimirMapa(mapa);
		// return resultado;
	}

	private double gananciaMaximaTopDown(int capacidadDisponible, int pasoActual, Item[] items,
			HashMap<Mochila, Double> mapa) {
		Mochila mochila = new Mochila(capacidadDisponible, pasoActual);

		// Si ya esta en memoria retorno el valor
		if (mapa.containsKey(mochila)) {
			return mapa.get(mochila);
		}

		// Caso base: Recorro todos los artefactos
		// if (pasoActual == artefactos.length || capacidadDisponible == 0)
		if (pasoActual == items.length) {
			mapa.put(mochila, 0.0);
			return 0;
		}

		double gananciaSiNoRobo = gananciaMaximaTopDown(capacidadDisponible, pasoActual + 1, items, mapa);

		// Si me paso de la capacidad, no lo puedo robar (si lo resto me quedaria un
		// peso negativo)
		// Seria equivalente a quedarme con una sola rama del arbol
		if (items[pasoActual].getPeso() > capacidadDisponible) {
			mapa.put(mochila, gananciaSiNoRobo);
			return gananciaSiNoRobo;
		}

		// Si estoy aca, es porque lo puedo robar y calculo la ganancia
		double gananciaSiRobo = items[pasoActual].getPrecio()
				+ gananciaMaximaTopDown(capacidadDisponible - items[pasoActual].getPeso(), pasoActual + 1, items, mapa);

		double maximoEntreHijos = Math.max(gananciaSiNoRobo, gananciaSiRobo);

		mapa.put(mochila, maximoEntreHijos);

		// Siempre devuelvo lo que guardo en la mochila, ya sea por caso base, maximo
		// entre hijos o que ya este en el mapa
		return maximoEntreHijos;
	}

	@SuppressWarnings("unused")
	private void imprimirMapa(HashMap<Mochila, Double> mapa) {
		for (Map.Entry<Mochila, Double> entry : mapa.entrySet()) {
			Mochila clave = entry.getKey();
			Double valor = entry.getValue();
			System.out.println("Clave[" + clave + "]\tValor: " + valor);
		}
	}

	// Método BottomUp

	public double gananciaMaximaBottomUp(Item[] items, int capacidad) {
		int filas = items.length;
		int columnas = capacidad + 1;
		double[][] tabla = new double[filas][capacidad + 1];

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				// En la primera fila coloco el precio del primer item a partir de su subindice
				if (i == 0) {
					tabla[i][j] = j < items[i].getPeso() ? 0 : items[i].getPrecio();
				} else {
					// Si no me voy afuera de la tabla
					if (j - items[i].getPeso() >= 0) {
						// Evaluo si me conviene quedarme con lo que ya tengo --> tabla[i - 1][j]
						// o robarme el item actual mas la ganacia que involucra llevarme ese peso
						tabla[i][j] = Math.max(tabla[i - 1][j],
								items[i].getPrecio() + tabla[i - 1][j - items[i].getPeso()]);
					} else {
						// Caso contrario robo solo lo que tengo hasta ahora
						tabla[i][j] = tabla[i - 1][j];
					}
				}
			}

		}

		//imprimirTabla(tabla);
		return tabla[filas - 1][columnas - 1];
	}

	@SuppressWarnings("unused")
	private void imprimirTabla(double[][] tabla) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println("");
		}

	}

}
