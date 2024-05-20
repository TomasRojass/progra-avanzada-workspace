package Varilla;

import java.util.Objects;

public class Par {

	private int inicio;
	private int fin;
	
	public Par(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	public int getInicio() {
		return inicio;
	}

	public int getFin() {
		return fin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fin, inicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Par other = (Par) obj;
		return fin == other.fin && inicio == other.inicio;
	}
	
	
	
}
