package onlineMedia;

import java.io.Serializable;
import java.util.ArrayList;

public class Hilo implements Serializable {
	
	private Usuario usuario = new Usuario();
	private String mensajes;
	private ArrayList<String>Comentarios = new ArrayList<String>();
	
	public Usuario getUsuario() {
		return usuario;
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
