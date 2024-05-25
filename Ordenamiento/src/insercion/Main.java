package insercion;

public class Main {
	 public static void main(String[] args) {
		 Insercion insercion = new Insercion();
	        int[] vector= {5,6,8,2,4,7,25,69,12,14,19,25};
	        insercion.ordenar(vector);
	        for(int i = 0;i<vector.length;i++){
	            System.out.print(vector[i]+ " ");
	        }
	    }
}
