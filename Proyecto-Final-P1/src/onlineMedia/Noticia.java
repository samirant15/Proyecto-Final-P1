package onlineMedia;

public class Noticia {
	
	private String titulo;
	private String texto;
	private String fecha;
	private String user;
	private String path;
	
	public Noticia(String titulo, String texto, String user, String fecha, String path) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.fecha = fecha;
		this.user = user;
		this.path = path;
	}
	
	

	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
