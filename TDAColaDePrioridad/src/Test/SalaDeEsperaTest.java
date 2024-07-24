package Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import Excepciones.MonticuloVacioException;
import Hospital.Enfermedad;
import Hospital.Paciente;
import Hospital.Prioridad;
import Hospital.SalaDeEspera2;

public class SalaDeEsperaTest {

	private SalaDeEspera2 sala;

	private Paciente juan, pedro, micaela, ana, luis, carlos, jose, marcela, eduardo;

	private List<Enfermedad> enfermedades, enfermedadesJuan, enfermedadesPedro, enfermedadesMicaela, enfermedadesAna,
			enfermedadesLuis, enfermedadesCarlos, enfermedadesJose, enfermedadesMarcela, enfermedadesEduardo;

	private Enfermedad paroCardiaco = new Enfermedad("Paro cardíaco", Prioridad.RESUCITACION);
	private Enfermedad ataqueAlCorazon = new Enfermedad("Ataque al corazón", Prioridad.EMERGENCIA);
	private Enfermedad fracturaPierna = new Enfermedad("Fractura de Pierna", Prioridad.EMERGENCIA);
	private Enfermedad fiebreAlta = new Enfermedad("Fiebre Alta", Prioridad.URGENCIA);
	private Enfermedad alergia = new Enfermedad("Alergia", Prioridad.POCA_URGENCIA);
	private Enfermedad dolorDeGarganta = new Enfermedad("Dolor de Garganta", Prioridad.POCA_URGENCIA);
	private Enfermedad gripe = new Enfermedad("Gripe", Prioridad.POCA_URGENCIA);
	private Enfermedad influenza = new Enfermedad("Influenza", Prioridad.POCA_URGENCIA);
	private Enfermedad dolorDeCabeza = new Enfermedad("Dolor de cabeza", Prioridad.SIN_URGENCIA);
	private Enfermedad dolorDeMuelas = new Enfermedad("Dolor de Muelas", Prioridad.SIN_URGENCIA);
	private Enfermedad fractura = new Enfermedad("Fractura", Prioridad.SIN_URGENCIA);

	@Before
	public void SetUp() {
		this.sala = new SalaDeEspera2();

		this.enfermedades = new ArrayList<Enfermedad>();
		this.enfermedadesJuan = new ArrayList<Enfermedad>();
		this.enfermedadesPedro = new ArrayList<Enfermedad>();
		this.enfermedadesMicaela = new ArrayList<Enfermedad>();
		this.enfermedadesAna = new ArrayList<Enfermedad>();
		this.enfermedadesLuis = new ArrayList<Enfermedad>();
		this.enfermedadesCarlos = new ArrayList<Enfermedad>();
		this.enfermedadesJose = new ArrayList<Enfermedad>();
		this.enfermedadesMarcela = new ArrayList<Enfermedad>();
		this.enfermedadesEduardo = new ArrayList<Enfermedad>();

		this.juan = new Paciente("Juan", enfermedadesJuan);
		this.pedro = new Paciente("Pedro", enfermedadesPedro);
		this.micaela = new Paciente("Micaela", enfermedadesMicaela);
		this.ana = new Paciente("Ana", enfermedadesAna);
		this.luis = new Paciente("Luis", enfermedadesLuis);
		this.carlos = new Paciente("Carlos", enfermedadesCarlos);
		this.jose = new Paciente("Jose", enfermedadesJose);
		this.marcela = new Paciente("Marcela", enfermedadesMarcela);
		this.eduardo = new Paciente("Eduardo", enfermedadesEduardo);
	}

	@Test
	public void insertarPacienteCorrectamente() {
		int resultadoEsperado = 2;
		enfermedadesJuan.add(dolorDeCabeza);
		enfermedadesJuan.add(gripe);
		sala.agregarPaciente(this.juan);
		int resultadoObtenido = sala.getTope();
		assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void insertarYAtenderPacienteCorrectamente() throws MonticuloVacioException {
		int resultadoEsperado = 1;
		String nombreEsperado = "Juan";
		this.enfermedadesJuan.add(dolorDeCabeza);
		this.sala.agregarPaciente(this.juan);
		Paciente pacienteAtendido = this.sala.atenderPaciente();
		int resultadoObtenido = this.sala.getTope();
		String nombreObtenido = pacienteAtendido.getNombre();
		assertEquals(resultadoObtenido, resultadoEsperado);
		assertEquals(nombreObtenido, nombreEsperado);
	}

	@Test
	public void atenderEnOrdenDePrioridadCorrectamente() throws MonticuloVacioException {
		int resultadoEsperado = 1;
		String nombrePrimerPacienteEsperado = "Pedro";
		String nombreSegundoPacienteEsperado = "Juan";
		this.enfermedadesJuan.add(this.dolorDeCabeza);
		this.enfermedadesPedro.add(this.paroCardiaco);
		this.sala.agregarPaciente(this.juan);
		this.sala.agregarPaciente(this.pedro);
		Paciente primerPacienteAtendido = this.sala.atenderPaciente();
		Paciente segundoPacienteAtendido = this.sala.atenderPaciente();
		int resultadoObtenido = this.sala.getTope();
		String nombrePrimerPacienteObtenido = primerPacienteAtendido.getNombre();
		String nombreSegundoPacienteObtenido = segundoPacienteAtendido.getNombre();
		assertEquals(resultadoObtenido, resultadoEsperado);
		assertEquals(nombrePrimerPacienteObtenido, nombrePrimerPacienteEsperado);
		assertEquals(nombreSegundoPacienteObtenido, nombreSegundoPacienteEsperado);
	}

	@Test
	public void atenderEnOrdenDeMismaPrioridadCorrectamente() throws MonticuloVacioException {
		int resultadoEsperado = 1;
		String nombrePrimerPacienteEsperado = "Juan";
		String nombreSegundoPacienteEsperado = "Pedro";
		this.enfermedades.add(this.dolorDeCabeza);
		this.juan.setEnfermedades(this.enfermedades);
		this.pedro.setEnfermedades(this.enfermedades);
		this.sala.agregarPaciente(this.juan);
		this.sala.agregarPaciente(this.pedro);
		Paciente primerPacienteAtendido = this.sala.atenderPaciente();
		Paciente segundoPacienteAtendido = this.sala.atenderPaciente();
		int resultadoObtenido = this.sala.getTope();
		String nombrePrimerPacienteObtenido = primerPacienteAtendido.getNombre();
		String nombreSegundoPacienteObtenido = segundoPacienteAtendido.getNombre();
		assertEquals(resultadoObtenido, resultadoEsperado);
		assertEquals(nombrePrimerPacienteObtenido, nombrePrimerPacienteEsperado);
		assertEquals(nombreSegundoPacienteObtenido, nombreSegundoPacienteEsperado);
	}

	@Test
	public void mostrarPacientesCorrectamente() {
		enfermedadesJuan.add(dolorDeCabeza);
		enfermedadesJuan.add(ataqueAlCorazon);

		enfermedadesPedro.add(paroCardiaco);
		enfermedadesPedro.add(gripe);

		enfermedadesMicaela.add(gripe);

		enfermedadesAna.add(fractura);
		enfermedadesAna.add(fiebreAlta);

		enfermedadesLuis.add(alergia);
		enfermedadesLuis.add(gripe);

		enfermedadesCarlos.add(dolorDeGarganta);
		enfermedadesCarlos.add(ataqueAlCorazon);

		enfermedadesMarcela.add(influenza);
		enfermedadesMarcela.add(fracturaPierna);

		enfermedadesJose.add(dolorDeMuelas);
		enfermedadesJose.add(gripe);

		enfermedadesEduardo.add(paroCardiaco);
		enfermedadesEduardo.add(fractura);

		sala.agregarPaciente(pedro);
		sala.agregarPaciente(juan);
		sala.agregarPaciente(micaela);
		sala.agregarPaciente(ana);
		sala.agregarPaciente(luis);
		sala.agregarPaciente(carlos);
		sala.agregarPaciente(jose);
		sala.agregarPaciente(marcela);
		sala.agregarPaciente(eduardo);

		Comparable<Paciente>[] pacientesObtenidosComparable = this.sala.getVector();
		Paciente[] pacientesObtenidos = new Paciente[this.sala.getTope()];
		System.arraycopy(pacientesObtenidosComparable, 0, pacientesObtenidos, 0, this.sala.getTope());
		Paciente[] pacientesEsperados = { null, pedro, eduardo, carlos, juan, luis, micaela, jose, ana, marcela };
		assertArrayEquals(pacientesEsperados, pacientesObtenidos);
	}

}
