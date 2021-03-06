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
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import enums.Posicion;
import ligaBasketball.EquipoFantasy;
import ligaBasketball.Jugador;
import ligaBasketball.JugadorFantasy;
import ligaBasketball.Liga;
import ligaBasketball.PartidaFantasy;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class FantasyLeague extends JDialog {
	private JTextField nameEquip;
	private JTable table;
	private JTextField idT;
	private JTextField idC;
	private JTextField idV;

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


		//Liga.getInstance().InsertJugadorFantasy("Pedro", 66, null, 6, 5, 6);
		//Liga.getInstance().InsertJugadorFantasy("Juan", 7, null, 3, 6, 6);

		/*try {
			File f = new File("jugador.txt");
			Scanner sc = new Scanner(f);

			ArrayList<JugadorFantasy> people = new ArrayList<JugadorFantasy>();

			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String[] details = line.split("|");
				String nombre = details[0];
				int numero = Integer.parseInt(details[1]);
				Posicion posicion = Posicion.valueOf(details[2]);
				int anotacion = Integer.parseInt(details[3]);
				int asistencia = Integer.parseInt(details[4]);
				int rebote = Integer.parseInt(details[5]);
				JugadorFantasy p = new JugadorFantasy(nombre, numero, posicion, anotacion, asistencia, rebote);
				people.add(p);
			}

			for(JugadorFantasy p: people){
				System.out.println(p.toString());
			}

		} catch (FileNotFoundException e) {         
			e.printStackTrace();
		}*/


		setBounds(100, 100, 446, 328);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tabbedPane.setBounds(0, 0, 430, 323);
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
		EquipoBox.setBounds(243, 44, 154, 20);
		panel.add(EquipoBox);

		ArrayList<EquipoFantasy> equipoFancy = Liga.getInstance().getEquiposfantasy();
		for(int i=0; i<equipoFancy.size(); i++){
			EquipoBox.addItem(equipoFancy.get(i).getNombre());
		}

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liga.getInstance().InsertEquipoFantasy(nameEquip.getText(), 0, 0, new ArrayList<JugadorFantasy>());
				EquipoBox.removeAllItems();
				for(int i=0; i<equipoFancy.size(); i++){
					EquipoBox.addItem(equipoFancy.get(i).getNombre());
				}
				JOptionPane.showMessageDialog(null, "Se ha agregado con exito");
				nameEquip.setText("");;
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
		lblJugadores.setBounds(235, 108, 154, 14);
		panel.add(lblJugadores);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(235, 76, 169, 1);
		panel.add(separator_2);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblId.setBounds(245, 136, 39, 14);
		panel.add(lblId);

		idT = new JTextField();
		idT.setBounds(275, 134, 39, 17);
		panel.add(idT);
		idT.setColumns(10);

		JButton btnNewButton = new JButton("Agregar a equipo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int team_index = EquipoBox.getSelectedIndex();

				EquipoFantasy team = Liga.getInstance().getEquiposfantasy().get(team_index);
				JugadorFantasy player = Liga.getInstance().getJugadoresfantasy().get(Integer.parseInt(idT.getText()));

				System.out.println(team.getNombre() + " "+ player+ " "+ team_index );

				Liga.getInstance().GenerateEquipoFantasy(team.getNombre(), player);



			}
		});
		btnNewButton.setBounds(253, 170, 136, 23);
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

		JSeparator separator = new JSeparator();
		separator.setBounds(235, 204, 169, 1);
		panel.add(separator);

		JButton btnVerEquipos = new JButton("Ver equipos");
		btnVerEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEquiposFantasy dialog = new ListaEquiposFantasy();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnVerEquipos.setBounds(51, 212, 115, 23);
		panel.add(btnVerEquipos);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Partidos", null, panel_1, null);
		panel_1.setLayout(null);

		JButton btnGenerarPartido = new JButton("Generar Partido");
		btnGenerarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ptsC=0, ptsV=0, C;

				for(int i=0; i<Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).getJugadoresfantasy().size(); i++){
					ptsC= ptsC+ Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).getJugadoresfantasy().get(i).getAnotaciones();
				}

				for(int i=0; i<Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).getJugadoresfantasy().size(); i++){
					ptsV= ptsV+ Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).getJugadoresfantasy().get(i).getAnotaciones();


				}
				if(ptsC>ptsV){
					JOptionPane.showMessageDialog(null, "El equipo: "+ Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).getNombre()+ " ha sido el ganador");
					Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).setPartidosGanados(1+Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).getPartidosGanados());
					Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).setPartidasPerdidas(1+Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).getPartidasPerdidas());
				}
				else if(ptsC<ptsV){
					JOptionPane.showMessageDialog(null, "El equipo: "+ Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).getNombre()+ " ha sido el ganador");
					Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).setPartidosGanados(1+Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idV.getText())).getPartidosGanados());
					Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).setPartidasPerdidas(1+Liga.getInstance().getEquiposfantasy().get(Integer.parseInt(idC.getText())).getPartidasPerdidas());
				}
				else{
					JOptionPane.showMessageDialog(null, "El partido termino en un empate");
				}
				System.out.println(ptsC +" "+ ptsV);

			}
		});
		btnGenerarPartido.setBounds(139, 218, 136, 23);
		panel_1.add(btnGenerarPartido);

		idC = new JTextField();
		idC.setColumns(10);
		idC.setBounds(71, 54, 39, 17);
		panel_1.add(idC);

		JLabel lblNombreEquipoCasa = new JLabel("Nombre equipo casa");
		lblNombreEquipoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEquipoCasa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNombreEquipoCasa.setBounds(10, 28, 165, 14);
		panel_1.add(lblNombreEquipoCasa);

		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(41, 56, 39, 14);
		panel_1.add(label_1);

		JLabel lblNombreEquipoVisita = new JLabel("Nombre equipo visita");
		lblNombreEquipoVisita.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEquipoVisita.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNombreEquipoVisita.setBounds(262, 28, 153, 14);
		panel_1.add(lblNombreEquipoVisita);

		idV = new JTextField();
		idV.setColumns(10);
		idV.setBounds(318, 54, 39, 17);
		panel_1.add(idV);

		JLabel label_2 = new JLabel("ID");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_2.setBounds(286, 56, 39, 14);
		panel_1.add(label_2);

		JButton btnVerEquipos_1 = new JButton("Ver Equipos");
		btnVerEquipos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEquiposFantasy dialog = new ListaEquiposFantasy();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);


			}
		});
		btnVerEquipos_1.setBounds(139, 147, 136, 23);
		panel_1.add(btnVerEquipos_1);



	}
}
