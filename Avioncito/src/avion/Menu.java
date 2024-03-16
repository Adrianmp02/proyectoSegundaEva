package avion;

import java.util.Scanner;

public class Menu implements MainMenuInterface {

	Avion vuelo1 = new Avion();


	protected Menu() {
		this.vuelo1 = new Avion();
	}

	public static void main(String[] args) throws AvionException, AsientoException {

		Menu menu = new Menu();

		menu.iniciar();

	}

	@Override
	public void iniciar() throws AvionException, AsientoException {	

		vuelo1.crearAvion();
		int eleccionOpcion;

		do {
			StringBuffer str = new StringBuffer();

			str.append("✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈✈✈️✈✈️✈️✈️✈️✈️✈✈");
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
			str.append("\n✈️✈️✈️✈️✈️✈️✈️✈️✈️✈️✈✈✈️✈✈️✈️✈️✈️✈️✈✈");

			System.out.println(str.toString());

			eleccionOpcion = scannerInt();

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
				vuelo1.mostrarAvion();
			}

		}
		while(eleccionOpcion != 5);

		System.out.println("Hasta pronto!!!");

	}

	@Override
	public void comprarEntrada() throws AsientoException {

		vuelo1.comprarBillete();

	}

	@Override
	public void comprarEntradas() throws AsientoException {

		vuelo1.reservarVariosBilletes();
	}

	@Override
	public void comprobarAsiento() throws AsientoException  {

		System.out.println("Dime el asiento que quieres comprobar:");
		String asiento=scannerString().toUpperCase();;
		vuelo1.comprobarAsiento(asiento);

	}

	@Override
	public void mostrarAsientos() throws AvionException {

		vuelo1.mostrarAvion();

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