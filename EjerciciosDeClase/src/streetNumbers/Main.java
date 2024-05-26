package streetNumbers;

import streetNumberCalculator.StreetNumberCalculator;

// Casos de prueba
//6 8
//35 49
//204 288
//1189 1681
//6930 9800
//40391 57121
//235416 332928
//1372105 1940449
//7997214 11309768
//46611179 65918161

public class Main {

	public static void main(String[] args) {
		
		StreetNumberCalculator calculator = new StreetNumberCalculator();
		System.out.println("Mi algoritmo de calculo: ");
		System.out.println("Solucion: " + calculator.calculateStreetNumberMine(332928));
		System.out.println("-----------------------------------------");
		System.out.println("Ejemplo O(n2): ");
		System.out.println("Solucion: " + calculator.calculateStreetNumberON2(332928));
		System.out.println("-----------------------------------------");
		System.out.println("Ejemplo O(n): ");
		System.out.println("Solucion: " + calculator.calculateStreetNumberON(332928));
		System.out.println("-----------------------------------------");
		System.out.println("Ejemplo O(1) ");
		System.out.println("Solucion: " + calculator.calculateStreetNumberO1(332928));
	}
}

