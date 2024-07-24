package Rescate;

import java.util.*;
import Entidades.*;
import Costos.Dijkstra;
import Excepciones.VerticeInvalidoException;

public class Rescate {

	private Grafo<Integer> bosque;

	private List<Vertice<Integer>> ubicacionDragones;

	private Vertice<Integer> claroPrincipe;

	private Vertice<Integer> claroPrincesa;

	public Rescate(int cantidadDeClaros, int cantidadDeSenderos, int[] dragones, int claroPrincesa, int claroPrincipe,
			int[][] senderos) {
		this.claroPrincesa = new Vertice<>(claroPrincesa);
		this.claroPrincipe = new Vertice<>(claroPrincipe);
		this.bosque = new GrafoMatriz<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO, cantidadDeClaros);
		cargarBosque(cantidadDeClaros, senderos);
		cargarListaDeDragones(dragones);
	}

	public String resolver() {
		Dijkstra<Integer> dijkstraPrincesa = new Dijkstra<>();
		Dijkstra<Integer> dijkstraPrincipe = new Dijkstra<>();
		String salida = null;
		try {
			// Aplicar Dijkstra desde la princesa
			dijkstraPrincesa.aplicarAlgoritmo(bosque, claroPrincesa);
			Map<Vertice<Integer>, Double> distanciasPrincesa = dijkstraPrincesa.getDistancias();

			// Aplicar Dijkstra desde el príncipe
			dijkstraPrincipe.aplicarAlgoritmo(bosque, claroPrincipe);
			Map<Vertice<Integer>, Double> distanciasPrincipe = dijkstraPrincipe.getDistancias();

			// Inicializar variables para el camino y el puntaje máximo
			List<Vertice<Integer>> mejorCamino = new ArrayList<>();
			double mejorPuntaje = Double.MAX_VALUE;

			// Evaluar todos los caminos posibles desde el príncipe
			for (Vertice<Integer> vertice : bosque.obtenerVertices()) {
				if (distanciasPrincipe.containsKey(vertice) && distanciasPrincesa.containsKey(vertice)) {
					double puntaje = distanciasPrincipe.get(vertice) + distanciasPrincesa.get(vertice);
					if (puntaje < mejorPuntaje) {
						// Concatenar los caminos sin repetir el vértice intermedio
						List<Vertice<Integer>> caminoPrincipe = dijkstraPrincipe.encontrarCaminoMinimo(bosque,
								claroPrincipe, vertice);
						List<Vertice<Integer>> caminoPrincesa = dijkstraPrincesa.encontrarCaminoMinimo(bosque, vertice,
								claroPrincesa);
						List<Vertice<Integer>> caminoCompleto = new ArrayList<>(caminoPrincipe);
						caminoCompleto.addAll(caminoPrincesa.subList(1, caminoPrincesa.size()));

						// Verificar si algún dragón está en el camino completo
						boolean interceptado = false;
						for (Vertice<Integer> dragon : ubicacionDragones) {
							if (caminoCompleto.contains(dragon)) {
								interceptado = true;
								break;
							}
						}

						if (!interceptado) {
							mejorPuntaje = puntaje;
							mejorCamino = caminoCompleto;
						}
					}
				}
			}

			// Construir la salida con el mejor camino seguro
			if (!mejorCamino.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				for (Vertice<Integer> vertice : mejorCamino) {
					sb.append(vertice.getValor()).append(" ");
				}
				salida = sb.toString().trim();
			} else if (mejorCamino.isEmpty() && bosque.obtenerVertices().contains(claroPrincesa)) {
				// Verificar si existe camino desde el príncipe a la princesa
				if (distanciasPrincipe.get(claroPrincesa) == Arista.INFINITO_DOUBLE) {
					salida = "NO HAY CAMINO";
				} else {
					salida = "INTERCEPTADO";
				}
			} else {
				salida = "INTERCEPTADO";
			}

		} catch (VerticeInvalidoException e) {
			e.printStackTrace();
		}
		return salida.trim();
	}

	// Privados

	private void cargarListaDeDragones(int[] dragones) {
		this.ubicacionDragones = new ArrayList<>();
		for (int dragon : dragones) {
			this.ubicacionDragones.add(new Vertice<>(dragon));
		}
	}

	private void cargarBosque(int cantidadDeClaros, int[][] senderos) {
		for (int claro = 1; claro <= cantidadDeClaros; claro++) {
			this.bosque.agregarVertice(new Vertice<>(claro));
		}

		for (int[] sendero : senderos) {
			Vertice<Integer> origen = new Vertice<>(sendero[0]);
			Vertice<Integer> destino = new Vertice<>(sendero[1]);
			double peso = sendero[2];
			this.bosque.agregarArista(origen, destino, peso);
		}
	}

}
