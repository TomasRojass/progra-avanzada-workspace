package Varilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Varilla {

	public int cortarVarilla(int largoVarilla, int[] cortes) {
		List<Integer> listaDeCortes = new ArrayList<>();
		for (int i = 0; i < cortes.length; i++) {
			listaDeCortes.add(cortes[i]);
		}
		Map<Integer, Map<List<Integer>, Integer>> memoria = new HashMap<>();
		return cortarVarilla(largoVarilla, listaDeCortes, memoria);
	}

	private int cortarVarilla(int largoVarilla, List<Integer> cortes,
			Map<Integer, Map<List<Integer>, Integer>> memoria) {

		// Si no hay cortes por aplicar, el costo es cero
		if (cortes.isEmpty())
			return 0;

		// Verificar si el resultado ya está almacenado en memoria.
		if (memoria.containsKey(largoVarilla) && memoria.get(largoVarilla).containsKey(cortes))
			return memoria.get(largoVarilla).get(cortes);

		int min = Integer.MAX_VALUE;
		int coste = 0;

		// Para cada corte c en cortes
		for (Integer corte : cortes) {

			// Divido la varilla en dos partes: izquierda (nIzq) y derecha (nDer).
			int nIzq = corte;
			int nDer = largoVarilla - corte;

			// Recalcula los cortes necesarios para las dos nuevas subvarillas resultantes
			List<Integer> cortesIzq = new ArrayList<>();
			List<Integer> cortesDer = new ArrayList<>();
			cortesIzq = recalcularCortes(largoVarilla, nIzq, cortes, corte, true);
			cortesDer = recalcularCortes(largoVarilla, nDer, cortes, corte, false);

			// Calculo el costo de cortar cada subvarilla y sumo ambos costos.
			coste = cortarVarilla(nIzq, cortesIzq, memoria) + cortarVarilla(nDer, cortesDer, memoria);

			// Actualizo min si el costo calculado es menor
			if (coste < min) {
				min = coste;
			}
		}

		// Almaceno el resultado en memoria antes de devolverlo
		if (!memoria.containsKey(largoVarilla)) {
			Map<List<Integer>, Integer> aux = new HashMap<>();
			memoria.put(largoVarilla, aux);
		}

		memoria.get(largoVarilla).put(cortes, largoVarilla + min);

		return largoVarilla + min;
	}

	private List<Integer> recalcularCortes(int largoInicial, int largoActual, List<Integer> cortes, int corte,
			boolean esIzquierda) {

		int diferencia = largoInicial - largoActual;
		List<Integer> aux = new ArrayList<>();

		// Para cada corte en cortes, si es un corte en la izquierda y es menor que c,
		// se añade a cortesIzq. Si es un corte en la derecha y es mayor que c, se añade
		// a cortesDer ajustando la diferencia.
		for (Integer corteAuxiliar : cortes) {

			// No recalculo el corte ya realizado
			if (corteAuxiliar == corte)
				continue;

			// esIzquierda indica si se está procesando la parte izquierda o derecha de la
			// varilla.
			if (esIzquierda && corteAuxiliar < corte) {
				aux.add(corteAuxiliar);
			}

			if (!esIzquierda && corteAuxiliar > corte) {
				aux.add(corteAuxiliar - diferencia);
			}

		}

		return aux;
	}

}
