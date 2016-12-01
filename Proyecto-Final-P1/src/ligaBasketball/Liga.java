package ligaBasketball;

import java.util.ArrayList;


import enums.Posicion;
import enums.Roles;
import onlineMedia.Usuario;


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
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<EquipoFantasy> equiposfantasy = new ArrayList<EquipoFantasy>();
	
	public void InsertJugador(String nombre, int numero, Posicion posicion, int rebotes, int asistencias, int puntosAnotados){
		Jugador player = new Jugador(nombre, numero,  posicion,  rebotes,  asistencias,  puntosAnotados);
		jugadores.add(player);
	}
	
	public void InsertEquipo(String nombre, int partidosGanados, int partidasPerdidas, ArrayList<Jugador> jugador){
		Equipo team = new Equipo(nombre, partidosGanados, partidasPerdidas, jugador);
		equipos.add(team);
	}
	
	public void InsertEquipoFantasy(String nombre, int partidosGanados, int partidasPerdidas, ArrayList<Jugador> jugador){
		EquipoFantasy teamfancy = new EquipoFantasy(nombre, partidosGanados, partidasPerdidas, jugador);
		equiposfantasy.add(teamfancy);
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
	
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public ArrayList<EquipoFantasy> getEquiposfantasy() {
		return equiposfantasy;
	}
	public void setEquiposfantasy(ArrayList<EquipoFantasy> equiposfantasy) {
		this.equiposfantasy = equiposfantasy;
	}
	public void ChoosePlayer(Jugador jugador){
		
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getUsuario(int pos){
		return usuarios.get(pos); 
	}
	public int posUsuarioPorUserName(String username){
		int pos = -1, i = 0;
		for (Usuario user : usuarios){
			if(user.getUsername().equals(username) == true){
				pos = i; 
			}
			i++; 
		}
		return pos; 
	}
	public int posUsuarioPorEmail(String email){
		int pos = -1,i = 0;
		for (Usuario user : usuarios){
			if(user.getEmail().equals(email) == true){
				pos = i; 
			}
			i++; 
		}
		return pos; 
	}
	public boolean confirmarPassword(String tryPassword,int pos){
		boolean igual = false ; 
		if(usuarios.get(pos).equals(tryPassword) == true){
			igual = true; 
		}
		return igual; 
	}
	public void addUsuarioV(String email, String contrasena, String username, String nombre, Roles rol){
		Usuario usuario = new Usuario(email, contrasena, username, nombre,Roles.Visitante);
		usuarios.add(usuario);
	}
	
	

}
	


	
	

