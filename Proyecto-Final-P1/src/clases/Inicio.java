package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enums.Posicion;
import enums.Roles;
import ligaBasketball.Liga;
import ligaBasketball.JugadorFantasy;
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
