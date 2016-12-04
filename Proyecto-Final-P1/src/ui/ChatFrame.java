package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JMenu;

public class ChatFrame extends JFrame {
	private JTextField txtEnviarMensaje;
	String IP;
	public static JTextArea messageTextArea = new JTextArea();
	private JTextField txtConectar;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		setBounds(100, 100, 800, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtEnviarMensaje = new JTextField();
		txtEnviarMensaje.setFont(new Font("Calibri Light", Font.BOLD, 14));
		txtEnviarMensaje.setBounds(204, 564, 461, 36);
		getContentPane().add(txtEnviarMensaje);
		txtEnviarMensaje.setColumns(10);
		
		JButton btnEnviarButton = new JButton("Enviar");
		btnEnviarButton.setFont(new Font("Calibri Light", Font.BOLD, 24));
		btnEnviarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Arreglar lo del IP, ese no es, le programa debe capturarlo solo
				//pruebaChatInicio.cliente.enviarMSG(txtEnviarMensaje.getText());
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 782, 31);
		getContentPane().add(menuBar);
		
		JMenu mnS = new JMenu("           Ver              ");
		menuBar.add(mnS);
		btnEnviarButton.setBounds(675, 561, 107, 36);
		getContentPane().add(btnEnviarButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(204, 41, 566, 510);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		messageTextArea.setBounds(0, 0, 566, 510);
		panel.add(messageTextArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 44, 180, 510);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(178, 0, -174, 556);
		panel_1.add(list);
		
		txtConectar = new JTextField();
		txtConectar.setBounds(3, 571, 104, 20);
		getContentPane().add(txtConectar);
		txtConectar.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruebaChatInicio.iniciarCliente(txtConectar.getText());
			}
		});
		btnConectar.setBounds(111, 569, 88, 23);
		getContentPane().add(btnConectar);

	}
}
