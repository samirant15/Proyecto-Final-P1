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
import ui.HiloMensaje;
import ui.pruebaChatInicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Foro extends JFrame {

	private JPanel contentPane;
	private JTable tableForo;
	private ArrayList<Hilo>hilos = new ArrayList<Hilo>();
	private DefaultTableModel tableModel = new DefaultTableModel( new String[] {"Títutlo", "Usuario"},0);

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Foro() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				MainJFrame.iniciarCliente("localhost");
				try {
					MainJFrame.server.enviarHilos();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pruebaChatInicio.cliente.leerMSG() != null){
					hilos = MainJFrame.cliente.leerMSG();
					llenar();
				}
			}
		});
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableForo = new JTable(tableModel);
		tableForo.getColumnModel().getColumn(0).setPreferredWidth(530);
		tableForo.getColumnModel().getColumn(0).setMinWidth(10);
		tableForo.setCellSelectionEnabled(true);
		tableForo.setBounds(0, 61, 344, 346);
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
	private void llenar(){
		tableModel.setRowCount(0);
		for (Hilo h : hilos) {
			tableModel.addRow(new Object[]{h.getTitulo(), h.getTitulo()});
			System.out.println(h.getTitulo() + "" + h.getTitulo());
		}
	}
}
