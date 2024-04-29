package hospital;

public class Enfermedad {

	private String nombre;
	private Prioridad prioridad;
	
	public Enfermedad(String nombre, Prioridad prioridad) {
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " - Prioridad: " + prioridad;
	}

}
