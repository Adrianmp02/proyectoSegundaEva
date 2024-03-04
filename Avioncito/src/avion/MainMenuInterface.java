package avion;


public interface MainMenuInterface {

	
	/**
	 * El método main va en esta clase*/
	public static void main(String[] args){}
	
	
	/**
	 * Imprime el menú con las opciones
	 * @throws AsientoException 
	 * */
	public void iniciar() throws AsientoException;
	
	
	/**
	 * Inicia el proceso de compra de una entrada
	 * */
	public void comprarEntrada();
	
	/**
	 * Inicia el proceso de compra de varias entradas de golpe
	 * */
	public void comprarEntradas();
	
	/**
	 * Comprueba la disponibilidad de un asiento
	 * @throws AsientoException 
	 * */
	public void comprobarAsiento() throws AsientoException;
	
	/**
	 * Muestra un diagrama de los asientos.
	 * */
	public void mostrarAsientos();
	
	
	
	
	
}
