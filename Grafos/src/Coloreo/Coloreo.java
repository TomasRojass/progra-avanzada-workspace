package Coloreo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Entidades.Vertice;

public class Coloreo<T> {

	private Map<Vertice<T>, Color> mapaColores;

	private int numeroCromatico;

	public Coloreo() {
		this.mapaColores = new HashMap<>();
		this.numeroCromatico = 0;
	}

	public void asignarColor(Vertice<T> vertice, Color color) {
		mapaColores.put(vertice, color);
		calcularNumeroCromatico();
	}

	public Color obtenerColor(Vertice<T> vertice) {
		return mapaColores.get(vertice);
	}

	public int getNumeroCromatico() {
		return numeroCromatico;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Vertice<T>, Color> entry : mapaColores.entrySet()) {
			sb.append("Vértice ").append(entry.getKey()).append(" -> Color: ").append(entry.getValue()).append("\n");
		}
		return sb.toString();
	}

	private void calcularNumeroCromatico() {
		Set<Color> coloresUsados = new HashSet<>(mapaColores.values());
		numeroCromatico = coloresUsados.size();
	}

}
