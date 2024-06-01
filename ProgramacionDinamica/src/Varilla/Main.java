package Varilla;

//import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		CortadorDeVarilla cortador = new CortadorDeVarilla();
		int[] cortes = {1, 3, 4, 5};
		
		System.out.println("Cortar Top-Down: ");
		System.out.println("Solucion: " + cortador.cortarOptimoTopDown(cortes, 7));
		System.out.println("-----------------------------------------");
	}

}
