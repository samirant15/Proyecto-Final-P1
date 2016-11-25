package clases;

import java.util.ArrayList;

import ui.NoticiasJFrame;

//Clase controladora del programa

public class Controlador {

	//********   SINGLETON  **************************
	private static Controlador controlador = null;
	
	private Controlador(){};
	
	public static Controlador getInstance(){
		if(controlador == null){
			controlador = new Controlador();
		}
		return controlador;
	}
	
	//************************************************
	
	private ArrayList<Noticia> noticias = new ArrayList<>(); 
	
	public static void main(String[] args) {
		//Crea un JFrame de las noticias(solo para probar, pueden quitarlo)
		NoticiasJFrame frame = new NoticiasJFrame();
		frame.setVisible(true);
	}
	
}
