package Pedregal;

public class PlanConstruccion {
	private int frenteCasa;
	private int ladoCasa;
	private int[][] terreno;
	private int[] ubicacionCasa;
	
	public PlanConstruccion() {
		this.frenteCasa = 0;
		this.ladoCasa = 0;
		this.terreno = null;
		this.ubicacionCasa = null;
	}

	public int[] getUbicacionCasa() {
		return ubicacionCasa;
	}

	public void setUbicacionCasa(int[] ubicacionCasa) {
		this.ubicacionCasa = ubicacionCasa;
	}

	public int getFrenteCasa() {
		return frenteCasa;
	}

	public void setFrenteCasa(int frenteCasa) {
		this.frenteCasa = frenteCasa;
	}

	public int getLadoCasa() {
		return ladoCasa;
	}
	
	public void setLadoCasa(int ladoCasa) {
		this.ladoCasa = ladoCasa;
	}

	public int[][] getTerreno() {
		return terreno;
	}

	public void setTerreno(int[][] terreno) {
		this.terreno = terreno;
	}
}
