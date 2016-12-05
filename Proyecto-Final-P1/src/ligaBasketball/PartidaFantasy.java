package ligaBasketball;
import java.util.Date;
public class PartidaFantasy {
	
	private int ptsEquipoCasa;
	private int ptsEquipoVisitante;
	private EquipoFantasy equipoCasa;
	private EquipoFantasy equipoVisitante;
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



	public EquipoFantasy getEquipoCasa() {
		return equipoCasa;
	}



	public void setEquipoCasa(EquipoFantasy equipoCasa) {
		this.equipoCasa = equipoCasa;
	}



	public EquipoFantasy getEquipoVisitante() {
		return equipoVisitante;
	}



	public void setEquipoVisitante(EquipoFantasy equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public PartidaFantasy(int ptsEquipoCasa, int ptsEquipoVisitante, EquipoFantasy equipoCasa2, EquipoFantasy equipoVisitante2,
			Date fecha) {
		super();
		this.ptsEquipoCasa = ptsEquipoCasa;
		this.ptsEquipoVisitante = ptsEquipoVisitante;
		this.equipoCasa = equipoCasa2;
		this.equipoVisitante = equipoVisitante2;
		this.fecha = fecha;
	}
	
	
	

}
