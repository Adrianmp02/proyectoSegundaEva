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
		//TODO
		if(asientos == null) {
			throw new AvionException("No se puede mostrar el avion, no hay ningun avion creado");
		}
		
		
		
	}

	@Override
	public void comprobarAsiento(String numAsiento) throws AsientoException {
		
		boolean flag = true; //Por defecto el asiento esta disponible
		for(int i = 0; i < asientos.size();i++) {
			if(!numAsiento.toUpperCase().equals(asientos.get(i).getNumAsiento())) { //Si el asiento que se quiere comprobar no esta en la lista
				flag = false; //flag pasa a false
			}else {
				flag = true; //flag vuelve a true en caso de encontrar el asiento 
				break;
			}
		}
		
		if(!flag) {
			throw new AsientoException("Asiento no valido"); //Si flag es false, da la excepcion
		}
		
		Asiento aux; //Objeto asiento aux para la busqueda
		boolean flagReservar = false; //Por defecto false, se entiende que no esta reservado aun
		for(int i = 0; i < asientos.size(); i++) {
			aux = asientos.get(i);
			if(aux.getNumAsiento().equals(numAsiento)) {
				if(aux.isReservado() == true) { 
					flagReservar = true; //Si el asiento esta reservado, la flag pasa a true
				}
			}
		}
		
		if(!flagReservar) {
			System.out.println("El asiento: "+numAsiento+", esta libre.");
		}else {
			System.out.println("El asiento: "+numAsiento+", esta ocupado.");
		}
		
	}

	@Override
	public void reservarAsiento(String numAsiento, Persona comprador) throws AsientoException {
		
		Asiento cambio = new AsientoOcupado(numAsiento, comprador);
		
		boolean flag = true;
		for(int i = 0; i < asientos.size();i++) {
			if(!numAsiento.toUpperCase().equals(asientos.get(i).getNumAsiento())) {
				flag = false;
			}else {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			throw new AsientoException("Asiento no valido");
		}
		
		for(int i = 0; i < asientos.size(); i++) {
			if(numAsiento.toUpperCase().equals(asientos.get(i).getNumAsiento())) {
				if(!asientos.get(i).isReservado()) {
					
					asientos.set(i, cambio);
					return;
					
				}else {
					
					System.out.println("Asiento ocupado, ingrese otro distinto");
					return;
					
				}
			}
		}
		
	}

}
