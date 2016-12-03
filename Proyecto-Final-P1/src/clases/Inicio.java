package clases;

import java.io.IOException;

import enums.Roles;
import ligaBasketball.Liga;
import ui.LoginJDialog;

public class Inicio {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	    Liga.getInstance().imprimirUsuarios();
	    Liga.getInstance().leerBinario();
        LoginJDialog login = new LoginJDialog();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        Liga.getInstance().imprimirUsuarios();
        
	}

}
