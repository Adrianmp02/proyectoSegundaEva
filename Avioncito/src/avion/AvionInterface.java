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
	

	
	
}
