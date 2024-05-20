package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Evaluador {

	public void iniciar() {
		
		List<Comprador> compradores = new ArrayList<Comprador>();
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		
		Archivo archivo = new Archivo("ganancia");
		int presupuesto = archivo.leerArchivo(Archivo.RUTA_ARCHIVOS_ENTRADA, fabricantes, compradores);
		
		//System.out.println(fabricantes);
		//System.out.println(compradores);
		//System.out.println(presupuesto);
				
		EnteroPorReferencia mejorFabricante = new EnteroPorReferencia(0);
		EnteroPorReferencia mejorComprador = new EnteroPorReferencia(0);
		
		int gananciaMaxima = ganancia(presupuesto, fabricantes, compradores, mejorFabricante, mejorComprador);
		
		System.out.println("Comprando a " + mejorComprador.getValor() + " y vendiendo a " + mejorFabricante.getValor() + " gana " + gananciaMaxima + " por día.");
	}
	
	public int ganancia(int presupuesto, List<Fabricante> fabricantes, List<Comprador> compradores, EnteroPorReferencia mejorFabricante, EnteroPorReferencia mejorComprador) {
		
		int maximaGanancia = 0;
		mejorFabricante.setValor(1);
		mejorComprador.setValor(1);
		
		int compradorActual = 1;
		
		for (Comprador comprador : compradores) {
			
			int gananciaPorVenta = comprador.getCantidadDeUnidadesAComprar() * comprador.getPrecioAPagarPorUnidad();
			int fabricanteActual = 1;
			
			for (Fabricante fabricante : fabricantes) {
				
				int cantidadAPedir = comprador.getCantidadDeUnidadesAComprar() < fabricante.getCantidadMinimaDeUnidades()?
						fabricante.getCantidadMinimaDeUnidades() : comprador.getCantidadDeUnidadesAComprar();
				
				int costoDeFabricante = cantidadAPedir * fabricante.getPrecioACobrarPorUnidad();
				
				if(costoDeFabricante <= presupuesto) {
					
					int gananciaNeta = gananciaPorVenta - costoDeFabricante;
					
					if(gananciaNeta > maximaGanancia) {
						
						maximaGanancia = gananciaNeta;
						mejorFabricante.setValor(fabricanteActual);
						mejorComprador.setValor(compradorActual);
						
					}
				}
				fabricanteActual++;
			}
			compradorActual++;
		}
		return maximaGanancia;
	}
	
}
