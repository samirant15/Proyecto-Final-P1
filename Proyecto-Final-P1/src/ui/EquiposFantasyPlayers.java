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
import ligaBasketball.EquipoFantasy;
import ligaBasketball.Jugador;


import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquiposFantasyPlayers extends JDialog {
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
	
	
	
	
	public EquiposFantasyPlayers() {
		setTitle("Lista de equipos fantasy"); 
		setBounds(100, 100, 515, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Lista de Equipos Fantasy", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de equipofancys", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
			panel.setBounds(0, 0, 506, 370);
			contentPanel.add(panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 26, 494, 344);
				panel.add(scrollPane);
				{
					table = new JTable();
					//TODO mouse listener 
					tableModel = new DefaultTableModel();
					String[] columnNames = {"ID","Nombre","Partidas Ganadas", "Partidas Perdidas"};
					tableModel.setColumnIdentifiers(columnNames);
					loadequipofancys();
					scrollPane.setViewportView(table);
				}
			}
		}
	}

	
	
	private void loadequipofancys() {

		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		int i=0;
		for (EquipoFantasy equipofancy : liga.getEquiposfantasy()){
			fila[0] = i++; 
			fila[1] = equipofancy.getNombre(); 
			fila[2] = equipofancy.getPartidosGanados(); 
			fila[3] = equipofancy.getPartidasPerdidas(); 


			
			tableModel.addRow(fila);
		}
		
		for(int i1=0; i1<Liga.getInstance().getEquiposfantasy().get(1).getJugadoresfantasy().size(); i1++){
			fila[0] = i++; 
			fila[1] = Liga.getInstance().getEquiposfantasy().get(1).getJugadoresfantasy().get(i1).getNombre(); 
			//fila[2] = equipofancy.getPartidosGanados(); 
			//fila[3] = equipofancy.getPartidasPerdidas(); 
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(2).setPreferredWidth(110);
		columnModel.getColumn(3).setPreferredWidth(110);


		
	}

}
