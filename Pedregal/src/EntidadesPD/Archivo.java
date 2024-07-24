package EntidadesPD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {
	public static final String RUTA_ARCHIVOS_ENTRADA = "archivos/in/";
	public static final String RUTA_ARCHIVOS_TESTS_ENTRADA = "archivos/test/in/";
	public static final String RUTA_ARCHIVOS_SALIDA = "archivos/out/";
	public static final String RUTA_ARCHIVOS_TESTS_SALIDA = "archivos/test/out/";
	
	private String entrada;
	
	public Archivo(String entrada) {
		this.entrada = entrada;
	}
	
	public PlanConstruccion leerArchivo(String rutaArchivo) {
		Scanner scanner = null;
		PlanConstruccion plan = null;
		
		try {
			File file = new File(rutaArchivo + this.entrada + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			plan = new PlanConstruccion();
			String[] tamPedregal = scanner.nextLine().split(" ");
			int[][] terreno = new int[Integer.parseInt(tamPedregal[0])][Integer.parseInt(tamPedregal[1])];
			String[] casa = scanner.nextLine().split(" ");
			
			plan.setFrenteCasa(Integer.parseInt(casa[0]));
			plan.setLadoCasa(Integer.parseInt(casa[1]));
			
			int cantPiedras = Integer.parseInt(scanner.nextLine());
			
			for(int i = 0; i < cantPiedras; i++) {
				String[] ubicacionPiedra = scanner.nextLine().split(" ");
				int fila = Integer.parseInt(ubicacionPiedra[0]);
				int columna = Integer.parseInt(ubicacionPiedra[1]);
				terreno[fila - 1][columna - 1] = 1;
			}
			plan.setTerreno(terreno);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
		
		return plan;
	}
	
	public void generarArchivo(String rutaArchivo, PlanConstruccion plan) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		try {
			file = new FileWriter(rutaArchivo + this.entrada + ".out");
			printWriter = new PrintWriter(file);
			if(plan.getUbicacionCasa() == null) {
				printWriter.println("NO");
			}else {
				printWriter.println("SI");
				printWriter.println(plan.getUbicacionCasa()[0] + " " + plan.getUbicacionCasa()[1]);
				
				if(plan.getUbicacionCasa()[1]==0)
					printWriter.println("E");
				else {
					if(plan.getUbicacionCasa()[1]==7)
						printWriter.println("O");
					else {
						if(plan.getUbicacionCasa()[0]==0)
							printWriter.println("N");
						else {
							printWriter.println("S");
						}
						
					}
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
