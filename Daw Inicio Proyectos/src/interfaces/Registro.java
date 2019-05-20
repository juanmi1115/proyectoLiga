package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Usuario;
import componentes.BotonNuevaPartida;
import componentes.MiLabel;
import excepciones.ContraseñaCortaExcaption;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Registro extends JPanel{
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoEmail;
	private JTextField campoFNacimiento;
	private JPasswordField campoContraseña;
	
	public Registro(Ventana v) {
		super();
		this.ventana=v;
		setSize(300,300);
		setLayout(null);
		
		MiLabel lblNombre = new MiLabel("Nombre");
		lblNombre.setBounds(52, 67, 110, 14);
		add(lblNombre);
		
		MiLabel lblEmail = new MiLabel("Email");
		lblEmail.setBounds(52, 105, 98, 14);
		add(lblEmail);
		
		MiLabel lblContrasea = new MiLabel("Contrase\u00F1a");
		lblContrasea.setBounds(24, 197, 111, 14);
		add(lblContrasea);
		
		MiLabel lblFechaNacimiento = new MiLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 151, 152, 14);
		add(lblFechaNacimiento);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(187, 65, 86, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(187, 103, 86, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoFNacimiento = new JTextField();
		campoFNacimiento.setBounds(187, 149, 86, 20);
		add(campoFNacimiento);
		campoFNacimiento.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(187, 195, 86, 20);
		add(campoContraseña);
		
		BotonNuevaPartida btnRegistrar = new BotonNuevaPartida("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nombreUsuario=campoNombre.getText();
				String contrasenia=
				String.copyValueOf(
						campoContraseña.getPassword());
				String fNacimiento=campoFNacimiento.getText();
				String email=campoEmail.getText();
				
				//Todo insertar el usuario en la base de datos
				/*try {
					ventana.setUsuario(new Usuario(nombreUsuario,
							contrasenia,LocalDate.parse(fNacimiento),
							email));
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.10/huesitos", "1dam", "123"));
					System.out.println("Conectado correctamente");
					
					//Usar la base de datos
					PreparedStatement smt = 
					ventana.getCon().prepareStatement("insert into usuarios values(? , ? , ? , ?)");
					smt.setString(1, email);
					smt.setString(2, nombreUsuario);
					smt.setDate(3, Date.valueOf(fNacimiento));
					smt.setString(4,contrasenia);
					smt.executeUpdate();
					
					
					ventana.getCon().close();
					ventana.irAPrincipal();
				}catch(SQLIntegrityConstraintViolationException iex) {
					JOptionPane.showMessageDialog(ventana,"El email ya esta registrado, elige otro email", "Email ya registrado", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(DateTimeParseException b) {
				JOptionPane.showMessageDialog(ventana,"Formato incorrecto de fecha, debe ser yyyy-mm-dd", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
				} catch (ContraseñaCortaExcaption e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana,"La contraseña debe tener al menos 8 caracteres", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
					
				}*/
			}});
		btnRegistrar.setBounds(39, 235, 142, 38);
		add(btnRegistrar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		btnAtrs.setBounds(209, 225, 91, 23);
		add(btnAtrs);
		setVisible(true);
	}

}
