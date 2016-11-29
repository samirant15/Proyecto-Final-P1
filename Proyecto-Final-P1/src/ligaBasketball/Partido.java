package ligaBasketball;

public class Partido {

	private int ptsEquipoCasa;
	private int ptsEquipoVisitante;
	private int dia;
	private int mes;
	private int anio;
	private Equipo equipoCasa;
	private Equipo equipoVisitante;
	
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
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
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


	
	

	public Partido(int ptsEquipoCasa, int ptsEquipoVisitante, int dia, int mes, int anio, Equipo equipoCasa,
			Equipo equipoVisitante) {
		super();
		this.ptsEquipoCasa = ptsEquipoCasa;
		this.ptsEquipoVisitante = ptsEquipoVisitante;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.equipoCasa = equipoCasa;
		this.equipoVisitante = equipoVisitante;
	}

	
	
	
	
	
}

