package avion;

public class AsientoOcupado extends Asiento {
	
	private Persona p;
	
	public AsientoOcupado(int num, char letra, Persona p) {
		super(num, letra);
		this.p = p;
		this.reservado = true;
	}
}
