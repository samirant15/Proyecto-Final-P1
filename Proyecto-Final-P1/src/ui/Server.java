package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class Server {

	private JFrame frame;
	private JTextField txtServer;
	
	/**
	 * Launch the application.
	 */
	public void main() {
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
		frame.setBounds(100, 100, 558, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 43, 221, 248);
		frame.getContentPane().add(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(311, 42, 231, 245);
		frame.getContentPane().add(textArea);
		
		JLabel lblUsuariosConectados = new JLabel("Usuarios conectados");
		lblUsuariosConectados.setBounds(58, 21, 125, 14);
		frame.getContentPane().add(lblUsuariosConectados);
		
		JLabel lblMensajesEnviados = new JLabel("Mensajes enviados");
		lblMensajesEnviados.setBounds(358, 21, 137, 14);
		frame.getContentPane().add(lblMensajesEnviados);
		
		JButton btnVerConectados = new JButton("Ver conectados");
		btnVerConectados.setBounds(54, 301, 133, 23);
		frame.getContentPane().add(btnVerConectados);
		
		JButton btnVerConectados_1 = new JButton("Ver conectados");
		btnVerConectados_1.setBounds(358, 298, 137, 23);
		frame.getContentPane().add(btnVerConectados_1);
		
		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO cambiar para el de verdad
				pruebaChatInicio.iniciarServidor();
			}
		});
		btnIniciarServidor.setBounds(65, 336, 425, 23);
		frame.getContentPane().add(btnIniciarServidor);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 552, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		JMenu mnEnviar = new JMenu("Enviar");
		mnHerramientas.add(mnEnviar);
		
		JMenuItem mntmMensajeGlobal = new JMenuItem("Mensaje global");
		mnEnviar.add(mntmMensajeGlobal);
		
		txtServer.setBounds(12, 380, 440, 62);
		frame.getContentPane().add(txtServer);
		txtServer.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruebaChatInicio.server.enviarMSG(txtServer.getText());
			}
		});
		btnEnviar.setBounds(458, 380, 89, 61);
		frame.getContentPane().add(btnEnviar);
	}
}
