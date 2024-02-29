package avion;

public class AsientoOcupado extends Asiento {
	
	private Persona p;
	
	public AsientoOcupado(String num, Persona p) {
		super(num);
		this.p = p;
		this.reservado = true;
	}

	public String toString() {

		StringBuffer str = new StringBuffer();

		str.append("Asiento: "+numAsiento);
		str.append("\n");
		str.append("Comprador: \n"+p);
		str.append("\n");
		str.append("----------------------------------------------");

		return str.toString();
	}
}
