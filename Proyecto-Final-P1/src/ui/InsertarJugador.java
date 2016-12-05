  
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ligaBasketball.Estadistica;
import ui.CreacionPartido;
import ui.InsertarEquipo;
import ui.InsertarJugador;
import ui.Ranking;
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
	private JTextField rebotes;
	private JTextField anotaciones;
	private JTextField asistencia;
	ArrayList <Estadistica> estadisticas = new ArrayList <Estadistica> () ;
	
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
		
		final JComboBox<Posicion> comboBox = new JComboBox<Posicion>();
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
				Liga.getInstance().InsertJugadorFantasy(NombreTF.getText(), Integer.parseInt(NumeroTF.getText()), (Posicion)comboBox.getSelectedItem(), Integer.parseInt(anotaciones.getText()), Integer.parseInt(asistencia.getText()), Integer.parseInt(rebotes.getText()));
				Jugador jugador = new Jugador(NombreTF.getText(), Integer.parseInt(NumeroTF.getText()),(Posicion)comboBox.getSelectedItem(), estadisticas);
				Liga.getInstance().getEquipos().get(ComboEquipos.getSelectedIndex()).getJugadores().add(jugador);
				//Liga.getInstance().InsertJugador(NombreTF.getText(), Integer.parseInt(NumeroTF.getText()),(Posicion)comboBox.getSelectedItem(), estadisticas);
				//String anterior = textArea.getText();
				textArea.setText( " Numero: " + jugador.getNumero() +  "\n"+ " Nombre: " + jugador.getNombre() + "\n" + " Posicion: " + jugador.getPosicion());
				resetearCampos();
				
			}
		});
		btnAgregar.setBounds(26, 338, 97, 25);
		contentPanel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		
			}
		});
		btnCancelar.setBounds(151, 338, 97, 25);
		contentPanel.add(btnCancelar);
		
		JButton btnEquipo = new JButton("Equipos");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertarEquipo equipo = new InsertarEquipo();
				equipo.setVisible(true);	
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
		
		rebotes = new JTextField();
		rebotes.setBounds(14, 258, 86, 20);
		contentPanel.add(rebotes);
		rebotes.setColumns(10);
		
		anotaciones = new JTextField();
		anotaciones.setText("");
		anotaciones.setBounds(115, 258, 86, 20);
		contentPanel.add(anotaciones);
		anotaciones.setColumns(10);
		
		asistencia = new JTextField();
		asistencia.setBounds(59, 307, 86, 20);
		contentPanel.add(asistencia);
		asistencia.setColumns(10);
		
		JLabel lblRebotes = new JLabel("Rebotes");
		lblRebotes.setBounds(26, 243, 46, 14);
		contentPanel.add(lblRebotes);
		
		JLabel lblAnotaciones = new JLabel("Anotaciones");
		lblAnotaciones.setBounds(134, 243, 46, 14);
		contentPanel.add(lblAnotaciones);
		
		JLabel lblAsistencia = new JLabel("Asistencia");
		lblAsistencia.setBounds(77, 282, 46, 14);
		contentPanel.add(lblAsistencia);
		
		JButton AgregarEstadistica = new JButton("Agregar Estadistica");
		AgregarEstadistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estadistica estadistica = new Estadistica( Integer.parseInt(anotaciones.getText().toString()),Integer.parseInt(asistencia.getText().toString()), Integer.parseInt(rebotes.getText().toString()));
				estadisticas.add(estadistica);
				anotaciones.setText("");
				rebotes.setText("");
				asistencia.setText("");
			}
		});
		AgregarEstadistica.setBounds(175, 289, 89, 23);
		contentPanel.add(AgregarEstadistica);
		
		JButton button = new JButton("Partido");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreacionPartido partido = new CreacionPartido();
				partido.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setBounds(386, 0, 97, 25);
		contentPanel.add(button);
		
		JButton button_3 = new JButton("Liga");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
				setVisible(false);
				
			}
		});
		button_3.setBounds(338, 25, 97, 25);
		contentPanel.add(button_3);
		
		JButton btnAbrir = new JButton("abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FantasyLeague dialog = new FantasyLeague();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnAbrir.setBounds(56, 401, 89, 23);
		contentPanel.add(btnAbrir);
		
		llenarEquipos();
	}
	
	private void llenarEquipos(){
		for (Equipo e : Liga.getInstance().getEquipos()) {
			ComboEquipos.addItem(e.getNombre().toString());
		}
	}
	
	void resetearCampos(){
		NombreTF.setText("");
		NumeroTF.setText("");
	}
}