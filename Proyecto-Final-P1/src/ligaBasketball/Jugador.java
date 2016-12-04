package ligaBasketball;
import java.io.Serializable;
import java.util.ArrayList;
import enums.Posicion;
public class Jugador implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7356002253677261975L;
	private String nombre;
	private int numero;
	private Posicion posicion;
	private ArrayList<Estadistica> estadisticas;
	
	public Jugador() {
		super();
	}

	public Jugador(String nombre, int numero, Posicion posicion, ArrayList<Estadistica> estadisticas) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.posicion = posicion;
		this.estadisticas = estadisticas;
		this.estadisticas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public ArrayList<Estadistica> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(ArrayList<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}
}
