package ligaBasketball;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import enums.Posicion;
import enums.Roles;
import onlineMedia.Usuario;
 

public class Liga implements Serializable{

	private static final long serialVersionUID = 2736906832795095562L;
    private static Liga Liga = null;
	private Liga(){}
	public static Liga getInstance(){
		if(Liga == null)
			Liga = new Liga();
		return Liga;
	}

	
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private ArrayList<PartidaFantasy> partidasfantasy = new ArrayList<PartidaFantasy>();
	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<EquipoFantasy> equiposfantasy = new ArrayList<EquipoFantasy>();
	private int casa;
	private int visita;
	
	public void InsertJugador(String nombre, int numero, Posicion posicion, ArrayList<Estadistica> estadisticas){
		Jugador player = new Jugador(nombre,  numero,posicion,  estadisticas);
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
	public void insertJugadorEnEquipo(int posEquipo,int posJugador){
        equipos.get(posEquipo).InsertJugador(jugadores.get(posJugador));
	}
	
	public void InsertParidaFantasy(int ptsEquipoCasa, int ptsEquipoVisitante, EquipoFantasy equipoCasa, EquipoFantasy equipoVisitante,
			Date fecha){
		PartidaFantasy partyfancy = new PartidaFantasy(ptsEquipoCasa, ptsEquipoVisitante, equipoCasa, equipoVisitante,
				 fecha);
		partidasfantasy.add(partyfancy);
	}
	
	
	
	public void GenerateEquipoFantasy(String name, Jugador player){
		
		for (int i=0; i<equiposfantasy.size(); i++){
			if(equiposfantasy.get(i).getNombre().equals(name)){
				
				equiposfantasy.get(i).getJugadores().add(player);
			}
		}
	
	}
	
	
	public void GeneratePartidaFantasy(String equipoC, String equipoV, Date fecha){
		for (int i=0; i<equiposfantasy.size(); i++){
			if (equiposfantasy.get(i).getNombre().equals(equipoC)){
				casa = i;
				
			}
			
			if (equiposfantasy.get(i).getNombre().equals(equipoV)){
				visita = i;
				
			}
			InsertParidaFantasy(0, 0, equiposfantasy.get(casa), equiposfantasy.get(visita), fecha);
		}
		
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
	
	
	public ArrayList<PartidaFantasy> getPartidasfantasy() {
		return partidasfantasy;
	}
	public void setPartidasfantasy(ArrayList<PartidaFantasy> partidasfantasy) {
		this.partidasfantasy = partidasfantasy;
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
		if(usuarios.get(pos).getContrasena().equals(tryPassword) == true){
			igual = true; 
		}
		return igual; 
	}
	public void addUsuarioV(String email, String contrasena, String username, String nombre){
		Usuario usuario = new Usuario(email, contrasena, username, nombre,Roles.Visitante);
		usuarios.add(usuario);
	}
	public void addUsuario(String email, String contrasena, String username, String nombre, Roles rol){
		Usuario usuario = new Usuario(email, contrasena, username, nombre,rol);
		usuarios.add(usuario);
	}
	public void escribirBinario() throws IOException{
		/* Crea el archivo binario*/
		FileOutputStream outStream = new FileOutputStream("Liga.dat");
		ObjectOutputStream binario = new ObjectOutputStream(outStream);
		binario.writeObject(Liga);
		binario.close();
	}
	
	public void leerBinario() throws IOException, ClassNotFoundException{
		FileInputStream inStream = new FileInputStream("Liga.dat");
		ObjectInputStream binario = new ObjectInputStream(inStream);
		Liga = (Liga)binario.readObject();
		binario.close();
	}
	
	public void imprimirUsuarios(){
		for(Usuario user : usuarios){
			System.out.println(user.getUsername() + "    " + user.getContrasena() + "   " + user.getEmail());
		}
	}
	public void imprimirIp(int pos){
		//TODO getIpAdress
		System.out.println(usuarios.get(pos).getIpAdress());
	}
	

}
	


	
	

