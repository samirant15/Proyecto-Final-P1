package ligaBasketball;

import java.util.ArrayList;


import enums.Posicion;


public class Liga {

    private static Liga Liga = null;
	private Liga(){}
	public static Liga getInstance(){
		if(Liga == null)
			Liga = new Liga();
		return Liga;
	}

	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	public void InsertJugador(String nombre, int numero, Posicion posicion, int rebotes, int asistencias, int puntosAnotados){
		Jugador player = new Jugador(nombre, numero,  posicion,  rebotes,  asistencias,  puntosAnotados);
		jugadores.add(player);
	}
	
	public void InsertEquipo(String nombre, int partidosGanados, int partidasPerdidas, ArrayList<Jugador> jugadores){
		Equipo team = new Equipo(nombre, partidosGanados, partidasPerdidas, jugadores);
		equipos.add(team);
	}
	
	public static Liga getLiga() {
		return Liga;
	}
	
	public static void setLiga(Liga liga) {
		Liga = liga;
	}
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	
	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
	
	public void InsertarJugador(Jugador jugador)
	{
		jugadores.add(jugador);
	}
	
	
	public void InsertarEquipo(Equipo equipo)
	{
		equipos.add(equipo);
	}
	
	public void InsertarPartidos(Partido partido)
	{
		partidos.add(partido);
	}
	

	
}

	
	

