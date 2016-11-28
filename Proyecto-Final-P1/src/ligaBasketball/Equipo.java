package ligaBasketball;

import java.util.List;

public class Equipo {
	
	private String PGanada;
	private String PPerdida;
	private List<Jugador> jugadores;
	
	
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
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
}
