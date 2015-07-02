package presentation;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.*;
import repository.AvionRepository;

public class FrmListadoAviones extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JScrollPane tabla;
	protected JTable tablaDatos;
	protected DefaultTableModel modelo;
	
	 
	
	public void cargarTabla(){
		try {
			//borro todos los reg anteriores
			while(modelo.getRowCount() > 0){
				modelo.removeRow(0);
			}
			
			
			List<Avion> lista2 = new ArrayList<>();
			AvionRepository avionRepository = new AvionRepository();
			
			lista2 = avionRepository.ListadoBase();
			//recorro la tabla
			for(Avion avi : lista2){
				Object[] fila = new Object[4];
				fila[0] = avi.getId();
				fila[1] = avi.getNombre();
				fila[2] = avi.getCapacidad();
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public FrmListadoAviones() throws SQLException  {
		// TODO Auto-generated constructor stub
		this.addWindowListener(new WindowListener(){
            public void windowActivated(WindowEvent e){
            	cargarTabla();
            }
            public void windowClosed(WindowEvent e){}
            public void windowDeactivated(WindowEvent e){}
            public void windowDeiconified(WindowEvent e){}
            public void windowIconified(WindowEvent e){}
            public void windowOpened(WindowEvent e){}
            public void windowClosing(WindowEvent e){
                System.out.println("Cerrando ventana...");
                e.getWindow().dispose();
            }
        });
		
		panel = new JPanel();
		
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		setBounds(50, 50, 800, 520);
		
		modelo = new DefaultTableModel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
				
		};
		List<Avion> lista = new ArrayList<>();
		AvionRepository avionRepository = new AvionRepository();
		lista = avionRepository.ListadoBase();
		
		
		
		//columnas
		modelo.addColumn("ID_AVION");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CAPACIDAD");
		//recorro la tabla
		for(Avion avi : lista){
			Object[] fila = new Object[4];
			fila[0] = avi.getId();
			fila[1] = avi.getNombre();
			fila[2] = avi.getCapacidad();
			modelo.addRow(fila);
		}
		tablaDatos = new JTable(modelo);
		
		tabla = new JScrollPane(tablaDatos);
		tabla.setBounds(10,10, 750, 400);
		
		//agrego todos los elementos al frame
		
		panel.add(tabla);
		
//		JButton btnModificar = new JButton("Modificar");
//		btnModificar.setBounds(30, 430, 90, 25);
//		panel.add(btnModificar);
//		
//		JButton btnEliminar = new JButton("Eliminar");
//		btnEliminar.setBounds(140, 430, 90, 25);
//		panel.add(btnEliminar);
		
//		btnModificar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(tablaDatos.getSelectedRow() > -1){
//					int fila = tablaDatos.getSelectedRow();
//					Avion avi = new Avion();
//					avi.setId((Integer)tablaDatos.getValueAt(fila,0));
//					avi.setNombre((String)tablaDatos.getValueAt(fila,1));
//					avi.setCapacidad((Integer)tablaDatos.getValueAt(fila,2));
//					avi.setMarca((String)tablaDatos.getValueAt(fila,3));
//					
//					FrmModificarAvion formModificar = new FrmModificarAvion(avi);
//					formModificar.setVisible(true);
//					
//				}
//				else{
//					JOptionPane.showMessageDialog(FrmListadoAviones.this, "Debe seleccionar un elemento de la lista");
//					
//				}
//			}
//		});
//		
//		btnEliminar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(tablaDatos.getSelectedRow() > -1){
//					int fila = tablaDatos.getSelectedRow();
//					Avion avi = new Avion();
//					avi.setId((Integer)tablaDatos.getValueAt(fila,0));
//					avi.setNombre((String)tablaDatos.getValueAt(fila,1));
//					avi.setCapacidad((Integer)tablaDatos.getValueAt(fila,2));
//					avi.setMarca((String)tablaDatos.getValueAt(fila,3));
//					
//					int i =JOptionPane.showConfirmDialog(FrmListadoAviones.this,"¿Realmente quieres eliminar el avion seleccionado?","Confirmar operación",JOptionPane.YES_NO_OPTION);
//		        	if(i==0){
//		        		try {
//		        			nAvion negAvi = new nAvion();
//							negAvi.eliminarAvion(avi);
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//		        	}
//					
//				}
//				else{
//					JOptionPane.showMessageDialog(FrmListadoAviones.this, "Debe seleccionar un elemento de la lista");
//					
//				}
//			}
//		});
		
	}

	

	

}
