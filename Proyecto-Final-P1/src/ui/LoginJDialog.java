package ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ligaBasketball.Liga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class LoginJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserEmail;
    Liga liga = Liga.getInstance(); 
    private JPasswordField txtPasswordField;
	/**
	 * Create the dialog.
	 */
	public LoginJDialog() {
		setTitle("Chat login");
		setBounds(100, 100, 540, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(58, 97, 408, 123);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(10, 11, 40, 40);
		panel.add(lblUsername);
		lblUsername.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_user.png"));
		lblUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		JLabel lblContrasea = new JLabel("");
		lblContrasea.setBounds(10, 62, 40, 40);
		panel.add(lblContrasea);
		lblContrasea.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_1pass.png"));
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setLabelFor(txtUserEmail);
		
		txtUserEmail = new JTextField();
		txtUserEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUserEmail.setForeground(Color.WHITE);
		txtUserEmail.setBackground(Color.DARK_GRAY);
		txtUserEmail.setBounds(60, 11, 234, 40);
		panel.add(txtUserEmail);
		txtUserEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtUserEmail.setColumns(10);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPasswordField.setForeground(Color.WHITE);
		txtPasswordField.setBackground(Color.DARK_GRAY);
		txtPasswordField.setBounds(60, 62, 234, 40);
		panel.add(txtPasswordField);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean findUser = false, findPassword = false ; 
				
				String auxUser = txtUserEmail.getText() ; 
				String auxPassword =  String.valueOf(txtPasswordField.getPassword());
				int posUser = -1;
				if(liga.posUsuarioPorEmail(auxUser)>0){
					posUser = liga.posUsuarioPorEmail(auxUser); 
					findUser = true; 
					System.out.println("Encontro email");
				}
				if(liga.posUsuarioPorUserName(auxUser)>0){
					posUser = liga.posUsuarioPorUserName(auxUser);
					findUser = true; 
					System.out.println("Encontro usuario " + liga.getUsuario(posUser).getContrasena() + "  " + auxPassword);
				}
				if(findUser == true){
					if(liga.confirmarPassword(auxPassword, posUser) == true){
						 findPassword = true; 
						 System.out.println("Encontro password");
						 try {
								String ip = InetAddress.getLocalHost().toString();
								liga.getUsuario(posUser).setIpAdress(ip);
								liga.imprimirIp(posUser);
							} catch (UnknownHostException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					}
				}
				if((findUser == false && findPassword == false)||(findUser == true && findPassword == false)){
					JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario o la contraseña no es correcta","Error en login", JOptionPane.ERROR_MESSAGE);
					clear();
				}else if(findUser == true && findPassword == true){	
						//TODO Frame Principal
		                MainJFrame mainFrame = null;
						mainFrame = new MainJFrame();
		                mainFrame.setVisible(true);
		                mainFrame.setLocationRelativeTo(null);
		                mainFrame.setPosUser(posUser);
		                dispose();
					}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(304, 11, 91, 91);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_1login.png"));
		
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBackground(Color.DARK_GRAY);
		btnRegistrarse.setIcon(new ImageIcon("Proyecto-Final-P1\\Resources\\rsz_1adduser.png"));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuarioJDialog registrarUsuarioVisitante = new RegistrarUsuarioJDialog();
				registrarUsuarioVisitante.setVisible(true);
				registrarUsuarioVisitante.setLocation(null);
			}
		});
		btnRegistrarse.setBounds(454, 246, 60, 60);
		contentPanel.add(btnRegistrarse);
	}
	public void clear(){
		txtUserEmail.setText("");
		txtPasswordField.setText("");
	}
}