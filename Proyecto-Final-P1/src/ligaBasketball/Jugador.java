package ligaBasketball;

public class Jugador {
	
	private String nombre;
	private int numero;
	private String posicion;
	private int rebotes;
	private int asistencia;
	private int falta;
	
	
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



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	public int getRebotes() {
		return rebotes;
	}



	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}



	public int getAsistencia() {
		return asistencia;
	}



	public void setAsistencia(int asistencia) {
		this.asistencia = asistencia;
	}



	public int getFalta() {
		return falta;
	}



	public void setFalta(int falta) {
		this.falta = falta;
	}



	public Equipo getTeam() {
		return team;
	}



	public void setTeam(Equipo team) {
		this.team = team;
	}



	Equipo team;
	
	
	//puntos, asistencias, falta
}
