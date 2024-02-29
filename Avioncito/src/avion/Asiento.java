package avion;

public class Asiento {

	protected boolean reservado;
	protected String numAsiento;
	
	public Asiento(String num) {
		this.reservado = false;
		this.numAsiento = num;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public String getNumAsiento() {
		return numAsiento;
	}
	
	public void setNumAsiento(String numAsiento) {
		this.numAsiento = numAsiento;
	}
	
	
	
}
