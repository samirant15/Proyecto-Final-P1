package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Roles;
import ligaBasketball.Liga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserEmail;
    Liga liga = Liga.getInstance(); 
    private JPasswordField txtPasswordField;
	/**
	 * Create the dialog.
	 */
	public LoginJDialog() {
		setTitle("Soccer Chat login");
		setBounds(100, 100, 542, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username \r\no Email:");
		lblUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblUsername.setBounds(27, 131, 149, 51);
		contentPanel.add(lblUsername);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(37, 194, 113, 28);
		contentPanel.add(lblContrasea);
		
		txtUserEmail = new JTextField();
		lblUsername.setLabelFor(txtUserEmail);
		txtUserEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtUserEmail.setBounds(179, 148, 234, 22);
		contentPanel.add(txtUserEmail);
		txtUserEmail.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(197, 107, 82, 28);
		contentPanel.add(lblLogin);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(179, 198, 234, 22);
		contentPanel.add(txtPasswordField);
		
		JLabel lblPuedeRegistrarseAqui = new JLabel("Puede registrarse aqui! como visitante. ");
		lblPuedeRegistrarseAqui.setBounds(179, 274, 234, 16);
		contentPanel.add(lblPuedeRegistrarseAqui);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuarioJDialog registrarUsuarioVisitante = new RegistrarUsuarioJDialog();
				registrarUsuarioVisitante.setVisible(true);
				registrarUsuarioVisitante.setLocation(null);
			}
		});
		btnRegistrarse.setBounds(415, 270, 97, 25);
		contentPanel.add(btnRegistrarse);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
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
				
				JButton btnRegistrarAdmin = new JButton("Registrar Admin");
				btnRegistrarAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO quitar esta opcion
						RegistrarUsuarioAdminJDialog registrarUsuarioAdmin = new RegistrarUsuarioAdminJDialog();
						registrarUsuarioAdmin.setVisible(true);
						registrarUsuarioAdmin.setLocationRelativeTo(null);
					}
				});
				buttonPane.add(btnRegistrarAdmin);
				okButton.setActionCommand("Login");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void clear(){
		txtUserEmail.setText("");
		txtPasswordField.setText("");
	}
}
