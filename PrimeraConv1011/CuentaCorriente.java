package PrimeraConv1011;
import java.io.*;
import java.util.*;
public class CuentaCorriente {

	private String _titular;
	private int _saldo;
	
	public CuentaCorriente(String t, int s){
		this._titular=t;
		this._saldo=s;
	}
	public void setTitular(String t){
		this._titular=t;
	}
	public void setSaldo(int s){
		this._saldo=s;
	}
	public String getTitular(){
		return _titular;
	}
	public int getSaldo(){
		return _saldo;
	}
	
	public static CuentaCorriente[] crearCC(String fileName, int max_cc){
		CuentaCorriente [] banco=new CuentaCorriente[max_cc];
		CuentaCorriente cuenta=null;
		int contador=0;
		int contador2=0;
		int numMovimientos=0;
		int saldo=0;
		int saldoFinal=0;
		String nombre;
		try{
			Scanner entrada=new Scanner(new FileReader(fileName));
			while(contador<max_cc){
				numMovimientos=entrada.nextInt();
				while(contador2<numMovimientos){
					saldo=entrada.nextInt();
					saldoFinal+=saldo;
					contador2++;
				}
				contador2=0;
				nombre=entrada.nextLine();
				cuenta=new CuentaCorriente(nombre,saldoFinal);
				banco[contador]=cuenta;
				contador++;
				saldoFinal=0;
			}
			entrada.close();
		}catch(java.io.IOException ioex){
			System.out.println(ioex.toString());
		}
		return banco;
	}
	
	public static CuentaCorriente[] mezclarCC(CuentaCorriente [] cb1, CuentaCorriente [] cb2){
		CuentaCorriente [] mezcla=new CuentaCorriente[cb1.length+cb2.length];
		CuentaCorriente [] aux=new CuentaCorriente[cb1.length+cb2.length];
		int contador1=0;
		int contador2=0;
		int saldoMayor=0;
		CuentaCorriente cuenta=null;
		int posicion=0;
		while(contador1<cb1.length){
			mezcla[contador1]=cb1[contador1];
			contador1++;
		}
		while(contador1<(cb1.length+cb2.length)){
			mezcla[contador1]=cb2[contador2];
			contador1++;
			contador2++;
		}
		contador1=0;
		for(int i=aux.length-1;i>=0;i--){
			while(contador1<mezcla.length){
				if(saldoMayor<mezcla[contador1].getSaldo()){
					saldoMayor=mezcla[contador1].getSaldo();
					cuenta=new CuentaCorriente(mezcla[contador1].getTitular(),mezcla[contador1].getSaldo());
					posicion=contador1;
				}
				contador1++;
			}
			aux[i]=cuenta;
			cuenta=null;
			mezcla[posicion].setSaldo(0);
			posicion=0;
			contador1=0;
			saldoMayor=0;
		}
		return aux;
	}
	
	public static void main(String[] args) {
		CuentaCorriente[] Banco1=CuentaCorriente.crearCC("ingresosBFI.txt",6);
		CuentaCorriente[] Banco2=CuentaCorriente.crearCC("ingresosBGT.txt", 6);
		CuentaCorriente[] mezcla=mezclarCC(Banco1,Banco2);
		System.out.println();
		System.out.println("Datos Banco1");
		for (int i=0; i<mezcla.length;i++){
		System.out.println(mezcla[i].getTitular()+" Saldo:"+mezcla[i].getSaldo());
		}
		
	}

}
