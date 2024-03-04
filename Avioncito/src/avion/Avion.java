package avion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Avion implements AvionInterface {

	private ArrayList<Integer> filaP;
	private ArrayList<Integer> filaT;
	private ArrayList<Character> letraTurista;
	private ArrayList<Character> letraFirstClass;
	private ArrayList<Asiento> asientosPrimera;
	private ArrayList<Asiento> asientosTurista;


	@Override
	public void crearAvion() throws AvionException {

		if(asientosPrimera != null) {
			throw new AvionException("Ya se encuentra un avion creado");
		}
		
		if(asientosTurista != null) {
			throw new AvionException("Ya se encuentra un avion creado");
		}

		filaP = new ArrayList<Integer>();
		filaT = new ArrayList<Integer>();
		letraTurista = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));
		letraFirstClass = new ArrayList<Character>(Arrays.asList('A', 'B', 'E', 'F'));
		asientosPrimera = new ArrayList<Asiento>();
		asientosTurista = new ArrayList<Asiento>();

		//Damos valor a la fila desde el numero 1 hasta el 4
		for(int i = 1; i <= 4; i++) {
			filaP.add(i);
		}

		//Damos valor a la fila desde el numero 5 hasta el 33
		for(int i = 0; i <= 33; i++) {
			filaT.add(i);
		}

		//Asigancion de asientos Primera Clase
		for(int i = 0; i < letraFirstClass.size(); i++) {
			for(int j = 0; j < 4; j++) {
				Asiento aux = new AsientoLibre(""+filaP.get(j)+letraFirstClass.get(i), 50.99);

				asientosPrimera.add(aux);
			}
		}

		//Asignacion de asientos Turista
		for(int i = 0; i < letraTurista.size(); i++) {
			for(int j = 5; j < filaT.size(); j++) {
				Asiento aux = new AsientoLibre(""+filaT.get(j)+letraTurista.get(i), 25.99);

				asientosTurista.add(aux);
			}
		}
		
		//System.out.println(asientosTurista);


	}

	@Override
	public void mostrarAvion() throws AvionException {

		int variableP = 0;
		int tamañoP = 3;

		int variableT = 0;
		int tamañoT = 32;

		if(asientosPrimera == null) {
			throw new AvionException("No se puede mostrar el avion, no hay ningun avion creado");
		}

		System.out.print("A  ");

		for(int j = variableP; j <= tamañoP; j++) {

			if(asientosPrimera.get(j).reservado) {
				System.out.print("[❌]");
			}else {
				System.out.print("[✔]");
			}

		}

		System.out.print(" |");

		System.out.print(" A  ");

		for(int j = variableT; j <= tamañoT; j++) {

			if(asientosTurista.get(j).reservado) {
				System.out.print("[❌]");
			}else {
				System.out.print("[✔]");
			}

		}
		
		//-----------------------------------------------------------------------------------//
		
		variableP += 4;
		tamañoP += 4;
		
		System.out.println();
		System.out.print("B  ");

		for(int j = variableP; j <= tamañoP; j++) {

			if(asientosPrimera.get(j).reservado) {
				System.out.print("[❌]");
			}else {
				System.out.print("[✔]");
			}

		}

		System.out.print(" |");

		System.out.print(" B  ");

		for(int j = variableT; j <= tamañoT;j++) {

			if(asientosTurista.get(j).reservado) {

				System.out.print("[❌]");
			}else {
				System.out.print("[✔]");
			}

		}
	}

	@Override
	public void comprobarAsiento(String numAsiento) {

		Asiento aux; //Objeto asiento aux para la busqueda
		boolean flag = false; //Por defecto false, se entiende que no esta reservado aun
		for(int i = 0; i < asientosPrimera.size(); i++) {
			aux = asientosPrimera.get(i);
			if(aux.getNumAsiento().equals(numAsiento)) {
				if(aux.isReservado() == true) { 
					flag = true; //Si el asiento esta reservado, la flag pasa a true
				}
			}
		}

		if(!flag) {
			System.out.println("El asiento: "+numAsiento+", esta libre.");
		}else {
			System.out.println("El asiento: "+numAsiento+", esta ocupado.");
		}

	}

	@Override
	public void reservarAsiento(String numAsiento, Persona comprador) throws AsientoException {

		Asiento cambio = new AsientoOcupado(numAsiento, comprador);
		Asiento aux; //Objeto asiento aux para la busqueda

		int j = 0;
		for (int i = 0; i < asientosPrimera.size(); i++) {
			if(!asientosPrimera.get(i).getNumAsiento().equals(numAsiento.toUpperCase())) {
				j++;
			}
		}

		if(j == 190) {
			throw new AsientoException("Asiento introducido no valido");
		}

		for(int i = 0; i < asientosPrimera.size(); i++) {
			aux = asientosPrimera.get(i);
			if(aux.getNumAsiento().equals(numAsiento)) {
				if(aux.isReservado() != true) { 
					asientosPrimera.set(i, cambio);
				}
			}
		}



	}

}
