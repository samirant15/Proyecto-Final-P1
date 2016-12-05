package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Controlador;
import enums.Roles;
import ligaBasketball.Liga;
import onlineMedia.ServidorNoticia;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int posUser; 
	
	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		Liga liga = Liga.getInstance();
		setTitle("Basketball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 25, 726, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crea un JFrame de las noticias
				NoticiasJFrame frame = null;
				try {
					frame = new NoticiasJFrame();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(true);
				Controlador.getInstance();
				Controlador.leerNoticias();
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_rss-logo-icon-png-4.png"));
		btnNewButton.setBounds(581, 0, 135, 135);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_vs_logo.png"));
		btnNewButton_1.setBounds(10, 187, 135, 135);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_free-vector-nba-logo_090617_nba_logo.png"));
		btnNewButton_2.setBounds(10, 11, 135, 135);
		panel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(238, 0, 249, 371);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido," + liga.getUsuario(posUser).getUsername());
		lblBienvenido.setBounds(33, 5, 182, 22);
		panel_2.add(lblBienvenido);
		lblBienvenido.setForeground(Color.BLACK);
		lblBienvenido.setBackground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 712, 26);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("  Programa  ");
		menuBar.add(menu);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   try {
					Liga.getInstance().escribirBinario();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				   dispose();
				   Liga.getInstance().imprimirUsuarios();
				    try {
						Liga.getInstance().leerBinario();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        LoginJDialog login = new LoginJDialog();
			        login.setVisible(true);
			        login.setLocationRelativeTo(null);
			        Liga.getInstance().imprimirUsuarios();
			}
		});
		menu.add(mntmLogOut);
		
		JMenuItem menuItem = new JMenuItem("  Salir   ");
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("      Ver      ");
		menuBar.add(menu_1);
		
		JMenuItem mntmNoticias = new JMenuItem("Noticias    ");
		mntmNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crea un JFrame de las noticias
				NoticiasJFrame frame = null;
				try {
					frame = new NoticiasJFrame();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(true);
				Controlador.getInstance().leerNoticias();
			}
		});
		menu_1.add(mntmNoticias);
		
		JMenu menu_2 = new JMenu("Herramientas    ");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("Admin Options");
		menuBar.add(menu_3);
		
		JMenuItem mntmRegistrarUsuarioAdministrador = new JMenuItem("Registrar Usuario administrador");
		mntmRegistrarUsuarioAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuarioAdminJDialog registrarUsuarioAdmin = new RegistrarUsuarioAdminJDialog();
				registrarUsuarioAdmin.setVisible(true);
				registrarUsuarioAdmin.setLocationRelativeTo(null);
			}
		});
		menu_3.add(mntmRegistrarUsuarioAdministrador);
		
		JMenuItem mntmIniciarServidorDe = new JMenuItem("Iniciar Servidor de Noticias");
		mntmIniciarServidorDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread server = new Thread(new ServidorNoticia());
				server.start();
			}
		});
		menu_3.add(mntmIniciarServidorDe);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 712, 363);
		contentPane.add(panel_1);
		if(liga.getUsuario(posUser).getRol() == Roles.Administrador){
			menu_3.setVisible(true);
		}else{
			menu_3.setVisible(false);
		}
	}
	public int getPosUser() {
		return posUser;
	}
	public void setPosUser(int posUser) {
		this.posUser = posUser;
	}
}