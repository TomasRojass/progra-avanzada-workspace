package ProblemaMochila;

import java.util.HashMap;
import java.util.Map;

public class Robo {

	public double gananciaMaximaTopDown(Item[] artefactos, int capacidad) {
		HashMap<Mochila, Double> mapa = new HashMap<>();
		return gananciaMaximaTopDown(capacidad, 0, artefactos, mapa);
		
		// Descomentar solo para ver como se armo el mapa
		//double resultado = gananciaMaximaTopDown(capacidad, 0, artefactos, mapa);
		//imprimirMapa(mapa);
		//return resultado;
	}
	
    private double gananciaMaximaTopDown(int capacidadDisponible, int pasoActual, Item[] artefactos, HashMap<Mochila, Double> mapa) {
        Mochila mochila = new Mochila(capacidadDisponible, pasoActual);
        
        // Si ya esta en memoria retorno el valor
        if (mapa.containsKey(mochila)) {
            return mapa.get(mochila);
        }

        // Caso base: Recorro todos los artefactos
        //if (pasoActual == artefactos.length || capacidadDisponible == 0)
        if (pasoActual == artefactos.length) {
            mapa.put(mochila, 0.0);
            return 0;
        }

        double gananciaSiNoRobo = gananciaMaximaTopDown(capacidadDisponible, pasoActual + 1, artefactos, mapa);

        // Si me paso de la capacidad, no lo puedo robar (si lo resto me quedaria un peso negativo)
        // Seria equivalente a quedarme con una sola rama del arbol
        if (artefactos[pasoActual].getPeso() > capacidadDisponible) {
            mapa.put(mochila, gananciaSiNoRobo);
            return gananciaSiNoRobo;
        }

        // Si estoy aca, es porque lo puedo robar y calculo la ganancia
        double gananciaSiRobo = artefactos[pasoActual].getPrecio() + gananciaMaximaTopDown(capacidadDisponible - artefactos[pasoActual].getPeso(), pasoActual + 1, artefactos, mapa);

        double maximoEntreHijos = Math.max(gananciaSiNoRobo, gananciaSiRobo);

        mapa.put(mochila, maximoEntreHijos);
        
        // Siempre devuelvo lo que guardo en la mochila, ya sea por caso base, maximo entre hijos o que ya este en el mapa
        return maximoEntreHijos;
    }
	
    @SuppressWarnings("unused")
	private void imprimirMapa (HashMap<Mochila, Double> mapa) {
        for (Map.Entry<Mochila, Double> entry : mapa.entrySet()) {
        	Mochila clave = entry.getKey();
            Double valor = entry.getValue();
            System.out.println("Clave[" + clave + "]\tValor: " + valor);
        }
    }
    
}
