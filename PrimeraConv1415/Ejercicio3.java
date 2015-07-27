package PrimeraConv1415;
import java.util.*;
public class Ejercicio3 {

	public static Scanner entrada=new Scanner(System.in);
	
	public static String calleConMasVentas (String [] calle){
		String calleMasVentas="";
		String calleAux="";
		int contador1=0;
		int maximo=0;
		for(int i=0;i<calle.length;i++){
			calleAux=calle[i];
			for(int j=0;j<calle.length;j++){
				if(calle[j].equals(calleAux)){
					contador1++;
				}
			}
			if(maximo<contador1){
				maximo=contador1;
				calleMasVentas=calleAux;
				contador1=0;
			}
		}
		return calleMasVentas;
	}

	public static void main (String [] args){
		String [] calle={"1","2","3","3","3","2"};
		System.out.println(calleConMasVentas(calle));
	}
	
}
