package Entidades;

public class Validacion {

	private static final int LIMITE_INFERIOR_PRESUPUESTO = 1;
	private static final int LIMITE_SUPERIOR_PRESUPUESTO = 1000000000;
	
	private static final int LIMITE_INFERIOR_PERSONAS = 1;
	private static final int LIMITE_SUPERIOR_PERSONAS = 100000;
	
	private static final int LIMITE_INFERIOR_PRECIO = 1;
	private static final int LIMITE_SUPERIOR_PRECIO = 10000;
	
	private static final int LIMITE_INFERIOR_CANTIDAD = 1;
	private static final int LIMITE_SUPERIOR_CANTIDAD = 100000;

	public static int verificarRangos(int presupuesto, int cantidadDeFabricantes, int cantidadDeCompradores) {
		return (presupuesto >= LIMITE_INFERIOR_PRESUPUESTO && presupuesto <= LIMITE_SUPERIOR_PRESUPUESTO) && 
			   (cantidadDeFabricantes >= LIMITE_INFERIOR_PERSONAS && cantidadDeFabricantes <= LIMITE_SUPERIOR_PERSONAS) && 
			   (cantidadDeCompradores >= LIMITE_INFERIOR_PERSONAS && cantidadDeCompradores <= LIMITE_SUPERIOR_PERSONAS)?
				Constante.TODO_OK : Constante.ERROR_RANGOS; 
	}
	
	public static int verificarPrecioYCantidad (int precio, int cantidad) {
		return (precio >= LIMITE_INFERIOR_PRECIO && precio <= LIMITE_SUPERIOR_PRECIO) && (cantidad >= LIMITE_INFERIOR_CANTIDAD && cantidad <= LIMITE_SUPERIOR_CANTIDAD)?
				Constante.TODO_OK : Constante.ERROR_RANGOS;
	}
	
}
