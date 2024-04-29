import hospital.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Enfermedad enfermedad1 = new Enfermedad("enf1", Prioridad.SIN_URGENCIA);
		Enfermedad enfermedad2 = new Enfermedad("enf1", Prioridad.POCA_URGENCIA);
		Enfermedad enfermedad3 = new Enfermedad("enf1", Prioridad.EMERGENCIA);
		Enfermedad enfermedad4 = new Enfermedad("enf1", Prioridad.RESUCITACION);
		List<Enfermedad> enfermedades1 = new ArrayList<Enfermedad>();
		enfermedades1.add(enfermedad1);
		List<Enfermedad> enfermedades2 = new ArrayList<Enfermedad>();
		enfermedades2.add(enfermedad2);
		List<Enfermedad> enfermedades3 = new ArrayList<Enfermedad>();
		enfermedades3.add(enfermedad3);
		List<Enfermedad> enfermedades4 = new ArrayList<Enfermedad>();
		enfermedades4.add(enfermedad4);
		Paciente paciente1 = new Paciente("paciente1", enfermedades1);
		Paciente paciente2 = new Paciente("paciente2", enfermedades2);
		Paciente paciente3 = new Paciente("paciente3", enfermedades3);
		Paciente paciente4 = new Paciente("paciente4", enfermedades4);
		

		
		SalaDeEspera sala = new SalaDeEspera();
		sala.AgregarPaciente(paciente1);
		sala.AgregarPaciente(paciente2);
		sala.AgregarPaciente(paciente3);
		sala.AgregarPaciente(paciente4);


		Paciente[] pacientess = sala.getPacientes();
		for(int i =1; i < sala.getTope(); i++) {
			System.out.println(pacientess[i].getNombre());
		}
		
		sala.Atender();
		
		for(int i =1; i < sala.getTope(); i++) {
			System.out.println(pacientess[i].getNombre());
		}

	}

}
