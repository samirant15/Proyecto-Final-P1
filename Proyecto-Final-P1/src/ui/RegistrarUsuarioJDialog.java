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

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuarioJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JPasswordField txtPasswordDefinitiva;
	private JPasswordField txtPasswordConfirmar;
	Liga liga = Liga.getInstance(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuarioJDialog dialog = new RegistrarUsuarioJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuarioJDialog() {
		setTitle("Registrar usuario");
		setBounds(100, 100, 576, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(29, 101, 185, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(29, 143, 185, 16);
		contentPanel.add(lblEmail);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(29, 185, 185, 16);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(29, 227, 185, 16);
		contentPanel.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmarContrasea.setBounds(29, 269, 185, 16);
		contentPanel.add(lblConfirmarContrasea);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(238, 99, 265, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(238, 141, 265, 22);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(238, 183, 265, 22);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPasswordDefinitiva = new JPasswordField();
		txtPasswordDefinitiva.setBounds(238, 225, 265, 22);
		contentPanel.add(txtPasswordDefinitiva);
		
		txtPasswordConfirmar = new JPasswordField();
		txtPasswordConfirmar.setText("");
		txtPasswordConfirmar.setBounds(238, 267, 265, 22);
		contentPanel.add(txtPasswordConfirmar);
		
		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUsuario.setBounds(153, 13, 237, 54);
		contentPanel.add(lblRegistrarUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 76, 534, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 308, 534, 2);
		contentPanel.add(separator_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombre.getText();
						String username = txtUsuario.getText();
						String email = txtEmail.getText(); 
						String contrasena = String.valueOf(txtPasswordDefinitiva.getPassword());; 
						String intentoClave = String.valueOf(txtPasswordConfirmar.getPassword());; 
						liga.addUsuarioV(email, contrasena, username, nombre);
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
