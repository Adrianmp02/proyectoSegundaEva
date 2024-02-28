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

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public String toString() {
        
		StringBuffer str = new StringBuffer();
		
		str.append("Asientos: ");
    }
	
}
