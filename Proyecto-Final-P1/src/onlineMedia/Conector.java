package onlineMedia;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector {
	private Socket client;
	private ServerSocket server;
	private InputStreamReader inSocket;
	private DataOutputStream outSocket;
	private BufferedReader in;
	final int port = 1128;
	
	public Conector(){
		try{
			server = new ServerSocket(port);
			client = server.accept();
			//entrada de datos
			inSocket = new InputStreamReader(client.getInputStream());
			in = new BufferedReader(inSocket);
			
			//salida de datos
			outSocket = new DataOutputStream(client.getOutputStream());
		} catch (Exception e){};
	}
	
	public Conector(String IP){
		try {
			client = new Socket(IP, this.port);
			//Creacion de entrada de datos para lectura de mensajes
			inSocket = new InputStreamReader(client.getInputStream());
			in = new BufferedReader(inSocket);
			
			//Cracion de salida de datos
			outSocket = new DataOutputStream(client.getOutputStream());
		} catch (Exception e){};
	}
	
	public void enviarMSG(String msg){
		try {
		 	outSocket.writeUTF(msg);
		} catch (Exception e){};
	}
	
	public String leerMSG(){
		try {
			return in.readLine();
		} catch (Exception e){};
		return null; 
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
