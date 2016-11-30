package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		setTitle("Tu real proyecto nama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnEsaVentanaEs = new JTextPane();
		txtpnEsaVentanaEs.setText("Esa ventana es para poder estar organizados, cuando creen una ventana para probar su parte del programa, pongan un boton aqui que abra su ventana. Asi trabajamos en el mismo proyecto y cada quien con sus ventanas");
		txtpnEsaVentanaEs.setBounds(130, 11, 459, 110);
		contentPane.add(txtpnEsaVentanaEs);
		
		JButton btnNewButton = new JButton("Noticias (cero poner mano)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crea un JFrame de las noticias
				NoticiasJFrame frame = new NoticiasJFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(250, 132, 200, 50);
		contentPane.add(btnNewButton);
	}
}
