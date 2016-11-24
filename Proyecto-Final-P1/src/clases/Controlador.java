package clases;

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

}
