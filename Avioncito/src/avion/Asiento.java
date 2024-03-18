package avion;

public class Asiento {

	protected boolean reservado;
	protected int numAsiento;
	protected char letraAsiento;
	
	public Asiento(int num, char letra) {
		
		this.reservado = false;
		this.numAsiento = num;
		this.letraAsiento = letra;
		
	}

	public boolean estaReservado() {
		return reservado;
	}

	public int getNumAsiento() {
		return numAsiento;
	}
	
	public char getLetraAsiento() {
		return letraAsiento;
	}
	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		if(this.reservado) {
			str.append("[❌]");
		}else {
			str.append("[✔]");
		}
		
		return str.toString();
	}
	
	public AsientoOcupado reservar(Persona p) {
	    this.reservado = true;
	    return new AsientoOcupado(this.numAsiento, this.letraAsiento, p);
	}
	
	

	
}
