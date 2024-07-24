package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Coloreo.Coloreo;
import Coloreo.Secuencial;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;

public class SecuencialTest {

	private Secuencial secuencial;

	private Grafo<Character> grafoDeCaracteres;

	private Grafo<Integer> grafoDeEnteros;

	private Vertice<Character> A, B, C, D, E, F, G, H, I, J;

	private Vertice<Integer> uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;

	@Before
	public void setUp() throws Exception {
		secuencial = new Secuencial();

		grafoDeCaracteres = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.NO_ES_PONDERADO);

		grafoDeEnteros = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);

		A = new Vertice<>('A');
		B = new Vertice<>('B');
		C = new Vertice<>('C');
		D = new Vertice<>('D');
		E = new Vertice<>('E');
		F = new Vertice<>('F');
		G = new Vertice<>('G');
		H = new Vertice<>('H');
		I = new Vertice<>('I');
		J = new Vertice<>('J');

		uno = new Vertice<Integer>(1);
		dos = new Vertice<Integer>(2);
		tres = new Vertice<Integer>(3);
		cuatro = new Vertice<Integer>(4);
		cinco = new Vertice<Integer>(5);
		seis = new Vertice<Integer>(6);
		siete = new Vertice<Integer>(7);
		ocho = new Vertice<Integer>(8);
		nueve = new Vertice<Integer>(9);
		diez = new Vertice<Integer>(10);
	}

	@Test
	public void testEjercicioDeClase() {

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		grafoDeCaracteres.agregarVertice(D);
		grafoDeCaracteres.agregarVertice(E);
		grafoDeCaracteres.agregarVertice(F);
		grafoDeCaracteres.agregarVertice(G);
		grafoDeCaracteres.agregarVertice(H);
		grafoDeCaracteres.agregarVertice(I);
		grafoDeCaracteres.agregarVertice(J);

		grafoDeCaracteres.agregarArista(A, B);
		grafoDeCaracteres.agregarArista(A, F);
		grafoDeCaracteres.agregarArista(B, E);
		grafoDeCaracteres.agregarArista(C, F);
		grafoDeCaracteres.agregarArista(C, G);
		grafoDeCaracteres.agregarArista(D, E);
		grafoDeCaracteres.agregarArista(D, H);
		grafoDeCaracteres.agregarArista(E, I);
		grafoDeCaracteres.agregarArista(F, G);
		grafoDeCaracteres.agregarArista(F, I);
		grafoDeCaracteres.agregarArista(F, J);
		grafoDeCaracteres.agregarArista(G, J);
		grafoDeCaracteres.agregarArista(H, I);
		grafoDeCaracteres.agregarArista(I, J);

		Coloreo<Character> coloreoGrafo = secuencial.colorearGrafo(grafoDeCaracteres);
		int resultadoObtenido = coloreoGrafo.getNumeroCromatico();
		int resultadoEsperado = 4;

		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void testEjercicioRecuperatorio() {

		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);
		grafoDeEnteros.agregarVertice(cuatro);
		grafoDeEnteros.agregarVertice(cinco);
		grafoDeEnteros.agregarVertice(seis);
		grafoDeEnteros.agregarVertice(siete);
		grafoDeEnteros.agregarVertice(ocho);
		grafoDeEnteros.agregarVertice(nueve);
		grafoDeEnteros.agregarVertice(diez);

		grafoDeEnteros.agregarArista(uno, cinco);
		grafoDeEnteros.agregarArista(uno, seis);
		grafoDeEnteros.agregarArista(dos, cinco);
		grafoDeEnteros.agregarArista(dos, ocho);
		grafoDeEnteros.agregarArista(tres, diez);
		grafoDeEnteros.agregarArista(cuatro, siete);
		grafoDeEnteros.agregarArista(cuatro, nueve);
		grafoDeEnteros.agregarArista(seis, siete);
		grafoDeEnteros.agregarArista(siete, nueve);
		grafoDeEnteros.agregarArista(siete, diez);

		Coloreo<Integer> coloreoGrafo = secuencial.colorearGrafo(grafoDeEnteros);
		int resultadoObtenido = coloreoGrafo.getNumeroCromatico();
		int resultadoEsperado = 3;

		assertEquals(resultadoObtenido, resultadoEsperado);

	}
}
