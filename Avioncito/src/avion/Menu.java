package avion;

import java.time.LocalDate;
import java.util.Scanner;



public class Menu implements MainMenuInterface {

	public int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		return n;

	}

	@Override
	public void iniciar() {	
		int eleccion= scannerInt();

		StringBuffer str = new StringBuffer();

		str.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		str.append("\n||                       ||");
		str.append("\n||   ELIJA UNA OPCIÒN:   ||");
		str.append("\n");
		str.append("||-----------------------||");
		str.append("\n||                       ||");
		str.append("\n");
		str.append("|| １ ► Billete Suelto");
		str.append("\uD83C\uDF40┊"); 
		str.append(" ||");
		str.append("\n||                       ||");
		str.append("\n||                       ||");
		str.append("\n");
		str.append("|| ２ ► Varios billetes");  
		str.append("\uD83D\uDCBE┊");
		str.append(" ||");
		str.append("\n||                       ||");
		str.append("\n||                       ||");
		str.append("\n");
		str.append("|| ３ ► Comprobación libre/ocupado        ");  
		str.append("\uD83D\uDEAA┊");
		str.append(" ||");
		str.append("\n||                       ||");
		str.append("\n||                       ||");
		str.append("|| 4 ► Ubicación Asiento");  
		str.append("\uD83D\uDEAA┊");
		str.append(" ||");
		str.append("\n||                       ||");
		str.append("\n||                       ||");
		str.append("|| 5 ► Salir        ");  
		str.append("\uD83D\uDEAA┊");
		str.append(" ||");
		str.append("\n||                       ||");
		str.append("\n||                       ||");
		str.append("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°");

		System.out.println(str.toString());

		if(eleccion==1) {
			StringBuffer str1 = new StringBuffer();

			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			str1.append("\n||                       ||");
			str1.append("\n||   TIPO DE ASIENTO:   ||");
			str1.append("\n");
			str1.append("||-----------------------||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| １ ► Primera Clase");
			str1.append("\uD83C\uDF40┊"); 
			str1.append(" ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| ２ ► Clase Turista");  
			str1.append("\uD83D\uDCBE┊");
			str1.append(" ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			System.out.println(str.toString());

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
			str1.append("\n||   TIPO DE ASIENTO:   ||");
			str1.append("\n");
			str1.append("||-----------------------||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| １ ► Primera Clase");
			str1.append("\uD83C\uDF40┊"); 
			str1.append(" ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("|| ２ ► Clase Turista");  
			str1.append("\uD83D\uDCBE┊");
			str1.append(" ||");
			str1.append("\n||                       ||");
			str1.append("\n||                       ||");
			str1.append("\n");
			str1.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			System.out.println(str.toString());

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
		// TODO Auto-generated method stub

	}

	@Override
	public void comprarEntradas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprobarAsiento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarAsientos() {
		// TODO Auto-generated method stub

	}
}