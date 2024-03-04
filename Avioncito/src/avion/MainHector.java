package avion;

public class MainHector {
	
	
	public static void main(String[] args) throws AvionException, AsientoException {
		
		Avion a = new Avion();
		Persona p = new Persona("12346394V", "Hector", "Montoya", 19);

		a.crearAvion();
		
		a.reservarAsiento("1A", p);
		a.reservarAsiento("4B", p);
		a.reservarAsiento("5A", p);
		a.reservarAsiento("33A", p);
		a.reservarAsiento("30B", p);
		
		a.mostrarAvion();
		
	}

}
