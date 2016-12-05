package onlineMedia;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ui.ChatFrame;

public class ConectorCliente extends Thread{
	private Socket client;
	private ServerSocket server;
	private InputStreamReader inSocket;
	private ObjectOutputStream outSocket;
	private ObjectOutputStream in;
	private ObjectInputStream read;
	final int port = 1234;
	ArrayList<Hilo>hilos = new ArrayList<Hilo>();
	
	public ConectorCliente(String IP){
		try {
			client = new Socket(IP, this.port);
			//Creacion de entrada de datos para lectura de mensajes
			//inSocket = new InputStreamReader(client.getInputStream());
			in = new ObjectOutputStream(client.getOutputStream());
			read = new ObjectInputStream(client.getInputStream());
			//Cracion de salida de datos
			//outSocket = new DataOutputStream(client.getOutputStream());
			//outSocket.writeUTF("Conectado -");
		} catch (Exception e){};
	}
	
	public void enviarMSG(Hilo hilo){
		try {
			in.writeObject(hilo);
			System.out.println(hilo.getMensajes());
			client.close();
		} catch (Exception e){};
	}
	
	public ArrayList<Hilo> leerMSG(){
		try {
			if(read.readObject() != null){
				//System.out.println(read.readObject().toString());
				this.hilos = (ArrayList<Hilo>)this.read.readObject();
				//ArrayList<Hilo>hilos = (ArrayList<Hilo>)arrayList;
				client.close();
				return this.hilos;
			}
		} catch (Exception e){
			System.out.println("Hubo un fallo en la lectura de objetos por parte del cliente");
		}
		return null; 
	}
	
	public void run(){
		String text = "text";
		while(true){
			try {
				//text = in.readLine();
				//ChatFrame.messageTextArea.setText(ChatFrame.messageTextArea.getText() + text + "\n");
				//System.out.println(in.readLine());
			} catch (Exception e) {
				System.out.println("Sucedió un error");
			}
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
