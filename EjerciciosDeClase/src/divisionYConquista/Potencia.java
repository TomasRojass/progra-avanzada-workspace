package divisionYConquista;

public class Potencia {

	public long calcularPotencia(int numero, int potencia) {
		if(potencia == 0) {
			return 1;
		}
		if(potencia == 1) {
			return numero;
		}
		int nuevaPotencia = potencia / 2;
		if(potencia % 2 == 0) {
			return this.calcularPotencia(numero, nuevaPotencia) * this.calcularPotencia(numero, nuevaPotencia);
		}
				
		return numero * this.calcularPotencia(numero, nuevaPotencia) * this.calcularPotencia(numero,  nuevaPotencia);
	}

}
