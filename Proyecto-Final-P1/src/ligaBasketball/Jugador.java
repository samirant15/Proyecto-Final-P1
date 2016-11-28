package ligaBasketball;
import java.util.List;
import enums.Posicion;
public class Jugador {
	
	private String nombre;
	private int numero;
	private String posicion;
	private int rebotes;
	private int asistencia;
	private int falta;
	
	Equipo team;
	
	private List<Posicion> position;
	
	public Jugador(String nombre, int numero, String posicion, int rebotes, int asistencia, int falta, Equipo team,
			List<Posicion> position) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.posicion = posicion;
		this.rebotes = rebotes;
		this.asistencia = asistencia;
		this.falta = falta;
		this.team = team;
		this.position = position;
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



	public List<Posicion> getPosition() {
		return position;
	}


	public void setPosition(List<Posicion> position) {
		this.position = position;
	}

	
	
	//puntos, asistencias, falta
}
