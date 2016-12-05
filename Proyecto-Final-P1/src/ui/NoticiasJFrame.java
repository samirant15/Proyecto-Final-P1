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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
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
import javax.swing.UIManager;

public class NoticiasJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel noticiaPrincipalPanel;
	private JTextField noticiaTituloText;
	private static JFileChooser ourFileSelector = new JFileChooser();
	JButton btnEnviarMedia = new JButton("Enviar Media");
	private JInternalFrame medialFrame = new JInternalFrame("Media");
	private String vlcPath = "Proyecto-Final-P1/Resources/VLC", mediaPath = "";
	ConectorArchivoNoticia client = new ConectorArchivoNoticia();
	String ip = "10.126.35.2";
	int port = 8080;
	int pagina = 0;
	int n = 0;
	JInternalFrame Imagen1 = new JInternalFrame("New JInternalFrame");// ------------------
	MediaPlayer player1;
	JInternalFrame Imagen2 = new JInternalFrame("New JInternalFrame");
	MediaPlayer player2;
	JInternalFrame Imagen3 = new JInternalFrame("New JInternalFrame");
	MediaPlayer player3;
	private JTextField Parrafo1;
	private JTextField Parrafo2;
	private JTextField Parrafo3;

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

	public NoticiasJFrame() {

		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		setTitle("Noticias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 422);

		JMenuBar menuBar = new JMenuBar();
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
					Controlador.getInstance();
					for (Noticia n : Controlador.getNoticias()) {
						File f = new File(n.getPath());
						if (!f.exists()) {
							client.Crear(sock);
							ConectorArchivoNoticia.receiveFile(n.getPath());
						}
					}
					ConectorArchivoNoticia.getSock().close();
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

		JButton Mostrar = new JButton("Mostrar Noticias");
		Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player1 = new MediaPlayer(Imagen1, vlcPath,
						Controlador.getNoticias().get(pagina).getPath().replaceAll("/", "\\\\"));
				player1.run();
				player2 = new MediaPlayer(Imagen2, vlcPath,
						Controlador.getNoticias().get(pagina + 1).getPath().replaceAll("/", "\\\\"));
				player2.run();
				player3 = new MediaPlayer(Imagen3, vlcPath,
						Controlador.getNoticias().get(pagina + 2).getPath().replaceAll("/", "\\\\"));
				player3.run();
				Mostrar.setVisible(false);
			}
		});
		Mostrar.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Mostrar.setBounds(0, 0, 592, 362);
		ListaNoticias.add(Mostrar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(367, 13, 165, 103);
		ListaNoticias.add(panel_1);

		Imagen1.getContentPane().setSize(165, 107);
		// Controlador.getInstance().leerNoticias();
		// String mediaPath1 =
		// Controlador.getInstance().getNoticias().get(0).getPath();
		// new MediaPlayer(Imagen1, vlcPath, mediaPath1).run();
		Imagen1.getContentPane().setBackground(Color.DARK_GRAY);
		Imagen1.setBorder(new EmptyBorder(0, 0, 0, 0));
		Imagen1.setBounds(0, -31, 165, 134);

		panel_1.setLayout(null);
		panel_1.add(Imagen1);
		Imagen1.setVisible(true);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(367, 129, 165, 103);
		ListaNoticias.add(panel_2);
		panel_2.setLayout(null);

		Imagen2.getContentPane().setSize(165, 105);
		Imagen2.getContentPane().setBackground(Color.DARK_GRAY);
		Imagen2.setBorder(new EmptyBorder(0, 0, 0, 0));
		Imagen2.setBounds(0, -29, 165, 132);
		panel_2.add(Imagen2);
		Imagen2.setVisible(true);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(367, 245, 165, 103);
		ListaNoticias.add(panel_3);
		panel_3.setLayout(null);

		Imagen3.getContentPane().setBackground(Color.DARK_GRAY);
		Imagen3.setBorder(new EmptyBorder(0, 0, 0, 0));
		Imagen3.setBounds(0, -29, 165, 132);
		panel_3.add(Imagen3);

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
		Titulo3.setBounds(238, 251, 115, 14);
		ListaNoticias.add(Titulo3);

		Parrafo1 = new JTextField();
		Parrafo1.setBounds(60, 156, 293, 76);
		ListaNoticias.add(Parrafo1);
		Parrafo1.setEditable(false);
		Parrafo1.setText(Controlador.getNoticias().get(pagina).getTexto());
		Parrafo1.setColumns(10);
		Controlador.getInstance();

		Parrafo2 = new JTextField();
		Parrafo2.setBounds(60, 272, 293, 76);
		ListaNoticias.add(Parrafo2);
		Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
		Parrafo2.setEditable(false);
		Parrafo2.setColumns(10);
		Controlador.getInstance();

		Parrafo3 = new JTextField();
		Parrafo3.setBounds(60, 40, 293, 76);
		ListaNoticias.add(Parrafo3);
		Parrafo3.setEditable(false);
		Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
		Parrafo3.setColumns(10);

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
		Fecha3.setBounds(60, 251, 117, 14);
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
						ConectorArchivoNoticia.getSock().close();
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
						ConectorArchivoNoticia.getSock().close();
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
					Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
					Controlador.getInstance();
					Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
					Controlador.getInstance();
					Titulo1.setText(Controlador.getNoticias().get(pagina).getTitulo());
					Controlador.getInstance();
					Titulo2.setText(Controlador.getNoticias().get(pagina + 1).getTitulo());
					Controlador.getInstance();
					Titulo3.setText(Controlador.getNoticias().get(pagina + 2).getTitulo());
					Controlador.getInstance();
					Fecha1.setText(Controlador.getNoticias().get(pagina).getFecha());
					Controlador.getInstance();
					Fecha2.setText(Controlador.getNoticias().get(pagina + 1).getFecha());
					Controlador.getInstance();
					Fecha3.setText(Controlador.getNoticias().get(pagina + 2).getFecha());
					Controlador.getInstance();
					player1.changeMedia(Controlador.getNoticias().get(pagina).getPath().replaceAll("/", "\\\\"));
					Controlador.getInstance();
				    player2.changeMedia(Controlador.getNoticias().get(pagina+1).getPath().replaceAll("/", "\\\\"));
					Controlador.getInstance();
				    player3.changeMedia(Controlador.getNoticias().get(pagina+2).getPath().replaceAll("/", "\\\\"));
				}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon(
				"Proyecto-Final-P1\\Resources\\rsz_1rsz_rsz_next.png"));
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
					Parrafo2.setText(Controlador.getNoticias().get(pagina + 1).getTexto());
					Controlador.getInstance();
					Parrafo3.setText(Controlador.getNoticias().get(pagina + 2).getTexto());
					Controlador.getInstance();
					Titulo1.setText(Controlador.getNoticias().get(pagina).getTitulo());
					Controlador.getInstance();
					Titulo2.setText(Controlador.getNoticias().get(pagina + 1).getTitulo());
					Controlador.getInstance();
					Titulo3.setText(Controlador.getNoticias().get(pagina + 2).getTitulo());
					Controlador.getInstance();
					Fecha1.setText(Controlador.getNoticias().get(pagina).getFecha());
					Controlador.getInstance();
					Fecha2.setText(Controlador.getNoticias().get(pagina + 1).getFecha());
					Controlador.getInstance();
					Fecha3.setText(Controlador.getNoticias().get(pagina + 2).getFecha());
					player1.changeMedia(Controlador.getNoticias().get(pagina).getPath().replaceAll("/", "\\\\"));
					Controlador.getInstance();
				    player2.changeMedia(Controlador.getNoticias().get(pagina+1).getPath().replaceAll("/", "\\\\"));
					Controlador.getInstance();
				    player3.changeMedia(Controlador.getNoticias().get(pagina+2).getPath().replaceAll("/", "\\\\"));
				}
			}
		});
		button.setIcon(new ImageIcon(
				"Proyecto-Final-P1\\Resources\\rsz_rsz_next.png"));
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(10, 13, 40, 40);
		ListaNoticias.add(button);

		Imagen3.setVisible(true);

	}
}