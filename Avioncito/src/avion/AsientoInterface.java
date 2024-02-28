package avion;


public interface AsientoInterface {
	
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
