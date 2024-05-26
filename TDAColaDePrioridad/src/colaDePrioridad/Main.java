package colaDePrioridad;

public class Main {

	public static void main(String[] args) {
		Integer[] arrayDesordenado = { 8, 125, -3, 88, 4, 54, 33, -7, 5};
		ColaDePrioridad<Integer> colaDePrioridad1 = new MonticuloInt(arrayDesordenado);
		
		System.out.println("-----------------------------------------");
		System.out.println("Mostrando elementos: ");
		colaDePrioridad1.mostrarElementos();
		
		colaDePrioridad1.insertarElemento(-88);
		System.out.println("-----------------------------------------");
		System.out.println("Mostrando elementos: ");
		colaDePrioridad1.mostrarElementos();
		
		colaDePrioridad1.eliminarElemento();
		System.out.println("-----------------------------------------");
		System.out.println("Mostrando elementos: ");
		colaDePrioridad1.mostrarElementos();
		
		colaDePrioridad1.insertarElemento(6);
		colaDePrioridad1.insertarElemento(9);
		colaDePrioridad1.insertarElemento(7);
		System.out.println("-----------------------------------------");
		System.out.println("Mostrando elementos: ");
		colaDePrioridad1.mostrarElementos();

	}

}
