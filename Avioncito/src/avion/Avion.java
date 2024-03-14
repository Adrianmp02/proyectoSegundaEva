package avion;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Avion implements AvionInterface {

	protected int capacidadMaxima;
	protected ArrayList<Asiento> asientosPrimera;
	protected ArrayList<Asiento> asientosTurista;
	protected ArrayList<Asiento> avionAsientos = new ArrayList<Asiento>();

	@Override
	public void crearAvion() throws AvionException {

		ArrayList<Integer> filaPrimeraClase;
		ArrayList<Integer> filaTurista;
		ArrayList<Character> letraTurista;
		ArrayList<Character> letraPrimeraClase;
		capacidadMaxima = 174;

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


	public String toString() {

		int variableP = 0;

		int tamañoP = 3;

		int variableT = 0;

		int tamañoT = 28;

		StringBuffer str = new StringBuffer();

		str.append("A  ");

		for(int j = variableP; j <= tamañoP; j++) {

			str.append(asientosPrimera.get(j).toString());

		}

		str.append(" |");

		str.append(" A  ");

		for(int j = variableT; j <= tamañoT; j++) {

			str.append(asientosTurista.get(j).toString());
		}


		//-----------------------------------------------------------------------------------//

		variableP += 4;

		tamañoP += 4;

		variableT += 29;

		tamañoT += 29;

		str.append("\n");

		str.append("B  ");

		for(int j = variableP; j <= tamañoP; j++) {

			str.append(asientosPrimera.get(j).toString());

		}

		str.append(" |");

		str.append(" B  ");

		for(int j = variableT; j <= tamañoT;j++) {

			str.append(asientosTurista.get(j).toString());

		}

		str.append(" 🚻");

		str.append("\n");

		//-----------------------------------------------------------------------------------//


		variableT += 29;

		tamañoT += 29;


		str.append("◀🚻                |");

		str.append(" C  ");

		for(int j = variableT; j <= tamañoT;j++) {

			str.append(asientosTurista.get(j).toString());

		}

		str.append("\n");
		str.append("\n");

		//-----------------------------------------------------------------------------------//


		variableT += 29;

		tamañoT += 29;


		str.append("◀🚻                |");

		str.append(" D  ");

		for(int j = variableT; j <= tamañoT;j++) {

			str.append(asientosTurista.get(j).toString());

		}


		//-----------------------------------------------------------------------------------//

		variableP += 4;

		tamañoP += 4;

		variableT += 29;

		tamañoT += 29;

		str.append("\n");

		str.append("E  ");

		for(int j = variableP; j <= tamañoP; j++) {

			str.append(asientosPrimera.get(j).toString());

		}

		str.append(" |");

		str.append(" E  ");

		for(int j = variableT; j <= tamañoT;j++) {

			str.append(asientosTurista.get(j).toString());
		}

		str.append(" 🚻");

		//-----------------------------------------------------------------------------------//

		variableP += 4;

		tamañoP += 4;

		variableT += 29;

		tamañoT += 29;

		str.append("\n");

		str.append("F  ");

		for(int j = variableP; j <= tamañoP; j++) {

			str.append(asientosPrimera.get(j).toString());

		}

		str.append(" |");

		str.append(" F  ");

		for(int j = variableT; j <= tamañoT;j++) {

			str.append(asientosTurista.get(j).toString());

		}
		str.append("\n");


		return str.toString();
	}

	@Override
	public void mostrarAvion() throws AvionException {

		System.out.println(toString());

	}

	@Override
	public void comprobarAsiento(String numAsiento) throws AsientoException {
		
		avionAsientos = new ArrayList<Asiento>();
		
		for(int i = 0; i < asientosPrimera.size(); i++) {

			avionAsientos.add(asientosPrimera.get(i));

		}

		for(int i = 0; i < asientosTurista.size(); i++) {

			avionAsientos.add(asientosTurista.get(i));

		}

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
						comprarBillete();
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
						comprarBillete();
					}
				}
			} 
		}
	}

	public void comprarBillete() throws AsientoException {

		System.out.println("Dime el asiento que quieres reservar:");

		String vuelo = scannerString();
		vuelo = vuelo.toUpperCase();

		boolean comp = true; //Flag, por defecto true ya que suponemos que el asiento es correcto
		for(int excp = 0; excp < avionAsientos.size(); excp++) {
			if(!vuelo.equals(avionAsientos.get(excp).getNumAsiento())) {
				comp = false; //Si el asiento introducido no corresponde con ninguno la flag pasa a false
			}else {
				comp = true; //Si alguno coincide pasa a true y sale del bucle
				break;
			}
		}

		//Si la flag es false, lanza excepcion
		if(!comp) {
			throw new AsientoException("El asiento que quieres reservar no esta en el rango informado");
		}

		Persona p = Persona.crearPersona();

		for(int j = 0; j < avionAsientos.size(); j++) {
			if(vuelo.equals(avionAsientos.get(j).getNumAsiento())) {
				reservarAsiento(vuelo, p);
			}
		}

		System.out.println("De parte de David, te agradecemos la compra");

	}


	public void reservarVariosBilletes() throws AsientoException {

		System.out.println("¿Cuantos billetes quieres reservar?");
		int numBilletes = scannerInt();

		Persona p = Persona.crearPersona();

		if(numBilletes == 1){
			comprarBillete();
			return;
		}

		int contador = 0;
		for (int i = 0; i < asientosTurista.size(); i++) {
			if(!asientosTurista.get(i).reservado) {
				contador++;
			}
		}

		if(numBilletes <= contador) {

			int veces = bucleDeAsientos(numBilletes, p);

			while(veces != 0) {

				veces = bucleDeAsientos(veces, p);

			}

		}else {
			System.out.println("No hay suficientes asientos libres");
			reservarVariosBilletes();
		}

	}


	public int logicaAsientos(int numBilletes, Persona p) throws AsientoException {

		int asientosTotales = 0;
		int seguir = 0;
		Asiento aux = null;
		
		int contador = 0;
		for (int i = 0; i < asientosTurista.size(); i++) {
			if(!asientosTurista.get(i).reservado) {
				contador++;
			}
		}

		if(numBilletes != contador) {

			boolean salir = false;
			for (int i = 0; i < 33; i++) {

				int a = i;
				if(salir == true) {
					break;
				}
				for (int j = 0; j < 6; j++) {
					asientosTotales++;
					if(!asientosTurista.get(a).reservado) {
						seguir++;
						if(seguir == 1) {
							aux = asientosTurista.get(a);
						}
						a+=29;
					}else {
						a+=29;
						seguir = 0;
					}
					if(seguir == numBilletes) {
						salir = true;
						break;
					}
				}

				if(asientosTotales == 175) {
					seguir = 0;
					break;
				}
			}

			if(seguir == 0) {

				System.out.println("Si llego hasta aqui");
				return 0;

			}else {

				boolean reservar = false;
				int reservado = 0;
				if(seguir == numBilletes) {
					for (int i = 0; i < 33; i++) {
						int b = i;
						for (int j = 0; j < 6; j++) {
							if(reservado != numBilletes) {
								if(asientosTurista.get(b) == aux) {
									reservar = true;
								}
								if(reservar) {
									reservarAsiento(asientosTurista.get(b).numAsiento, p);
									b+=29;
									reservado++;
								}else {
									b+=29;
								}
							}
						}
					}
				}
			}
		}else {
			
			boolean salir = false;
			for (int i = 0; i < 33; i++) {

				int a = i;
				if(salir == true) {
					break;
				}
				for (int j = 0; j < 6; j++) {
					
					if(!asientosTurista.get(a).reservado) {
						seguir++;
						if(seguir == 1) {
							aux = asientosTurista.get(a);
						}
						a+=29;
					}else {
						a+=29;
						seguir = 0;
					}
					if(seguir == numBilletes) {
						salir = true;
						break;
					}
				}
			}
					
			boolean reservar = false;
			int reservado = 0;
			if(seguir == numBilletes) {
				for (int i = 0; i < 33; i++) {
					int b = i;
					for (int j = 0; j < 6; j++) {
						if(reservado != numBilletes) {
							if(asientosTurista.get(b) == aux) {
								reservar = true;
							}
							if(reservar) {
								reservarAsiento(asientosTurista.get(b).numAsiento, p);
								b+=29;
								reservado++;
							}else {
								b+=29;
							}
						}
					}
				}
			}
		}
		return 1;

	}

	public int bucleDeAsientos(int numBilletes, Persona p) throws AsientoException {

		int num = logicaAsientos(numBilletes, p);
		int conteo = 0;

		while(num == 0) {

			numBilletes--;
			conteo++;
			num = logicaAsientos(numBilletes, p);

		}

		return conteo;
	}

	//NO tocar
	public String scannerString() {

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