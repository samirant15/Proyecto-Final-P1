package onlineMedia;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import ui.ChatFrame;

public class ConectorCliente extends Thread{
	private Socket client;
	private ServerSocket server;
	private InputStreamReader inSocket;
	private DataOutputStream outSocket;
	private BufferedReader in;
	final int port = 1234;
	
	public ConectorCliente(String IP){
		try {
			client = new Socket(IP, this.port);
			//Creacion de entrada de datos para lectura de mensajes
			inSocket = new InputStreamReader(client.getInputStream());
			in = new BufferedReader(inSocket);
			
			//Cracion de salida de datos
			outSocket = new DataOutputStream(client.getOutputStream());
			outSocket.writeUTF("Conectado -");
		} catch (Exception e){};
	}
	
	public void enviarMSG(String msg){
		try {
		 	outSocket.writeUTF(msg);
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
		while(true){
			try {
				text = in.readLine();
				ChatFrame.messageTextArea.setText(ChatFrame.messageTextArea.getText() + text + "\n");
				System.out.println(in.readLine());
			} catch (Exception e) {
				System.out.println("Sucedi� un error");
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