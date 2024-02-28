package avion;


public interface AvionInterface {
	
	
	/**
	 * Crea la estructura en la que se almacenan los asientos.
	 * En un primer momento todos los asientos están disponibles.
	 * Debe asignar a cada uno su número de asiento (Ej: 23B)
	 * @throws AvionException si se trata de crear un avion ya creado
	 * */
	public void crearAvion();
	
	
	/**
	 * Crea la estructura en la que se almacenan los asientos.
	 * En un primer momento todos los asientos están disponibles.
	 * Debe asignar a cada uno su número de asiento (Ej: 23B)
	 * @throws AvionException si se trata de mostrar un avión que no ha sido creado
	 * */
	public void mostrarAvion();
	

	/**
	 * Comprueba si un asiento está disponible
	 * @param numAsiento número del asiento (Ej: 23A)
	 * @throws AsientoException si el número de asiento no es correcto
	 * */
	public void comprobarAsiento(String numAsiento);
	
	
	/**
	 * Reserva un asiento
	 * @param numAsiento número del asiento (Ej: 23A)
	 * @throws AsientoException si el número de asiento no es correcto
	 * @throws AsientoException si el asiento ya estaba previamente reservado
	 * */
	public void reservarAsiento(String numAsiento, Persona comprador);
	
	
}
