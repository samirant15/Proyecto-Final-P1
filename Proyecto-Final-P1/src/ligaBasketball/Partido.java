package ligaBasketball;

import java.util.Date;

import ligaBasketball.Equipo;

public class Partido {

	private int ptsEquipoCasa;
	private int ptsEquipoVisitante;
	private Date fecha;
	private Equipo equipoCasa;
	private Equipo equipoVisitante;
	
	public Partido() {
		super();
	}

	public Partido(int ptsEquipoCasa, int ptsEquipoVisitante, Date fecha, Equipo equipoCasa,
			Equipo equipoVisitante) {
		super();
		this.ptsEquipoCasa = ptsEquipoCasa;
		this.ptsEquipoVisitante = ptsEquipoVisitante;
		this.fecha = fecha;
		this.equipoCasa = equipoCasa;
		this.equipoVisitante = equipoVisitante;
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
}
