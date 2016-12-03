package ligaBasketball;
import java.util.Date;
public class PartidaFantasy {
	
	private int ptsEquipoCasa;
	private int ptsEquipoVisitante;
	private Equipo equipoCasa;
	private Equipo equipoVisitante;
	Date fecha = new Date();
	
	
	
	public int getPtsEquipoCasa() {
		return ptsEquipoCasa;
	}



	public void setPtsEquipoCasa(int ptsEquipoCasa) {
		this.ptsEquipoCasa = ptsEquipoCasa;
	}



	public int getPtsEquipoVisitante() {
		return ptsEquipoVisitante;
	}



	public void setPtsEquipoVisitante(int ptsEquipoVisitante) {
		this.ptsEquipoVisitante = ptsEquipoVisitante;
	}



	public Equipo getEquipoCasa() {
		return equipoCasa;
	}



	public void setEquipoCasa(Equipo equipoCasa) {
		this.equipoCasa = equipoCasa;
	}



	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}



	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public PartidaFantasy(int ptsEquipoCasa, int ptsEquipoVisitante, Equipo equipoCasa, Equipo equipoVisitante,
			Date fecha) {
		super();
		this.ptsEquipoCasa = ptsEquipoCasa;
		this.ptsEquipoVisitante = ptsEquipoVisitante;
		this.equipoCasa = equipoCasa;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
	}
	
	
	

}
