package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import onlineMedia.Noticia;
import ui.MainJFrame;
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
	
	private static ArrayList<Noticia> noticias = new ArrayList<>(); 
	
	public static void main(String[] args) {
		MainJFrame frame = new MainJFrame();
		frame.setVisible(true);
		leerNoticias(noticias); //lee las noticias cuando abre el programa
	}
	
	
	//leer noticias (luilli y samir)
	public static void leerNoticias(ArrayList<Noticia> noticias){
		try {
			File file = new File("Noticias.txt");
			String txtAux="", txt="", titulo = null, user="", date="", path="";
			// Si no existe se crea
			if (!file.exists()) {
				file.createNewFile();
			}
			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);
			while(txtAux!=null){
				txtAux=br.readLine();
				if(txtAux==null)	break;
				switch(txtAux){
				case "#Start":
					txtAux=br.readLine();//Usuario
					user = txtAux;
					txtAux=br.readLine();//Fecha
					date = txtAux;
					txtAux=br.readLine();//Path
					path = txtAux;
					txtAux=br.readLine();//Titulo
					titulo = txtAux;
					break;
				case "#End":
					Noticia n = new Noticia(titulo, txt, user, date, path);//guardar
					noticias.add(n);
					txt="";
					break;
				default:
					txt+=txtAux+"\n";//texto
					break;
				}				
			}
			br.close();
		} catch (Exception e) {
			
		}
		/*for (Noticia n : noticias) {
			System.out.print("**Titulo: "+n.getTitulo()+"\n");
			System.out.print("**Usuario: "+n.getUser()+"\n");
			System.out.print("**Fecha: "+n.getFecha()+"\n");
			System.out.print("**Path: "+n.getPath()+"\n");
			System.out.print(n.getTexto()+"\n");
		}*///**no me borren eto**
	}
}