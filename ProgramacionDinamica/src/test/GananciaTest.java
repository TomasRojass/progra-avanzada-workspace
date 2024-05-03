package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ejercicios.Ganancia;

public class GananciaTest {

	private static Ganancia ganancia;
	
	@Before
	public void setUp() throws Exception{
		ganancia = new Ganancia();
	}

	@Test
	public void gananciaConUnElemento() {
		int[] vector = {2};
		int resultadoEsperado = vector[0];
		
		int resultadoObtenido = ganancia.robarGananciaMaximaMetodoBottomUp(vector);
		
		assertEquals(resultadoObtenido, resultadoEsperado);
	}
	
	@Test
	public void gananciaConDosElementos() {
		int[] vector = {50, 25};
		int resultadoEsperado = Math.max(vector[0], vector[1]);
		
		int resultadoObtenido = ganancia.robarGananciaMaximaMetodoBottomUp(vector);
		
		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void gananciaConPosicionesIntercalas() {
		int[] vector = {3, 2, 7, 10, 6};
		int resultadoEsperado = 16;		//3 + 7 + 6
		
		int resultadoObtenido = ganancia.robarGananciaMaximaMetodoBottomUp(vector);
		
		assertEquals(resultadoObtenido, resultadoEsperado);
	}
	
	@Test
	public void gananciaConPosicionesNoIntercaladas() {
		int[] vector = {2, 10, 3, 6, 8, 1, 7};
		int resultadoEsperado = 25;		//10 + 8 + 7
		
		int resultadoObtenido = ganancia.robarGananciaMaximaMetodoBottomUp(vector);
		
		assertEquals(resultadoObtenido, resultadoEsperado);
	}
}