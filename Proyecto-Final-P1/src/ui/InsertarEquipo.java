
package ui;
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ui.CreacionPartido;
import ui.InsertarEquipo;
import ui.InsertarJugador;
import ui.Ranking;
import ligaBasketball.Equipo;
import ligaBasketball.Liga;



public class InsertarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField NombreTF;
	private JTextArea textArea = new JTextArea();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarEquipo dialog = new InsertarEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarEquipo() {
		setBounds(100, 100, 513, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre\r\n");
			lblNombre.setBounds(26, 129, 90, 16);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblNombre);
		}
		
		NombreTF = new JTextField();
		NombreTF.setBounds(151, 127, 116, 22);
		contentPanel.add(NombreTF);
		NombreTF.setColumns(10);
		
		
		
		JLabel lblInsertarEquipo = new JLabel("Insertar Equipo\r\n");
		lblInsertarEquipo.setBounds(12, 0, 255, 37);
		lblInsertarEquipo.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPanel.add(lblInsertarEquipo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(117, 447, 97, 25);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo equipo = new Equipo(NombreTF.getText(), 0, 0,null);
				Liga.getInstance().getEquipos().add(equipo);
				textArea.setText( " Nombre: " + equipo.getNombre() +  "\n"+ " Partidos ganados: " + equipo.getPartidosGanados() +  "\n"+ " Partidos perdidos: " + equipo.getPartidasPerdidas());
				resetearCampos();
			}
		});
		contentPanel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(240, 447, 97, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		
			}
		});
		contentPanel.add(btnCancelar);
		
		JButton btnJugador = new JButton("Jugadores");
		btnJugador.setBounds(279, 0, 90, 25);
		btnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertarJugador jugador = new InsertarJugador();
				jugador.setVisible(true);	
				setVisible(false);
				
				
			}
		});
		contentPanel.add(btnJugador);
		
		JPanel panel = new JPanel();
		panel.setBounds(284, 130, 179, 244);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textArea.setBounds(12, 13, 155, 218);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Partido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreacionPartido partido = new CreacionPartido();
				partido.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(375, 0, 97, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnLiga = new JButton("Liga");
		btnLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
				setVisible(false);
			}
			
		});
		btnLiga.setBounds(330, 23, 97, 25);
		contentPanel.add(btnLiga);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	void resetearCampos(){
		NombreTF.setText("");
		
	}
}