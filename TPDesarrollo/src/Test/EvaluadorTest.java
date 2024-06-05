	package Test;

import static org.junit.Assert.*;

import Entidades.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class EvaluadorTest {
	
	private static List<Fabricante> fabricantes;
	private static List<Comprador> compradores;
	private static MutableInt fabricanteSeleccionado;
	private static MutableInt compradorSeleccionado;
	private static MutableInt presupuesto;

	@Before
	public void setup() throws Exception {
		new Evaluador();
		fabricantes = new ArrayList<Fabricante>();
		compradores = new ArrayList<Comprador>();
		fabricanteSeleccionado = new MutableInt(0);
		compradorSeleccionado = new MutableInt(0);
		presupuesto = new MutableInt(0);
	}

	@Test
	public void existeGananciaEnLaPrimeraIteracion() {
		Archivo archivo = new Archivo("gananciaEnLaPrimeraIteracion");	
		archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
		int resultadoEsperado = 3800;
		int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
		
	@Test
	public void existeGananciaMaxima() {
		Archivo archivo = new Archivo("gananciaTest");	
		archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
		int resultadoEsperado = 3800;
		int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	public void resignarNegocio() {
		Archivo archivo = new Archivo("archivoConBajoPresupuesto");
		archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
		int resultadoEsperado = Constante.RESIGNAR_NEGOCIO;
		int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	// 3600 1 2
		// 200 6
		// 200 10
		// 600 7
		@Test
		public void deberiaElegirCompradorConMenorGanancia() {
			Archivo archivo = new Archivo("compradorConMenorGanancia");	
			archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
			int resultadoEsperado = 800;
			int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
			assertEquals(resultadoEsperado, resultadoObtenido);
		}
		
		@Test
		public void deberiaElegirFabricanteConMenorPrecio() {
			Archivo archivo = new Archivo("fabricanteConMenorPrecio");	
			archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
			int resultadoEsperado = 2400;
			int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
			assertEquals(resultadoEsperado, resultadoObtenido);
		}
		
		@Test
		public void deberiaElegirFabricanteConMenorCostoTotal() {
			Archivo archivo = new Archivo("fabricanteConMenorCostoTotal");	
			archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
			int resultadoEsperado = 800;
			int resultadoObtenido = Evaluador.ganancia(presupuesto.getValor(), fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
			assertEquals(resultadoEsperado, resultadoObtenido);
		}
		
	
}
