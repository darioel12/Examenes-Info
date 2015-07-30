package SegundaConv1011;
import java.io.*;
import java.util.*;


public class Alumno {

	private String _nombre;
	private double _nota;
	private boolean _superada;
	
	public Alumno(String nb, boolean sp, double nt){
		this._nombre=nb;
		this._superada=sp;
		this._nota=nt;
	}
	public void setNombre(String nb){
		this._nombre=nb;
	}
	public void setNota(double nt){
		this._nota=nt;
	}
	public void setSuperada(boolean sp){
		this._superada=sp;
	}
	public String getNombre(){
		return _nombre;
	}
	public double getNota(){
		return _nota;
	}
	public boolean getSuperada(){
		return _superada;
	}
	
	public static Alumno [] calculoNotasAlumnos(String fichero,int numAlumnos){
		double notaFinal=0;
		double nota=0;
		boolean superada=false;
		double contador=0;
		double suma=0;
		int contador1=0;
		Alumno al;
		Alumno [] clase=new Alumno[numAlumnos];
		String nombre;
		try{
			Scanner entrada=new Scanner(new FileReader(fichero));
			while(entrada.hasNext()){
				while(entrada.hasNextDouble()){
					nota=entrada.nextDouble();
					suma+=nota;
					contador=contador+1.0;
				}
				nombre=entrada.nextLine();
				notaFinal=suma/contador;
				if(notaFinal>=5.0){
					superada=true;
				}
				al=new Alumno(nombre,superada,notaFinal);
				clase[contador1]=al;
				contador1++;
				suma=0;
				contador=0;
			}
			entrada.close();
		}catch(java.io.IOException ioex){
			System.out.println(ioex);
		}
		return clase;
	}
	
	public static void verHistogramaClase(Alumno [] clase){
		String [] calificaciones={"Sobresaliente:","Notable:","Aprobado:","No superadas:"};
		int contador1=0;
		int contador2=0;
		int contador3=0;
		int contador4=0;
		double nota=0;
		for(int i=0;i<clase.length;i++){
			nota=clase[i].getNota();
			if(nota>=9.0){
				contador1++;
			}else if(nota<9.0 && nota>=7.0){
				contador2++;
			}else if(nota<7.0 && nota>=5.0){
				contador3++;
			}else{
				contador4++;
			}
		}
		for(int i=0;i<calificaciones.length;i++){
			System.out.print(calificaciones[i]);
			if(i==0){
				for(int j=1;j<=contador1;j++){
					System.out.print("*");
				}
			}else if(i==1){
				for(int j=1;j<=contador2;j++){
					System.out.print("*");
				}
			}else if(i==2){
				for(int j=1;j<=contador3;j++){
					System.out.print("*");
				}
			}else{
				for(int j=1;j<=contador4;j++){
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Alumno [] clase=calculoNotasAlumnos("notas2.txt",6);
		Alumno al=null;
		for(int i=0;i<clase.length;i++){
			al=clase[i];
			System.out.print(al.getNota()+" ");
		}
		System.out.println();

		verHistogramaClase(clase);
	}
}
