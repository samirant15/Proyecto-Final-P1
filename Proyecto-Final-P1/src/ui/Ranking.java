package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.CreacionPartido;
import ui.InsertarEquipo;
import ui.InsertarJugador;
import ui.Ranking;

import javax.swing.JList;

import ligaBasketball.Equipo;
import ligaBasketball.Liga;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ranking extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ranking dialog = new Ranking();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ranking() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(94, 34, 219, 147);
		contentPanel.add(list);
		{
			
			ArrayList <Integer> puntos = new ArrayList <Integer>();
			ArrayList <String> rankingF = new ArrayList <String>();
			
			
			for(Equipo e : Liga.getInstance().getEquipos()){
				puntos.add(e.getPartidosGanados());
				System.out.println(e);
			}
			
			Collections.sort(puntos);
			Collections.reverse(puntos);
			
			for(Integer i : puntos){
				for(Equipo eq :  Liga.getInstance().getEquipos()){
					if(eq.getPartidosGanados() == i){
						rankingF.add(i.toString() + " " + eq.getNombre() );
					}
				}
			}
			
			
			
			list.setListData(rankingF.toArray());
			
		}
		{
			JButton button = new JButton("Partido");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					CreacionPartido partido = new CreacionPartido();
					partido.setVisible(true);	
					setVisible(false);
					
				}
			});
			button.setBounds(335, 0, 97, 25);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Equipos");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					InsertarEquipo equipo = new InsertarEquipo();
					equipo.setVisible(true);
					setVisible(false);
					
				}
			});
			button.setBounds(335, 26, 97, 25);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Jugadores");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					InsertarJugador jugador = new InsertarJugador();
					jugador.setVisible(true);
					setVisible(false);
					
				}
			});
			button.setBounds(335, 52, 97, 25);
			contentPanel.add(button);
		}
	}
}
