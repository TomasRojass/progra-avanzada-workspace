package Principales;

import Busqueda.Busqueda;
import Busqueda.BusquedaBinaria;
import DivisionYConquista.Potencia;
import DivisionYConquista.SumaElementosArray;
import StreetNumbers.StreetNumberCalculator;

//Casos de prueba
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
		
		Busqueda buscador = new BusquedaBinaria();
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		int numero = 5;

		System.out.println("-----------------------------------------");
		System.out.println("Buscando numero " + numero + ": ");
		System.out.println("Posicion: " + buscador.buscar(array, numero));

		int potencia = 5;
		Potencia calculadorDePotencia = new Potencia();
		System.out.println("-----------------------------------------");
		System.out.println("El numero " + numero + " elevado a la " + potencia + " es: ");
		System.out.println("Resultado: " + calculadorDePotencia.calcularPotencia(numero, potencia));

		SumaElementosArray sumador = new SumaElementosArray();
		System.out.println("-----------------------------------------");
		System.out.println("La suma del array es " + sumador.sumar(array));
	}

}
