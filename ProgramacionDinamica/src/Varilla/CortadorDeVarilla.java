package Varilla;

import java.util.HashMap;

public class CortadorDeVarilla {
private int iteraciones;
	
	public CortadorDeVarilla() {
		this.iteraciones = 0;
	}
	
	
	/**
	 * Calcula el costo mínimo de cortar una varilla de longitud `largoVarilla` en las posiciones especificadas
	 * en `cortesVarilla`, utilizando un enfoque top-down de programación dinámica con memoización.
	 *
	 * @param cortesVarilla Un array de enteros que indica las posiciones en las que se deben realizar los cortes.
	 * @param largoVarilla La longitud total de la varilla.
	 * @return El costo mínimo de realizar todos los cortes.
	 */
	public int cortarOptimoTopDown(int[] cortesVarilla, int largoVarilla) {
		HashMap<CombinacionCorte, Integer> memo = new HashMap<>();
		long startTime = System.currentTimeMillis();
		int[] varillaCompleta = new int[cortesVarilla.length + 2];
		System.arraycopy(cortesVarilla, 0, varillaCompleta, 1, cortesVarilla.length);
		varillaCompleta[0] = 0;
		varillaCompleta[varillaCompleta.length - 1] = largoVarilla;
		int ganancia = this.cortarOptimoTopDown(varillaCompleta, 0, varillaCompleta.length - 1, memo);
		System.out.println("Cantidad de iteraciones: " + this.iteraciones);
		long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
        this.iteraciones =  0;
		
		return ganancia;
	}
	
	
	/**
	 * Metodo auxiliar recursiva que calcula el costo mínimo de realizar los cortes en la varilla
	 * en el rango especificado por `izq` y `der`, utilizando memoización para evitar cálculos repetidos.
	 *
	 * @param cortesVarilla Un array de enteros que indica las posiciones de los cortes, incluyendo los extremos.
	 * @param izq El índice izquierdo del rango actual en el que se están considerando los cortes.
	 * @param der El índice derecho del rango actual en el que se están considerando los cortes.
	 * @param memo Un HashMap que almacena los costos mínimos calculados para las combinaciones de cortes.
	 * @return El costo mínimo de realizar los cortes en el rango especificado.
	 */
	private int cortarOptimoTopDown(int[] cortesVarilla, int izq, int der, HashMap<CombinacionCorte, Integer> memo) {
		if(izq + 1 == der) {
			return 0;
		}
		CombinacionCorte combinacion = new CombinacionCorte(izq, der);
		if(memo.containsKey(combinacion)) {
			return memo.get(combinacion);
		}
		
		int minCosto = Integer.MAX_VALUE;
		// Recorre todas las posiciones de cortes posibles en el rango actual
		for(int i = izq + 1; i < der; i++) {
			// Calcula el costo de cortar en la posición actual y los costos de los cortes recursivos
			int costo = cortesVarilla[der] - cortesVarilla[izq] + cortarOptimoTopDown(cortesVarilla, izq, i, memo) + cortarOptimoTopDown(cortesVarilla,  i, der, memo);
			if(costo < minCosto) {
				minCosto = costo;
			}
		}
		
		memo.put(combinacion, minCosto);
		
		return minCosto;
	}
}
