package avion;

public class AsientoLibre extends Asiento {

	protected double precio;
	public AsientoLibre(int num, char letra, double precio) {
		super(num, letra);
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