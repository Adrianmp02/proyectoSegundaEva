package avion;


public interface MainMenuInterface {

	
	/**
	 * El método main va en esta clase*/
	public void main(String[] args);
	
	
	/**
	 * Imprime el menú con las opciones
	 * */
	public void iniciar();
	
	
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
	 * */
	public void comprobarAsiento();
	
	/**
	 * Muestra un diagrama de los asientos.
	 * */
	public void mostrarAsientos();
	
	
	
	
	
}
