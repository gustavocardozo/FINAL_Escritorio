package presentation;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;

import model.*;
import repository.ClienteRepository;


public class FrmAgregarCliente extends JFrame {
	private JPanel panel;
	public static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	public FrmAgregarCliente(){
		
		//Pantalla
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		setBounds(100, 100, 400, 350);
		setResizable(false);
		setTitle("Agregar Cliente");
		
		//Contenido del Form
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(30, 30, 200, 20);
		panel.add(lblNombre);
		
		final JTextField textNombre = new JTextField();
		textNombre.setBounds(200, 30,150,20);
		panel.add(textNombre);
		
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(30,60, 200, 20);
		panel.add(lblApellido);
		
		final JTextField textApellido = new JTextField();
		textApellido.setBounds(200, 60,150,20);
		panel.add(textApellido);
		
		JLabel lblDni = new JLabel("Dni: ");
		lblDni.setBounds(30,90, 200, 20);
		panel.add(lblDni);
		
		final JTextField textDni = new JTextField();
		textDni.setBounds(200, 90,150,20);
		
		textDni.addKeyListener(new KeyAdapter()
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
		panel.add(textDni);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nacimiento: ");
		lblFechaNac.setBounds(30,120, 200, 20);
		panel.add(lblFechaNac);
		
		
		final JTextField textFechaDia = new JTextField();
		textFechaDia.setBounds(200, 120,30,20);
		textFechaDia.addKeyListener(new KeyAdapter()
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
		panel.add(textFechaDia);
		
		JLabel lblFechaNacBarra = new JLabel("/");
		lblFechaNacBarra.setBounds(240,120, 30, 20);
		panel.add(lblFechaNacBarra);
		
		final JTextField textFechaMes = new JTextField();
		textFechaMes.setBounds(250, 120,30,20);
		textFechaMes.addKeyListener(new KeyAdapter()
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
		panel.add(textFechaMes);
		
		JLabel lblFechaNacBarra2 = new JLabel("/");
		lblFechaNacBarra2.setBounds(290,120, 30, 20);
		panel.add(lblFechaNacBarra2);
		
		final JTextField textFechaAnio = new JTextField();
		textFechaAnio.setBounds(300, 120,35,20);
		textFechaAnio.addKeyListener(new KeyAdapter()
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
		panel.add(textFechaAnio);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(30,150, 200, 20);
		panel.add(lblEmail);
		
		final JTextField textEmail = new JTextField();
		textEmail.setBounds(200, 150,150,20);
		panel.add(textEmail);
		
		JLabel lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setBounds(30,180, 200, 20);
		panel.add(lblDireccion);
		
		final JTextField textDireccion = new JTextField();
		textDireccion.setBounds(200, 180,150,20);
		panel.add(textDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(30,210, 200, 20);
		panel.add(lblTelefono);
		
		final JTextField textTelefono = new JTextField();
		textTelefono.setBounds(200, 210,150,20);
		textTelefono.addKeyListener(new KeyAdapter()
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
		panel.add(textTelefono);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(50, 250, 90, 25);
		panel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(180, 250, 90, 25);
		panel.add(btnCancelar);	
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAgregarCliente.this.dispose();	
			}
			
		});
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(validarForm()){
					
						ClienteRepository clienteRepository = new ClienteRepository();
						Cliente cliente = new Cliente();
						
						cliente.setId(clienteRepository.GetIdBase());
						cliente.setApellido(textApellido.getText());
						cliente.setDireccion(textDireccion.getText());
						cliente.setDni(textDni.getText());
						cliente.setEmail(textEmail.getText());
						cliente.setTelefono(textTelefono.getText());
						
						SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
						Date fecha = new Date();
						fecha = formatoFecha.parse(textFechaAnio.getText()+"-"+textFechaMes.getText()+"-"+textFechaDia.getText());
						cliente.setFecha_nacimiento(fecha);
						cliente.setNombre(textNombre.getText());
		
						if(clienteRepository.InsertarBase(cliente))
						{
							JOptionPane.showMessageDialog(FrmAgregarCliente.this, "Se agrego correctamente");
							FrmAgregarCliente.this.dispose();
						}
					
					}
				} catch ( ParseException | HeadlessException  e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					
					
				}
				
			}

			@SuppressWarnings("deprecation")
			private boolean validarForm() {
				// TODO Auto-generated method stub
				ArrayList<String> errores = new ArrayList();
				
				//falta validar numerico
				
				
				if(textNombre.getText().trim().length() <= 0){
					errores.add("Debe ingresar un nombre");
				}else if (!(textNombre.getText().trim().length() <= 40)){
					errores.add("Maximo de 40 caracteres para nombre");
				}
				
				if(textApellido.getText().trim().length() <= 0){
					errores.add("Debe ingresar un apellido");
				}else if (!(textApellido.getText().trim().length() <= 40)){
					errores.add("Maximo de 40 caracteres para apellido");
				}
				
				if(textDireccion.getText().trim().length() <= 0){
					errores.add("Debe ingresar una dirección");
				}else if (!(textDireccion.getText().trim().length() <= 40)){
					errores.add("Maximo de 50 caracteres para una dirección");
				}
				
				if(textDni.getText().trim().length() <= 0){
					errores.add("Debe ingresar un dni");
				}else if (!(textDni.getText().trim().length() <= 10)){
					errores.add("Maximo de 10 caracteres para un Dni");
				}
				
				if(textEmail.getText().trim().length() <= 0){
					errores.add("Debe ingresar un email");
				}else if (!(textEmail.getText().trim().length() <= 50)){
					errores.add("Maximo de 50 caracteres para un email");
				}
				
				
				if(textTelefono.getText().trim().length() <= 0){
					errores.add("Debe ingresar un telefono");
				}else if (!(textTelefono.getText().trim().length() <= 30)){
					errores.add("Maximo de 30 caracteres para un telefono");
				}
				
				if(textFechaAnio.getText().trim().length() <= 0){
					errores.add("Debe ingresar un ano en la fecha de nacimiento");
				}else if (!(textFechaAnio.getText().trim().length() <= 4)){
					errores.add("Maximo de 4 caracteres para el año de nacimiento");
				}
				
				if(textFechaMes.getText().trim().length() <= 0){
					errores.add("Debe ingresar un mes en la fecha de nacimiento");
				}else if (!(textFechaMes.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para el mes de nacimiento");
				}
				
				if(textFechaDia.getText().trim().length() <= 0){
					errores.add("Debe ingresar un dia en la fecha de nacimiento");
				}else if (!(textFechaDia.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para el dia de nacimiento");
				}
				if(!isFechaValida(textFechaDia.getText().trim()+"/"+textFechaMes.getText().trim()+"/"+textFechaAnio.getText().trim()))
					errores.add("Ingrese una fecha válida");
				
				if(errores.size() > 0){
					String msjError="";
					
					for(String e : errores)
					{
						msjError = msjError + e.toString() + "\n";
						
					}
					
					JOptionPane.showMessageDialog(FrmAgregarCliente.this, msjError);
					
				}else{
					return true;
				}
				return false;
			}

			
		});
	}
}
