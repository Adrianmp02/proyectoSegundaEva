package avion;

import java.util.Scanner;

public class Menu implements MainMenuInterface {
	
	
	Avion s = new Avion();
	
	

	public static void main(String[] args) throws AvionException, AsientoException {

		Menu menu = new Menu();

		menu.iniciar();
		
		
	}



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

		s.comprarBillete();

	}

	@Override
	public void comprarEntradas() throws AsientoException {
		
		s.reservarVariosBilletes();
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