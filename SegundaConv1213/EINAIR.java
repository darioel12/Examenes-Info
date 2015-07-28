package SegundaConv1213;
import java.io.*;
import java.util.*;
public class EINAIR {

	public static final int FILAS = 33;
	public static final int LETRAS = 6;
	public static final int NUMPLAZAS = 198;
	
	public static int buscaUltimaReserva(int [] ocupacion){
		int max=0;
		for(int i=0;i<ocupacion.length;i++){
			if(max<ocupacion[i]){
				max=ocupacion[i];
			}
		}
		return max;
	}
	
	public static int plazasLibres(int [] ocupacion){
		int numPlazas=0;
		for(int i=0;i<ocupacion.length;i++){
			if(ocupacion[i]==0){
				numPlazas++;
			}
		}
		return numPlazas;
	}
	
	public static int [] reserva (int [] ocupacion, int numPlazas){
		int plazasLibres=plazasLibres(ocupacion);
		int ultimaReserva=buscaUltimaReserva(ocupacion)+1;
		int contador=ultimaReserva+numPlazas;
		int contador2=0;
		int [] vReserva=new int [NUMPLAZAS];
		if(numPlazas>plazasLibres){
			System.out.println("Quedan sólo "+plazasLibres+" asientos");
			return null;
		}
		for(int i=ocupacion.length-1;i>=0;i--){
			while(ultimaReserva<contador){
				vReserva[contador2]=ultimaReserva;
				ultimaReserva++;
				contador2++;
			}
		}
		return vReserva;
	}
	
	public static int []leeFicheroPlazas (String nombreFichero){
		int numPlazas=0;
		int plaza=0;
		int contador;
		int [] ocupacion=null;
		try{
			Scanner entrada=new Scanner(new FileReader(nombreFichero));
			numPlazas=entrada.nextInt();
			ocupacion=new int [numPlazas];
			contador=numPlazas-1;
			while(entrada.hasNext()){
				plaza=entrada.nextInt();
				ocupacion[contador]=plaza;
				contador--;
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return ocupacion;
	}
	
	public static void copiaFicheroPlazas (String nombreFichero,
			int [] ocupacion){
		try{
			PrintWriter salida=new PrintWriter(new FileWriter(nombreFichero));
			salida.println(ocupacion.length);
			for(int i=ocupacion.length-1;i>=0;i--){
				salida.println(ocupacion[i]);
			}
			salida.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static void imprimePlazas(int [] ocupacion){
		char c='F';
		int puntero= (int) c;
		int contador1=NUMPLAZAS-1;
		int contador2=NUMPLAZAS-FILAS-1;
		int contador3=1;
		for(int i=puntero;i>puntero-LETRAS;i--){
			if(i==puntero-3){
				System.out.print(" ");
				while(contador3<=FILAS){
					System.out.printf("%3d ",contador3);
					contador3++;
				}
				System.out.println();
			}
			System.out.print((char) i);
			while(contador1>contador2){
				System.out.printf("%3d ",ocupacion[contador1]);
				contador1--;
			}
			contador1=contador2;
			contador2=contador2-FILAS;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [] ocupacion=leeFicheroPlazas("AB202.txt");
		int [] vReserva=reserva(ocupacion,3);
		for(int i=0;i<vReserva.length;i++){
			if(vReserva[i]!=0){
				System.out.print(vReserva[i]);
			}
		}
		
	}

}
