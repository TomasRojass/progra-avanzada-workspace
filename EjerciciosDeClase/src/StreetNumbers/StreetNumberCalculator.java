package StreetNumbers;

public class StreetNumberCalculator {
	public long calculateStreetNumberMine(long n) {
		long startTime = System.currentTimeMillis();
		long address = n-1;
		long counter = 2;
		long leftAdd = 1;
		long rightAdd = n;
		
		while(counter < address ) {
			leftAdd += counter++;
		}
		rightAdd = n;
		while(leftAdd > rightAdd) {
			leftAdd -= address - 1;
			rightAdd += address;
			address --;
		}
		if(leftAdd == rightAdd) {
			long endTime = System.currentTimeMillis();
	        long elapsedTime = endTime - startTime;
	        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
			return address;
		}
		long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
		return -1;
	}
	
	 public int calculateStreetNumberON2(int n) {
		long startTime = System.currentTimeMillis();
		if (n < 3) return -1;
		for (int i = 2; i <= n; i++) {
			int sumaIzq = 0;
			for (int j = 1; j < i; j++)
				sumaIzq += j;
			int sumaDer=0;
			for (int k = i + 1; k <= n; k++)
				sumaDer += k;
			if (sumaDer == sumaIzq) {
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
		        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
				return i;
			}
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
        return -1;
	}

	public int calculateStreetNumberON(int n) {
		long startTime = System.currentTimeMillis();
		if (n < 3) return -1;
		for (int i = 1; i <= n; i++) {
			int sumaIzq = i * (i - 1) / 2;
			int sumaDer=(n*(n+1)/2-i*(i+1)/2);
			if (sumaDer == sumaIzq) {
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
		        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
				return i;
			}
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
		return -1;				
	}
	
	public int calculateStreetNumberO1(int n) {
		long startTime = System.currentTimeMillis();
		if (n<3) return -1;
		double i = Math.sqrt((Math.pow(n, 2)+n)/2);
		int entera = (int) i;
		if ((i-entera) == 0) {
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
	        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
			return (int) i;
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
        return -1;				
	}
}
