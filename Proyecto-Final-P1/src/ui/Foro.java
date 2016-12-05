package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import onlineMedia.Hilo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Foro extends JFrame {

	private JPanel contentPane;
	private JTable tableForo;
	private ArrayList<Hilo>hilos = new ArrayList<Hilo>();
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Foro() {
		setTitle("Foro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableForo = new JTable();
		tableForo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Hilo", "Creador"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableForo.getColumnModel().getColumn(0).setPreferredWidth(530);
		tableForo.getColumnModel().getColumn(0).setMinWidth(10);
		tableForo.setCellSelectionEnabled(true);
		tableForo.setBounds(0, 45, 344, 362);
		contentPane.add(tableForo);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 0, 46, 14);
		contentPane.add(label);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HiloMensaje nuevoHilo = new HiloMensaje();
				nuevoHilo.setVisible(true);
			}
		});
		btnCrear.setBounds(245, 11, 89, 23);
		contentPane.add(btnCrear);
	}
}
