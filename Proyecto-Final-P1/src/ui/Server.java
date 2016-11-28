package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Server {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 461, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 46, 186, 344);
		frame.getContentPane().add(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(229, 46, 206, 344);
		frame.getContentPane().add(textArea);
		
		JLabel lblUsuariosConectados = new JLabel("Usuarios conectados");
		lblUsuariosConectados.setBounds(41, 21, 125, 14);
		frame.getContentPane().add(lblUsuariosConectados);
		
		JLabel lblMensajesEnviados = new JLabel("Mensajes enviados");
		lblMensajesEnviados.setBounds(264, 21, 137, 14);
		frame.getContentPane().add(lblMensajesEnviados);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(229, 46, 6, 20);
		frame.getContentPane().add(textPane);
		
		JButton btnVerConectados = new JButton("Ver conectados");
		btnVerConectados.setBounds(37, 401, 133, 23);
		frame.getContentPane().add(btnVerConectados);
		
		JButton btnVerConectados_1 = new JButton("Ver conectados");
		btnVerConectados_1.setBounds(264, 401, 137, 23);
		frame.getContentPane().add(btnVerConectados_1);
	}
}
