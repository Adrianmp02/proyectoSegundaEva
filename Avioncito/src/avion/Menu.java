package avion;

import java.util.Scanner;

public class Menu implements MainMenuInterface {

	static Avion avion;

	// Constructor de la clase Menu
	public static void main(String[] args) throws AvionException, AsientoException {

		avion = new Avion();

		Menu menu = new Menu();

		menu.iniciar();

	}
	// Método para iniciar el menú
	@Override
	public void iniciar() throws AvionException, AsientoException {	

		//avion.crearAvion();// Crear avión antes de mostrar el menú
		int eleccionOpcion;

		do {
			StringBuffer str = new StringBuffer();// Utilizando StringBuffer para construir el menú dinámicamente
			// Construcción del menú
			str.append("✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈✈✈✈✈✈");
			str.append("\n||                              ||");
			str.append("\n||      ELIJA UNA OPCIÒN:       ||");
			str.append("\n");
			str.append("||------------------------------||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 1 ► Billete Suelto     ");			 
			str.append("      ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 2 ► Varios Billetes     ");  		
			str.append("     ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 3 ► Asiento Libre/ocupado    ");  		
			str.append("||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n|| 4 ►  Mostrar Asientos    ");  		
			str.append("    ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n|| 5 ► Salir       ");  		
			str.append("             ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n✈️✈️✈️✈️✈️✈️✈️✈️✈️✈✈️✈️✈️✈️✈️✈✈✈✈✈✈");

			System.out.println(str.toString());

			eleccionOpcion = scannerInt();
			// Realizar acciones basadas en la opción elegida
			if(eleccionOpcion == 1) {
				comprarEntrada();
			}

			if(eleccionOpcion == 2) {
				comprarEntradas();
			}

			if(eleccionOpcion == 3) {
				comprobarAsiento();
			}

			if(eleccionOpcion == 4) {
				avion.mostrarAvion();
			}

		}
		while(eleccionOpcion != 5);

		System.out.println("Hasta pronto!!!");

	}
	// Método para comprar un billete suelto
	@Override
	public void comprarEntrada() throws AsientoException {

		Persona p = Persona.crearPersona();

		try {

			avion.reservarAsiento(avion.genAsiento(), p);

		} catch (Exception AsientoException) {

			avion.reservarAsiento(avion.genAsiento(), p);
		}
		
	}
	// Método para comprar varios billetes
	@Override
	public void comprarEntradas() throws AsientoException {
		Persona p = Persona.crearPersona();
		System.out.println("¿Cuantos billetes quieres reservar?");
		int billetes = scannerInt();
		try {

			avion.reservarVariosBilletes(billetes, p, 0);

		} catch (Exception AsientoException) {
			System.out.println("¿Cuantos billetes quieres reservar?");
			int billetes2 = scannerInt();
			avion.reservarVariosBilletes(billetes2, p, 0);
		}
	}
	// Método para comprobar si un asiento está libre u ocupado
	@Override
	public void comprobarAsiento() throws AsientoException  {
		
		System.out.println("Dime el asiento que quieres comprobar:");
		String asiento=scannerString().toUpperCase();
		
		try {

			avion.comprobarAsiento(asiento);

		} catch (Exception AsientoException) {
			
			System.out.println("Dime el asiento que quieres comprobar:");
			String asiento2=scannerString().toUpperCase();
			avion.comprobarAsiento(asiento2);
		}


	}
	// Método para mostrar los asientos del avión
	@Override
	public void mostrarAsientos() throws AvionException {
		
		try {

			avion.mostrarAvion();

		} catch (Exception AsientoException) {
			
			System.out.println("Avion no creado");
		}
		
		
	}

	// Método para leer una cadena de entrada del usuario
	//NO tocar
	public String scannerString() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();

		return n;

	}
	// Método para leer un entero de entrada del usuario
	public int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		return n;

	}

}