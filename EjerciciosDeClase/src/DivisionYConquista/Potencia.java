package DivisionYConquista;

public class Potencia {

	public long calcularPotencia(int numero, int potencia) {
		if(potencia == 0) {
			return 1;
		}
		if(potencia == 1) {
			return numero;
		}
		long nuevaPotencia = this.calcularPotencia(numero, potencia / 2);
		if(potencia % 2 == 0) {
			return nuevaPotencia * nuevaPotencia;
		}
				
		return numero * nuevaPotencia * nuevaPotencia;
	}

}
