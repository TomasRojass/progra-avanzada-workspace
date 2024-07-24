package LadronDeCasas;

import java.util.HashMap;
import java.util.Map;

public class LadronDeCasas {

	public int obtenerMaximaCantidadDeDineroBottomUp(int[] casas) {

		// Casos base
		if (casas.length == 0) {
			return 0;
		} else if (casas.length == 1) {
			return casas[0];
		} else if (casas.length == 2) {
			return Math.max(casas[0], casas[1]);
		}

		// Declaro un vector de la misma longitud
		int[] gananciasParciales = new int[casas.length];

		// Almaceno la primera ganancia
		gananciasParciales[0] = casas[0];

		// Veo cual entre los primeros 2 es el que me conviene robar
		gananciasParciales[1] = Math.max(casas[0], casas[1]);

		// Me voy fijando si es que conviene quedarme con la ganancia que ya tengo y no
		// sumarle nada
		// O si conviene agarrar la nueva + la ganancia anterior y que no puedo agarrar
		// consecutivamente
		for (int i = 2; i < casas.length; i++) {
			gananciasParciales[i] = Math.max(casas[i] + gananciasParciales[i - 2], gananciasParciales[i - 1]);
		}

		return gananciasParciales[gananciasParciales.length - 1];
	}

	public int obtenerMaximaCantidadDeDineroTopDown(int[] casas) {
		Map<Integer, Integer> memoria = new HashMap<>();
		return obtenerMaximaCantidadDeDineroTopDown(casas, casas.length - 1, memoria);
	}

	// Privados

	private int obtenerMaximaCantidadDeDineroTopDown(int[] casas, int numeroDeCasa, Map<Integer, Integer> memoria) {
		// Caso base
		if (numeroDeCasa < 0) {
			return 0;
		}

		// Verificar si el resultado ya se encuentra en memoria
		if (memoria.containsKey(numeroDeCasa)) {
			return memoria.get(numeroDeCasa);
		}

		// Calcular la ganancia máxima si se roba la casa
		int gananciaSiSeRoba = casas[numeroDeCasa]
				+ obtenerMaximaCantidadDeDineroTopDown(casas, numeroDeCasa - 2, memoria);
		// Calcular la ganancia máxima si no se roba la casa
		int gananciaSiNoSeRoba = obtenerMaximaCantidadDeDineroTopDown(casas, numeroDeCasa - 1, memoria);
		// Guardar el resultado en el memoria
		int gananciaParcial = Math.max(gananciaSiSeRoba, gananciaSiNoSeRoba);
		memoria.put(numeroDeCasa, gananciaParcial);

		return gananciaParcial;
	}

}
