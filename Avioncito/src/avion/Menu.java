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

			StringBuffer str = new StringBuffer();

			str.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			str.append("\n||                       ||");
			str.append("\n||   ELIGE UNA OPCIÒN:   ||");
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