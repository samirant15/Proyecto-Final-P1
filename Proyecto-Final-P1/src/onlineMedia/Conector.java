package onlineMedia;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import ui.ServerFrame;


public class Conector extends Thread{
	private Socket client;
	private ServerSocket server;
	private InputStreamReader inSocket;
	private DataOutputStream outSocket;
	private BufferedReader in;
	final int port = 1234;
	
	public Conector(String nombre){
		super(nombre);
	}
	
	public void enviarMSG(String msg){
		try {
		 	outSocket.writeUTF(msg + "\n");
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
			inSocket = new InputStreamReader(client.getInputStream());
			in = new BufferedReader(inSocket);
			
			//salida de datos
			outSocket = new DataOutputStream(client.getOutputStream());
			
			while(true){
				text = in.readLine();
				ServerFrame.txtAreaServidor.setText(ServerFrame.txtAreaServidor.getText() + "\n" + text);
				System.out.println(in.readLine());
			}
			
		} catch (Exception e) {
			System.out.println("Sucedió un error");
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
