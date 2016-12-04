
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


import ligaBasketball.Equipo;
import ligaBasketball.Liga;



public class InsertarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField NombreTF;
	private JTextField PartidosGanadosTF;
	private JTextField PartidoTF;
	private JTextArea textArea = new JTextArea();
	private JTextField PartidosPerdidosTF;
	
	
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
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(12, 60, 90, 16);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblPartidosGanado = new JLabel("Ganados");
			lblPartidosGanado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPartidosGanado.setBounds(12, 114, 90, 16);
			contentPanel.add(lblPartidosGanado);
		}
		{
			JLabel lblPartidosPerdidos = new JLabel("Perdidos");
			lblPartidosPerdidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPartidosPerdidos.setBounds(12, 164, 90, 16);
			contentPanel.add(lblPartidosPerdidos);
		}
		{
			JLabel lblPartido = new JLabel("Partido \r\n\r\n");
			lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPartido.setBounds(12, 220, 90, 16);
			contentPanel.add(lblPartido);
		}
		
		NombreTF = new JTextField();
		NombreTF.setBounds(151, 57, 116, 22);
		contentPanel.add(NombreTF);
		NombreTF.setColumns(10);
		
		PartidosGanadosTF = new JTextField();
		PartidosGanadosTF.setBounds(151, 111, 116, 22);
		contentPanel.add(PartidosGanadosTF);
		PartidosGanadosTF.setColumns(10);
		
		PartidoTF = new JTextField();
		PartidoTF.setBounds(151, 217, 116, 22);
		contentPanel.add(PartidoTF);
		PartidoTF.setColumns(10);
		
		
		
		JLabel lblInsertarEquipo = new JLabel("Insertar Equipo\r\n");
		lblInsertarEquipo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblInsertarEquipo.setBounds(12, 0, 255, 37);
		contentPanel.add(lblInsertarEquipo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo equipo = new Equipo(NombreTF.getText(), Integer.parseInt(PartidosGanadosTF.getText()),Integer.parseInt(PartidosPerdidosTF.getText()), null);
				Liga.getInstancia().getEquipos().add(equipo);
				textArea.setText( " Nombre: " + equipo.getNombre() +  "\n"+ " Partidos ganados: " + equipo.getPartidosGanados() +  "\n"+ " Partidos perdidos: " + equipo.getPartidasPerdidas());
				resetearCampos();
			}
		});
		btnAgregar.setBounds(117, 447, 97, 25);
		contentPanel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		
			}
		});
		btnCancelar.setBounds(240, 447, 97, 25);
		contentPanel.add(btnCancelar);
		
		JButton btnJugador = new JButton("Jugadores");
		btnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertarJugador jugador = new InsertarJugador();
				jugador.setVisible(true);	
				setVisible(false);
				
				
			}
		});
		btnJugador.setBounds(284, 0, 90, 25);
		contentPanel.add(btnJugador);
		
		JPanel panel = new JPanel();
		panel.setBounds(284, 130, 179, 244);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textArea.setBounds(12, 13, 155, 218);
		panel.add(textArea);
		
		PartidosPerdidosTF = new JTextField();
		PartidosPerdidosTF.setBounds(151, 164, 116, 20);
		contentPanel.add(PartidosPerdidosTF);
		PartidosPerdidosTF.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	void resetearCampos(){
		PartidosGanadosTF.setText("");
		NombreTF.setText("");
		PartidoTF.setText("");
		
	}
}
