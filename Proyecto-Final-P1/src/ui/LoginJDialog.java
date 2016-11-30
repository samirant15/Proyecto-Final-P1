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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginJDialog dialog = new LoginJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginJDialog() {
		setTitle("Soccer Chat");
		setBounds(100, 100, 542, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username o Email:");
		lblUsername.setBounds(58, 137, 113, 45);
		contentPanel.add(lblUsername);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(58, 195, 113, 28);
		contentPanel.add(lblContrasea);
		
		txtUserEmail = new JTextField();
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
						String auxPassword = txtPasswordField.getText();
						int posUser = 0;
						if(liga.posUsuarioPorEmail(auxUser)>0){
							posUser = liga.posUsuarioPorEmail(auxUser); 
							findUser = true; 
						}
						if(liga.posUsuarioPorUserName(auxUser)>0){
							posUser = liga.posUsuarioPorUserName(auxUser);
							findUser = true; 
						}
						if(findUser == true){
							if(liga.confirmarPassword(auxPassword, posUser) == true){
								 findPassword = true; 
							}
						}
						if(findUser == false || findPassword == false){
							JOptionPane.showInternalMessageDialog(null, "El usuario o contraseña que ha ingresado no es correcto", "Error", ERROR);
						}else if(findUser == true && findPassword == true){
							if(liga.getUsuario(posUser).getRol() == Roles.Administrador){
								//TODO Frame Principal
				                MainJFrame mainFrame = new MainJFrame();
				                mainFrame.setVisible(true);
				                mainFrame.setLocationRelativeTo(null);
				                mainFrame.setPosUser(posUser);
							}
							dispose();
						}
					}
				});
				okButton.setActionCommand("Login");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
