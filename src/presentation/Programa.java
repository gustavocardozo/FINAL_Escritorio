package presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import server.Server;
import model.*;

public class Programa {
	public static void main(String[] args) throws SQLException, IOException{
		
		Thread t = new Thread(new Server());
		
		t.start();
		Runnable inicializador = new Runnable() {
			
			@Override
			public void run() {
				FrmMenu form = new FrmMenu();
				form.setVisible(true);
			}
		};
		
		SwingUtilities.invokeLater(inicializador);
		
	}
}