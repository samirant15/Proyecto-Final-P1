package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JMenu;

public class ChatFrame extends JFrame {
	private JTextField chatTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		setBounds(100, 100, 800, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		chatTextField = new JTextField();
		chatTextField.setFont(new Font("Calibri Light", Font.BOLD, 14));
		chatTextField.setBounds(204, 564, 461, 36);
		getContentPane().add(chatTextField);
		chatTextField.setColumns(10);
		
		JButton btnEnviarButton = new JButton("Enviar");
		btnEnviarButton.setFont(new Font("Calibri Light", Font.BOLD, 24));
		btnEnviarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 782, 31);
		getContentPane().add(menuBar);
		
		JMenu mnS = new JMenu("           Ver              ");
		menuBar.add(mnS);
		btnEnviarButton.setBounds(673, 564, 97, 36);
		getContentPane().add(btnEnviarButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(204, 41, 566, 510);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea messageTextArea = new JTextArea();
		messageTextArea.setBounds(0, 0, 566, 510);
		panel.add(messageTextArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 44, 180, 556);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(178, 0, -174, 556);
		panel_1.add(list);

	}
}
