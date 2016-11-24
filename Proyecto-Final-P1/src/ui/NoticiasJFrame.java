package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class NoticiasJFrame extends JFrame {

	private String nuevaNoticia = "";
	
	private JPanel noticiaPrincipalPanel;
	private JTextField noticiaTituloText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticiasJFrame frame = new NoticiasJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NoticiasJFrame() {
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setTitle("Nueva Noticia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		noticiaPrincipalPanel = new JPanel();
		noticiaPrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(noticiaPrincipalPanel);
		noticiaPrincipalPanel.setLayout(new CardLayout(0, 0));
		
		JPanel noticiaMenuPanel = new JPanel();
		noticiaPrincipalPanel.add(noticiaMenuPanel, "noticiaMenuPanel");
		noticiaMenuPanel.setLayout(null);
		
		JButton noticiaNuevaCrearBtn = new JButton("Nueva noticia");
		noticiaNuevaCrearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel, "noticiaNuevaPanel");
				
			}
		});
		noticiaNuevaCrearBtn.setBounds(10, 110, 140, 70);
		noticiaMenuPanel.add(noticiaNuevaCrearBtn);
		
		JPanel noticiaNuevaPanel = new JPanel();
		noticiaPrincipalPanel.add(noticiaNuevaPanel, "noticiaNuevaPanel");
		noticiaNuevaPanel.setLayout(null);
		
		JTextArea noticiaNuevaText = new JTextArea();
		noticiaNuevaText.setLineWrap(true);
		noticiaNuevaText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaText.setBounds(10, 90, 434, 176);
		noticiaNuevaPanel.add(noticiaNuevaText);
		
		JButton noticiaNuevaGuardarBtn = new JButton("Guardar");
		noticiaNuevaGuardarBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaGuardarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Se presiono boton guardar noticia
				nuevaNoticia += noticiaTituloText.getText()+"\n";
				nuevaNoticia += noticiaNuevaText.getText();
				//-----------------------------------
				try{
					File file = new File("Noticias.txt");
					// Si no existe se crea
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("#\n");
					bw.write(nuevaNoticia);
					nuevaNoticia = "";
					bw.newLine();
					bw.close();
					    }catch (Exception e){
					  System.err.println("Error: " + e.getMessage());
					  }
		    }
				//-----------------------------------
		});
		noticiaNuevaGuardarBtn.setBounds(334, 277, 110, 23);
		noticiaNuevaPanel.add(noticiaNuevaGuardarBtn);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblTtulo.setBounds(10, 11, 61, 23);
		noticiaNuevaPanel.add(lblTtulo);
		
		noticiaTituloText = new JTextField();
		noticiaTituloText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaTituloText.setBounds(77, 11, 337, 23);
		noticiaNuevaPanel.add(noticiaTituloText);
		noticiaTituloText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cuerpo:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 56, 95, 23);
		noticiaNuevaPanel.add(lblNewLabel);
	}
}
