package Hospital;

import Entidades.MonticuloDeMinimos;
import Excepciones.MonticuloVacioException;

public class SalaDeEspera2 extends MonticuloDeMinimos<Paciente> {

	public SalaDeEspera2() {
		super();
	}

	public void agregarPaciente(Paciente paciente) {
		this.agregarElemento(paciente);
	}

	public Paciente atenderPaciente() throws MonticuloVacioException {
		return this.sacarElemento();
	}

	public Paciente verProximoPaciente() throws MonticuloVacioException {
		return this.verRaiz();
	}

	public Paciente[] obtenerListaDePacientes() {
		return this.getVector();
	}

	public int obtenerCantidadDePacientes() {
		return this.getTope();
	}

	public void mostrarPacientesEnArray() {
		this.mostrarMonticuloEnFormaDeArray();
	}

	public void mostrarPacientesEnArbol() {
		this.mostrarMonticuloEnFormaDeArbol();
	}

}
