package PrimeraConv1415;
import java.io.*;
import java.util.*;

public class Ejercicio2 {
	
	public static void ficheroPorCP(String input, int codigo, String output){
		float urgencia;
		int CP;
		String calle;
		try{
			Scanner entrada=new Scanner(new FileReader(input));
			PrintWriter salida=new PrintWriter(new FileWriter(output));
			while(entrada.hasNext()){
				urgencia=entrada.nextFloat();
				CP=entrada.nextInt();
				calle=entrada.nextLine();
				if(codigo==CP){
					salida.println(urgencia+" "+codigo+" "+calle);
				}
			}
			entrada.close();
			salida.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
