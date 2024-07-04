package Entidades;

public class Arista implements Comparable<Arista> {
	
	public static final int INFINITO = Integer.MAX_VALUE;
	public static final int SIN_COSTO = 0;

	private int origen;
	private int destino;
	private int costo;

	public Arista(int origen, int destino, int costo) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public int compareTo(Arista otro) {
		return this.costo - otro.costo;
	}

}
