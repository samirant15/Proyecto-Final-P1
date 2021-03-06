package onlineMedia;

import java.io.Serializable;

import enums.Roles;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -8404687263484925113L;
	private String equipo;
	private String email;
	private String contrasena;
	private String username; 
	private String Nombre; 
	private Roles rol ; 
	private String ipAdress; 
	
	public Usuario(){}
	
	public Usuario(String email, String contrasena, String username, String nombre, Roles rol) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.username = username;
		Nombre = nombre;
		this.rol = rol;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	
}
