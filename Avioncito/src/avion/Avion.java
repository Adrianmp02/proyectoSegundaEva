package avion;

import java.util.ArrayList;
import java.util.Arrays;

public class Avion implements AvionInterface {

	private ArrayList<Integer> fila;
	private ArrayList<Character> letraTurista;
	private ArrayList<Character> letraFirstClass;
	private ArrayList<Asiento> asientos;
	
	
	@Override
	public void crearAvion() {
		
		fila = new ArrayList<Integer>();
		letraTurista = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));
		letraFirstClass = new ArrayList<Character>(Arrays.asList('A', 'B', 'E', 'F'));

		asientos = new ArrayList<Asiento>();

		//Damos valor a la fila desde el numero 1 hasta el 33
		for(int i = 1; i <= 33; i++) {
			fila.add(i);
		}

		//Asigancion de asientos Primera Clase
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < letraFirstClass.size(); j++) {
				Asiento aux = new Asiento(letraFirstClass.get(j), fila.get(i));

				asientos.add(aux);
			}
		}

		//Asignacion de asientos Turista
		for(int i = 4; i < fila.size(); i++) {
			for(int j = 0; j < letraTurista.size(); j++) {
				Asiento aux = new Asiento(letraTurista.get(j), fila.get(i));

				asientos.add(aux);
			}
		}

		
	}

	@Override
	public void mostrarAvion() {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		

	}

	@Override
	public void comprobarAsiento(String numAsiento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reservarAsiento(String numAsiento, Persona comprador) {
		// TODO Auto-generated method stub

	}

}
