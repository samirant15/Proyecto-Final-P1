package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Roles;
import ligaBasketball.Liga;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	private int posUser; 
	
	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		Liga liga = Liga.getInstance();
		setTitle("Soccer Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 712, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido," + liga.getUsuario(posUser).getUsername());
		lblBienvenido.setBounds(265, 5, 182, 22);
		panel.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextPane txtpnEsaVentanaEs = new JTextPane();
		txtpnEsaVentanaEs.setBounds(119, 40, 433, 75);
		panel.add(txtpnEsaVentanaEs);
		txtpnEsaVentanaEs.setText("Esa ventana es para poder estar organizados, cuando creen una ventana para probar su parte del programa, pongan un boton aqui que abra su ventana. Asi trabajamos en el mismo proyecto y cada quien con sus ventanas");
		
		JButton btnNewButton = new JButton("Noticias (cero poner mano)");
		btnNewButton.setBounds(245, 128, 189, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crea un JFrame de las noticias
				NoticiasJFrame frame = new NoticiasJFrame();
				frame.setVisible(true);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 712, 26);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("  Programa  ");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("  Salir   ");
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("      Ver      ");
		menuBar.add(menu_1);
		
		JMenuItem mntmNoticias = new JMenuItem("Noticias    ");
		menu_1.add(mntmNoticias);
		
		JMenu menu_2 = new JMenu("Herramientas    ");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("Admin Options");
		menuBar.add(menu_3);
		
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
