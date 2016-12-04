package ligaBasketball;
import java.io.Serializable;
import java.util.ArrayList;
import enums.Posicion;
public class Jugador implements Serializable{
    
	/**
	 * 
	 */
	private static long serialVersionUID = 7356002253677261975L;
	private String nombre;
	private int numero;
	private Posicion posicion;
	private int anotaciones;
	private int asistencias;
	private int rebotes;
	
	

	
	public Jugador(String nombre, int numero, Posicion posicion, int anotaciones, int asistencias, int rebotes) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.posicion = posicion;
		this.anotaciones = anotaciones;
		this.asistencias = asistencias;
		this.rebotes = rebotes;
	}



	public Jugador() {
		super();
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}



	public int getAnotaciones() {
		return anotaciones;
	}



	public void setAnotaciones(int anotaciones) {
		this.anotaciones = anotaciones;
	}



	public int getAsistencias() {
		return asistencias;
	}



	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}



	public int getRebotes() {
		return rebotes;
	}



	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	
	
}
