package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import enums.Posicion;
import ligaBasketball.EquipoFantasy;
import ligaBasketball.Jugador;
import ligaBasketball.Liga;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class FantasyLeague extends JDialog {
	private JTextField nameEquip;
	private JTable table;
	private JTextField idT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FantasyLeague dialog = new FantasyLeague();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public FantasyLeague() {
		
		
		Liga.getInstance().InsertJugador("Pedro", 66, null, 6, 5, 6);
		Liga.getInstance().InsertJugador("Juan", 7, null, 3, 6, 6);
		
		
		setBounds(100, 100, 446, 283);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tabbedPane.setBounds(0, 0, 430, 244);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Equipos", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSeleccionarEquipoYa = new JLabel("Seleccionar equipo ya creado");
		lblSeleccionarEquipoYa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSeleccionarEquipoYa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarEquipoYa.setBounds(235, 19, 169, 14);
		panel.add(lblSeleccionarEquipoYa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(24, 19, 162, 126);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(48, 34, 63, 14);
		panel_2.add(lblNombre);
		
		nameEquip = new JTextField();
		nameEquip.setBounds(33, 58, 86, 20);
		panel_2.add(nameEquip);
		nameEquip.setColumns(10);
		
		JLabel lblInsertarNombreDe = new JLabel("Crear equipo");
		lblInsertarNombreDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblInsertarNombreDe.setBounds(10, 11, 142, 14);
		panel_2.add(lblInsertarNombreDe);
		lblInsertarNombreDe.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JComboBox EquipoBox = new JComboBox();
		EquipoBox.setBounds(243, 57, 154, 20);
		panel.add(EquipoBox);
		
		ArrayList<EquipoFantasy> equipoFancy = Liga.getInstance().getEquiposfantasy();
		for(int i=0; i<equipoFancy.size(); i++){
			EquipoBox.addItem(equipoFancy.get(i).getNombre());
		}
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liga.getInstance().InsertEquipoFantasy(nameEquip.getText(), 0, 0, null);
				EquipoBox.removeAllItems();
				for(int i=0; i<equipoFancy.size(); i++){
					EquipoBox.addItem(equipoFancy.get(i).getNombre());
				}
				
			}
		});
		
		
		btnCrear.setBounds(43, 89, 68, 23);
		panel_2.add(btnCrear);
		
		
		table = new JTable();
		table.setBounds(10, 234, 1, 1);
		panel.add(table);
		
		JLabel lblJugadores = new JLabel("A\u00F1adir jugador:");
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblJugadores.setBounds(243, 99, 154, 14);
		panel.add(lblJugadores);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(235, 89, 169, 1);
		panel.add(separator_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblId.setBounds(243, 137, 39, 14);
		panel.add(lblId);
		
		idT = new JTextField();
		idT.setBounds(273, 135, 39, 17);
		panel.add(idT);
		idT.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar a equipo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int team_index = EquipoBox.getSelectedIndex();
				
				EquipoFantasy team=Liga.getInstance().getEquiposfantasy().get(team_index);
				Jugador player = Liga.getInstance().getJugadores().get(Integer.parseInt(idT.getText()));
				
				Liga.getInstance().GenerateEquipoFantasy(team.getNombre(), player);
				
				
			}
		});
		btnNewButton.setBounds(243, 162, 136, 23);
		panel.add(btnNewButton);
		
		JButton btnVerJugadores = new JButton("Ver jugadores");
		btnVerJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaJugadores dialog = new ListaJugadores();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
			}
		});
		btnVerJugadores.setBounds(51, 162, 115, 23);
		panel.add(btnVerJugadores);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEquiposFantasy dialog = new ListaEquiposFantasy();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(177, 101, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Partidos", null, panel_1, null);
		panel_1.setLayout(null);
		
	}
}
