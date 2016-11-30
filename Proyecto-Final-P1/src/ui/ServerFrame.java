package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ServerFrame extends JFrame {
	public static JTextArea txtAreaServidor = new JTextArea();
	private JPanel contentPane;

	
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruebaChatInicio.iniciarServidor();
				System.out.println("Inició el servidor");
			}
		});
		btnIniciarServidor.setBounds(165, 206, 124, 23);
		contentPane.add(btnIniciarServidor);
		
		txtAreaServidor.setBounds(10, 11, 414, 188);
		contentPane.add(txtAreaServidor);
	}
}
