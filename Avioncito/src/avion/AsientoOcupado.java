package avion;

public class AsientoOcupado extends Asiento {
	
	@SuppressWarnings("unused")
	private Persona p;
	
	public AsientoOcupado(String num, Persona p) {
		super(num);
		this.p = p;
		this.reservado = true;
	}

	
}
