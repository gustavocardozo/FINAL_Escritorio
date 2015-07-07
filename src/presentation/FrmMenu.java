package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import presentation.*;



public class FrmMenu extends JFrame  implements ActionListener {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar mb;
	 private JMenu mClientes, mPqtTuristico, mMigrar, mAviones, mVuelos;
	 private JMenuItem jmListadoClientes, jmAltaPaquetes,jmAltaVuelos, jmSalir, jmAltaClientes, jmListadoAviones, jmMigrarClientes, jmMigrarPaquetes;
	    
	   	
	    public FrmMenu() {
	    	setLayout(null);
	       	setBounds(100, 100, 800, 600);
	       	setDefaultCloseOperation(EXIT_ON_CLOSE);
	       	
	       	mb=new JMenuBar();
	        setJMenuBar(mb);	       
	        setTitle("Sistema de vuelos");	
	        setResizable(false);
	        mClientes=new JMenu("Clientes");
	        mb.add(mClientes);
	        
	        jmListadoClientes=new JMenuItem("Listado Clientes");
	        mClientes.add(jmListadoClientes);
	        jmListadoClientes.addActionListener(this);
	        
	        jmAltaClientes=new JMenuItem("Alta Clientes");
	        mClientes.add(jmAltaClientes);
	        jmAltaClientes.addActionListener(this);
	        
	        mAviones=new JMenu("Aviones");
	        mb.add(mAviones);
	        
	        jmListadoAviones=new JMenuItem("Listado de aviones");
	        mAviones.add(jmListadoAviones);
	        jmListadoAviones.addActionListener(this);
	        
	        mPqtTuristico=new JMenu("Paquetes");
	        mb.add(mPqtTuristico);
	        
	        jmAltaPaquetes=new JMenuItem("Agregar paquetes");
	        mPqtTuristico.add(jmAltaPaquetes);
	        jmAltaPaquetes.addActionListener(this);
	        
	        mVuelos=new JMenu("Vuelos");
	        mb.add(mVuelos);
	        
	        jmAltaVuelos = new JMenuItem("Agregar vuelo");
	        mVuelos.add(jmAltaVuelos);
	        jmAltaVuelos.addActionListener(this);
	        
	        mMigrar=new JMenu("Migrar");
	        mb.add(mMigrar);
	        
	        
	        
	        jmMigrarClientes = new JMenuItem("Migrar Clientes");
	        mMigrar.add(jmMigrarClientes);
	        jmMigrarClientes.addActionListener(this);
	        
	        jmMigrarPaquetes = new JMenuItem("Migrar Paquetes");
	        mMigrar.add(jmMigrarPaquetes);
	        jmMigrarPaquetes.addActionListener(this);
	        
	        
	        jmSalir=new JMenuItem("Salir");
	        mb.add(jmSalir);
	        jmSalir.addActionListener(this);
	        
	        
	        
	        jmListadoClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Menu.setVisible(false);
					//ListadoClientes.setVisible(true);
					FrmListadoClientes FormCliente = new FrmListadoClientes();
					FormCliente.setVisible(true);
				}
			});
	        jmAltaClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Menu.setVisible(false);
					//ListadoClientes.setVisible(true);
					FrmAgregarCliente FormAgregarCliente = new FrmAgregarCliente();
					FormAgregarCliente.setVisible(true);
				}
			});
	        
	        jmAltaPaquetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Menu.setVisible(false);
					//AgregarPaquete.setVisible(true);
					FrmAgregarPaquete FormAddPackage = new FrmAgregarPaquete();
					FormAddPackage.setVisible(true);
				}
			});
	        
	        jmAltaVuelos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Menu.setVisible(false);
					//AgregarPaquete.setVisible(true);
					FrmAgregarVuelo FormAddPackage = new FrmAgregarVuelo();
					FormAddPackage.setVisible(true);
				}
			});
	        
	        jmListadoAviones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Menu.setVisible(false);
					//ListadoClientes.setVisible(true);
					FrmListadoAviones FormAviones = null;
					try {
						FormAviones = new FrmListadoAviones();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					FormAviones.setVisible(true);
				}
			});
	        jmMigrarClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(new FrmMigrarClientes());
					t.start();
				}
			});
	        
	        jmMigrarPaquetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(new FrmMigrarPaquetes());
					t.start();
				}
			});
	        
	        jmSalir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
		        	int i =JOptionPane.showConfirmDialog(FrmMenu.this,"¿Realmente Desea Salir?","Confirmar Salida",JOptionPane.YES_NO_OPTION);
		        	if(i==0){
		        	System.exit(0);
		        	}
	        	}
			});
	        
	        
	        
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		
}