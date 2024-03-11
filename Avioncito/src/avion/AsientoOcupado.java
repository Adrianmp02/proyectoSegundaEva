package avion;

public class AsientoOcupado extends Asiento {
	
	private Persona p;
	
	public AsientoOcupado(String num, Persona p) {
		super(num);
		this.p = p;
		this.reservado = true;
	}

	
}
