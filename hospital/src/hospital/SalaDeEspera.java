package hospital;

public class SalaDeEspera {

	private Paciente[] pacientes;
	private int tope;

	public SalaDeEspera(Paciente[] pacientes) {
		this.pacientes = pacientes;
		tope = 1;
	}
	
	public void AgregarPaciente(Paciente paciente) {
		pacientes[tope] = paciente;
		
		int pos = tope;
		while(pacientes[pos/2].compareTo(paciente) > 0 && pos != 1) {
			Paciente aux = pacientes[pos/2];
			pacientes[pos/2] = paciente;
			pacientes[pos] = aux;
			pos = pos/2;
		}
		tope++;
	}
	
	
	public void Atender() {
		if(tope == 1) {
			System.out.println("No hay nadie para atender");
			return;
		}
		Paciente pacienteAtendido = pacientes[1];
		System.out.printf("Se atendió al paciente: %s", pacienteAtendido);
		
		tope--;
		if(tope == 1) {
			return;
		}
		
		pacientes[1] = pacientes[tope];
		
		int pos = 1;
		int posHijoMenor = GetPosHijoMenor(pos);
		while(posHijoMenor != -1) {
			Paciente aux = pacientes[posHijoMenor];
			pacientes[posHijoMenor] = pacientes[pos];
			pacientes[pos] = aux;
			pos = posHijoMenor;
			posHijoMenor = GetPosHijoMenor(pos);
		}
		return;
	}
	
	private int GetPosHijoMenor(int pos) {
		// TODO Auto-generated method stub
		return -1;
	}

	public Paciente[] getPacientes() {
		return pacientes;
	}

	public int getTope() {
		return tope;
	}
}
