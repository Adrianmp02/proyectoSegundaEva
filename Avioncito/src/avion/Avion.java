package avion;

import java.util.ArrayList;
import java.util.Arrays;

public class Avion implements AvionInterface {

	private ArrayList<Integer> fila;
	private ArrayList<Character> letraTurista;
	private ArrayList<Character> letraFirstClass;
	private ArrayList<Asiento> asientos;
	
	
	@Override
	public void crearAvion() throws AvionException {
		
		if(asientos != null) {
			throw new AvionException("Ya se encuentra un avion creado");
		}
		
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
				Asiento aux = new AsientoLibre(""+fila.get(i)+letraFirstClass.get(j), 50.99);

				asientos.add(aux);
			}
		}

		//Asignacion de asientos Turista
		for(int i = 4; i < fila.size(); i++) {
			for(int j = 0; j < letraTurista.size(); j++) {
				Asiento aux = new AsientoLibre(""+fila.get(i)+letraTurista.get(j), 25.99);

				asientos.add(aux);
			}
		}

		
	}

	@Override
	public void mostrarAvion() throws AvionException {
		
		if(asientos == null) {
			throw new AvionException("No se puede mostrar el avion, no hay ningun avion creado");
		}
		//Recorremos la lista sacando por pantalla los asientos
		for(int i = 0; i < asientos.size(); i++) {
			System.out.println(asientos.get(i));
		}
		
	}

	@Override
	public void comprobarAsiento(String numAsiento) {
		
		
		Asiento aux; //Objeto asiento aux para la busqueda
		boolean flag = false; //Por defecto false, se entiende que no esta reservado aun
		for(int i = 0; i < asientos.size(); i++) {
			aux = asientos.get(i);
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
		for (int i = 0; i < asientos.size(); i++) {
			if(!asientos.get(i).getNumAsiento().equals(numAsiento.toUpperCase())) {
				j++;
			}
		}
		
		if(j == 190) {
			throw new AsientoException("Asiento introducido no valido");
		}
		
		for(int i = 0; i < asientos.size(); i++) {
			aux = asientos.get(i);
			if(aux.getNumAsiento().equals(numAsiento)) {
				if(aux.isReservado() != true) { 
					asientos.set(i, cambio);
				}
			}
		}
		
		
		
	}

}
