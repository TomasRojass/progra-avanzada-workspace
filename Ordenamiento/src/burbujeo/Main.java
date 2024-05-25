package burbujeo;

public class Main {
	 public static void main(String[] args) {
		 Burbujeo burbujeo = new Burbujeo();
	        int[] vector= {5,6,8,55,89,35,46,5,14,19,25};
	        burbujeo.ordenar(vector);
	        for(int i = 0;i<vector.length;i++){
	            System.out.print(vector[i] + " ");
	        }
	    }
}
