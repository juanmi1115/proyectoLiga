package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import equiposJugadores.Equipo;
import equiposJugadores.Jugador;
import excepciones.restriccionEquipo;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class SeleccionEquipo extends JPanel implements Serializable{
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private Ventana ventana;
	private Equipo equipo;
	private Jugador jugador;
	private Connection con;
	public SeleccionEquipo(Ventana v) {
		super();
		setBackground(SystemColor.textHighlight);
		this.ventana=v;
		setSize(800,550);
		setLayout(null);
		
		
		JLabel lblSeleccionaTuEquipo = new JLabel("SELECCIONA TU EQUIPO");
		lblSeleccionaTuEquipo.setForeground(new Color(204, 255, 255));
		lblSeleccionaTuEquipo.setFont(new Font("Book Antiqua", Font.PLAIN, 24));
		lblSeleccionaTuEquipo.setBounds(256, 40, 334, 23);
		add(lblSeleccionaTuEquipo);
		
	
		
		JButton botonMalaga = new JButton("MÁLAGA C.F");
		botonMalaga.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(0, 0, 255)));
		botonMalaga.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonMalaga.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonMalaga.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/malaga_cf_footballteam_18013 (1).png")));
		botonMalaga.setBackground(SystemColor.scrollbar);
		botonMalaga.setBounds(114, 95, 190, 50);
		add(botonMalaga);
		botonMalaga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonMalaga.getText()));
				
				
				
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonBarcelona = new JButton("F.C BARCELONA");
		botonBarcelona.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/fc_barcelona_footballteam_18015 (1).png")));
		botonBarcelona.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
		botonBarcelona.setBackground(SystemColor.scrollbar);
		botonBarcelona.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonBarcelona.setBounds(491, 95, 190, 50);
		add(botonBarcelona);
		botonBarcelona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonBarcelona.getText()));
				ventana.irAClasificacion();
			}
			
			
			
		});
		
		
		
		JButton botonRealMadrid = new JButton("RREAL MADRID C.F");
		botonRealMadrid.setBorder(new MatteBorder(1, 3, 5, 1, (Color) Color.WHITE));
		botonRealMadrid.setBackground(SystemColor.scrollbar);
		botonRealMadrid.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/real_madrid_footballteam_18009.png")));
		botonRealMadrid.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonRealMadrid.setBounds(114, 153, 190, 54);
		add(botonRealMadrid);
		botonRealMadrid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonRealMadrid.getText()));
				ventana.irAClasificacion();
			}
			
			
		});

		JButton botonCelta = new JButton("CELTA F.C");
		botonCelta.setBorder(new MatteBorder(1, 1, 3, 3, (Color) Color.CYAN));
		botonCelta.setBackground(SystemColor.scrollbar);
		botonCelta.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonCelta.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/celta-de-vigo_109482.png")));
		botonCelta.setBounds(491, 152, 190, 54);
		add(botonCelta);
		botonCelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonCelta.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonSevilla = new JButton("SEVILLA F.C");
		botonSevilla.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(255, 153, 153)));
		botonSevilla.setBackground(SystemColor.scrollbar);
		botonSevilla.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/sevilla_109492.png")));
		botonSevilla.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonSevilla.setBounds(114, 218, 190, 54);
		add(botonSevilla);
		botonSevilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonSevilla.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		
		JButton botonBetis = new JButton("REAL BETIS BALOMPIÉ");
		botonBetis.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(51, 255, 0)));
		botonBetis.setBackground(SystemColor.scrollbar);
		botonBetis.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonBetis.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/betis_109480.png")));
		botonBetis.setBounds(491, 218, 190, 54);
		add(botonBetis);
		botonBetis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonBetis.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonEspanyol = new JButton("ESPANYOL F.C");
		botonEspanyol.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(0, 102, 255)));
		botonEspanyol.setBackground(SystemColor.scrollbar);
		botonEspanyol.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonEspanyol.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/espanyol_footballteam_18016.png")));
		botonEspanyol.setBounds(114, 283, 190, 50);
		add(botonEspanyol);
		botonEspanyol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonEspanyol.getText()));
				
				ventana.irAClasificacion();
			}
			
			
		});
		
		JButton botonAtletico = new JButton("ATLÉTICO DE MADRID");
		botonAtletico.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
		botonAtletico.setBackground(SystemColor.scrollbar);
		botonAtletico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonAtletico.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/atletico_madrid_footballteam_18020.png")));
		botonAtletico.setBounds(491, 283, 190, 50);
		add(botonAtletico);
		botonAtletico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(botonAtletico.getText());
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonAtletico.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonAthletic = new JButton("ATHLETIC CLUB");
		botonAthletic.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(204, 0, 0)));
		botonAthletic.setBackground(SystemColor.scrollbar);
		botonAthletic.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonAthletic.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/athletic_bilbao_footballteam_18021.png")));
		botonAthletic.setBounds(116, 344, 188, 50);
		add(botonAthletic);
		botonAthletic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonAthletic.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonValencia = new JButton("VALENCIA C.F");
		botonValencia.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		botonValencia.setBackground(SystemColor.scrollbar);
		botonValencia.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonValencia.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/valencia_109487.png")));
		botonValencia.setBounds(491, 344, 190, 50);
		add(botonValencia);
		botonValencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
			ventana.setMiEquipo(ventana.getLigaSantander().getEquipo().get(botonValencia.getText()));
			System.out.println(ventana.getMiEquipo());
			ventana.irAClasificacion();	
				
			}
			
			
		});
		
		LeerTablaBaseDatos();
		
		
		 /*try {
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ligaFutbol19",
				      "ligaFutbol19", "ligaFutbol19");
			System.out.println("Conexion realizada con exito");
			
			String ruta = "./src/interfaces/clasificacion.txt";
			
			File f = new File(ruta);
			
			FileOutputStream fs;
			
			fs = new FileOutputStream(f);

			ObjectOutputStream os;
		
			os = new ObjectOutputStream(fs);
		
			os.writeObject();
			
			System.out.println("El archivo se ha crreado");
			
			os.flush();
			
			os.close();
			
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
			      	

	}

	public void LeerTablaBaseDatos() {
        Statement sql=null;
        ResultSet rs=null;
        String jugadores="";
           try {
               
        	   Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ligaFutbol19",
 				      "ligaFutbol19", "ligaFutbol19");
               System.out.println("Conexión establecida");

               sql=con.createStatement();

               rs=sql.executeQuery("SELECT id_jugador,nombre,apellido,equipo_jugador FROM jugadores");

               System.out.println("CONSULTA EJECUTADA");

               boolean r=rs.next();
               while (r) {
                   jugadores+=rs.getInt("id_jugador") + 
                             "  " + rs.getString("nombre") + " " +
                             rs.getString("apellido") +" "+rs.getString("equipo_jugador")+"\n";
                   r=rs.next();
               }

               String ruta = "./src/interfaces/clasificacion.txt";

               File f = new File(ruta);

               FileOutputStream fs;

               fs = new FileOutputStream(f);

               ObjectOutputStream os;

               os = new ObjectOutputStream(fs);

               os.writeObject(jugadores);

               System.out.println("El archivo se ha creado");

               os.flush();

               os.close();




               con.close();
               System.out.println("CERRADA LA CONEXION");
           } catch (SQLException e) {
               System.out.println
                          ("ERROR AL EJECUTAR LA SENTENCIA SQL");
             } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

       }
		} 

