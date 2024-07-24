package Hospital;

public class SalaDeEspera {

	private Paciente[] pacientes;
	private int tope;

	public SalaDeEspera() {
		this.pacientes = new Paciente[50];
		tope = 1;
	}

	public SalaDeEspera(Paciente[] pacientes) {
		this.pacientes = pacientes;
		tope = 1;
	}

	public void agregarPaciente(Paciente paciente) {
		pacientes[tope] = paciente;
		int pos = tope;
		while (pacientes[pos / 2] != null && pacientes[pos / 2].compareTo(paciente) > 0 && pos != 1) {
			Paciente aux = pacientes[pos / 2];
			pacientes[pos / 2] = paciente;
			pacientes[pos] = aux;
			pos = pos / 2;
		}
		tope++;
	}

	public Paciente atender() {
		if (tope == 1) {
			System.out.println("No hay nadie para atender");
			return null;
		}
		Paciente pacienteAtendido = pacientes[1];
		System.out.printf("Se atiende al paciente: %s\n", pacienteAtendido.getNombre());

		tope--;
		if (tope == 1) {
			return pacienteAtendido;
		}

		pacientes[1] = pacientes[tope];
		pacientes[tope] = null;

		int pos = 1;
		int posHijoMenor = getPosHijoMenor(pos);
		while (posHijoMenor != -1) {
			Paciente aux = pacientes[posHijoMenor];
			pacientes[posHijoMenor] = pacientes[pos];
			pacientes[pos] = aux;
			pos = posHijoMenor;
			posHijoMenor = getPosHijoMenor(pos);
		}
		return pacienteAtendido;
	}

	public Paciente[] getPacientes() {
		return pacientes;
	}

	public int getTope() {
		return tope;
	}

	private int getPosHijoMenor(int pos) {
		int posHijoIzq = pos * 2;
		Paciente hijoIzq = this.pacientes[posHijoIzq];
		Paciente hijoDer = this.pacientes[posHijoIzq + 1];

		if (posHijoIzq >= tope && posHijoIzq + 1 >= tope) {
			return -1;
		}
		if (posHijoIzq + 1 >= tope || hijoIzq.compareTo(hijoDer) == -1) {
			return posHijoIzq;
		}
		return posHijoIzq + 1;
	}

	public void mostrarSalaDeEsperaVector() {
		for (int i = 1; i < tope; i++) {
			System.out.printf(pacientes[i].toString() + "\n\n");
		}
	}

	public void mostrarSalaDeEsperaArbol() {
		mostrarSalaDeEsperaArbolRecursivo(1, 0, "");
		System.out.println();
	}

	private void mostrarSalaDeEsperaArbolRecursivo(int indice, int nivel, String prefijo) {
		if (indice < tope && pacientes[indice] != null) {
			mostrarSalaDeEsperaArbolRecursivo(indice * 2 + 1, nivel + 1, "\t\t" + prefijo);
			System.out.print(prefijo);
			for (int i = 0; i < nivel; i++) {
				System.out.print("\t\t\t");
			}
			System.out.println(pacientes[indice].mostrarPaciente());
			mostrarSalaDeEsperaArbolRecursivo(indice * 2, nivel + 1, "\t\t" + prefijo);
		} else {
			System.out.println();
		}
	}

}
