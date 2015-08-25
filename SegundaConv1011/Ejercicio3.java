package SegundaConv1011;
import java.util.*;
import java.io.*;
public class Ejercicio3 {

	public static int crapulo(int numero){
		int cociente=0;
		int resto=0;
		int suma=0;
		while(numero>10){
			cociente=numero/10;
			resto=numero%10;
			numero=cociente;
			suma+=resto;
			resto=0;
		}
		suma+=cociente;
		while(suma>10){
			numero=suma;
			suma=0;
			cociente=0;
			resto=0;
			while(numero>10){
				cociente=numero/10;
				resto=numero%10;
				numero=cociente;
				suma+=resto;
				resto=0;
			}
			suma+=cociente;
		}
		return suma;
	}
	
	public static void cifrado (String ficheroOrigen, String ficheroDestino,
			int clave, boolean cifrado){
		clave=crapulo(clave);
		String linea;
		char c='.';
		try{
			Scanner entrada=new Scanner(new FileReader(ficheroOrigen));
			PrintWriter salida=new PrintWriter (new FileWriter(ficheroDestino));
			while(entrada.hasNext()){
				linea=entrada.nextLine();
				for(int i=0;i<linea.length();i++){
					c=linea.charAt(i);
					c=(char)(c+clave);
					salida.print(c);
				}
				salida.println();
			}
			entrada.close();
			salida.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static void main(String[] args) {
		System.out.println(crapulo(492));

	}

}
