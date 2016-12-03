package ligaBasketball;

import java.io.Serializable;
import java.util.ArrayList;


public class Equipo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4877462266129460468L;
	private String nombre;
	private int partidosGanados;
	private int partidasPerdidas;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	public void InsertJugador(Jugador jugador){
		jugadores.add(jugador);
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	
	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}
	
	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugador) {
		this.jugadores = jugador;
	}

	public Equipo(String nombre, int partidosGanados, int partidasPerdidas, ArrayList<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.partidosGanados = partidosGanados;
		this.partidasPerdidas = partidasPerdidas;
		this.jugadores = jugadores;
	}

	

	
	
	
}
