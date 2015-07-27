package PrimeraConv1314;
import java.io.*;
import java.util.*;
public class I_VEI {

	public static int[] ofertasPorImporte(String name){
		int[] ofertasRangoPrecios = new int[100];
		int dni=0;
		int oferta=0;
		int componente=0;
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				dni=entrada.nextInt();
				oferta=entrada.nextInt();
				componente=oferta/1000;
				if(oferta%1000==0){
					componente--;
					ofertasRangoPrecios[componente]++;
				}
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return ofertasRangoPrecios;
	}
	
	public static boolean dniValido (int dni){
		boolean valido=false;
		int cociente=0;
		int resto=0;
		int suma=0;
		int contador=1;
		while(dni/10>=9){
			cociente=dni/10;
			resto=dni%10;
			if(contador%2==0){
				resto=resto*2;
				suma+=resto;
			}else{
				resto=resto*5;
				suma+=resto;
			}
			dni=cociente;
			contador++;
			resto=0;
		}
		if(suma%2==0){
			valido=true;
			return valido;
		}else{
			valido=false;
			return valido;
		}
	}
	
	public static int ofertaSeleccionada(String name,int menor, int mayor){
		int dni=0;
		int oferta=0;
		int dniSelec=0;
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				dni=entrada.nextInt();
				oferta=entrada.nextInt();
				if(oferta>menor && oferta<mayor && dniValido(dni)){
				dniSelec=dni;
				}
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return dniSelec;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dni;
		dni=ofertaSeleccionada("ofertas-recibidas.txt",30000,40000);
		System.out.println(dni);
	}

}
