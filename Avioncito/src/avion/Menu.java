package avion;

import java.time.LocalDate;
import java.util.Scanner;



public class Menu {

	

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
		str.append("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		
		System.out.println(str);

		eleccion = scannerInt();

		if (eleccion == 1) 
		
			StringBuffer str2 = new StringBuffer();
			
		str2.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		str2.append("\n||                       ||");
		str2.append("\n||   ELIGE UNA OPCIÒN:   ||");
		str2.append("\n");
		str2.append("||-----------------------||");
		str2.append("\n||                       ||");
		str2.append("\n");
		str2.append("|| １ ► Primera Clase");
		str2.append("\uD83C\uDF40┊");
		str2.append(" ||");
		str2.append("\n||                       ||");
		str2.append("\n||                       ||");
		str2.append("\n");
		str2.append("|| ２ ► Clase Turista");  
		str2.append("\uD83D\uDCBE┊");
		str2.append(" ||");
		str2.append("\n||                       ||");
		str2.append("\n||                       ||");
		str2.append("\n");
		str2.append("°°°°°°°°°°°°°°°°°°°°°°°°°°°");

			str2.append("║    1. ");
			for (int i = 0; i < usuarioPrimitiva.length; i++) {

				str2.append(String.format("%02d", usuarioPrimitiva[i]));
				str2.append(" ");

			}

			str2.append("  ║");
			str2.append("\n");

			str2.append("║                           ║");
			str2.append("\n");
			str2.append("║       REINTEGRO: "+usuarioReintegro+"        ║");
			str2.append("\n");
			str2.append("║                           ║");
			str2.append("\n");
			str2.append("╠═══════════════════════════╣");
			str2.append("\n");
			str2.append("║                           ║");
			str2.append("\n");
			str2.append("║                 1,00 EUR  ║");
			str2.append("\n");
			str2.append("║                           ║");
			str2.append("\n");
			str2.append("║  "+ LocalDate.now()+"               ║");
			str2.append("\n");
			str2.append("║                           ║");
			str2.append("\n");
			str2.append("╚═══════════════════════════╝");
			str2.append("\n");
			str2.append("=============================");
			
			System.out.println(str2);

			//Comparamos la primitiva del Usuario y Premiada / Reintegro Usuario y Premiado
			compaPrimitiva = comb.comparativaPrimitiva(usuarioPrimitiva, primitivaPremiada);
			compaReintegro = comb.comparativaReintegro(usuarioReintegro, reintegroPremiado);

			//Se muestra al usuario cuantos aciertos ha tenido
			if (compaPrimitiva != 0) {


				if (compaPrimitiva==1) {
					System.out.println("Has acertado: "+compaPrimitiva+" numero en la primitiva. Enhorabuena. 😊");
				}
				else {
					System.out.println("Has acertado: "+compaPrimitiva+" numeros en la primitiva. Enhorabuena. 😊");
				}
			}
			else {
				System.out.println("No has acertado ningún número de la primitiva. 😞");
			}

			//Comprobacion si se ha acertado el reintegro
			if (compaReintegro==1) {
				System.out.println("Has acertado el número reintegro.Enhorabuena. 😄");
			}
			else {
				System.out.println("No has acertado el número reintegro. 😞");
			}


			//Si ha acertado mas de 3 se guarda el premio para llevar un registro en el historial
			int premio = comb.puntaje(compaPrimitiva, compaReintegro, h);

			//Se muestra por pantalla al usuario el premio que se ha ganado
			System.out.println("Has ganado: "+premio+" €");

			h.premioGanado(premio);


		//Si el usuario elige la opcion 2, se muestra el historial
		}else if(eleccion == 2) {
			
			//Si el usuario no ha jugado ninguna partida, se le indica al usuario que no hay historial
			if (contadorPartidas == 0) {

				System.out.println("No hay historial reciente. No has jugado ninguna partida.");
			
			//Si ha jugado minimo 1 partida, se muestra el historial
			}else {

				h.imprimirHistorial();

			}
		
		//Si elige la opcion 3 se cierra
		}else if(eleccion == 3) {

			break;

		//Indica que no es valido si el usuario elige cualquier opcion distinta a 1, 2 o 3 y se vuelve a pedir
		}else {

			System.out.println("Opcion no valida, introduzca otra distinta");

		}
		
		//Si el usuario llega al limite de partidas, se le mostrara por pantalla el historial y se hara un reset para que continue jugando de cero
		if (contadorPartidas >= limitePartidas) {

			System.out.println("==========================");
			System.out.println("Has alcanzado el limite de partidas.");
			System.out.println("La ludopatía puede ser una trampa silenciosa.");
			System.out.println("Apostar no solo implica dinero, sino también salud mental y bienestar.");
			System.out.println("¡Juega responsablemente y prioriza tu salud!");
			System.out.println();
			System.out.println("Este es tu historial:");
			System.out.println("--------------------------");
			h.resetHistorial();
			contadorPartidas = 0;

		}

		//Si el usuario elige la opcion 3 el programa se para
	}	while(eleccion != 3); 

}


//Scanner NO TOCAR
public int scannerInt() {

	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();

	return n;

}