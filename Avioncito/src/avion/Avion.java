
package avion;
 
import java.util.ArrayList;

import java.util.Arrays;

import java.util.Iterator;
 
public class Avion implements AvionInterface {
 
	private ArrayList<Integer> filaPrimeraClase;

	private ArrayList<Integer> filaTurista;

	private ArrayList<Character> letraTurista;

	private ArrayList<Character> letraPrimeraClase;

	protected ArrayList<Asiento> asientosPrimera;

	protected ArrayList<Asiento> asientosTurista;

	protected ArrayList<Asiento> avionAsientos = new ArrayList<Asiento>();
 
 
	@Override

	public void crearAvion() throws AvionException {
 
		if(asientosPrimera != null) {

			throw new AvionException("Ya se encuentra un avion creado");

		}
 
		if(asientosTurista != null) {

			throw new AvionException("Ya se encuentra un avion creado");

		}
 
		filaPrimeraClase = new ArrayList<Integer>();

		filaTurista = new ArrayList<Integer>();

		letraTurista = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));

		letraPrimeraClase = new ArrayList<Character>(Arrays.asList('A', 'B', 'E', 'F'));

		asientosPrimera = new ArrayList<Asiento>();

		asientosTurista = new ArrayList<Asiento>();
 
		//Damos valor a la fila desde el numero 1 hasta el 4

		for(int i = 1; i <= 4; i++) {

			filaPrimeraClase.add(i);

		}
 
		//Damos valor a la fila desde el numero 5 hasta el 33

		for(int i = 0; i <= 33; i++) {

			filaTurista.add(i);

		}
 
		//Asigancion de asientos Primera Clase

		for(int i = 0; i < letraPrimeraClase.size(); i++) {

			for(int j = 0; j < 4; j++) {

				Asiento aux = new AsientoLibre(""+filaPrimeraClase.get(j)+letraPrimeraClase.get(i), 50.99);
 
				asientosPrimera.add(aux);

			}

		}
 
		//Asignacion de asientos Turista

		for(int i = 0; i < letraTurista.size(); i++) {

			for(int j = 5; j < filaTurista.size(); j++) {

				Asiento aux = new AsientoLibre(""+filaTurista.get(j)+letraTurista.get(i), 25.99);
 
				asientosTurista.add(aux);

			}

		}
 
		for(int i = 0; i < asientosPrimera.size(); i++) {

			avionAsientos.add(asientosPrimera.get(i));

		}

		for(int i = 0; i < asientosTurista.size(); i++) {

			avionAsientos.add(asientosTurista.get(i));

		}

 
	}
 
	@Override

	public void mostrarAvion() throws AvionException {
 
		int variableP = 0;

		int tamañoP = 3;
 
		int variableT = 0;

		int tamañoT = 28;
 
		if(avionAsientos == null) {

			throw new AvionException("No se puede mostrar el avion, no hay ningun avion creado");

		}
 
		System.out.print("A  ");
 
		for(int j = variableP; j <= tamañoP; j++) {
 
			if(avionAsientos.get(j).reservado) {

				System.out.print("[❌]");

			}else {

				System.out.print("[✔]");

			}
 
		}
 
		System.out.print(" |");
 
		System.out.print(" A  ");
 
		for(int j = variableT; j <= tamañoT; j++) {
 
			if(avionAsientos.get(j).reservado) {

				System.out.print("[❌]");

			}else {

				System.out.print("[✔]");

			}
 
		}
 
		//-----------------------------------------------------------------------------------//
 
		variableP += 4;

		tamañoP += 4;

		variableT += 29;

		tamañoT += 29;
 
		System.out.println();

		System.out.print("B  ");
 
		for(int j = variableP; j <= tamañoP; j++) {
 
			if(avionAsientos.get(j).reservado) {

				System.out.print("[❌]");

			}else {

				System.out.print("[✔]");

			}
 
		}
 
		System.out.print(" |");
 
		System.out.print(" B  ");
 
		for(int j = variableT; j <= tamañoT;j++) {
 
			if(avionAsientos.get(j).reservado) {
 
				System.out.print("[❌]");

			}else {

				System.out.print("[✔]");

			}
 
		}

		System.out.println();

	}
 
	@Override

	public void comprobarAsiento(String numAsiento) throws AsientoException {
 
		boolean flag = true;

		for(int i = 0; i < avionAsientos.size(); i++) {

			if(!numAsiento.toUpperCase().equals(avionAsientos.get(i).getNumAsiento())) {

				flag = false;

			}else {

				flag = true;

				break;

			}

		}

		if(!flag) {

			throw new AsientoException("Asiento no valido");

		}

		boolean flagReservar = false;

		for(int i = 0; i < avionAsientos.size(); i++) {

			if(numAsiento.toUpperCase().equals(avionAsientos.get(i).getNumAsiento())) {

				if(avionAsientos.get(i).reservado) {

					flagReservar = true;

				}

			}

		}

		if(flagReservar) {

			System.out.println("El asiento: "+numAsiento+" no esta disponible");

		}else {

			System.out.println("El asiento: "+numAsiento+" esta disponible");

		}

	}
 
	@Override

	public void reservarAsiento(String numAsiento, Persona comprador) throws AsientoException {
 
		Asiento cambio = new AsientoOcupado(numAsiento, comprador);
 
		boolean isFirstClass = false;

		boolean flagAsientoValido = true;

		for(int i = 0; i < avionAsientos.size(); i++) {

			if(!numAsiento.toUpperCase().equals(avionAsientos.get(i).getNumAsiento())) {

				flagAsientoValido = false;

			}else {

				flagAsientoValido = true;

				break;

			}

		}

		if(!flagAsientoValido) {

			throw new AsientoException("Asiento no valido");

		}
 
		//Array con asientos de Primera Clase

		String[] array = {"1A","2A","3A","4A","1B","2B","3B","4B","1E","2E","3E","4E","1F","2F","3F","4F"};
 
		//Identifica el tipo de asiento que se quiere reservar

		for (int i = 0; i < array.length; i++) {

			if(numAsiento.toUpperCase().equals(array[i])) {

				isFirstClass = true;

				break;

			}

		}
 
		if(isFirstClass) {
 
			//Si es asiento de Primera Clase, busca el asiento libre y lo cambia por un Asiento Ocupado

			for(int i = 0; i < asientosPrimera.size(); i++) {

				if(asientosPrimera.get(i).getNumAsiento().equals(numAsiento)) {

					if(asientosPrimera.get(i).isReservado() != true) { 

						asientosPrimera.set(i, cambio);

						return;

					}else {

						System.out.println("El asiento esta ocupado. Ingrese otro distinto");

					}

				}

			}

		}else {

			//Si es asiento Turista, busca el asiento libre y lo cambia por un Asiento Ocupado

			for(int i = 0; i < asientosTurista.size(); i++) {

				if(asientosTurista.get(i).getNumAsiento().equals(numAsiento)) {

					if(asientosTurista.get(i).isReservado() != true) { 

						asientosTurista.set(i, cambio);

						return;

					}else {

						System.out.println("El asiento esta ocupado. Ingrese otro distinto");

					}

				}

			}

		}

	}

}
