package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HiloMensaje extends JFrame {

	private JPanel contentPane;
	private JTextField txtMensaje;
	private JTextField txtIP;
	private JButton btnConectar;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public HiloMensaje() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMensaje = new JTextField();
		txtMensaje.setBounds(10, 48, 424, 197);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JButton btnMensaje = new JButton("Mensaje");
		btnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruebaChatInicio.cliente.enviarMSG(txtMensaje.getText());
			}
		});
		btnMensaje.setBounds(345, 248, 89, 23);
		contentPane.add(btnMensaje);
		
		txtIP = new JTextField();
		txtIP.setBounds(227, 11, 108, 20);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruebaChatInicio.cliente.enviarMSG(txtMensaje.getText());
			}
		});
		btnConectar.setBounds(345, 10, 89, 23);
		contentPane.add(btnConectar);
	}

}
