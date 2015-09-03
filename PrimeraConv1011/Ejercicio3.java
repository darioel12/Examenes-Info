package PrimeraConv1011;
import java.util.*;
public class Ejercicio3{
	
	public static Scanner entrada=new Scanner(System.in);
	
	public static String [] numeroBaseFormato(long numero){
		String linea="";
		String lineaAux="";
		String [] vNumeros=new String [34];
		long cociente=0;
		long resto=0;
		int contador=0;
		long contador2=2;
		long numeroAux=numero;
		char c;
		char d='A';
		while(contador2<=36){
			while(numero/contador2>=1){
				cociente=numero/contador2;
				resto=numero%contador2;
				if(resto>=10){
					d=(char)(d+resto-10);
					linea+=d;
				}else{
					linea+=resto;
				}
				d='A';
				numero=cociente;
				resto=0;
			}
			linea+=cociente;
			contador=linea.length()-1;
			while(contador>=0){
				c=linea.charAt(contador);
				lineaAux+=c;
				contador--;
			}
			if(contador2==36){
				vNumeros[vNumeros.length-1]=lineaAux;
			}else{
				vNumeros[(int)contador2-2]=lineaAux;
			}
			numero=numeroAux;
			linea="";
			lineaAux="";
			contador2=contador2+1;
		}
		return vNumeros;
	}
	
	public static void main(String [] args){
		System.out.println("Dame un numero en base 10 ");
		long numero=entrada.nextLong();
		int base=2;
		String [] a=numeroBaseFormato(numero);
		String aux=a[0];
		int contador=0;
		int contador2=0;
		for(int i=0;i<a.length;i++){
			System.out.print("Base ");
			System.out.printf("%3d ",base);
			System.out.print(":");
			if(i!=0){
				contador=aux.length()-a[i].length();
				while(contador2<contador){
					System.out.print(" ");
					contador2++;
				}
				contador=0;
				contador2=0;
			}
			System.out.print(a[i]);
			System.out.println();
			base++;
		}
	}
}