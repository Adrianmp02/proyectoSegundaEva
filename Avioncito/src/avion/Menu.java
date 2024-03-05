package avion;

import java.time.LocalDate;
import java.util.Scanner;



public class Menu implements MainMenuInterface {

	Avion avion = new Avion();
	Persona p= new Persona ("7114554A","hector","garcia",13);

	@Override
	public void iniciar() throws AvionException, AsientoException {	

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
		int eleccion= scannerInt();
		if(eleccion==1) {
			StringBuffer str1 = new StringBuffer();

			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			str1.append("\n||                       ||");
			str1.append("\n||   TIPO DE ASIENTO:    ||");
			str1.append("\n");
			str1.append("||-----------------------||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| 1 ► Primera Clase");
			
			str1.append("     ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| 2 ► Clase Turista");  
			
			str1.append("     ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			System.out.println(str1.toString());

			int eleccion11 = scannerInt();
			if (eleccion11 ==1) {
				comprarEntrada();
			}
			if (eleccion11 ==2) {
				comprarEntradas();
			}
			else {
				System.out.println("elija otra opción. La opción elegida no existe.");
			}
		}
		if(eleccion==2) {
			
			StringBuffer str1 = new StringBuffer();

			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			str1.append("\n||                       ||");
			str1.append("\n||   TIPO DE ASIENTO:    ||");
			str1.append("\n");
			str1.append("||-----------------------||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| 1 ► Primera Clase");
			
			str1.append("     ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| 2 ► Clase Turista");  
			
			str1.append("     ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			System.out.println(str1.toString());

			int eleccion12 = scannerInt();
			if (eleccion12 ==1) {
				comprarEntrada();
			}
			if (eleccion12 ==2) {
				comprarEntradas();
			}
			else {
				System.out.println("elija otra opción. La opción elegida no existe.");
			}
		}
		if(eleccion==3) {
			System.out.println("introduzca asiento");
			
			comprobarAsiento();
		}

		if(eleccion==4) {
			
			
			mostrarAsientos();
		}
		if(eleccion==5) {
			System.out.println("Gracias por utilizar nuestra compañia.");
			return;
		}


		}
	



	@Override
	public void comprarEntrada() throws AsientoException {
String vuelo = scanner();
avion.reservarAsiento(vuelo,p);

		
		
	}

	@Override
	public void comprarEntradas() throws AsientoException {
		String vuelos = scanner();
		avion.reservarAsiento(vuelos, p);
		
		
	}

	@Override
	public void comprobarAsiento() {
		String asiento=scanner();
		avion.comprobarAsiento(asiento);
		
		
	}

	@Override
	public void mostrarAsientos() throws AvionException {
		avion.mostrarAvion();

	}
	public String scanner() {

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