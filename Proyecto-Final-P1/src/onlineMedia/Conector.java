package onlineMedia;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ui.ServerFrame;


public class Conector extends Thread{
	private Socket client;
	private ServerSocket server;
	//private InputStreamReader inSocket;
	private DataOutputStream outSocket;
	private ObjectInputStream in;
	final int port = 1234;
	private Hilo hilo;
	private Object objeto;
	
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
			System.out.println("Se conectó");
			//salida de datos
			//outSocket = new DataOutputStream(client.getOutputStream());
					
			while(true){
				//System.out.println(((Hilo)in.readObject()).getMensajes());
				//objeto = new Hilo();
				objeto = (Object)in.readObject();
				if(objeto instanceof Hilo){
					hilo = (Hilo)objeto;
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
	
	public void desconectar(){
		try {
			client.close();
		} catch (Exception e) {};
		try {
			server.close();
		} catch (Exception e) {};
	}
}
