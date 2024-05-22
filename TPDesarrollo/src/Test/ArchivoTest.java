package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entidades.Archivo;
import Entidades.Comprador;
import Entidades.Constante;
import Entidades.Fabricante;
import Entidades.MutableInt;

public class ArchivoTest {
	
	private static List<Fabricante> fabricantes;
	private static List<Comprador> compradores;
	private static MutableInt presupuesto;

	@Before
	public void setup() throws Exception {
		fabricantes = new ArrayList<Fabricante>();
		compradores = new ArrayList<Comprador>();
		presupuesto = new MutableInt(0);
	}

	@Test
	public void valoresFueraDelRango() {
		// Arrange
		Archivo archivo = new Archivo("archivoConValoresFueraDeRango");
		int resultadoEsperado = Constante.ERROR_RANGOS;
		
		// Act
		int resultadoObtenido = archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
		
		// Assert
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void archivoVacio() {
		// Arrange
		Archivo archivo = new Archivo("archivoVacio");
		int resultadoEsperado = Constante.ARCHIVO_VACIO;
		
		// Act
		int resultadoObtenido = archivo.leerArchivo(Constante.RUTA_ARCHIVOS_TESTS, fabricantes, compradores, presupuesto);
	
		// Assert
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
