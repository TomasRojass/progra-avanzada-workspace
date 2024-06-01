package Varilla;

import java.util.Objects;

public class CombinacionCorte {
	private int izq;
	private int der;
	
	public CombinacionCorte(int izq, int der) {
		this.izq = izq;
		this.der = der;
	}

	public int getIzq() {
		return izq;
	}

	public void setIzq(int izq) {
		this.izq = izq;
	}

	public int detDer() {
		return der;
	}

	public void setDer(int der) {
		this.der = der;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(izq, der);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CombinacionCorte other = (CombinacionCorte) obj;
		return izq == other.izq && der == other.der;
	}
}
