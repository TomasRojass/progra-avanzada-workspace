import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		int largoVarilla = 5;
		int[] cortes = { 2, 4 };
		System.out.println("Costo optimo:" + cortar(largoVarilla, cortes));
	}
	
	//Punto de corte	Clave
	//Costo				Valor
	
	//HashMap<Integer, Integer> mapa = new HashMap<>();
	//int costoOptimo = cortar(largoVarilla, cortes, mapa);
	
	public static int cortar(int largoVarilla, int[] cortes) {
		
		//int mitad = largoVarilla / 2;
		//int corteMasViable = buscarMitadMasCercana(cortes, mitad);
		
		//int costo = Math.min(, );
		
		//cortar(corteMasViable, cortes, mitad - 1, cortes.length);
		//cortar(largoVarilla - corteMasViable, cortes, 0, mitad + 1);
		
		return largoVarilla;
	}
	
	private static int cortar(int largoVarilla, int[] cortes, int inicio, int fin) {
		//if() {
			
		//}
		
		return 0;
	}

}
