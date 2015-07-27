package PrimeraConv1415;
import java.io.*;
import java.util.*;

public class Ejercicio1 {

	public static Scanner entrada=new Scanner(System.in);
	
	public static void anidamiento (String name){
		String linea;
		char c;
		int contador1=1;
		int contador2=0;
		int contador3=0;
		int maximo=0;
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				System.out.print(contador1+" : ");
				linea=entrada.nextLine();
				for(int i=0;i<linea.length();i++){
					c=linea.charAt(i);
					if(c=='('){
						contador2++;
					}
					if(c==')'){
						contador2--;
						contador3++;
						if(maximo<contador3 && contador2==0){
							maximo=contador3;
							contador3=0;
						}if(contador2<0){
							System.out.print("Error");
							i=linea.length()-1;
						}
					}
				}
				if(maximo>=0 && contador2>=0){
					System.out.print("Correcta máximo anidamineto= "+maximo);
				}
				System.out.println();
				contador1++;
				contador2=0;
				contador3=0;
				maximo=0;
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	public static void main(String[] args){
		anidamiento("expresiones.txt");
	}

}
