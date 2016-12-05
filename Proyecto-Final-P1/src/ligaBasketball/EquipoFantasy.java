package ligaBasketball;
import java.util.ArrayList;
public class EquipoFantasy {

	private String nombre;
	private int partidosGanados;
	private int partidasPerdidas;
	private ArrayList<JugadorFantasy> jugadoresfantasy = new ArrayList<JugadorFantasy>();
	
	
	
	public EquipoFantasy(String nombre, int partidosGanados, int partidasPerdidas,
			ArrayList<JugadorFantasy> jugadoresfantasy) {
		super();
		this.nombre = nombre;
		this.partidosGanados = partidosGanados;
		this.partidasPerdidas = partidasPerdidas;
		this.jugadoresfantasy = jugadoresfantasy;
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
	public ArrayList<JugadorFantasy> getJugadoresfantasy() {
		return jugadoresfantasy;
	}
	public void setJugadoresfantasy(ArrayList<JugadorFantasy> jugadoresfantasy) {
		this.jugadoresfantasy = jugadoresfantasy;
	}
	
	
	

}
