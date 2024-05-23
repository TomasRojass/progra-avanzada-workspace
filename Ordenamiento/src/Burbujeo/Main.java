package Burbujeo;

public class Main {
	 public static void main(String[] args) {
		 Burbujeo burbujeo = new Burbujeo();
	        int[] vector= {5,6,8,2,4,7,25,69,12,14,19,25};
	        burbujeo.ordenar(vector);
	        for(int i = 0;i<vector.length;i++){
	            System.out.println(vector[i]);
	        }
	    }
}
