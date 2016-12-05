package onlineMedia;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class ConectorArchivoNoticia {
	private static Socket sock;
	private static String fileName;
    private static BufferedReader stdin;
    private static PrintStream os;
    
    public static Socket getSock() {
		return sock;
	}
    
    public void Crear(Socket sock) throws IOException {
        try {
        	this.sock = sock;
        	System.out.println("Cliente de noticias iniciado!.");
            stdin = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Usted no esta conectado al servidor de noticias"
					+ "\nVuelva a Intentelo mas tarde", "ERROR", JOptionPane.ERROR_MESSAGE);
            //System.exit(1);
        }
    }



    public static void sendFile(String fileName) {
    	try {
        	os = new PrintStream(sock.getOutputStream());
            os.println("Send");
            File myFile = new File(fileName);
            os.println("Proyecto-Final-P1/Resources/"+myFile.getName());
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            //bis.read(mybytearray, 0, mybytearray.length);

            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);

            OutputStream os = sock.getOutputStream();

            //Sending file name and file size to the server
            DataOutputStream dos = new DataOutputStream(os);
            //dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            System.out.println("File "+fileName+" sent to Server.");
            //dis.close();
        } catch (Exception e) {
            System.err.println("File does not exist!");
        }
    }

    public static void receiveFile(String fileName) {
        try {
        	os = new PrintStream(sock.getOutputStream());
            os.println("Recive");
            os.println(fileName);
            int bytesRead;
            InputStream in = sock.getInputStream();

            DataInputStream clientData = new DataInputStream(in);

            fileName = clientData.readUTF();
            OutputStream output = new FileOutputStream(("Proyecto-Final-P1/Resources/"+fileName));
            long size = clientData.readLong();
            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            clientData.close();
            in.close();

            System.out.println("Las noticias han sido actualizadas desde el servidor, Recibido: " + fileName);
            JOptionPane.showMessageDialog(null, "Las noticias han sido actualizadas desde el servidor", "Actualizar noticias", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ConectorClienteNoticia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}