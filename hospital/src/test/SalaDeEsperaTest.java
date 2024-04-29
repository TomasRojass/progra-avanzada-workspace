package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hospital.Enfermedad;
import hospital.Paciente;
import hospital.Prioridad;
import hospital.SalaDeEspera;

public class SalaDeEsperaTest {

	private static SalaDeEspera sala;

	private static Enfermedad paroCardiaco = new Enfermedad("Paro cardíaco", Prioridad.RESUCITACION);
	
	private static Enfermedad ataqueAlCorazon = new Enfermedad("Ataque al corazón", Prioridad.EMERGENCIA);
	private static Enfermedad fracturaPierna = new Enfermedad("Fractura de Pierna", Prioridad.EMERGENCIA);
	
	private static Enfermedad fiebreAlta = new Enfermedad("Fiebre Alta", Prioridad.URGENCIA);
	
	private static Enfermedad alergia = new Enfermedad("Alergia", Prioridad.POCA_URGENCIA);
	private static Enfermedad dolorDeGarganta = new Enfermedad("Dolor de Garganta", Prioridad.POCA_URGENCIA);
	private static Enfermedad gripe = new Enfermedad("Gripe", Prioridad.POCA_URGENCIA);
	private static Enfermedad influenza = new Enfermedad("Influenza", Prioridad.POCA_URGENCIA);
	
	private static Enfermedad dolorDeCabeza = new Enfermedad("Dolor de cabeza", Prioridad.SIN_URGENCIA);
	private static Enfermedad dolorDeMuelas = new Enfermedad("Dolor de Muelas", Prioridad.SIN_URGENCIA);
	private static Enfermedad fractura = new Enfermedad("Fractura", Prioridad.SIN_URGENCIA);

	@Before
	public void SetUp() {
		sala = new SalaDeEspera();
	}

	@Test
	public void InsertarPacienteCorrectamente() {
		int resultadoEsperado = 2;
		List<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(dolorDeCabeza);
		enfermedades.add(gripe);
		Paciente paciente = new Paciente("Paciente 1", enfermedades);

		sala.agregarPaciente(paciente);

		assertEquals(sala.getTope(), resultadoEsperado);
	}

	@Test
	public void InsertarYAtenderPacienteCorrectamente() {
		int resultadoEsperado = 1;
		List<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(dolorDeCabeza);
		Paciente paciente = new Paciente("Paciente 1", enfermedades);

		sala.agregarPaciente(paciente);
		Paciente pacienteAtendido = sala.atender();

		assertEquals(sala.getTope(), resultadoEsperado);
		assertEquals(pacienteAtendido.getNombre(), "Paciente 1");
	}

	@Test
	public void AtenderEnOrdenDePrioridadCorrectamente() {
		int resultadoEsperado = 1;

		List<Enfermedad> enfermedadesPrimerPaciente = new ArrayList<Enfermedad>();
		enfermedadesPrimerPaciente.add(dolorDeCabeza);
		Paciente primerPaciente = new Paciente("Paciente 1", enfermedadesPrimerPaciente);

		List<Enfermedad> enfermedadesSegundoPaciente = new ArrayList<Enfermedad>();
		enfermedadesSegundoPaciente.add(paroCardiaco);
		Paciente segundoPaciente = new Paciente("Paciente 2", enfermedadesSegundoPaciente);

		sala.agregarPaciente(primerPaciente);
		sala.agregarPaciente(segundoPaciente);
		Paciente primerPacienteAtendido = sala.atender();
		Paciente segundoPacienteAtendido = sala.atender();

		assertEquals(sala.getTope(), resultadoEsperado);
		assertEquals(primerPacienteAtendido.getNombre(), "Paciente 2");
		assertEquals(segundoPacienteAtendido.getNombre(), "Paciente 1");
	}

	@Test
	public void AtenderEnOrdenDeMismaPrioridadCorrectamente() {
		List<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(dolorDeCabeza);
		Paciente primerPaciente = new Paciente("Paciente 1", enfermedades);
		Paciente segundoPaciente = new Paciente("Paciente 2", enfermedades);

		sala.agregarPaciente(primerPaciente);
		sala.agregarPaciente(segundoPaciente);

		Paciente primerPacienteAtendido = sala.atender();
		Paciente segundoPacienteAtendido = sala.atender();

		assertEquals(sala.getTope(), 1);
		assertEquals(primerPacienteAtendido.getNombre(), "Paciente 1");
		assertEquals(segundoPacienteAtendido.getNombre(), "Paciente 2");
	}

	@Test
	public void mostrarPacientesCorrectamente() {
		List<Enfermedad> enfermedadesJuan = new ArrayList<Enfermedad>();
		enfermedadesJuan.add(dolorDeCabeza);
		enfermedadesJuan.add(ataqueAlCorazon);

		List<Enfermedad> enfermedadesPedro = new ArrayList<Enfermedad>();
		enfermedadesPedro.add(paroCardiaco);
		enfermedadesPedro.add(gripe);

		List<Enfermedad> enfermedadesMicaela = new ArrayList<Enfermedad>();
		enfermedadesMicaela.add(gripe);

		List<Enfermedad> enfermedadesAna = new ArrayList<>();
		enfermedadesAna.add(fractura);
		enfermedadesAna.add(fiebreAlta);

		List<Enfermedad> enfermedadesLuis = new ArrayList<>();
		enfermedadesLuis.add(alergia);
		enfermedadesLuis.add(gripe);

	    List<Enfermedad> enfermedadesCarlos = new ArrayList<>();
	    enfermedadesCarlos.add(dolorDeGarganta);
	    enfermedadesCarlos.add(ataqueAlCorazon);
	    
	    List<Enfermedad> enfermedadesMarcela = new ArrayList<>();
	    enfermedadesMarcela.add(influenza);
	    enfermedadesMarcela.add(fracturaPierna);

	    List<Enfermedad> enfermedadesJose = new ArrayList<>();
	    enfermedadesJose.add(dolorDeMuelas);
	    enfermedadesJose.add(gripe);

	    List<Enfermedad> enfermedadesEduardo = new ArrayList<>();
	    enfermedadesEduardo.add(paroCardiaco);
	    enfermedadesEduardo.add(fractura);
		
		Paciente juan = new Paciente("Juan", enfermedadesJuan);
		Paciente pedro = new Paciente("Pedro", enfermedadesPedro);
		Paciente micaela = new Paciente("Micaela", enfermedadesMicaela);
		Paciente ana = new Paciente("Ana", enfermedadesAna);
		Paciente luis = new Paciente("Luis", enfermedadesLuis);
	    Paciente carlos = new Paciente("Carlos", enfermedadesCarlos);
	    Paciente jose = new Paciente("Jose", enfermedadesJose);
	    Paciente marcela = new Paciente("Marcela", enfermedadesMarcela);
	    Paciente eduardo = new Paciente("Eduardo", enfermedadesEduardo);

		sala.agregarPaciente(pedro);
		sala.agregarPaciente(juan);
		sala.agregarPaciente(micaela);
		sala.agregarPaciente(ana);
		sala.agregarPaciente(luis);
	    sala.agregarPaciente(carlos);
	    sala.agregarPaciente(marcela);
	    sala.agregarPaciente(eduardo);

		sala.mostrarSalaDeEsperaVector();

		System.out.println("\n=================================================================================================================================\n");

		sala.mostrarSalaDeEsperaArbol();

	}

}
