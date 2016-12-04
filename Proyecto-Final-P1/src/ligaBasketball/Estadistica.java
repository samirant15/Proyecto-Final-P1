package ligaBasketball;

public class Estadistica {

	private int anotaciones;
	private int asistencias;
	private int rebotes;
	
	public Estadistica() {
		super();
	}

	public Estadistica(int anotaciones, int asistencias, int rebotes) {
		super();
		this.anotaciones = anotaciones;
		this.asistencias = asistencias;
		this.rebotes = rebotes;
	}

	public int getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(int anotaciones) {
		this.anotaciones = anotaciones;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}	
}
