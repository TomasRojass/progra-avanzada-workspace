import hospital.Prioridad;
import hospital.*;

public class Main {

	public static void main(String[] args) {
		Enfermedad enfermedad1 = new Enfermedad("enf1", Prioridad.SIN_URGENCIA);
		Enfermedad enfermedad2 = new Enfermedad("enf1", Prioridad.POCA_URGENCIA);
		Enfermedad enfermedad3 = new Enfermedad("enf1", Prioridad.EMERGENCIA);
		Enfermedad enfermedad4 = new Enfermedad("enf1", Prioridad.RESUCITACION);
		Paciente paciente1 = new Paciente("paciente", enfermedad1);
		Paciente paciente4 = new Paciente("paciente4", enfermedad4);
		Paciente paciente2 = new Paciente("paciente2", enfermedad2);
		Paciente paciente3 = new Paciente("paciente3", enfermedad3);
		

		
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
