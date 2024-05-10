package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ejercicios.MinaDeOro;

public class MinaDeOroTest {

	private static MinaDeOro minaDeOro;

	@Before
	public void setUp() throws Exception {
		minaDeOro = new MinaDeOro();
	}

	@Test
	public void minaConUnaFila() {
		int[][] mina = { { 3, 2, 12, 15, 10 } };
		int resultadoEsperado = 15;

		int resultadoObtenido = minaDeOro.obtenerOroMaximoBottomUp(mina);

		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void minaConUnaColumna() {
		int[][] mina = { { 3 }, { 6 }, { 8 }, { 3 } };
		int resultadoEsperado = 20;

		int resultadoObtenido = minaDeOro.obtenerOroMaximoBottomUp(mina);

		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void minaNoCuadrada() {
		int[][] mina = { { 3, 2, 12, 15, 10 }, { 6, 19, 7, 11, 17 }, { 8, 5, 12, 32, 21 }, { 3, 20, 2, 9, 7 } };
		int resultadoEsperado = 73;

		int resultadoObtenido = minaDeOro.obtenerOroMaximoBottomUp(mina);

		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void minaCuadrada() {
		int[][] mina = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, };
		int resultadoEsperado = 240;

		int resultadoObtenido = minaDeOro.obtenerOroMaximoBottomUp(mina);

		assertEquals(resultadoObtenido, resultadoEsperado);
	}

}
