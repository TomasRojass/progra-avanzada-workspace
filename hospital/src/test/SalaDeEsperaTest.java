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
	private static Enfermedad enfermedad1 = new Enfermedad("enf1", Prioridad.SIN_URGENCIA);
	private static Enfermedad enfermedad2 = new Enfermedad("enf2", Prioridad.POCA_URGENCIA);
	private static Enfermedad enfermedad3 = new Enfermedad("enf3", Prioridad.EMERGENCIA);
	private static Enfermedad enfermedad4 = new Enfermedad("enf4", Prioridad.RESUCITACION);
	
	@Before
	public void SetUp() {
		sala = new SalaDeEspera();
	}
	
	@Test
	public void InsertarPacienteCorrectamente() {
		List<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(enfermedad1);
		Paciente paciente = new Paciente("paciente1", enfermedades);
		
		sala.AgregarPaciente(paciente);
		
		assertEquals(sala.getTope(), 2);
	}

	@Test
	public void InsertarYAtenderPacienteCorrectamente() {
		List<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(enfermedad1);
		Paciente paciente = new Paciente("paciente1", enfermedades);
		
		sala.AgregarPaciente(paciente);
		Paciente pacienteAtendido = sala.Atender();
		
		assertEquals(sala.getTope(), 1);
		assertEquals(pacienteAtendido.getNombre(), "paciente1");
	}
	
	@Test
	public void AtenderEnOrdenDePrioridadCorrectamente() {
		List<Enfermedad> enfermedades1 = new ArrayList<Enfermedad>();
		enfermedades1.add(enfermedad1);
		Paciente paciente1 = new Paciente("paciente1", enfermedades1);
		List<Enfermedad> enfermedades2 = new ArrayList<Enfermedad>();
		enfermedades2.add(enfermedad4);
		Paciente paciente2 = new Paciente("paciente2", enfermedades2);
		
		sala.AgregarPaciente(paciente1);
		sala.AgregarPaciente(paciente2);
		Paciente pacienteAtendidoPrimero = sala.Atender();
		Paciente pacienteAtendidoSegundo = sala.Atender();
		
		assertEquals(sala.getTope(), 1);
		assertEquals(pacienteAtendidoPrimero.getNombre(), "paciente2");
		assertEquals(pacienteAtendidoSegundo.getNombre(), "paciente1");
	}
	
	@Test
	public void AtenderEnOrdenDeMismaPrioridadCorrectamente() {
		List<Enfermedad> enfermedades1 = new ArrayList<Enfermedad>();
		enfermedades1.add(enfermedad1);
		Paciente paciente1 = new Paciente("paciente1", enfermedades1);
		Paciente paciente2 = new Paciente("paciente2", enfermedades1);
		
		sala.AgregarPaciente(paciente1);
		sala.AgregarPaciente(paciente2);
		Paciente pacienteAtendidoPrimero = sala.Atender();
		Paciente pacienteAtendidoSegundo = sala.Atender();
		
		assertEquals(sala.getTope(), 1);
		assertEquals(pacienteAtendidoPrimero.getNombre(), "paciente1");
		assertEquals(pacienteAtendidoSegundo.getNombre(), "paciente2");
	}
}
