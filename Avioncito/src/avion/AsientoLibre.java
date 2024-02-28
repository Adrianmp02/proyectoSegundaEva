package avion;

public class AsientoLibre extends Asiento {

	private double precio;
	public AsientoLibre(char letra, int fila, double precio) {
		super(letra, fila);
		// TODO Auto-generated constructor stub
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
        return "AsientoLibre{" +
                "fila=" + getFila() +
                ", letra='" + getLetra() + '\'' +
                ", reservado=" + isReservado() +
                ", precio=" + precio +
                '}';
    }
}
