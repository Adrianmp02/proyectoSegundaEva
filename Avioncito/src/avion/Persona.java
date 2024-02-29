package avion;

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
}
