package avion;

import java.util.Scanner;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private int numAsientos;
	
	public Persona(String dni, String nombre, String apellido, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numAsientos = 0;
		
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getNumAsientos() {
		return numAsientos;
	}
	
	public String toString() {

		StringBuffer str = new StringBuffer();

		str.append("Nombre: "+nombre);
		str.append("\n");
		str.append("Apellido: "+apellido);

		return str.toString();
	}
	
	
	
	public static Persona crearPersona() {
		
		System.out.println("Dime tus datos: ");
		System.out.println("DNI: ");
		String dni = scannerString();
		System.out.println("Nombre: ");
		String nombre = scannerString();
		System.out.println("Apellido: ");
		String apellido = scannerString();
		System.out.println("Edad: ");
		int edad = scannerInt();
		Persona p = new Persona(dni, nombre, apellido, edad);
		
		return p;
	}
	
	
	
	
	//NO tocar
		public static String scannerString() {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String n = sc.nextLine();

			return n;

		}
		public static int scannerInt() {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			return n;

		}
}
