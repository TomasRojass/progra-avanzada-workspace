package Dijkstra;

public interface GrafoDirigido {

	public int getNodos();

	public void setArista(int desde, int hasta, double costo);

	public Double getArista(int desde, int hasta);

}
