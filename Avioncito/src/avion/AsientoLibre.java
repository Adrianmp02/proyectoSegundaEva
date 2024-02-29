package avion;

public class AsientoLibre extends Asiento {

	private double precio;
	public AsientoLibre(String num, double precio) {
		super(num);
		this.reservado = false;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String toString() {

		StringBuffer str = new StringBuffer();

		str.append("Asiento: "+numAsiento);
		str.append("\n");
		str.append("Precio: "+precio+" €");
		str.append("\n");
		str.append("----------------------------------------------");

		return str.toString();
	}

}
