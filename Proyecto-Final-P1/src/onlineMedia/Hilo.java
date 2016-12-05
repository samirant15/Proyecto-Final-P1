package onlineMedia;

import java.io.Serializable;
import java.util.ArrayList;

public class Hilo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3452829115504000549L;
	/**
	 * 
	 */
	private String Titulo;
	private Usuario usuario = null;
	private String mensajes;
	private ArrayList<String>Comentarios = new ArrayList<String>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public void addComentario(String comentario){
		Comentarios.add(comentario);
	}
	
	public ArrayList<String> getComentarios(){
		return Comentarios;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getMensajes() {
		return mensajes;
	}
	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
