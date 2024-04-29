package hospital;

import java.util.List;

public class Paciente implements Comparable<Paciente> {

	private String nombre;
	private List<Enfermedad> enfermedades;

	public Paciente(String nombre, List<Enfermedad> enfermedades) {
		this.nombre = nombre;
		this.enfermedades = enfermedades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private Enfermedad getEnfermedadPrioritaria() {
		Enfermedad enfermedadPrioritaria = enfermedades.get(0);
		for (Enfermedad enfermedad : enfermedades) {
			if (Integer.compare(enfermedad.getPrioridad().ordinal(),
					enfermedadPrioritaria.getPrioridad().ordinal()) < 0) {
				enfermedadPrioritaria = enfermedad;
			}
		}
		return enfermedadPrioritaria;
	}

	@Override
	public int compareTo(Paciente o) {
		return Integer.compare(this.getEnfermedadPrioritaria().getPrioridad().ordinal(),
				o.getEnfermedadPrioritaria().getPrioridad().ordinal());
	}

	@Override
	public String toString() {
		return "Paciente:\n" + "- Nombre: " + nombre + "\n" + "- Enfermedades:\n" + mostrarEnfermedades();
	}

	private String mostrarEnfermedades() {
		String listaEnfermedadesString = "";
		for (Enfermedad enfermedad : enfermedades) {
			listaEnfermedadesString += "\t" + enfermedad.toString() + "\n";
		}
		return listaEnfermedadesString;
	}

	public String mostrarPaciente() {
		return "[" + getNombre() + " - " + getEnfermedadPrioritaria().getNombre() + " - "
				+ getEnfermedadPrioritaria().getPrioridad() + "]";
	}

}
