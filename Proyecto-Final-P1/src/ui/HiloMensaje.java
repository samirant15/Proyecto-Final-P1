package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineMedia.Hilo;
import ui.pruebaChatInicio;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class HiloMensaje extends JFrame {

	private JPanel contentPane;
	private JTextField txtIP;
	private JButton btnConectar;
	JTextPane txtMensaje = new JTextPane();
	private JTextField txtTitulo;

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
		
		JButton btnMensaje = new JButton("Mensaje");
		btnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hilo hilo = new Hilo();
				hilo.setMensajes(txtMensaje.getText());
				hilo.setTitulo(txtTitulo.getText());
				MainJFrame.cliente.enviarMSG(hilo);
				dispose();
			}
		});
		
		txtMensaje.setBounds(10, 73, 424, 162);
		contentPane.add(txtMensaje);
		btnMensaje.setBounds(345, 248, 89, 23);
		contentPane.add(btnMensaje);
		
		txtIP = new JTextField();
		txtIP.setBounds(227, 11, 108, 20);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainJFrame.iniciarCliente(txtIP.getText());
			}
		});
		btnConectar.setBounds(345, 10, 89, 23);
		contentPane.add(btnConectar);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(79, 42, 355, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(10, 42, 78, 17);
		contentPane.add(lblTitulo);
	}
}
