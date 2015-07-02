package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;
import repository.PaqueteRepository;
import repository.VueloRepository;


public class FrmAgregarPaquete extends JFrame implements ActionListener{
	protected JPanel AgregarPaquete;
	protected JMenuBar bMenu;
	protected JMenu menu;
	protected JMenuItem listadoClientes;
	protected JMenuItem agregarPaquetes;
	
	public FrmAgregarPaquete(){
		AgregarPaquete = new JPanel();
		getContentPane().add(AgregarPaquete);
		AgregarPaquete.setLayout(null);
		setBounds(100, 100, 270,450);
		
		setResizable(false);
		setTitle("Agregar paquete");
		
		final JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(20, 20, 110, 15);
		AgregarPaquete.add(lblPrecio);
		
		final JTextField textPrecio = new JTextField(8);
		textPrecio.setBounds(110, 20, 130, 20);
		AgregarPaquete.add(textPrecio);
		textPrecio.setColumns(10);
		textPrecio.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();

		      // Verificar si la tecla pulsada no es un digito
		      if(((caracter < '0') ||
		         (caracter > '9')) &&
		         (caracter != '\b' /*corresponde a BACK_SPACE*/))
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(20, 50, 110, 15);
		AgregarPaquete.add(lblNombre);
		
		final JTextField textNombre = new JTextField(10);
		textNombre.setBounds(110, 50, 130, 20);
		AgregarPaquete.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(20, 80, 110, 15);
		AgregarPaquete.add(lblDesde);
		
		final JTextField textDesde = new JTextField();
		textDesde.setBounds(110, 80, 130, 20);
		AgregarPaquete.add(textDesde);
		textDesde.setColumns(10);
		
		JLabel lblHacia = new JLabel("Hacia: ");
		lblHacia.setBounds(20, 110, 110, 15);
		AgregarPaquete.add(lblHacia);
		
		
		final JTextField textHacia = new JTextField();
		textHacia.setBounds(110, 110, 130, 20);
		AgregarPaquete.add(textHacia);
		textHacia.setColumns(10);
		
		VueloRepository vueloRepository = new VueloRepository();
		
		JLabel lblVuelo = new JLabel("Vuelo: ");
		lblVuelo.setBounds(20, 140, 110, 15);
		AgregarPaquete.add(lblVuelo);
		
		final JComboBox comboVuelo = new JComboBox(vueloRepository.ListadoBase().toArray());
		comboVuelo.setBounds(110, 140, 130, 20);
		AgregarPaquete.add(comboVuelo);
		
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(30, 300, 90, 25);
		AgregarPaquete.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(140, 300, 90, 25);
		AgregarPaquete.add(btnCancelar);	
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(validarForm()){
						PaqueteRepository paqueteRepository = new PaqueteRepository();
						VueloRepository vueloRepository = new VueloRepository();
						Paquete paquete = new Paquete();
						//Vuelo vuelo = new Vuelo();
						
						paquete.setId(paqueteRepository.GetID());
						paquete.setNombre(textNombre.getText());
						paquete.setPrecio(Float.parseFloat(textPrecio.getText()));
						paquete.setCantidadPersonas(1);
						
						String identificador = comboVuelo.getSelectedItem().toString().substring(comboVuelo.getSelectedItem().toString().lastIndexOf(";")+1,comboVuelo.getSelectedItem().toString().length());
						
						Integer id = Integer.parseInt(identificador);
						paquete.setVuelo(vueloRepository.GetByIdBase(id));
						if(paqueteRepository.InsertarArchivo(paquete))
						{
							JOptionPane.showMessageDialog(FrmAgregarPaquete.this, "Se agrego correctamente");
							FrmAgregarPaquete.this.dispose();
						}
						System.out.print("SE GRABO SUPUESTAMENTE");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					
					
				}
				
			}

			private boolean validarForm() {
				// TODO Auto-generated method stub
				ArrayList<String> errores = new ArrayList();
				
				//falta validar numerico
				
				
				if(textPrecio.getText().trim().length() <= 0){
					errores.add("Debe ingresar un precio");
				}else if (!(textPrecio.getText().trim().length() <= 8)){
					errores.add("Maximo de 8 caracteres para precio");
				}
				
				if(textNombre.getText().trim().length() <= 0){
					errores.add("Debe ingresar un nombre");
				}else if (!(textNombre.getText().trim().length() <= 30)){
					errores.add("Maximo de 30 caracteres para nombre");
				}
				
				if(textDesde.getText().trim().length() <= 0){
					errores.add("Debe ingresar un lugar de partida");
				}else if (!(textDesde.getText().trim().length() <= 30)){
					errores.add("Maximo de 30 caracteres para un lugar de partida");
				}
				
				if(textHacia.getText().trim().length() <= 0){
					errores.add("Debe ingresar un lugar de destino");
				}else if (!(textHacia.getText().trim().length() <= 30)){
					errores.add("Maximo de 30 caracteres para un lugar de destino");
				}
				
				
				if(errores.size() > 0){
					String msjError="";
					
					for(String e : errores)
					{
						msjError = msjError + e.toString() + "\n";
						
					}
					
					JOptionPane.showMessageDialog(FrmAgregarPaquete.this, msjError);
					
				}else{
					return true;
				}
				return false;
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAgregarPaquete.this.dispose();	
			}
		});
	}
	

	public void actionPerformed(ActionEvent e) {
        if (e.getSource()==listadoClientes) {
        }
        if (e.getSource()==agregarPaquetes) {
        }
    }

}