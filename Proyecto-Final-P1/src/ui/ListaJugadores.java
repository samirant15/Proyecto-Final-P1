package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import ligaBasketball.Liga;
import ligaBasketball.Jugador;


import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaJugadores extends JDialog {
    final Liga liga = Liga.getInstance(); 
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private static JButton btnModificar;
	JComboBox cbxPublicType;

	/**
	 * Create the dialog.
	 */
	
	
	
	
	public ListaJugadores() {
		setTitle("Lista de players"); 
		setBounds(100, 100, 621, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Lista de jugadores", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de players", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
			panel.setBounds(0, 0, 605, 419);
			contentPanel.add(panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 26, 976, 393);
				panel.add(scrollPane);
				{
					table = new JTable();
					//TODO mouse listener 
					tableModel = new DefaultTableModel();
					String[] columnNames = {"Nombre","Número", "Posición","Anotaciones","Asistencias", "Rebotes"};
					tableModel.setColumnIdentifiers(columnNames);
					loadplayers();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton btnVender = new JButton("aceptar");
					btnVender.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						
						}
					});
					buttonPane.add(btnVender);
				}
			}
		}
	}

	
	
	private void loadplayers() {

		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Jugador player : liga.getJugadores()){
			fila[0] = player.getNombre(); 
			fila[1] = player.getNumero(); 
			fila[2] = player.getPosicion(); 
			fila[3] = player.getAnotaciones(); 
			fila[4] = player.getAsistencias() ; 
			fila[5] = player.getRebotes();
		
			
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(2).setPreferredWidth(110);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(80);
		columnModel.getColumn(5).setPreferredWidth(100);
		
	}

}
