package onlineMedia;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ui.ServerFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Conector extends Thread{
	private Socket client;
	private ServerSocket server;
	//private InputStreamReader inSocket;
	private DataOutputStream outSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	final int port = 1234;
	private Hilo hilo;
	private Object objeto;
	private ArrayList<Hilo>hilos = new ArrayList<Hilo>();
	
	public Conector(String nombre){
		super(nombre);
	}
	
	public void enviarMSG(String msg){
		try {
		 	//outSocket.writeUTF(msg + "\n");
		 	System.out.println(msg);
		} catch (Exception e){};
	}
	
	public String leerMSG(){
		try {
			in.readLine();
		 	return in.readLine();
		} catch (Exception e){};
		return null; 
	}
	
	public void run(){
		String text = "text";
		try {
			this.server = new ServerSocket(port);
			this.client = server.accept();
					
			//entrada de datos
			//in = new ObjectInputStream(client.getInputStream());
			//in = new ObjectInputStream(inSocket);
			in = new ObjectInputStream(client.getInputStream());
			out = new ObjectOutputStream(client.getOutputStream());
			System.out.println("Se conectó");
			//salida de datos
			//outSocket = new DataOutputStream(client.getOutputStream());
					
			while(true){
				//System.out.println(((Hilo)in.readObject()).getMensajes());
				//objeto = new Hilo();
				objeto = (Object)in.readObject();
				if(objeto instanceof Hilo){
					if(leer() != null){
						this.hilos = (ArrayList<Hilo>)leer();
					}
					hilo = (Hilo)objeto;
					this.hilos.add(hilo);
					escribir(this.hilos);
					ServerFrame.txtAreaServidor.setText(ServerFrame.txtAreaServidor.getText() + "\n" + hilo.getMensajes());
					System.out.println(hilo.getMensajes());
				}
			}	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribir(ArrayList<Hilo> hilos) throws FileNotFoundException, IOException{
		String ruta = "C://Users/Juan Thomas/git/Proyecto-Final-P1/Proyecto-Final-P1";
		File file = new File(ruta, "Hilos.dat");
		if(file.exists()){
			ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(file));
			fileStream.writeObject(hilos);
			fileStream.close();
		} else {
			file.createNewFile();
			ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(file));
			fileStream.writeObject(hilos);
			fileStream.close();
		}
		//ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(ruta));
		
	}
	
	public ArrayList<Hilo> leer() throws FileNotFoundException, IOException, ClassNotFoundException{
		String ruta = "C://Users/Juan Thomas/git/Proyecto-Final-P1/Proyecto-Final-P1/Hilos.dat";
		File archivo = new File(ruta);
		if(archivo.exists()){
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta));
			//@SuppressWarnings("unchecked")
			ArrayList<Hilo>hilos = (ArrayList<Hilo>)file.readObject();
			file.close();
			return hilos;
		}
		return null;
	}
	
	public void enviarHilos() throws FileNotFoundException, ClassNotFoundException, IOException{
		ArrayList<Hilo>hiloOut = new ArrayList<Hilo>();
		hiloOut = leer();
		this.out.writeObject(hiloOut);
		//out = new ObjectOutputStream(client.getOutputStream());
	}
	
	public void desconectar(){
		try {
			client.close();
		} catch (Exception e) {};
		try {
			server.close();
		} catch (Exception e) {};
	}
}
