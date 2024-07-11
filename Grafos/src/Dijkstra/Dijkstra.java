package Dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Dijkstra implements GrafoDirigido {
	LinkedList<PriorityQueue<Nodo>> grafo;
	private int[] predecesores = null;
	
	public Dijkstra(int tam) {
		this.grafo = new LinkedList<>();
		for (int i = 0 ; i < tam; i++) {
			this.grafo.add(new PriorityQueue<>());
		}
	}
	
	public int [] getPredecesores() {
		return this.predecesores;
	}

	@Override
	public int getNodos() {
		return this.grafo.size();
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		this.grafo.get(desde).add(new Nodo(hasta, costo));
	}

	@Override
	public Double getArista(int desde, int hasta) {
		for(Nodo nodo: this.grafo.get(desde)) {
			if(nodo.getId() == hasta) {
				return nodo.getPeso();
			}
		}
		
		return null;
	}

	public double[] dijkstra(int desde) {
		predecesores = new int[this.getNodos()];
		boolean[] visitados = new boolean[this.getNodos()];
		double[] distancias = new double[this.getNodos()];
		double I = Double.MAX_VALUE;
		
		// Se inicializa el vector distancias con infinito en todas las posiciones
		for(double distanciaNodo: distancias) {
			distanciaNodo = I;
		}
		
		Set<Integer> vMenosS = new HashSet<Integer>();

		// cargo vMenosS con todos los nodos excepto el que se encuentra ya en s
		for (int i = 0; i < this.getNodos(); i++) {
			if (desde != i)
				vMenosS.add(i);
		}
		
		// Se inicializa vector de predecesores con el nodo inicial
		for(int predecesor: predecesores) {
			predecesor = desde;
		}
		
		predecesores[desde] = desde;
		visitados[desde] = true;
		distancias[desde] = 0;
		
		// Primer paso: se carga en distancias todas las distancias a nodos directos
		// desde el nodo inicial
		for(Nodo predecesor: this.grafo.get(desde)) {
			distancias[predecesor.getId()] = predecesor.getPeso();
		}
		
		// Segundo y n pasos... Mientras vMenosS no sea vacio
		while(!vMenosS.isEmpty()) {
			boolean bandera = false;
			double min = 0;
			int w = 0;
			
			// busco nuevo w para iteracion
			for(int sucesor: vMenosS) {
				if(!bandera) {
					min = distancias[sucesor];
					w = sucesor;
					bandera = true;
				}
				else {
					if (min > distancias[sucesor]) {
						min = distancias[sucesor];
						w = sucesor;
					}
				}
			}
			
			vMenosS.remove(w);
			visitados[w] = true;
			
			//recalculo distancias para ese w
			for(Nodo sucesor: this.grafo.get(w)) {
				if(distancias[sucesor.getId()] > distancias[w] + sucesor.getPeso()) {
					distancias[sucesor.getId()] = distancias[w] + sucesor.getPeso();
					predecesores[sucesor.getId()] = w;
				}
			}
		}
		
		return distancias;
	}
	
	public List <Integer> caminoHastaNodo(int desde, int hasta){
		List<Integer> lista= new LinkedList <Integer>();
		Stack <Integer> pila= new Stack <Integer>();
		pila.push(hasta);
		while (this.predecesores[hasta] != desde) {
			pila.push(this.predecesores[hasta]);
			hasta = this.predecesores[hasta];
		}
		pila.push(desde);
		while (!pila.empty()) {
			lista.add(pila.pop());
		}
		return lista;
	}
}

