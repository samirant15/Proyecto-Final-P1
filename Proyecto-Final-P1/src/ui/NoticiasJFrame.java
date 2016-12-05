package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.ConectorArchivoNoticia;
import onlineMedia.MediaPlayer;
import onlineMedia.Noticia;

import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JInternalFrame;
import java.awt.Color;
import clases.Controlador;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class NoticiasJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel noticiaPrincipalPanel;
	private JTextField noticiaTituloText;
	@SuppressWarnings("unused")
	private JPanel PlaylistRun;
	private JTextField TituloPlay;
	private static JFileChooser ourFileSelector = new JFileChooser();
	JButton btnEnviarMedia = new JButton("Enviar Media");
	private JInternalFrame medialFrame = new JInternalFrame("Media");
	private String vlcPath = "Proyecto-Final-P1/Resources/VLC", mediaPath = "";
	ConectorArchivoNoticia client = new ConectorArchivoNoticia();
	String ip = "localhost";
	int port = 8080;
	int pagina = 0;
	int n = 0;
	int pos = 0;
	JInternalFrame imagenPlayList = new JInternalFrame("New JInternalFrame");
	MediaPlayer imagenPlayer;
	JTextArea Parrafo1 = new JTextArea();
	JTextArea Parrafo2 = new JTextArea();
	JTextArea Parrafo3 = new JTextArea();
	JTextArea ParrafoPlay = new JTextArea();
	ArrayList<Integer> al = new ArrayList<Integer>();

	/**
	 * Create the frame.
	 */

	public void GuardarNoticias(String nuevaNoticia, String user, String date, String mediapath) {
		try {
			File file = new File("Proyecto-Final-P1/Resources/Noticias.txt");
			File media = new File(mediapath);
			mediapath = "Proyecto-Final-P1/Resources/" + media.getName();
			String txt = "";
			// Si no existe se crea
			if (!file.exists()) {
				file.createNewFile();
			}
			txt = user + "\n" + date + "\n" + mediapath + "\n" + nuevaNoticia;
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("#Start\n");
			bw.write(txt + "\n");
			bw.write("#End");
			nuevaNoticia = "";
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public NoticiasJFrame() throws PropertyVetoException {

		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setTitle("Noticias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 422);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setForeground(Color.WHITE);
		menuBar.add(mnOpciones);

		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir noticia");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Socket sock = new Socket(ip, port);
					client.Crear(sock);
					if (ConectorArchivoNoticia.getSock() != null)
						((CardLayout) noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel,
								"noticiaNuevaPanel");
					ConectorArchivoNoticia.getSock().close();
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
					ConectorArchivoNoticia.receiveFile("Proyecto-Final-P1/Resources/Noticias.txt");
					Controlador.getInstance();
					Controlador.leerNoticias();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnOpciones.add(mntmActualizar);
		mnOpciones.add(mntmAadir);

		JMenuItem mntmNoticias = new JMenuItem("Noticias");
		mntmNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel, "listanoticias");
			}
		});

		mnOpciones.add(mntmNoticias);

		JMenuItem mntmPlaylist = new JMenuItem("Playlist");
		mntmPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) noticiaPrincipalPanel.getLayout()).show(noticiaPrincipalPanel, "PlaylistRun");
			}
		});
		mnOpciones.add(mntmPlaylist);
		noticiaPrincipalPanel = new JPanel();
		noticiaPrincipalPanel.setBackground(Color.BLACK);
		noticiaPrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(noticiaPrincipalPanel);
		noticiaPrincipalPanel.setLayout(new CardLayout(0, 0));

		JPanel ListaNoticias = new JPanel();
		ListaNoticias.setBackground(Color.DARK_GRAY);
		ListaNoticias.setLayout(null);
		noticiaPrincipalPanel.add(ListaNoticias, "listanoticias");
		Controlador.getInstance();
		Controlador.leerNoticias();

		JLabel Titulo1 = new JLabel("Titulo");
		Controlador.getInstance();
		Titulo1.setText(Controlador.getNoticias().get(pagina).getTitulo());
		Titulo1.setBounds(60, 13, 142, 14);
		ListaNoticias.add(Titulo1);
		Titulo1.setForeground(Color.WHITE);
		Titulo1.setBackground(Color.DARK_GRAY);

		JLabel Titulo2 = new JLabel("Titulo");
		Controlador.getInstance();
		Titulo2.setText(Controlador.getNoticias().get(pagina + 1).getTitulo());
		Titulo2.setForeground(Color.WHITE);
		Titulo2.setBackground(Color.DARK_GRAY);
		Titulo2.setBounds(60, 132, 142, 14);
		ListaNoticias.add(Titulo2);

		JLabel Titulo3 = new JLabel("Titulo");
		Controlador.getInstance();
		Titulo3.setText(Controlador.getNoticias().get(pagina + 2).getTitulo());
		Titulo3.setBackground(Color.DARK_GRAY);
		Titulo3.setForeground(Color.WHITE);
		Titulo3.setBounds(60, 245, 115, 14);
		ListaNoticias.add(Titulo3);
		Controlador.getInstance();
		Controlador.getInstance();

		Controlador.getInstance();

		JLabel Fecha1 = new JLabel("New label");
		Fecha1.setForeground(Color.WHITE);
		Controlador.getInstance();
		Fecha1.setText(Controlador.getNoticias().get(pagina).getFecha());
		Fecha1.setBounds(238, 13, 115, 14);
		ListaNoticias.add(Fecha1);

		JLabel Fecha2 = new JLabel("New label");
		Fecha2.setForeground(Color.WHITE);
		Controlador.getInstance();
		Fecha2.setText(Controlador.getNoticias().get(pagina + 1).getFecha());
		Fecha2.setBounds(238, 129, 115, 14);
		ListaNoticias.add(Fecha2);

		JLabel Fecha3 = new JLabel("New label");
		Fecha3.setForeground(Color.WHITE);
		Controlador.getInstance();
		Fecha3.setText(Controlador.getNoticias().get(pagina + 2).getFecha());
		Fecha3.setBounds(238, 245, 117, 14);
		ListaNoticias.add(Fecha3);

		JPanel noticiaNuevaPanel = new JPanel();
		noticiaNuevaPanel.setForeground(Color.GRAY);
		noticiaPrincipalPanel.add(noticiaNuevaPanel, "noticiaNuevaPanel");
		noticiaNuevaPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 365, 176);
		noticiaNuevaPanel.add(scrollPane);

		JTextArea noticiaNuevaText = new JTextArea();
		scrollPane.setViewportView(noticiaNuevaText);
		noticiaNuevaText.setLineWrap(true);
		noticiaNuevaText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		JButton noticiaNuevaEnviarBtn = new JButton("Enviar Noticia");
		noticiaNuevaEnviarBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		noticiaNuevaEnviarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Se presiono boton
															// guardar noticia
				if (btnEnviarMedia.isEnabled() == true) {
					JOptionPane.showMessageDialog(null, "Primero presione enviar media", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String nuevaNoticia = "";
					nuevaNoticia += noticiaTituloText.getText() + "\n";
					nuevaNoticia += noticiaNuevaText.getText();
					try {
						GuardarNoticias(nuevaNoticia, "user", Controlador.getInstance().ObtenerFecha(), mediaPath);

						Socket sock = new Socket(ip, port);
						client.Crear(sock);
						ConectorArchivoNoticia.sendFile("Proyecto-Final-P1/Resources/Noticias.txt");
						dispose();
						// JOptionPane.showMessageDialog(null, "Eto no funciona
						// aun, vayase pa otro lao", "ERROR",
						// JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
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
		medialFrame.setBounds(0, -28, 187, 204);
		panel.add(medialFrame);
		medialFrame.setBorder(new EmptyBorder(0, 0, 0, 0));
		medialFrame.setVisible(true);
		btnEnviarMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (mediaPath.equals("")) {
					JOptionPane.showMessageDialog(null, "Seleccione una imagen o video", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Socket sock = new Socket(ip, port);
						client.Crear(sock);
						ConectorArchivoNoticia.sendFile(mediaPath);
						btnEnviarMedia.setBackground(Color.green);
						btnEnviarMedia.setEnabled(false);
						// JOptionPane.showMessageDialog(null, "Eto no funciona
						// aun, vayase pa otro lao", "ERROR",
						// JOptionPane.ERROR_MESSAGE);
					} catch (Exception e1) {
						System.err.println("Error: " + e1.getMessage());
					}
				}
			}
		});
		btnEnviarMedia.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnEnviarMedia.setBounds(10, 300, 156, 23);
		noticiaNuevaPanel.add(btnEnviarMedia);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pagina += 1;
				Controlador.getInstance();
				if (Controlador.getNoticias().size() < pagina) {
					pagina = 0;
				} else {
					Controlador.getInstance();
					Parrafo1.setText(Controlador.getNoticias().get(pagina).getTexto());
					Controlador.getInstance();
					Titulo1.setText(Controlador.getNoticias().get(pagina).getTitulo());
					Controlador.getInstance();
					Fecha1.setText(Controlador.getNoticias().get(pagina).getFecha());
					Controlador.getInstance();
					Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
					Controlador.getInstance();
					Titulo2.setText(Controlador.getNoticias().get(pagina + 1).getTitulo());
					Controlador.getInstance();
					Fecha2.setText(Controlador.getNoticias().get(pagina + 1).getFecha());
					Controlador.getInstance();
					Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
					Controlador.getInstance();
					Titulo3.setText(Controlador.getNoticias().get(pagina + 2).getTitulo());
					Controlador.getInstance();
					Fecha3.setText(Controlador.getNoticias().get(pagina + 2).getFecha());
				}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_1rsz_rsz_next.png"));
		btnNewButton.setBounds(10, 311, 40, 40);
		ListaNoticias.add(btnNewButton);
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagina -= 1;
				Controlador.getInstance();
				if (0 > pagina) {
					pagina = Controlador.getNoticias().size() - 3;
				} else {
					Controlador.getInstance();
					Parrafo1.setText(Controlador.getNoticias().get(pagina).getTexto());
					Controlador.getInstance();
					Titulo1.setText(Controlador.getNoticias().get(pagina).getTitulo());
					Controlador.getInstance();
					Fecha1.setText(Controlador.getNoticias().get(pagina).getFecha());
					Controlador.getInstance();
					Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
					Controlador.getInstance();
					Titulo2.setText(Controlador.getNoticias().get(pagina + 1).getTitulo());
					Controlador.getInstance();
					Fecha2.setText(Controlador.getNoticias().get(pagina + 1).getFecha());
					Controlador.getInstance();
					Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
					Controlador.getInstance();
					Titulo3.setText(Controlador.getNoticias().get(pagina + 2).getTitulo());
					Controlador.getInstance();
					Fecha3.setText(Controlador.getNoticias().get(pagina + 2).getFecha());
				}
			}
		});
		button.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_rsz_next.png"));
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(10, 13, 40, 40);
		ListaNoticias.add(button);

		JButton btnNewButton_1 = new JButton("A\u00F1adir a la lista");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.add(pagina);

			}
		});
		btnNewButton_1.setBounds(430, 51, 116, 50);
		ListaNoticias.add(btnNewButton_1);

		JButton btnAadirALa = new JButton("A\u00F1adir a la lista");
		btnAadirALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.add(pagina + 1);
			}
		});
		btnAadirALa.setBounds(430, 165, 116, 50);
		ListaNoticias.add(btnAadirALa);

		JButton btnAadirALa_1 = new JButton("A\u00F1adir a la lista");
		btnAadirALa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.add(pagina + 2);
			}
		});
		btnAadirALa_1.setBounds(430, 284, 116, 50);
		ListaNoticias.add(btnAadirALa_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 51, 297, 70);
		ListaNoticias.add(scrollPane_2);
		scrollPane_2.setViewportView(Parrafo1);
		Parrafo1.setLineWrap(true);
		Parrafo1.setEditable(false);
		Parrafo1.setText(Controlador.getNoticias().get(pagina).getTexto());
		
		
		Parrafo2.setText((String) null);
		Parrafo2.setLineWrap(true);
		Parrafo2.setEditable(false);
		Parrafo2.setBounds(60, 157, 295, 68);
		ListaNoticias.add(Parrafo2);
		Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
		
		
		Parrafo3.setText((String) null);
		Parrafo3.setLineWrap(true);
		Parrafo3.setEditable(false);
		Parrafo3.setBounds(58, 270, 295, 68);
		ListaNoticias.add(Parrafo3);
		Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
		JPanel PlaylistRun = new JPanel();
		PlaylistRun.setForeground(Color.GRAY);
		noticiaPrincipalPanel.add(PlaylistRun, "PlaylistRun");
		PlaylistRun.setLayout(null);
		TituloPlay = new JTextField();
		Controlador.getInstance();
		
				JButton EmpezarBoton = new JButton("Empezar a ver la lista");
				EmpezarBoton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ParrafoPlay.setText(Controlador.getNoticias().get(al.get(pos)).getTexto());
						if(new File(Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\")).exists())
							imagenPlayer = new MediaPlayer(imagenPlayList, vlcPath, Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\"));
						else
							imagenPlayer = new MediaPlayer(imagenPlayList, vlcPath, "Proyecto-Final-P1\\Resources\\warning.png");
						imagenPlayer.run();
						EmpezarBoton.setVisible(false);
					}
				});
				EmpezarBoton.setFont(new Font("Tahoma", Font.PLAIN, 50));
				EmpezarBoton.setBounds(0, 0, 592, 362);
				PlaylistRun.add(EmpezarBoton);
		TituloPlay.setText(Controlador.getNoticias().get(pagina).getTitulo());
		TituloPlay.setBounds(116, 22, 363, 23);
		TituloPlay.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		PlaylistRun.add(TituloPlay);
		TituloPlay.setColumns(10);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 324, 46, 14);
		PlaylistRun.add(lblAutor);

		JLabel autor = new JLabel("");
		Controlador.getInstance();
		autor.setText(Controlador.getNoticias().get(pagina).getUser());
		autor.setBounds(66, 324, 128, 14);
		PlaylistRun.add(autor);

		JLabel lel = new JLabel("Publicado");
		lel.setBounds(204, 324, 56, 14);
		PlaylistRun.add(lel);

		JLabel publicacion = new JLabel("");
		publicacion.setText(Controlador.getNoticias().get(pagina).getFecha());
		publicacion.setBounds(270, 324, 103, 14);
		PlaylistRun.add(publicacion);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(383, 90, 199, 223);
		PlaylistRun.add(panel_4);
		panel_4.setLayout(null);

		imagenPlayList.setBorder(new EmptyBorder(0, 0, 0, 0));
		imagenPlayList.setBounds(0, -29, 199, 252);
		panel_4.add(imagenPlayList);
		imagenPlayList.setVisible(true);

		JButton delante = new JButton("");
		delante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pos += 1;
				if (al.size() - 1 < pos)
					pos = 0;
				Controlador.getInstance();
				ParrafoPlay.setText(Controlador.getNoticias().get(al.get(pos)).getTexto());
				Controlador.getInstance();
				TituloPlay.setText(Controlador.getNoticias().get(al.get(pos)).getTitulo());
				Controlador.getInstance();
				Fecha1.setText(Controlador.getNoticias().get(al.get(pos)).getFecha());
				Controlador.getInstance();
				autor.setText(Controlador.getNoticias().get(al.get(pos)).getUser());
				Controlador.getInstance();
				publicacion.setText(Controlador.getNoticias().get(al.get(pos)).getFecha());
				Controlador.getInstance();
				if(new File(Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\")).exists())
					imagenPlayer.changeMedia(Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\"));
				else
					imagenPlayer.changeMedia("Proyecto-Final-P1\\Resources\\warning.png");

			}
		});
		delante.setIcon(
				new ImageIcon("C:\\Users\\Luilli\\git\\Proyecto-Final-P1\\Proyecto-Final-P1\\Resources\\rsz_next.png"));
		delante.setBounds(489, 11, 40, 40);
		PlaylistRun.add(delante);

		JButton atras = new JButton("");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos -= 1;
				if (0 > pos)
					pos = al.size() - 1;

				Controlador.getInstance();
				ParrafoPlay.setText(Controlador.getNoticias().get(al.get(pos)).getTexto());
				Controlador.getInstance();
				TituloPlay.setText(Controlador.getNoticias().get(al.get(pos)).getTitulo());
				Controlador.getInstance();
				Fecha1.setText(Controlador.getNoticias().get(al.get(pos)).getFecha());
				Controlador.getInstance();
				autor.setText(Controlador.getNoticias().get(al.get(pos)).getUser());
				Controlador.getInstance();
				publicacion.setText(Controlador.getNoticias().get(al.get(pos)).getFecha());
				Controlador.getInstance();
				if(new File(Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\")).exists())
					imagenPlayer.changeMedia(Controlador.getNoticias().get(al.get(pos)).getPath().replaceAll("/", "\\\\"));
				else
					imagenPlayer.changeMedia("Proyecto-Final-P1\\Resources\\warning.png");
			}

		});
		atras.setIcon(new ImageIcon(
				"C:\\Users\\Luilli\\git\\Proyecto-Final-P1\\Proyecto-Final-P1\\Resources\\rsz_1rsz_next.png"));
		atras.setBounds(66, 11, 40, 40);
		PlaylistRun.add(atras);
		Controlador.getInstance();
				
				JButton btnDescargarMedia = new JButton("Descargar Media");
				btnDescargarMedia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
								File f = new File(Controlador.getNoticias().get(al.get(pos)).getPath());
								if (!f.exists()) {
									Socket sock = new Socket(ip, port);
									client.Crear(sock);
									ConectorArchivoNoticia.receiveFile(Controlador.getNoticias().get(al.get(pos)).getPath());
								}else{
									JOptionPane.showMessageDialog(null, "Usted ya tiene este archivo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
								}
							
							ConectorArchivoNoticia.getSock().close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				btnDescargarMedia.setBounds(432, 320, 113, 23);
				PlaylistRun.add(btnDescargarMedia);
						
						JScrollPane scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(10, 90, 363, 223);
						PlaylistRun.add(scrollPane_1);
						scrollPane_1.setViewportView(ParrafoPlay);
						
						
						ParrafoPlay.setLineWrap(true);
		imagenPlayList.setVisible(true);
	}
}