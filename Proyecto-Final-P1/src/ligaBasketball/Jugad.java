package ligaBasketball;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Jugad {
	Vector vjugad = new Vector();
	
	public void guardar(JugadorFantasy jugador){
		vjugad.addElement(jugador);
		
	}
	
	public void guardarArchivo(JugadorFantasy jugad){
		try {
			FileWriter fw = new FileWriter("jugador.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print("|"+jugad.getNombre());
			pw.print("|"+jugad.getNumero());
			pw.print("|"+jugad.getPosicion());
			pw.print("|"+jugad.getAnotaciones());
			pw.print("|"+jugad.getAsistencias());
			pw.print("|"+jugad.getRebotes()+"\n");
			pw.close();
			
		
		} catch (IOException g) {
			JOptionPane.showMessageDialog(null, g);
		}
		
	}
	
	public DefaultTableModel listaJugadores() {
		Vector jugadores = new Vector();
		jugadores.addElement("Nombre");
		jugadores.addElement("Numero");
		jugadores.addElement("Posicion");
		jugadores.addElement("Rebotes");
		jugadores.addElement("Asistencias");
		jugadores.addElement("Faltas");
		
		DefaultTableModel mdlTabla1 = new DefaultTableModel();
		
		try{
			FileReader fr = new FileReader("jugador.txt");
			BufferedReader br = new BufferedReader(fr);
			String f;
			while((f=br.readLine())!=null){
				StringTokenizer datos = new StringTokenizer(f, "|");
				Vector y = new Vector();
				while(datos.hasMoreTokens()){
					y.addElement(datos.nextToken());
				}
				mdlTabla1.addRow(y);
			}
		}catch(Exception g){
			JOptionPane.showMessageDialog(null, g);
		}
		return mdlTabla1;
	}
	
	
	
}
