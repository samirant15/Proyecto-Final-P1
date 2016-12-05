package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.Conector;
import onlineMedia.ConectorCliente;

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
	public static Conector server;
	public static ConectorCliente cliente;
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
					Foro clientChat = new Foro();
					clientChat.setVisible(true);
				}
			});
			btnInicioDelChat.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
			btnInicioDelChat.setBounds(12, 10, 266, 56);
			contentPanel.add(btnInicioDelChat);
		}
		
		JButton btnInicioDeServidor = new JButton("Incio del Servidor");
		btnInicioDeServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerFrame server = new ServerFrame();
				server.setVisible(true);
			}
		});
		btnInicioDeServidor.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		btnInicioDeServidor.setBounds(12, 77, 266, 45);
		contentPanel.add(btnInicioDeServidor);
	}
	public static void iniciarServidor(){
		server = new Conector("Servidor");
		server.start();
		
	} 
	public static void iniciarCliente(String IP){
		cliente = new ConectorCliente(IP);
		cliente.start();
	}
}
