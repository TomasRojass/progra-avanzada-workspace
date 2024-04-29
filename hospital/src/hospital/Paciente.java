package hospital;

public class Paciente implements Comparable<Paciente> {

	private String nombre;
	private Enfermedad enfermedad;
	
	public Paciente(String nombre, Enfermedad enfermedad) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	@Override
	public int compareTo(Paciente o) {
		return Integer.compare(this.enfermedad.getPrioridad().ordinal(), o.enfermedad.getPrioridad().ordinal());
	}

	
	
	
}
