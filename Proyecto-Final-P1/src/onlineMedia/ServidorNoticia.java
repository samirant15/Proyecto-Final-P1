package onlineMedia;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNoticia  implements Runnable {
	private static ServerSocket serverSocket;
    private static Socket clientSocket = null;
    
    public ServidorNoticia() {
        
    }
    
    public void run() {

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.err.println("Port already in use.");
            System.exit(1);
        }

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);

                Thread t = new Thread(new ConectorClienteNoticia(clientSocket));

                t.start();

            } catch (Exception e) {
                System.err.println("Error in connection attempt.");
            }
        }
    }
}