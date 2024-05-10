package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ProblemaMochila.Item;
import ProblemaMochila.Robo;

public class RoboMochilaTest {

	private static Robo robo;
	private static double TOLERANCIA = 0.001;

	@Before
	public void setUp() throws Exception {
		robo = new Robo();
	}

	@Test
	public void primerEjemplo() {
		int capacidadMaxima = 3;
		Item[] items = { new Item(1, 400), new Item(1, 300), new Item(2, 150) };
		double resultadoEsperado = 700;

		double resultadoObtenido = robo.gananciaMaximaTopDown(items, capacidadMaxima);

		assertEquals(resultadoEsperado, resultadoObtenido, TOLERANCIA);
	}

	@Test
	public void segundoEjemplo() {
		int capacidadMaxima = 4;
		Item[] items = { new Item(4, 400), new Item(3, 300), new Item(1, 150) };
		double resultadoEsperado = 450;

		double resultadoObtenido = robo.gananciaMaximaTopDown(items, capacidadMaxima);

		assertEquals(resultadoEsperado, resultadoObtenido, TOLERANCIA);
	}

	@Test
	public void tercerEjemplo() {
		int capacidadMaxima = 20;
		Item[] items = { new Item(6, 20), new Item(13, 30), new Item(7, 15), new Item(10, 25), new Item(3, 10) };
		double resultadoEsperado = 55;

		double resultadoObtenido = robo.gananciaMaximaTopDown(items, capacidadMaxima);

		assertEquals(resultadoEsperado, resultadoObtenido, TOLERANCIA);
	}

}
