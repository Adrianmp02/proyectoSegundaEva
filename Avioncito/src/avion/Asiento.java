package avion;

public class Asiento {

	protected boolean reservado;
	private char letra;
	private int fila;
	
	public Asiento(char letra, int fila) {
		this.reservado = false;
		this.letra = letra;
		this.fila = fila;
	}
	
	
}
