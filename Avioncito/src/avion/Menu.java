package avion;

import java.time.LocalDate;
import java.util.Scanner;



public class Menu implements MainMenuInterface {

	

	@Override
	public void iniciar() {	

		StringBuffer str = new StringBuffer();

		str.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		str.append("\n||                              ||");
		str.append("\n||      ELIJA UNA OPCIÒN:       ||");
		str.append("\n");
		str.append("||------------------------------||");
		str.append("\n||                              ||");
		str.append("\n");
		str.append("|| 1 ► Billete Suelto");
		 
		str.append("           ||");
		str.append("\n||                              ||");
		str.append("\n||                              ||");
		str.append("\n");
		str.append("|| 2 ► Varios billetes");  
		
		str.append("          ||");
		str.append("\n||                              ||");
		str.append("\n||                              ||");
		str.append("\n");
		str.append("|| 3 ► Asiento libre/ocupado    ");  
		
		str.append("||");
		str.append("\n||                              ||");
		str.append("\n||                              ||");
		str.append("\n|| 4 ► Ubicación Asiento");  
		
		str.append("        ||");
		str.append("\n||                              ||");
		str.append("\n||                              ||");
		str.append("\n|| 5 ► Salir        ");  
		
		str.append("            ||");
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
			comprobarAsiento();
		}



		}
	



	@Override
	public void comprarEntrada() {

		
		
	}

	@Override
	public void comprarEntradas() {

		
		
	}

	@Override
	public void comprobarAsiento() {

		
		
	}

	@Override
	public void mostrarAsientos() {
		// TODO Auto-generated method stub

	}
	public int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		return n;

	}
}