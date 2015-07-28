package PrimeraConv1314;
import java.util.*;
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int primero=0;
		int segundo=0;
		int dato;
		boolean SRE=false;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Dame una serie de números");
		dato=entrada.nextInt();
		if(dato!=0){
			primero=dato;
			dato=entrada.nextInt();
			if(dato!=0){
				segundo=dato;
				dato=entrada.nextInt();
				while(dato!=0){
					if(primero<segundo){
						if(dato>primero && dato<segundo){
							SRE=true;
						}
					}else{
						if(dato<segundo && dato>primero){
							SRE=true;
						}
					}
					primero=segundo;
					segundo=dato;
					dato=entrada.nextInt();
				}
			}
		}
		if(SRE){
			System.out.println("Es una serie ritmica de enteros");
		}else{
			System.out.println("No es una serie rítmica de enteros");
		}
		entrada.close();
	}

}
