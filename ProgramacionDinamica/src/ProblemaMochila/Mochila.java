package ProblemaMochila;

import java.util.Objects;

public class Mochila {

	int capacidad;
	int numeroItem;
	
	public Mochila(int capacidad, int numeroItem) {
		this.capacidad = capacidad;
		this.numeroItem = numeroItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidad, numeroItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mochila other = (Mochila) obj;
		return capacidad == other.capacidad && numeroItem == other.numeroItem;
	}

	
	@Override
	public String toString() {
		return "Capacidad: " + capacidad + ", Item: " + numeroItem;
	}
	
}
