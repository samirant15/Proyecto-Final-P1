
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import ligaBasketball.Equipo;
import ligaBasketball.Jugador;
import ligaBasketball.Liga;

import javax.swing.DefaultComboBoxModel;

import enums.Posicion;


public class InsertarJugador extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField NumeroTF;
	private JTextField NombreTF;
	private JTextArea textArea = new JTextArea();
	private JComboBox<String> ComboEquipos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarJugador dialog = new InsertarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarJugador() {
		setBounds(100, 100, 513, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumero = new JLabel("Numero:\r\n\r\n\r\n\r\n");
			lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNumero.setBounds(12, 60, 90, 16);
			contentPanel.add(lblNumero);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(12, 114, 90, 16);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblPosicion = new JLabel("Posicion:\r\n\r\n");
			lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPosicion.setBounds(14, 203, 90, 16);
			contentPanel.add(lblPosicion);
		}
		
		NumeroTF = new JTextField();
		NumeroTF.setBounds(151, 57, 116, 22);
		contentPanel.add(NumeroTF);
		NumeroTF.setColumns(10);
		
		NombreTF = new JTextField();
		NombreTF.setBounds(151, 111, 116, 22);
		contentPanel.add(NombreTF);
		NombreTF.setColumns(10);
		
		JComboBox<Posicion> comboBox = new JComboBox<Posicion>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<Posicion>(Posicion.values()));
		comboBox.setBounds(153, 203, 116, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		
		JLabel lblInsertarJugador = new JLabel("Insertar Jugador");
		lblInsertarJugador.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblInsertarJugador.setBounds(12, 0, 255, 37);
		contentPanel.add(lblInsertarJugador);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Jugador jugador = new Jugador(NombreTF.getText(), Integer.parseInt(NumeroTF.getText()),(Posicion)comboBox.getSelectedItem(), null);
				//Liga.getInstancia().getEquipos().get(ComboEquipos.getSelectedIndex()).getJugadores().add(jugador);
				//String anterior = textArea.getText();
				//textArea.setText( " Numero: " + jugador.getNumero() +  "\n"+ " Nombre: " + jugador.getNombre() + "\n" + " Posicion: " + jugador.getPosicion());
				resetearCampos();
				
			}
		});
		btnAgregar.setBounds(23, 300, 97, 25);
		contentPanel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		
			}
		});
		btnCancelar.setBounds(151, 300, 97, 25);
		contentPanel.add(btnCancelar);
		
		JButton btnEquipo = new JButton("Equipos");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//InsertarEquipo equipo = new InsertarEquipo();
				//equipo.setVisible(true);	
				setVisible(false);
				
			}
		});
		btnEquipo.setBounds(284, 0, 90, 25);
		contentPanel.add(btnEquipo);
		
		JPanel panel = new JPanel();
		panel.setBounds(284, 130, 179, 244);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textArea.setBounds(12, 13, 155, 218);
		panel.add(textArea);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(12, 162, 56, 16);
		contentPanel.add(lblEquipo);
		
		ComboEquipos = new JComboBox();
		ComboEquipos.setBounds(151, 159, 116, 22);
		contentPanel.add(ComboEquipos);
		
		llenarEquipos();
	}
	
	private void llenarEquipos(){
		//for (Equipo e : Liga.getInstancia().getEquipos()) 
		{
			//ComboEquipos.addItem(e.getNombre().toString());
		}
	}
	
	void resetearCampos(){
		NombreTF.setText("");
		NumeroTF.setText("");
	}
}
