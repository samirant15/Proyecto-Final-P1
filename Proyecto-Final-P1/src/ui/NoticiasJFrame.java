package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.ConectorArchivoNoticia;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
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

import clases.Controlador;

import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class NoticiasJFrame extends JFrame {

	private JPanel noticiaPrincipalPanel;
	private JTextField noticiaTituloText;
	private static JFileChooser ourFileSelector = new JFileChooser(); 
	JButton btnEnviarMedia = new JButton("Enviar Media");
	private JInternalFrame medialFrame = new JInternalFrame("Media");
	private String vlcPath="Proyecto-Final-P1/Resources/VLC", mediaPath="";
	ConectorArchivoNoticia client = new ConectorArchivoNoticia();
	String ip = "localhost";
	int port = 8080;

	/**
	 * Create the frame.
	 */
	
	public void GuardarNoticias(String nuevaNoticia, String user, String date, String mediapath){
		try {
			File file = new File("Proyecto-Final-P1/Resources/Noticias.txt");
			File media = new File(mediapath);
			mediapath = "Proyecto-Final-P1/Resources/"+media.getName();
			String txt="";			
			// Si no existe se crea
			if (!file.exists()) {
				file.createNewFile();
			}
			txt=user+"\n"+date+"\n"+mediapath+"\n"+nuevaNoticia;
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("#Start\n");
			bw.write(txt+"\n");
			bw.write("#End");
			nuevaNoticia = "";
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public NoticiasJFrame() {
				
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setTitle("Noticias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 422);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir noticia");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Socket sock = new Socket(ip, port);
					client.Crear(sock);
					if(client.getSock()!=null)
						((CardLayout)noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel, "noticiaNuevaPanel");
					client.getSock().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmActualizar = new JMenuItem("Actualizar");
		mntmActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket sock = new Socket(ip, port);
					client.Crear(sock);
					client.receiveFile("Proyecto-Final-P1/Resources/Noticias.txt");
					client.getSock().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnOpciones.add(mntmActualizar);
		mnOpciones.add(mntmAadir);
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
		
		JButton noticiaNuevaEnviarBtn = new JButton("Enviar Noticia");
		noticiaNuevaEnviarBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaEnviarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Se presiono boton guardar noticia
				if(btnEnviarMedia.isEnabled()==true){
					JOptionPane.showMessageDialog(null, "Primero presione enviar media", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					String nuevaNoticia = "";
					nuevaNoticia += noticiaTituloText.getText()+"\n";
					nuevaNoticia += noticiaNuevaText.getText();
					try{
						GuardarNoticias(nuevaNoticia, "user", Controlador.getInstance().ObtenerFecha(), mediaPath);
						
							Socket sock = new Socket(ip, port);
							client.Crear(sock);
							client.sendFile("Proyecto-Final-P1/Resources/Noticias.txt");
							client.getSock().close();
							dispose();
							//JOptionPane.showMessageDialog(null, "Eto no funciona aun, vayase pa otro lao", "ERROR", JOptionPane.ERROR_MESSAGE);
						    }catch (Exception e){
						  System.err.println("Error: " + e.getMessage());
						  }
					}
		    }
		});
		noticiaNuevaEnviarBtn.setBounds(10, 328, 156, 23);
		noticiaNuevaPanel.add(noticiaNuevaEnviarBtn);
		
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
			
			
			btnEnviarMedia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(mediaPath.equals("")){
						JOptionPane.showMessageDialog(null, "Seleccione una imagen o video", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
						try{
							Socket sock = new Socket(ip, port);
							client.Crear(sock);
							client.sendFile(mediaPath);
							client.getSock().close();
							btnEnviarMedia.setBackground(Color.green);
							btnEnviarMedia.setEnabled(false);
							//JOptionPane.showMessageDialog(null, "Eto no funciona aun, vayase pa otro lao", "ERROR", JOptionPane.ERROR_MESSAGE);
						    }catch (Exception e1){
						  System.err.println("Error: " + e1.getMessage());
						  }
					}
				}
			});
			btnEnviarMedia.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			btnEnviarMedia.setBounds(10, 300, 156, 23);
			noticiaNuevaPanel.add(btnEnviarMedia);

	}
}