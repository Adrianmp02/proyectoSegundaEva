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

	

}
