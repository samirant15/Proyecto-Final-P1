package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Roles;
import ligaBasketball.Liga;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class RegistrarUsuarioAdminJDialog extends JDialog {
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmarPass;

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuarioAdminJDialog() {
		Liga liga = Liga.getInstance();
		setTitle("Registrar Usuario administrador");
		setBounds(100, 100, 601, 417);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 583, 394);
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel);
			{
				JLabel label = new JLabel("Nombre: ");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(29, 101, 185, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Email:");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(29, 143, 185, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Usuario:");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(29, 185, 185, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Contrase\u00F1a:");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(29, 227, 185, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Confirmar Contrase\u00F1a:");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(29, 269, 185, 16);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(238, 99, 265, 22);
				panel.add(txtNombre);
			}
			{
				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(238, 141, 265, 22);
				panel.add(txtEmail);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setColumns(10);
				txtUsuario.setBounds(238, 183, 265, 22);
				panel.add(txtUsuario);
			}
			{
				txtPassword = new JPasswordField();
				txtPassword.setBounds(238, 225, 265, 22);
				panel.add(txtPassword);
			}
			{
				txtConfirmarPass = new JPasswordField();
				txtConfirmarPass.setText("");
				txtConfirmarPass.setBounds(238, 267, 265, 22);
				panel.add(txtConfirmarPass);
			}
			{
				JLabel lblRegistrarUsuarioAdministrador = new JLabel("Registrar Usuario Administrador\r\n");
				lblRegistrarUsuarioAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
				lblRegistrarUsuarioAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblRegistrarUsuarioAdministrador.setBounds(153, 13, 265, 54);
				panel.add(lblRegistrarUsuarioAdministrador);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(12, 76, 534, 2);
				panel.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(12, 308, 534, 2);
				panel.add(separator);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 323, 583, 35);
				panel.add(buttonPane);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton okButton = new JButton("Registrar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String nombre = txtNombre.getText();
							String username = txtUsuario.getText();
							String email = txtEmail.getText(); 
							String contrasena = String.valueOf(txtPassword.getPassword()); 
							String intentoClave = String.valueOf(txtConfirmarPass.getPassword()); 
							liga.addUsuario(email, contrasena, username, nombre,Roles.Administrador);
							liga.imprimirUsuarios();
							try {
								liga.escribirBinario();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    clear();
						    dispose();
						}
					});
					okButton.setActionCommand("OK");
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
	}
    public void clear(){
    	txtNombre.setText("");
    	txtUsuario.setText("");
    	txtEmail.setText("");
    	txtPassword.setText("");
    	txtConfirmarPass.setText("");
    }
}
