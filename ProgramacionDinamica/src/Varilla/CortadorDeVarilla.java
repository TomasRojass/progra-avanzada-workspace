package Varilla;

import java.util.HashMap;

public class CortadorDeVarilla {
private int iteraciones;
	
	public CortadorDeVarilla() {
		this.iteraciones = 0;
	}
	
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
	
	private int cortarOptimoTopDown(int[] cortesVarilla, int izq, int der, HashMap<CombinacionCorte, Integer> memo) {
		if(izq + 1 == der) {
			return 0;
		}
		CombinacionCorte combinacion = new CombinacionCorte(izq, der);
		if(memo.containsKey(combinacion)) {
			return memo.get(combinacion);
		}
		
		int minCosto = Integer.MAX_VALUE;
		for(int i = izq + 1; i < der; i++) {
			int costo = cortesVarilla[der] - cortesVarilla[izq] + cortarOptimoTopDown(cortesVarilla, izq, i, memo) + cortarOptimoTopDown(cortesVarilla,  i, der, memo);
			if(costo < minCosto) {
				minCosto = costo;
			}
		}
		
		memo.put(combinacion, minCosto);
		
		return minCosto;
	}
}
