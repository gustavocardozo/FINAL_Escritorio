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
import repository.DestinoRepository;
import repository.PaqueteRepository;
import repository.VueloRepository;


public class FrmAgregarPaquete extends JFrame implements ActionListener{
	protected JPanel AgregarPaquete;
	protected JMenuBar bMenu;
	protected JMenu menu;
	protected JMenuItem listadoClientes;
	protected JMenuItem agregarPaquetes;
	
	public FrmAgregarPaquete(){
		VueloRepository vueloRepository = new VueloRepository();
		DestinoRepository destinoRepositoty = new DestinoRepository();
		
		AgregarPaquete = new JPanel();
		getContentPane().add(AgregarPaquete);
		AgregarPaquete.setLayout(null);
		setBounds(100, 100, 310,300);
		
		setResizable(false);
		setTitle("Agregar paquete");
		
		final JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(20, 20, 110, 15);
		AgregarPaquete.add(lblPrecio);
		
		final JTextField textPrecio = new JTextField(8);
		textPrecio.setBounds(110, 20, 170, 20);
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
		textNombre.setBounds(110, 50, 170, 20);
		AgregarPaquete.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(20, 80, 110, 15);
		AgregarPaquete.add(lblDesde);
		
		final JComboBox comboDesde = new JComboBox(destinoRepositoty.ListadoBase().toArray());
		comboDesde.setBounds(110, 80, 170, 20);
		AgregarPaquete.add(comboDesde);
		
		
		JLabel lblHacia = new JLabel("Hacia: ");
		lblHacia.setBounds(20, 110, 110, 15);
		AgregarPaquete.add(lblHacia);
		
		final JComboBox comboHacia = new JComboBox(destinoRepositoty.ListadoBase().toArray());
		comboHacia.setBounds(110, 110, 170, 20);
		AgregarPaquete.add(comboHacia);
		
		
		JLabel lblCant = new JLabel("Personas: ");
		lblCant.setBounds(20, 140, 110, 15);
		AgregarPaquete.add(lblCant);
		
		final JTextField textCant = new JTextField(10);
		textCant.setBounds(110, 140, 170, 20);
		AgregarPaquete.add(textCant);
		textCant.setColumns(10);
		
		textCant.addKeyListener(new KeyAdapter()
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
		
		JLabel lblDescr = new JLabel("Descripcion: ");
		lblDescr.setBounds(20, 170, 110, 15);
		AgregarPaquete.add(lblDescr);
		
		final JTextField textDescr = new JTextField(10);
		textDescr.setBounds(110, 170, 170, 20);
		AgregarPaquete.add(textDescr);
		textDescr.setColumns(10);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(50, 220, 90, 25);
		AgregarPaquete.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(160, 220, 90, 25);
		AgregarPaquete.add(btnCancelar);	
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(validarForm()){
						PaqueteRepository paqueteRepository = new PaqueteRepository();
						Paquete paquete = new Paquete();
						//Vuelo vuelo = new Vuelo();
						
						paquete.setId(paqueteRepository.GetID());
						paquete.setNombre(textNombre.getText());
						paquete.setPrecio(Float.parseFloat(textPrecio.getText()));
						paquete.setCantidadPersonas(Integer.parseInt(textCant.getText()));
						
						String identificadorDesde = comboDesde.getSelectedItem().toString().substring(comboDesde.getSelectedItem().toString().lastIndexOf(";")+1,comboDesde.getSelectedItem().toString().length());
						String identificadorHacia = comboHacia.getSelectedItem().toString().substring(comboHacia.getSelectedItem().toString().lastIndexOf(";")+1,comboHacia.getSelectedItem().toString().length());
						
						Integer idDesde = Integer.parseInt(identificadorDesde);
						Integer idHacia = Integer.parseInt(identificadorHacia);
						paquete.setDesde(destinoRepositoty.GetByIdBase(idDesde));
						paquete.setHacia(destinoRepositoty.GetByIdBase(idHacia));
						paquete.setDescripcion(textDescr.getText().trim());
						if(paqueteRepository.InsertarArchivo(paquete))
						{
							JOptionPane.showMessageDialog(FrmAgregarPaquete.this, "Se agrego correctamente");
							System.out.print("SE GRABO SUPUESTAMENTE");
							FrmAgregarPaquete.this.dispose();
						}else{
							JOptionPane.showMessageDialog(FrmAgregarPaquete.this, "Hubo un error en su solicitud, intente nuevamente mas tarde.");
							FrmAgregarPaquete.this.dispose();
						}
						
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
				
				if(comboDesde.getSelectedIndex() < 0)
					errores.add("Debe seleccionar un destino de partida");
				
				if(comboHacia.getSelectedIndex() < 0)
					errores.add("Debe seleccionar un destino de llegada");
				
				if(comboHacia.getSelectedIndex() == comboDesde.getSelectedIndex())
					errores.add("Los destinos son iguales");
				
				if(textPrecio.getText().trim().length() <= 0){
					errores.add("Debe ingresar un precio");
				}else if (!(textPrecio.getText().trim().length() <= 8)){
					errores.add("Maximo de 8 caracteres para precio");
				}
				
				if(textNombre.getText().trim().length() <= 0){
					errores.add("Debe ingresar un nombre");
				}else if (!(textNombre.getText().trim().length() <= 50)){
					errores.add("Maximo de 50 caracteres para nombre");
				}
				
				if(textCant.getText().trim().length() <= 0){
					errores.add("Debe ingresar una cantidad");
				}else if (!(textCant.getText().trim().length() <= 3)){
					errores.add("Maximo de 3 caracteres para una cantidad");
				}
				
				if(textDescr.getText().trim().length() <= 0){
					errores.add("Debe ingresar una descripcion");
				}else if (!(textDescr.getText().trim().length() <= 100)){
					errores.add("Maximo de 100 caracteres para una descripcion");
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