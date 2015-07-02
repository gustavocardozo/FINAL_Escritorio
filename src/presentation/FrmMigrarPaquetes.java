package presentation;

import java.io.EOFException;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import repository.PaqueteRepository;
import model.*;

public class FrmMigrarPaquetes extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JProgressBar barra;
	protected JLabel cantidad;
	protected PaqueteRepository paqueteRepository;
	public FrmMigrarPaquetes()
	{
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		setBounds(100,100,315,170);
		
		cantidad = new JLabel();
		cantidad.setBounds(25, 25, 315, 20);
		
		barra = new JProgressBar();
		barra.setBounds(25,50,250,70);
		panel.add(barra);
		panel.add(cantidad);
		
		paqueteRepository = new PaqueteRepository();
		
		
		this.setVisible(true);
	}

	@Override
	public void run() {
		int proceso=0;
		List<Paquete> paquetes = new ArrayList<>();
		
		paquetes = paqueteRepository.ListadoArchivo();

		
		cantidad.setText(String.valueOf(paquetes.size()));
		barra.setMaximum(paquetes.size());
		
		if(paquetes.size()==0)
		{
			JOptionPane.showMessageDialog(FrmMigrarPaquetes.this, "No hay nada para migrar");
			FrmMigrarPaquetes.this.dispose();
		}
		
		for(Paquete p : paquetes)
		{
			paqueteRepository.InsertarBase(p);
			System.out.println("ANDA");			
			barra.setValue(barra.getValue()+1);
			proceso++;
			cantidad.setText("Progreso: " + proceso + "/"+paquetes.size());
		}
		
		JOptionPane.showMessageDialog(FrmMigrarPaquetes.this, "Se migro correctamente");
		FrmMigrarPaquetes.this.dispose();
		
		
	}
	
	
	
}
