package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
import repository.AvionRepository;
import repository.DestinoRepository;
import repository.PaqueteRepository;
import repository.VueloRepository;


public class FrmAgregarVuelo extends JFrame implements ActionListener{
	protected JPanel AgregarPaquete;
	protected JMenuBar bMenu;
	protected JMenu menu;
	protected JMenuItem listadoClientes;
	protected JMenuItem agregarPaquetes;
	public static boolean isFechaValida(String fecha) {
        try {
            Date fechaActual = new Date();
        	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            formatoFecha.setLenient(false);
            Date date = formatoFecha.parse(fecha);
            if(fechaActual.compareTo(date) > 0)
            	return false;
            System.out.println("Pase por aqui");
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	public FrmAgregarVuelo(){
		VueloRepository vueloRepository = new VueloRepository();
		DestinoRepository destinoRepositoty = new DestinoRepository();
		AvionRepository avionRepository = new AvionRepository();
		
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
		
		
		JLabel lblNombre = new JLabel("Avion: ");
		lblNombre.setBounds(20, 50, 110, 15);
		AgregarPaquete.add(lblNombre);
		
		
		final JComboBox comboAvion = new JComboBox(avionRepository.ListadoBase().toArray());
		comboAvion.setBounds(110, 50, 170, 20);
		AgregarPaquete.add(comboAvion);
		
		
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
		
		
		JLabel lblPartida = new JLabel("Partida: ");
		lblPartida.setBounds(20, 140, 110, 15);
		AgregarPaquete.add(lblPartida);
		
		
		final JTextField textFechaDiaPartida = new JTextField();
		textFechaDiaPartida.setBounds(110, 140, 30, 20);
		textFechaDiaPartida.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaDiaPartida);
		
		JLabel lblFechaNacBarraPartida = new JLabel("/");
		lblFechaNacBarraPartida.setBounds(145,140, 30, 20);
		AgregarPaquete.add(lblFechaNacBarraPartida);
		
		final JTextField textFechaMesPartida = new JTextField();
		textFechaMesPartida.setBounds(150,140,30,20);
		textFechaMesPartida.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaMesPartida);
		
		JLabel lblFechaNacBarra2Partida = new JLabel("/");
		lblFechaNacBarra2Partida.setBounds(185,140, 30, 20);
		AgregarPaquete.add(lblFechaNacBarra2Partida);
		
		final JTextField textFechaAnioPartida = new JTextField();
		textFechaAnioPartida.setBounds(190,140,30,20);
		textFechaAnioPartida.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaAnioPartida);
		
		final JTextField textFechaHoraPartida = new JTextField();
		textFechaHoraPartida.setBounds(230,140,30,20);
		textFechaHoraPartida.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaHoraPartida);
		
		JLabel lblFechaNacPuntoPartida = new JLabel(":");
		lblFechaNacPuntoPartida.setBounds(260,140, 30, 20);
		AgregarPaquete.add(lblFechaNacPuntoPartida);
		
		final JTextField textFechaMinutoPartida = new JTextField();
		textFechaMinutoPartida.setBounds(265,140,30,20);
		textFechaMinutoPartida.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaMinutoPartida);
		
		JLabel lblLlegada = new JLabel("Llegada: ");
		lblLlegada.setBounds(20, 170, 110, 15);
		AgregarPaquete.add(lblLlegada);
		
		
		final JTextField textFechaDiaLlegada = new JTextField();
		textFechaDiaLlegada.setBounds(110, 170, 30, 20);
		textFechaDiaLlegada.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaDiaLlegada);
		
		JLabel lblFechaNacBarraLlegada = new JLabel("/");
		lblFechaNacBarraLlegada.setBounds(145,170, 30, 20);
		AgregarPaquete.add(lblFechaNacBarraLlegada);
		
		final JTextField textFechaMesLlegada = new JTextField();
		textFechaMesLlegada.setBounds(150,170,30,20);
		textFechaMesLlegada.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaMesLlegada);
		
		JLabel lblFechaNacBarra2Llegada = new JLabel("/");
		lblFechaNacBarra2Llegada.setBounds(185,170, 30, 20);
		AgregarPaquete.add(lblFechaNacBarra2Llegada);
		
		final JTextField textFechaAnioLlegada = new JTextField();
		textFechaAnioLlegada.setBounds(190,170,30,20);
		textFechaAnioLlegada.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaAnioLlegada);
		
		final JTextField textFechaHoraLlegada = new JTextField();
		textFechaHoraLlegada.setBounds(230,170,30,20);
		textFechaHoraLlegada.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaHoraLlegada);
		
		JLabel lblFechaNacPuntoLlegada = new JLabel(":");
		lblFechaNacPuntoLlegada.setBounds(260,170, 30, 20);
		AgregarPaquete.add(lblFechaNacPuntoLlegada);
		
		final JTextField textFechaMinutoLlegada = new JTextField();
		textFechaMinutoLlegada.setBounds(265,170,30,20);
		textFechaMinutoLlegada.addKeyListener(new KeyAdapter()
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
		AgregarPaquete.add(textFechaMinutoLlegada);
		
		
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
						AvionRepository avionRepository = new AvionRepository();
						DestinoRepository destinoRepository = new DestinoRepository();
						Vuelo vuelo = new Vuelo();
						
						String identificadorAvion = comboAvion.getSelectedItem().toString().substring(comboAvion.getSelectedItem().toString().lastIndexOf(";")+1,comboAvion.getSelectedItem().toString().length());
						Integer idAvion = Integer.parseInt(identificadorAvion);
						vuelo.setAvion(avionRepository.GetByIdBase(idAvion));
						
						String identificadorDesde = comboDesde.getSelectedItem().toString().substring(comboDesde.getSelectedItem().toString().lastIndexOf(";")+1,comboDesde.getSelectedItem().toString().length());
						Integer idDesde = Integer.parseInt(identificadorDesde);
						vuelo.setDesde(destinoRepository.GetByIdBase(idDesde));
						
						String identificadorHacia = comboHacia.getSelectedItem().toString().substring(comboHacia.getSelectedItem().toString().lastIndexOf(";")+1,comboHacia.getSelectedItem().toString().length());
						Integer idHacia = Integer.parseInt(identificadorHacia);
						vuelo.setHacia(destinoRepository.GetByIdBase(idHacia));
						
						vuelo.setId(vueloRepository.GetIdBase());
						vuelo.setPrecio(Float.parseFloat(textPrecio.getText().trim()));
						
						SimpleDateFormat formatoFechaPartida = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date fechaPartida = new Date();
						fechaPartida = formatoFechaPartida.parse(textFechaAnioPartida.getText()+"-"+textFechaMesPartida.getText()+"-"+textFechaDiaPartida.getText()+" "+textFechaHoraPartida.getText().trim()+":"+textFechaMinutoPartida.getText().trim());
						vuelo.setPartida(fechaPartida);
						
						SimpleDateFormat formatoFechaLlegada = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date fechaLlegada = new Date();
						fechaLlegada = formatoFechaLlegada.parse(textFechaAnioLlegada.getText()+"-"+textFechaMesLlegada.getText()+"-"+textFechaDiaLlegada.getText()+" "+textFechaHoraLlegada.getText().trim()+":"+textFechaMinutoLlegada.getText().trim());
						vuelo.setLlegada(fechaLlegada);
						

						if(vueloRepository.InsertarBase(vuelo))
						{
							JOptionPane.showMessageDialog(FrmAgregarVuelo.this, "Se agrego correctamente");
							System.out.print("SE GRABO SUPUESTAMENTE");
							FrmAgregarVuelo.this.dispose();
						}else{
							JOptionPane.showMessageDialog(FrmAgregarVuelo.this, "Hubo un error en su solicitud, intente nuevamente mas tarde.");
							FrmAgregarVuelo.this.dispose();
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
				
				if(comboAvion.getSelectedIndex() < 0)
					errores.add("Debe seleccionar un avion");
				
				if(comboHacia.getSelectedIndex() == comboDesde.getSelectedIndex())
					errores.add("Los destinos son iguales");
				
				if(textPrecio.getText().trim().length() <= 0){
					errores.add("Debe ingresar un precio");
				}else if (!(textPrecio.getText().trim().length() <= 8)){
					errores.add("Maximo de 8 caracteres para precio");
				}
				
				if(!isFechaValida(textFechaDiaPartida.getText().trim()+"/"+textFechaMesPartida.getText().trim()+"/"+textFechaAnioPartida.getText().trim()+" "+textFechaHoraPartida.getText().trim()+":"+textFechaMinutoPartida.getText().trim()))
					errores.add("Ingrese una fecha de partida válida");
				if(textFechaDiaPartida.getText().trim().length() <= 0){
					errores.add("Debe ingresar un dia Partida");
				}else if (!(textFechaDiaPartida.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para dia Partida");
				}
				if(textFechaMesPartida.getText().trim().length() <= 0){
					errores.add("Debe ingresar un mes Partida");
				}else if (!(textFechaMesPartida.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para mes Partida");
				}
				if(textFechaAnioPartida.getText().trim().length() <= 0){
					errores.add("Debe ingresar un año Partida");
				}else if (!(textFechaAnioPartida.getText().trim().length() <= 4)){
					errores.add("Maximo de 4 caracteres para año Partida");
				}
				if(textFechaHoraPartida.getText().trim().length() <= 0){
					errores.add("Debe ingresar una hora Partida");
				}else if (!(textFechaHoraPartida.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para hora Partida");
				}
				if(textFechaMinutoPartida.getText().trim().length() <= 0){
					errores.add("Debe ingresar minuto Partida");
				}else if (!(textFechaMinutoPartida.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para minuto Partida");
				}
				
				if(!isFechaValida(textFechaDiaLlegada.getText().trim()+"/"+textFechaMesLlegada.getText().trim()+"/"+textFechaAnioLlegada.getText().trim()+" "+textFechaHoraLlegada.getText().trim()+":"+textFechaMinutoLlegada.getText().trim()))
					errores.add("Ingrese una fecha de Llegada válida");
				if(textFechaDiaLlegada.getText().trim().length() <= 0){
					errores.add("Debe ingresar un dia Llegada");
				}else if (!(textFechaDiaLlegada.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para dia Llegada");
				}
				if(textFechaMesLlegada.getText().trim().length() <= 0){
					errores.add("Debe ingresar un mes Llegada");
				}else if (!(textFechaMesLlegada.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para mes Llegada");
				}
				if(textFechaAnioLlegada.getText().trim().length() <= 0){
					errores.add("Debe ingresar un año Llegada");
				}else if (!(textFechaAnioLlegada.getText().trim().length() <= 4)){
					errores.add("Maximo de 4 caracteres para año Llegada");
				}
				if(textFechaHoraLlegada.getText().trim().length() <= 0){
					errores.add("Debe ingresar una hora Llegada");
				}else if (!(textFechaHoraLlegada.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para hora Llegada");
				}
				if(textFechaMinutoLlegada.getText().trim().length() <= 0){
					errores.add("Debe ingresar minuto Llegada");
				}else if (!(textFechaMinutoLlegada.getText().trim().length() <= 2)){
					errores.add("Maximo de 2 caracteres para minuto Llegada");
				}
				
//				if(textCant.getText().trim().length() <= 0){
//					errores.add("Debe ingresar una cantidad");
//				}else if (!(textCant.getText().trim().length() <= 3)){
//					errores.add("Maximo de 3 caracteres para una cantidad");
//				}
				
//				if(textDescr.getText().trim().length() <= 0){
//					errores.add("Debe ingresar una descripcion");
//				}else if (!(textDescr.getText().trim().length() <= 100)){
//					errores.add("Maximo de 100 caracteres para una descripcion");
//				}
//				
				
				if(errores.size() > 0){
					String msjError="";
					
					for(String e : errores)
					{
						msjError = msjError + e.toString() + "\n";
						
					}
					
					JOptionPane.showMessageDialog(FrmAgregarVuelo.this, msjError);
					
				}else{
					return true;
				}
				return false;
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAgregarVuelo.this.dispose();	
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