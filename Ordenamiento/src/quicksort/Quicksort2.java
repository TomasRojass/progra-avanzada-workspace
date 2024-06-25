package quicksort;

public class Quicksort2 {


    public static void ordenar(int[]v,int inicio,int fin){
    int i = inicio, j = fin,pibote = (inicio + fin)/2;
		do{
			while(i<=j && v[i]<v[pibote]) {
				i++;
			}
			while(i<=j && v[j]>v[pibote]) {
				j--;
			}
			if(i<=j) {
				int aux = v[j];
				v[j]= v[i];
				v[i]= aux;
				i ++;
				j --;
			}
			
		}while(i<= j);
		
		if(inicio < j)
			ordenar(v,inicio,j);
		if(fin > i)
			ordenar(v,i-1,fin);
    }
}
