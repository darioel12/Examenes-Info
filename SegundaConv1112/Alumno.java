package SegundaConv1112;
import java.io.*;
import java.util.*;
public class Alumno {

	int nip;
	int [] codigos;
	boolean [] presentado;
	double [] notas;
	
	public Alumno(int elnip, int numAsig){
		nip=elnip;
		codigos=new int [numAsig];
		presentado=new boolean[numAsig];
		notas=new double [numAsig];
	}
	
	public static Alumno obtenerCalificaciones(String name, int elNIP){
		Alumno al=null;
		int [] asignaturas;
		int codAsig;
		String[] linea;
		String [] linea2;
		int nip = 0;
		double nota=0;
		double[] notas;
		boolean [] presentado;
		boolean calificado;
		try{
			Scanner entrada=new Scanner(new FileReader(name));
			linea=entrada.nextLine().split(" ");
			asignaturas=new int[linea.length];
			presentado=new boolean [linea.length];
			notas=new double [linea.length];
			for(int i=0;i<linea.length;i++){
				codAsig=Integer.parseInt(linea[i]);
				asignaturas[i]=codAsig;
			}
			entrada.nextLine();
			while(entrada.hasNext()){
				nip=entrada.nextInt();
				if(nip==elNIP){
					linea2=entrada.nextLine().split(" ");
					for(int i=1;i<linea2.length;i++){
						if(linea2[i].equals("*")){
							nota=-1.0;
							calificado=false;
							presentado[i-1]=calificado;
							notas[i-1]=nota;
						}else{
							nota=Double.valueOf(linea2[i]);
							calificado=true;
							presentado[i-1]=calificado;
							notas[i-1]=nota;
						}
					}
					al=new Alumno(nip,linea.length);
					al.codigos=asignaturas;
					al.notas=notas;
					al.presentado=presentado;
				}else{
					entrada.nextLine();
				}
			}
			entrada.close();
		}catch (java.io.IOException ioex){
			System.out.println(ioex);
		}
		return al;
	}
	
	public static boolean convalidar (Alumno al, int codAsig, double nt){
		double [] notas=al.notas;
		int contador=0;
		int contador1=0;
		int contador2=0;
		double suma=0;
		int [] asignaturas=al.codigos;
		for(int i=0;i<asignaturas.length;i++){
			if(asignaturas[i]==codAsig){
				while(contador1<notas.length){
					if(contador<=1 && notas[contador1]<5.0 && i==contador1){
						notas[i]=nt;
						while(contador2<notas.length){
							suma+=notas[contador2];
							contador2++;
						}
						if(suma/(double)notas.length>=5.0){
							return true;
						}
					}
					contador1++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Alumno al=obtenerCalificaciones("notas.txt",443212);
		System.out.println(convalidar(al,30300,5.0));

	}

}
