package MinaDeOro;

import java.util.Random;

public class MinaDeOro2 {
	public static void main(String[] args) {
        int[][] mina = new int[3][4];
        int[][] gananciaMaxima = new int[mina.length][mina[0].length];

        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                mina[i][j] = rand.nextInt(100);
            }
        }

        for(int i=0;i<mina[0].length;i++){
            gananciaMaxima[0][i] = mina[0][i];
        }
        
        imprimirMatriz(mina);

        buscarGanancia(mina,gananciaMaxima);

        imprimirMatriz(gananciaMaxima);
    }


    public static void buscarGanancia(int[][] mina,int[][] gananciaMaxima){
        for(int i = 1;i<mina.length;i++){
            for(int j = 0;j<mina[0].length;j++){
                int maxGanancia = gananciaMaxima[i - 1][j];
                if (j > 0) {
                    maxGanancia = Math.max(maxGanancia, gananciaMaxima[i - 1][j - 1]);
                }
                if (j < mina[0].length - 1) {
                    maxGanancia = Math.max(maxGanancia, gananciaMaxima[i - 1][j + 1]);
                }
                gananciaMaxima[i][j] = mina[i][j] + maxGanancia;
            }    
        }
    }

    public static void imprimirMatriz(int[][]m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
            	System.out.printf("%3d ",m[i][j]);
            }
            System.out.println();
        }
    }
}
