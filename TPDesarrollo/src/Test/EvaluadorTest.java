package Test;

import static org.junit.Assert.*;

import Entidades.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class EvaluadorTest {
	
	private static Evaluador evaluador;
	private static List<Fabricante> fabricantes;
	private static List<Comprador> compradores;
	private static MutableInt fabricanteSeleccionado;
	private static MutableInt compradorSeleccionado;

	@Before
	public void setup() throws Exception {
		evaluador = new Evaluador();
		fabricantes = new ArrayList<Fabricante>();
		compradores = new ArrayList<Comprador>();
		fabricanteSeleccionado = new MutableInt(0);
		compradorSeleccionado = new MutableInt(0);
	}

	@Test
	public void primeraPrueba() {
		Archivo archivo = new Archivo("gananciaTest");	// Cambiar los valores del archivo que es el mismo que el ejemplo
		int presupuesto = archivo.leerArchivo(Archivo.RUTA_ARCHIVOS_TESTS, fabricantes, compradores);
		int resultadoEsperado = 3800;
		
		int resultadoObtenido = evaluador.ganancia(presupuesto, fabricantes, compradores, fabricanteSeleccionado, compradorSeleccionado);
		
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
