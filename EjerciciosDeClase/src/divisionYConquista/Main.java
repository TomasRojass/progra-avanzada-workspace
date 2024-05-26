package divisionYConquista;

public class Main {

	public static void main(String[] args) {
		BusquedaBinariaInt buscador = new BusquedaBinariaInt();
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		int numero = 5;
		
		System.out.println("-----------------------------------------");
		System.out.println("Buscando numero " +  numero + ": ");
		System.out.println("Posicion: " + buscador.buscar(numero, array));
		
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
