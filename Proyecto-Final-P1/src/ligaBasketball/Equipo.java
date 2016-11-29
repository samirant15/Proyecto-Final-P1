package ligaBasketball;

import java.util.ArrayList;

public class Equipo {
	
	private String PGanada;
	private String PPerdida;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	public String getPGanada() {
		return PGanada;
	}
	public void setPGanada(String pGanada) {
		PGanada = pGanada;
	}
	public String getPPerdida() {
		return PPerdida;
	}
	public void setPPerdida(String pPerdida) {
		PPerdida = pPerdida;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
	
	
}
