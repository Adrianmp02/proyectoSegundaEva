package avion;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Avion implements AvionInterface {

	private HashMap<String, Asiento> asientos;

	// Constructor de la clase Avion
	public Avion() throws AvionException {

		this.asientos = new HashMap<>();
		crearAvion();

	}

	/**
	 * Crea la estructura del avión asignando asientos libres.
	 * @throws AvionException Si ya se ha creado previamente un avión.
	 */
	@Override
	public void crearAvion() throws AvionException {
		// Verificar si ya existe un avión creado
		if (!asientos.isEmpty()) {
			throw new AvionException("Ya se encuentra un avion creado");
		}

		// Cambiar a LinkedHashMap para mantener el orden de inserción
		asientos = new LinkedHashMap<>();

		// Crear asientos de primera clase (filas 1 a 4) con letras A, B, E, F
		for (int numero = 1; numero <= 4; numero++) {
			for (char letra : new char[] {'A', 'B', 'E', 'F'}) {
				String id = numero + "" + letra;
				asientos.put(id, new AsientoLibre(numero, letra, 50.99));
			}
		}

		// Crear asientos de clase turista (filas 5 a 33) con letras A, B, C, D, E, F
		for (int numero = 5; numero <= 33; numero++) {
			for (char letra : new char[] {'A', 'B', 'C', 'D', 'E', 'F'}) {
				String id = numero + "" + letra;
				asientos.put(id, new AsientoLibre(numero, letra, 25.99));
			}
		}
	}

	public Asiento getAsiento(String numAsiento) {
		return asientos.get(numAsiento);
	}



	/**
	 * Devuelve un HashMap que contiene los asientos del proyecto, donde cada asiento
	 * se identifica por una cadena de texto y se asigna a un objeto de tipo Asiento.
	 * @return HashMap<String, Asiento> Un mapeo de cadenas de texto a objetos Asiento.
	 */
	public HashMap<String, Asiento> getAsientos() {
		return asientos;
	}	

	/**
	 * Devuelve un HashMap que contiene los asientos libres del proyecto, donde cada asiento
	 * libre se identifica por una cadena de texto y se asigna a un objeto de tipo AsientoLibre.
	 * @return HashMap<String, AsientoLibre> Un mapeo de cadenas de texto a objetos AsientoLibre.
	 */
	public HashMap<String, AsientoLibre> getAsientosLibres() {
		// Se crea un nuevo HashMap para almacenar los asientos libres.
		HashMap<String, AsientoLibre> asientosLibres = new HashMap<>();

		// Se itera sobre el HashMap de asientos existentes.
		for (HashMap.Entry<String, Asiento> entry : asientos.entrySet()) {
			// Si el valor correspondiente a la clave es una instancia de AsientoLibre, se agrega al HashMap de asientos libres.
			if (entry.getValue() instanceof AsientoLibre) {
				asientosLibres.put(entry.getKey(), (AsientoLibre) entry.getValue());
			}
		}

		// Se devuelve el HashMap que contiene los asientos libres.
		return asientosLibres;
	}



	@Override
	public String toString() {

		StringBuilder str = new StringBuilder();
		str.append("Estado de los Asientos del Avión:\n");
		str.append("--------------------------------\n");

		// Asientos de Primera Clase
		str.append("Primera Turista VIP:\n");
		str.append(estadoFilaAsientosHorizontal(1, 4, new char[]{'A', 'B', 'E', 'F'}));
		str.append("\n");

		// Asientos de Clase Turista
		str.append("Clase Turista:\n");
		str.append(estadoFilaAsientosHorizontal(5, 33, new char[]{'A', 'B', 'C', 'D', 'E', 'F'}));

		str.append("--------------------------------\n");
		return str.toString();
	}

	/**
	 * Genera una representación en forma de cadena de una fila de asientos horizontales dentro del rango especificado,
	 * identificados por números y letras.
	 * @param inicio El número inicial de asiento en la fila.
	 * @param fin El número final de asiento en la fila.
	 * @param letras El conjunto de letras que identifican los asientos en la fila.
	 * @return String Una cadena que representa el estado de los asientos en la fila.
	 */
	private String estadoFilaAsientosHorizontal(int inicio, int fin, char[] letras) {
		// Se crea un StringBuilder para construir la representación de la fila de asientos.
		StringBuilder strFila = new StringBuilder();

		// Itera sobre los números de asiento en la fila.
		for (int numero = inicio; numero <= fin; numero++) {
			// Agrega el número de asiento seguido de dos puntos y un espacio.
			strFila.append(numero).append(": ");

			// Itera sobre las letras que identifican los asientos en la fila.
			for (char letra : letras) {
				// Construye el ID del asiento combinando el número y la letra.
				String id = numero + "" + letra;
				// Obtiene el asiento correspondiente al ID del HashMap de asientos.
				Asiento asiento = asientos.get(id);
				// Si se encuentra un asiento, se agrega su representación a la cadena.
				if (asiento != null) {
					strFila.append(id).append(asiento.toString()).append(" ");
				}
			}

			// Agrega un salto de línea al final de la fila.
			strFila.append("\n");
		}

		// Devuelve la representación de la fila de asientos como una cadena.
		return strFila.toString();
	}


	@Override
	public void mostrarAvion() throws AvionException {

		System.out.println(toString());

	}

	/**
	 * Comprueba si un asiento específico está disponible o no.
	 * @param numAsiento El número de asiento a comprobar.
	 * @throws AsientoException Si el asiento no es válido o no está disponible.
	 */
	@Override
	public void comprobarAsiento(String numAsiento) throws AsientoException {
		// Convierte el número de asiento a mayúsculas para asegurar la consistencia.
		numAsiento = numAsiento.toUpperCase();
		System.out.println("Comprobando asiento: " + numAsiento);

		// Verifica si el número de asiento buscado está presente en el conjunto de asientos.
		if (!asientos.containsKey(numAsiento)) {
			System.out.println("Asiento no encontrado: " + numAsiento);
			// Lanza una excepción si el asiento no es válido.
			throw new AsientoException("Asiento no válido");
		}

		// Obtiene el objeto Asiento correspondiente al número de asiento.
		Asiento asiento = asientos.get(numAsiento);

		// Comprueba si el asiento está disponible.
		if (asientoDisponible(asiento)) {
			System.out.println("El asiento: " + numAsiento + " no está disponible");
		} else {
			System.out.println("El asiento: " + numAsiento + " está disponible");
		}
	}


	/**
	 * Reserva un asiento específico para una persona dada.
	 * @param numAsiento El número de asiento a reservar.
	 * @param p La persona para la cual se está reservando el asiento.
	 * @throws AsientoException Si el asiento no está en el rango informado o si ya está ocupado.
	 */
	@Override
	public void reservarAsiento(String numAsiento, Persona p) throws AsientoException {

		// Verifica si el asiento buscado está presente en el conjunto de asientos.
		if (!asientos.containsKey(numAsiento)) {
			throw new AsientoException("El asiento que quieres reservar no está en el rango informado");
		}

		// Obtiene el objeto Asiento correspondiente al número de asiento.
		Asiento asiento = asientos.get(numAsiento);

		// Verifica si el asiento está ocupado.
		if (asiento.estaReservado()) {
			throw new AsientoException("El asiento ya está ocupado");
		}

		// Verifica si el asiento es de tipo AsientoLibre.
		if (!(asiento instanceof AsientoLibre)) {
			throw new AsientoException("El asiento no es de tipo AsientoLibre y no se puede reservar");
		}

		// Realiza la reserva del asiento.
		AsientoLibre asientoLibre = (AsientoLibre) asiento;
		AsientoOcupado asientoOcupado = asientoLibre.reservar(p);

		// Actualiza el asiento en el mapa de asientos con el asiento ocupado.
		asientos.put(numAsiento, asientoOcupado);

		// Mostrar el asiento reservado y su precio por pantalla
		System.out.println("Has reservado el asiento: " + numAsiento);
		System.out.println("Por un precio de: " + asientoLibre.getPrecio());
		System.out.println("De parte de David, te agradecemos la compra");
	}




	/**
	 * Reserva varios billetes contiguos para una persona dada.
	 * @param cantidadBilletes La cantidad de billetes que se desea reservar.
	 * @param p La persona para la cual se están reservando los billetes.
	 * @throws AsientoException Si no se encuentran suficientes asientos contiguos disponibles.
	 */
	
	protected void reservarVariosBilletes(int cantidadBilletes, Persona p, int restantes) throws AsientoException {

		int disponibles = 0;

		for (Asiento asiento : asientos.values()) {
			if (!asiento.estaReservado()) {
				disponibles++;
			}
		}

		if (disponibles < cantidadBilletes) {
			throw new AsientoException("No se encontraron suficientes asientos contiguos para reservar");
		}

		// Lista para almacenar los asientos disponibles.
		ArrayList<Asiento> asientosAReservarHector = new ArrayList<>();

		int seguidos = 0;
		boolean resto = false;

		// Itera sobre todos los asientos para encontrar los disponibles.
		for (Asiento asiento : asientos.values()) {
			if (!asiento.estaReservado()) {
				asientosAReservarHector.add(asiento);
				seguidos++;
			}else {
				asientosAReservarHector = new ArrayList<>();
				seguidos = 0;
			}
			
			if(cantidadBilletes == asientosAReservarHector.size() && seguidos == cantidadBilletes) {
				resto = true;
				for (int i = 0; i < asientosAReservarHector.size(); i++) {
					asientosAReservarHector.get(i).reservar(p);
			    }
				if(restantes == 0) {
					System.out.println("De parte de David, te agradecemos la compra");
				}
				break;
			}
		}

		if(seguidos != cantidadBilletes) {
			if(cantidadBilletes%2 == 0 && cantidadBilletes > 2) {
				cantidadBilletes-=2;
				restantes+=2;
			}else if(cantidadBilletes > 4){
				cantidadBilletes--;
				restantes++;
				cantidadBilletes-=2;
				restantes+=2;
			}else{
				cantidadBilletes--;
				restantes++;
			}
			reservarVariosBilletes(cantidadBilletes, p, restantes);
		}

		if(resto == true && restantes != 0) {
			reservarVariosBilletes(restantes, p, 0);
		}

		
	}

	/**
	 * Comprueba si un asiento está disponible (no está reservado).
	 * @param asiento El asiento a comprobar.
	 * @return boolean true si el asiento está disponible, false si está reservado.
	 */
	public boolean asientoDisponible(Asiento asiento) {

		return !asiento.estaReservado();


	}





	//NO tocar
	public String scannerString() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();

		return n;

	}

	public int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		return n;

	}

	public String genAsiento() {

		System.out.println("Dime el asiento que quieres reservar:");

		String vuelo = scannerString().toUpperCase();

		return vuelo;
	}
}