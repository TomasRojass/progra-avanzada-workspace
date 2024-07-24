package Test;

import static org.junit.Assert.*;
import Entidades.Monticulo;
import Entidades.MonticuloDeMaximos;
import Excepciones.MonticuloVacioException;
import org.junit.Test;

public class MonticuloDeMaximosTest {

	@Test
	public void sacarElemento1() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMaximos<>();
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(2);
		monticulo.agregarElemento(12);
		monticulo.agregarElemento(25);
		monticulo.agregarElemento(8);
		monticulo.agregarElemento(56);
		monticulo.agregarElemento(60);
		monticulo.agregarElemento(30);

		int resultadoEsperado = 60;
		int resultadoObtenido = monticulo.sacarElemento();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void sacarElemento2() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMaximos<>();
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(2);
		monticulo.agregarElemento(12);
		monticulo.agregarElemento(25);
		monticulo.agregarElemento(8);
		monticulo.agregarElemento(56);
		monticulo.agregarElemento(60);
		monticulo.agregarElemento(30);

		int resultadoEsperado = 56;
		monticulo.sacarElemento();
		int resultadoObtenido = monticulo.sacarElemento();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void verRaiz() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMaximos<>();
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(2);
		monticulo.agregarElemento(12);
		monticulo.agregarElemento(25);
		monticulo.agregarElemento(8);
		monticulo.agregarElemento(56);
		monticulo.agregarElemento(60);
		monticulo.agregarElemento(30);

		int resultadoEsperado = 30;
		monticulo.sacarElemento();
		monticulo.sacarElemento();
		int resultadoObtenido = monticulo.verRaiz();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
