package PrimeraConv1213;
import java.io.*;
import java.util.*;
public class gastos {

	public static int gastoPorFechas(String name, int diaI, int diaF){
		int gasto=0;
		int gastoFinal=0;
		int dia=0;
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				gasto=entrada.nextInt();
				dia=entrada.nextInt();
				if(diaI<dia && dia<diaF){
					gastoFinal+=gasto;
				}
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return gastoFinal;
	}

	public static int maximo (int [] v){
		int max=0;
		int pos=0;
		for(int i=0;i<v.length;i++){
			if(max<v[i]){
				max=v[i];
				pos=i;
			}
		}
		return pos;
	}
	
	public static int diaMayorGasto(String name){
		int gasto=0;
		int dia=0;
		int diaMayor=0;
		int [] mes= new int [31];
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				gasto=entrada.nextInt();
				dia=entrada.nextInt();
				mes[dia-1]+=gasto;
			}
			entrada.close();
		}catch (Exception ex){
			System.out.println(ex.toString());
		}
		diaMayor=maximo(mes);
		return diaMayor;
	}
	
	public static void histogramaGastos(int[] gastos, int periodo){
		int contador=1;
		int contador1=1;
		int puntero=gastos.length/periodo;
		int contador2=periodo;
		int contador3=0;
		int gastoTotal=0;
		while(contador1<=puntero){
			System.out.print("Días del "+contador+"-"+contador2+" :");
			while(contador3<contador2){
				gastoTotal+=gastos[contador3];
				contador3++;
			}
			System.out.print("importe total es de "+gastoTotal+" euros");
			gastoTotal=0;
			contador+=periodo;
			contador1++;
			contador2+=periodo;
			System.out.println();
		}
		System.out.print("Días del "+contador+"-"+gastos.length+" :");
		while(contador3<gastos.length){
			gastoTotal+=gastos[contador3];
			contador3++;
		}
		System.out.print("importe total es de "+gastoTotal+" euros");
		System.out.println();
	}
	
	public static int [] vGastos(String name){
		int dia,gasto=0;
		int [] mes =new int [31];
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			while(entrada.hasNext()){
				gasto=entrada.nextInt();
				dia=entrada.nextInt();
				mes[dia-1]+=gasto;
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return mes;
	}
	
	public static void main(String[] args) {
		int [] mes =vGastos("gastos.txt");
		histogramaGastos(mes,8);

	}

}
