package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.CreacionPartido;
import ui.InsertarEquipo;
import ui.InsertarJugador;
import ui.Ranking;
import ligaBasketball.Equipo;
import ligaBasketball.Jugador;
import ligaBasketball.Liga;
import ligaBasketball.Partido;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class CreacionPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JTextField puntosEqC;
	private JTextField puntosEqV;
	private JComboBox<String> ComboEquipoC, ComboEquipoV;
	private JTextPane textPane, textPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreacionPartido dialog = new CreacionPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreacionPartido() {
		setBounds(10, 10, 726, 672);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Equipo Casa");
			lblNewLabel.setBounds(169, 13, 81, 16);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setBounds(405, 13, 103, 16);
		contentPanel.add(lblEquipoVisitante);
		
		ComboEquipoC = new JComboBox();
		ComboEquipoC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jug1 = new ArrayList<String>();
				for (Jugador j : Liga.getInstance().getEquipos().get(ComboEquipoC.getSelectedIndex()).getJugadores()) {
					jug1.add(j.getNombre());
				}
				textPane.setText(jug1.toString());
			}
		});
		ComboEquipoC.setBounds(151, 42, 117, 22);
		contentPanel.add(ComboEquipoC);
		
		ComboEquipoV = new JComboBox();
		ComboEquipoV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jug = new ArrayList<String>();
				for (Jugador j : Liga.getInstance().getEquipos().get(ComboEquipoV.getSelectedIndex()).getJugadores()) {
					jug.add(j.getNombre() );
					
				}
				textPane_1.setText(jug.toString());
			}
		});
		ComboEquipoV.setBounds(415, 42, 103, 22);
		contentPanel.add(ComboEquipoV);
		
		panel = new JPanel();
		panel.setBounds(93, 145, 216, 236);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 11, 196, 214);
		panel.add(textPane);
		
		JLabel lblJugadoresEquipo = new JLabel("Jugadores Equipo Casa");
		lblJugadoresEquipo.setBounds(133, 116, 153, 16);
		contentPanel.add(lblJugadoresEquipo);
		
		JLabel lblJugadoresEquipoVisitante = new JLabel("Jugadores Equipo Visitante");
		lblJugadoresEquipoVisitante.setBounds(376, 116, 160, 16);
		contentPanel.add(lblJugadoresEquipoVisitante);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(356, 145, 216, 236);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 11, 196, 214);
		panel_1.add(textPane_1);
		
		JLabel lblPuntuacion = new JLabel("Puntos");
		lblPuntuacion.setBounds(93, 404, 92, 16);
		contentPanel.add(lblPuntuacion);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(356, 404, 92, 16);
		contentPanel.add(lblPuntos);
		
		puntosEqC = new JTextField();
		puntosEqC.setBounds(195, 401, 116, 22);
		contentPanel.add(puntosEqC);
		puntosEqC.setColumns(10);
		
		puntosEqV = new JTextField();
		puntosEqV.setBounds(458, 401, 116, 22);
		contentPanel.add(puntosEqV);
		puntosEqV.setColumns(10);
		
		JButton btnGuardarPartido = new JButton("Guardar Partido");
		btnGuardarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido partido = new Partido(Integer.parseInt(puntosEqC.getText()), Integer.parseInt(puntosEqV.getText()), new Date(), Liga.getInstance().getEquipos().get(ComboEquipoC.getSelectedIndex()), Liga.getInstance().getEquipos().get(ComboEquipoV.getSelectedIndex()));
				Liga.getInstance().getPartidos().add(partido);
				
				for(Partido p : Liga.getInstance().getPartidos()){
					if(p.getPtsEquipoCasa() > p.getPtsEquipoVisitante()){
						
						Equipo equipo = p.getEquipoCasa();
						int eganadas = equipo.getPartidosGanados() + 1;
						equipo.setPartidosGanados(eganadas);
						
						Equipo equipo2 = p.getEquipoVisitante();
						int eperdidas = equipo.getPartidasPerdidas() + 1;
						equipo2.setPartidasPerdidas(eperdidas);
					}
				}
				
				JOptionPane.showMessageDialog(null, "Partido agregado!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnGuardarPartido.setBounds(262, 587, 153, 25);
		contentPanel.add(btnGuardarPartido);
		
		JButton btnControlDeEquipos = new JButton("Control de equipos");
		btnControlDeEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarEquipo ie = new InsertarEquipo();
				ie.setVisible(true);
			}
		});
		btnControlDeEquipos.setBounds(292, 512, 139, 25);
		contentPanel.add(btnControlDeEquipos);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarEquipos();
			}
		});
		btnNewButton.setBounds(570, 42, 130, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnVerRanking = new JButton("Ver Ranking");
		btnVerRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ranking ir = new Ranking();
				ir.setVisible(true);
			}
		});
		btnVerRanking.setBounds(568, 535, 89, 23);
		contentPanel.add(btnVerRanking);
		
		JButton btnEquipos = new JButton("Equipos");
		btnEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertarEquipo equipo = new InsertarEquipo();
				equipo.setVisible(true);
				setVisible(false);
				
			}
		});
		btnEquipos.setBounds(0, 13, 97, 25);
		contentPanel.add(btnEquipos);
		
		JButton btnJugadores = new JButton("Jugadores");
		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertarJugador jugador = new InsertarJugador();
				jugador.setVisible(true);
				setVisible(false);
				
			}
		});
		btnJugadores.setBounds(0, 39, 97, 25);
		contentPanel.add(btnJugadores);
		
		JButton btnNewButton_1 = new JButton("Liga");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(0, 63, 97, 25);
		contentPanel.add(btnNewButton_1);
	}

	
	private void inicializarEquipos(){
		ComboEquipoC.removeAllItems();
		ComboEquipoV.removeAllItems();
		for (Equipo e : Liga.getInstance().getEquipos()) {
			ComboEquipoC.addItem(e.getNombre());
			ComboEquipoV.addItem(e.getNombre());
		}
	}
}
