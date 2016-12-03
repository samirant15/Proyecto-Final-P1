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
	private int rebotes;
	private int asistencias;
	private int puntosAnotados;
	
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
	
	
	public int getRebotes() {
		return rebotes;
	}
	
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	
	public int getPuntosAnotados() {
		return puntosAnotados;
	}
	
	public void setPuntosAnotados(int puntosAnotados) {
		this.puntosAnotados = puntosAnotados;
	}


	public Jugador(String nombre, int numero, Posicion posicion, int rebotes, int asistencias, int puntosAnotados) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.posicion = posicion;
		this.rebotes = rebotes;
		this.asistencias = asistencias;
		this.puntosAnotados = puntosAnotados;
	}

	
	
	
}
