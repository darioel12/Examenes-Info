package SegundaConv1314;
import java.io.*;
import java.util.*;
public class ExamenCompleto {

	public static void pasosAleatorios(int numPasos,int num_filas,int num_columnas,
			 int fila_ini, int columna_ini, String nombreFichero){
		int fila=fila_ini;
		int columna=columna_ini;
		int direccion;
		Random r=new Random();
		try{
			PrintWriter salida=new PrintWriter(nombreFichero);
			salida.println(num_filas+" "+num_columnas);
			salida.println("0 * "+fila+" "+columna);
			for(int i=1;i<=numPasos;i++){
				direccion=r.nextInt(4);
				if(direccion==0){//norte
					if(fila==1){
						fila=num_filas;
					}else{
						fila--;
					}
					salida.println(i+" ^ "+fila+" "+columna);
				}else if(direccion==1){//este
					if(columna==num_columnas){
						columna=1;
					}else{
						columna++;
					}
					salida.println(i+" > "+fila+" "+columna);
				}else if(direccion==2){//sur
					if(fila==num_filas){
						fila=1;
					}else{
						fila++;
					}
					salida.println(i+" v "+fila+" "+columna);
				}else if(direccion==3){//oeste
					if(columna==1){
						columna=num_columnas;
					}else{
						columna--;
					}
					salida.println(i+" < "+fila+" "+columna);
				}
			}
			salida.close();
		}catch (Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static int [][] frecuencias(String nombreFichero){
		int numFilas;
		int numColumnas;
		String direccion;
		int fila;
		int columna;
		int pasos;
		int [][] matrizFrec=null;
		try{
			Scanner entrada=new Scanner(new FileReader(nombreFichero));
			numFilas=entrada.nextInt();
			numColumnas=entrada.nextInt();
			matrizFrec=new int[numFilas][numColumnas];
			while(entrada.hasNext()){
				pasos=entrada.nextInt();
				direccion=entrada.next();
				fila=entrada.nextInt();
				columna=entrada.nextInt();
				matrizFrec[fila-1][columna-1]++;
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return matrizFrec;
	}
	
	
	
	public static void graficoBarras(int [] [] frecuencias, int maxLinea){
		int puntero=1;
		int puntero2=1;
		int contador1=1;
		int contador2=1;
		int fila=0;
		int columna=0;
		for(int i=0;i<frecuencias.length;i++){
			for(int j=0;j<frecuencias[i].length;j++){
				puntero=frecuencias[i][j];
				if(puntero>maxLinea){
					while(fila<frecuencias.length){
						while(columna<frecuencias[fila].length){
							System.out.print("["+fila+","+columna+"]");
							puntero2=Math.round(frecuencias[fila][columna]);
							while(contador2<=puntero2){
								System.out.print("* ");
								contador2++;
							}
							contador2=1;
							columna++;
						}
						fila++;
					}
					System.out.println();
				}
				else{
					System.out.print("["+i+","+j+"]");
					while(contador1<=puntero){
						System.out.print("* ");
						contador1++;
					}
					contador1=1;
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
//		pasosAleatorios(10,4,3,2,2,"camino.txt");
		
		
		int[][] a=null;
		a=frecuencias("camino.txt");
//		for(int i=0;i<a.length;i++){
//			for(int j=0;j<a[i].length;j++){
//				System.out.print(a[i][j]);
//				if(j!=a[i].length-1){
//					System.out.print("\t");
//				}
//			}
//			System.out.println();
//		}
//		
		graficoBarras(a,9);
	}

}
