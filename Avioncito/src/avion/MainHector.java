package avion;

public class MainHector {
	
	
	public static void main(String[] args) throws AvionException, AsientoException {
		
		Avion a = new Avion();
		Persona p = new Persona("12346394V", "Hector", "Montoya", 19);

		a.crearAvion();
		
		a.reservarAsiento("1A", p);
		a.reservarAsiento("2A", p);
		
		a.mostrarAvion();
		
	}

}
