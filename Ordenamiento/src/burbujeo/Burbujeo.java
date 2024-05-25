package burbujeo;

public class Burbujeo {
	public void ordenar(int []vector){
        for(int i=0; i<vector.length;i++){
            for(int j=i+1;j<vector.length;j++){
                if(vector[i]>vector[j]){
                    int aux = vector[j];
                    vector[j] = vector[i];
                    vector[i] = aux;
                }
            }
        }
    }
}
