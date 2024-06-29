package LadronDeCasas;

public class LadronDeCasas2 {
	public static void main(String[] args) {
        int[] casas = {2,10,3,6,8,1,7};
        int[] ganacia = new int[casas.length];
        int i = 2, j = 0;
        ganacia[0] = casas[0];
        if(casas[1]>ganacia[0]){
            ganacia[1] = casas[1];
        }
        else{
            ganacia[1] = ganacia[0];
        }
        while(i<casas.length){
            int aux = ganacia[j] + casas[i];
            if(aux>ganacia[i-1]){
                ganacia[i] = aux;
            }
            else{
                ganacia[i] = ganacia[i-1];
            }
            i++;
            j++;
        }
            System.out.print("mator ganancia: " + ganacia[ganacia.length-1]);
    }
}
