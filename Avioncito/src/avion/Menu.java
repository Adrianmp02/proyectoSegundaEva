package avion;

import java.util.Iterator;
import java.util.Scanner;

public class Menu implements MainMenuInterface {

	public static void main(String[] args) throws AvionException, AsientoException {

		Menu menu = new Menu();

		menu.iniciar();
	}

	Avion s = new Avion();

	@Override
	public void iniciar() throws AvionException, AsientoException {	


		s.crearAvion();
		int eleccionOpcion;

		do {
			StringBuffer str = new StringBuffer();

			str.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			str.append("\n||                              ||");
			str.append("\n||      ELIJA UNA OPCIÒN:       ||");
			str.append("\n");
			str.append("||------------------------------||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 1 ► Billete Suelto ┊🃏 ");			 
			str.append("      ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 2 ► Varios billetes 🃏┊🃏");  		
			str.append("     ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n");
			str.append("|| 3 ► Asiento 👍libre/ocupado⛔ ");  		
			str.append("||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n|| 4 ► ✈️ Mostrar Asientos ✈️");  		
			str.append("    ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n|| 5 ► Salir 👋    ");  		
			str.append("             ||");
			str.append("\n||                              ||");
			str.append("\n||                              ||");
			str.append("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

			System.out.println(str.toString());

			eleccionOpcion = scannerInt();

			if(eleccionOpcion == 1 || eleccionOpcion == 2) {

				if(eleccionOpcion == 1) {

					comprarEntrada();

				}

				else if(eleccionOpcion == 2) {

					comprarEntradas();

				}

			}

			if(eleccionOpcion == 3) {

			}

			if(eleccionOpcion == 4) {
				s.mostrarAvion();
			}
		}
		while(eleccionOpcion != 5);

	}



	@Override
	public void comprarEntrada() throws AsientoException {

		System.out.println("Estos son los asientos disponibles de primera clase ->");

		int separadorPrimera = 0;

		for (int i = 0; i < s.asientosPrimera.size(); i++) {

			if(separadorPrimera == 4) {
				System.out.println();
				separadorPrimera = 0;
			}

			if(!s.asientosPrimera.get(i).reservado) {
				System.out.print(s.asientosPrimera.get(i).numAsiento + " | ");
				separadorPrimera++;
			}

		}

		System.out.println();

		System.out.println("Estos son los asientos disponibles de clase turista ->");

		int separadorTurista = 0;

		for (int i = 0; i < s.asientosTurista.size(); i++) {

			if(separadorTurista == 29) {
				System.out.println();
				separadorTurista = 0;
			}

			if(!s.asientosTurista.get(i).reservado) {
				System.out.print(s.asientosTurista.get(i).numAsiento + " | ");
				separadorTurista++;
			}

		}

		System.out.println();

		System.out.println("Dime el asiento que quieres reservar.");
		String vuelo = scannerString().toUpperCase();
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
		s.reservarAsiento(vuelo, p);
		System.out.println("De parte de David, te agradecemos la compra");


	}

	@Override
	public void comprarEntradas() throws AsientoException {

		System.out.println("¿Cuantas billetes quieres?");
		int numDeBilletes = scannerInt();
		String vuelos = "";

		//Elegir cantidad del numero de billetes comprados

		if(numDeBilletes < 1) {
			System.out.println("Usted es imbecil, introduzca un numero valido, y deje de hacernos perder el tiempo");   //Adrian no ha tenido nada que ver
			comprarEntradas();
		}
		if(numDeBilletes == 1) {
			System.out.println("Usted es imbecil, para la proxima elija la opcion uno en el menu anterior");
			comprarEntrada();
		}
		if(numDeBilletes > 1) {


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

			//Elegir primera clase o clase turista

			System.out.println("Opcion 1-> Primera clase \nOpcion 2-> Clase turista");
			int numOpcion = scannerInt();

			int disponibles = 0;

			if(numOpcion == 1) {

				//cuenta los asientos disponbles

				for (int i = 0; i < s.asientosPrimera.size(); i++) {
					if(!s.asientosPrimera.get(i).reservado) {
						disponibles++;
					}
				}


				if(disponibles <= numDeBilletes) {

					int comprobar = 0;
					int i = 0;

					while(comprobar != numDeBilletes && i > s.asientosPrimera.size()) {
						if(!s.asientosPrimera.get(i).reservado) {
							comprobar++;
						}else {
							comprobar = 0;
						}
						i++;
					}

					for (int j = i-numDeBilletes; j < numDeBilletes+i; j++) {
						s.reservarAsiento(s.asientosPrimera.get(j).numAsiento, p);
					}


				}
			}
		}

		for (int i = 0; i < s.avionAsientos.size(); i++) {

		}

		for (int i = 1; i < numDeBilletes; i++) {





		}
	}


	@Override
	public void comprobarAsiento() throws AsientoException  {

		String asiento=scannerString();
		s.comprobarAsiento(asiento);

	}

	@Override
	public void mostrarAsientos() throws AvionException {

		s.mostrarAvion();

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

}