package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.MediaPlayer;

import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class NoticiasJFrame extends JFrame {

	private String nuevaNoticia = "";
	
	private JPanel noticiaPrincipalPanel;
	private JTextField noticiaTituloText;
	private static JFileChooser ourFileSelector = new JFileChooser(); 
	private JInternalFrame medialFrame = new JInternalFrame("Media");
	private String vlcPath="C:/Program Files/VideoLAN/VLC", mediaPath="";

	/**
	 * Create the frame.
	 */
	public NoticiasJFrame() {
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setTitle("Noticias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 422);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir noticia");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel, "noticiaNuevaPanel");
			}
		});
		mnOpciones.add(mntmAadir);
		
		JMenuItem mntmVLCPath = new JMenuItem("Ruta VLC");
		mntmVLCPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File ourFile;
				ourFileSelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				ourFileSelector.showSaveDialog(null);
				ourFile = ourFileSelector.getSelectedFile();
				vlcPath = ourFile.getAbsolutePath();
			}
		});
		mnOpciones.add(mntmVLCPath);
		noticiaPrincipalPanel = new JPanel();
		noticiaPrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(noticiaPrincipalPanel);
		noticiaPrincipalPanel.setLayout(new CardLayout(0, 0));
		
		JPanel noticiaMenuPanel = new JPanel();
		noticiaPrincipalPanel.add(noticiaMenuPanel, "noticiaMenuPanel");
		noticiaMenuPanel.setLayout(null);
		
		
		JPanel noticiaNuevaPanel = new JPanel();
		noticiaPrincipalPanel.add(noticiaNuevaPanel, "noticiaNuevaPanel");
		noticiaNuevaPanel.setLayout(null);
		
		JTextArea noticiaNuevaText = new JTextArea();
		noticiaNuevaText.setLineWrap(true);
		noticiaNuevaText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaText.setBounds(10, 90, 365, 176);
		noticiaNuevaPanel.add(noticiaNuevaText);
		
		JButton noticiaNuevaGuardarBtn = new JButton("Guardar");
		noticiaNuevaGuardarBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaGuardarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Se presiono boton guardar noticia
				if(mediaPath.equals("")){
					JOptionPane.showMessageDialog(null, "Seleccione una imagen o video", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					nuevaNoticia += noticiaTituloText.getText()+"\n";
					nuevaNoticia += noticiaNuevaText.getText();
					try{
						File file = new File("Noticias.txt");
						Date d = new Date();
						String date = "", user="user";
						boolean pm = true;
	
						if(d.getHours()<12) {pm=false; date += d.getHours();} else date += d.getHours()-12;
						if(d.getMinutes()>9) date += ":"+d.getMinutes(); else date += ":0"+d.getMinutes();
						if(pm == false) date+=", AM "; else date+=" PM, ";
						date+= d.getDate() +"/"+ (d.getMonth()+1) +"/"+ (d.getYear()-100);
						
						// Si no existe se crea
						if (!file.exists()) {
							file.createNewFile();
						}
						FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write("#Start\n");
						bw.write(user+"\n");
						bw.write(date+"\n");
						bw.write(mediaPath+"\n");
						bw.write(nuevaNoticia+"\n");
						bw.write("#End");
						nuevaNoticia = "";
						bw.newLine();
						bw.close();
						    }catch (Exception e){
						  System.err.println("Error: " + e.getMessage());
						  }
					}
		    }
		});
		noticiaNuevaGuardarBtn.setBounds(10, 318, 110, 23);
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
		
		JButton btnImagenvideo = new JButton("Imagen/Video");
		btnImagenvideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File ourFile;
				ourFileSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ourFileSelector.showSaveDialog(null);
				ourFile = ourFileSelector.getSelectedFile();
				mediaPath = ourFile.getAbsolutePath();
				new MediaPlayer(medialFrame, vlcPath, mediaPath).run();
			}
		});
		btnImagenvideo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnImagenvideo.setBounds(405, 276, 156, 23);
		noticiaNuevaPanel.add(btnImagenvideo);
		
		JPanel panel = new JPanel();
		panel.setBounds(385, 90, 187, 176);
		noticiaNuevaPanel.add(panel);
		panel.setLayout(null);
		medialFrame.setBounds(0, 5, 140, 171);
		panel.add(medialFrame);
		medialFrame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		medialFrame.setVisible(true);
		try {
			medialFrame.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
}