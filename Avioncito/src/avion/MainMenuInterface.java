package avion;


public interface MainMenuInterface {

	
	/**
	 * El método main va en esta clase*/
	public static void main(String[] args){}
	
	
	/**
	 * Imprime el menú con las opciones
	 * @throws AvionException 
	 * @throws AsientoException 
	 * */
	public void iniciar() throws AvionException, AsientoException;
	
	
	/**
	 * Inicia el proceso de compra de una entrada
	 * @throws AsientoException 
	 * */
	public void comprarEntrada() throws AsientoException;
	
	/**
	 * Inicia el proceso de compra de varias entradas de golpe
	 * @throws AsientoException 
	 * */
	public void comprarEntradas() throws AsientoException;
	
	/**
	 * Comprueba la disponibilidad de un asiento
	 * @throws AsientoException 
	 * */
	public void comprobarAsiento() throws AsientoException;
	
	/**
	 * Muestra un diagrama de los asientos.
	 * @throws AvionException 
	 * */
	public void mostrarAsientos() throws AvionException;
	
	
	
	
	
}
