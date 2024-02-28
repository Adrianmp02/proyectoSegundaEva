package avion;

public class AsientoLibre extends Asiento {

	private double precio;
	public AsientoLibre(char letra, int fila, double precio) {
		super(letra, fila);
		// TODO Auto-generated constructor stub
		this.reservado = false;
		this.precio = precio;
	}

}
