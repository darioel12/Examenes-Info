package PrimeraConv1011;
import java.util.*;
public class Ejercicio3 {

	public static Scanner entrada=new Scanner(System.in);
	
	public static void main(String[] args) {
		long numero;
		long numeroaux=0;
		long cociente=0;
		long resto=0;
		char b='A';
		int contador;
		int contador2=0;
		int contador3=0;
		char c;
		String cadena="";
		System.out.println("Introduce un entero (base 10): ");
		numero=entrada.nextLong();
		numeroaux=numero;
		
 		for(int i=2;i<=36;i++){
 			System.out.print("Base ");
 			System.out.printf("%3d ",i);
 			System.out.print(": ");
 			if(i<=10){
 				while(numero/i>=1){
 					cociente=numero/i;
 					resto=numero%i;
 					numero=cociente;
					cadena+=resto+"";
					resto=0;
 				}
 				cadena+=cociente+"";
 			}else{
 				while(numero/i>=1){
 					cociente=numero/i;
 					resto=numero%i;
 					if(resto>=10){
 						b=(char) (b+resto-10);
 						cadena+=b+"";
 					}else{
 						cadena+=resto+"";
 					}
 					numero=cociente;
					resto=0;
					b='A';
 				}
 				if(cociente>10){
 					b=(char)(b+numero-10);
 					cadena+=b+"";
 				}else{
 					cadena+=cociente+"";
 				}
 			}
 			contador=cadena.length()-1;
 			while(contador3+contador<contador2){
 				cadena+=" ";
 				contador3++;
 			}
 			if(contador2<contador){
 				contador2=contador;
 			}
 			contador=cadena.length()-1;
 			while(contador>=0){
 				c=cadena.charAt(contador);
 				System.out.print(c);
 				contador--;
 			}
 			cadena="";
 			
 			contador3=0;
 			cociente=0;
 			numero=numeroaux;
 			System.out.println();
 		}
			
	}

}