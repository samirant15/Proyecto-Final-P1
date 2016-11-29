package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.Conector;
import onlineMedia.Servidor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pruebaChatInicio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			pruebaChatInicio dialog = new pruebaChatInicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public static Conector server, cliente;
	public pruebaChatInicio() {
		setBounds(100, 100, 308, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnInicioDelChat = new JButton("Inicio del Chat");
			btnInicioDelChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Server server = new Server();
					server.main();
				}
			});
			btnInicioDelChat.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
			btnInicioDelChat.setBounds(12, 10, 266, 120);
			contentPanel.add(btnInicioDelChat);
		}
	}
	public static void iniciarServidor(){
		server = new Conector();
	} 
	public static void iniciarCliente(String IP){
		cliente = new Conector(IP);
	}
}
