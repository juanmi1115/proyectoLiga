package interfaces;
import javax.swing.JFrame;

//import clases.Usuario;
import competiciones.Jornada;
import competiciones.Liga;
import competiciones.Partido;
import equiposJugadores.Equipo;
import equiposJugadores.Estadio;
import equiposJugadores.Jugador;

import javax.swing.JButton;
import static equiposJugadores.Caracteristicas.FUERZA;
import static equiposJugadores.Caracteristicas.PRECISION;
import static equiposJugadores.Caracteristicas.RESISTENCIA;
import static equiposJugadores.Caracteristicas.TECNICA;
import static equiposJugadores.Caracteristicas.VELOCIDAD;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/*
 * Clase ventana, es un JFrame que  va a contener todos los paneles de las interfaces.
 * */
public class Ventana extends JFrame {
	private PanelInicio panelInicio;
	private SeleccionEquipo seleccionEquipo;
//	private Registro registro;
	//private Usuario usuario;
	private Principal principal;
	private Liga ligaSantander;
	private Equipo miEquipo;
	private PanelClasificacion panelClasificacion;
	private PanelJornada panelJornada;
	private HashMap<String,Equipo> equipos;
	private JButton [][]matrizCampo;
	private Resultados resultados;
	private Connection con;
	private Jugador jugador;
	private Jornada jornada;


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Ventana() {
		super();
		panelInicio=new PanelInicio(this);
		this.setTitle("Mi programa");
		this.setSize(800,500);
		this.setContentPane(panelInicio);
		this.setResizable(false);
		this.setVisible(true);
	
			try {
				
					
				   //Creación de los estadios
				   Estadio rosaleda = new Estadio("La Rosaleda");
			       Estadio bernabeu = new Estadio("Santiago Bernabeu");
			       Estadio camp = new Estadio("Camp Nou");
			       Estadio villa = new Estadio("Benito Villamarín");
			       Estadio pizjuan = new Estadio("Sánchez Pizjuán");
			       Estadio pajaritos= new Estadio("Los Pajaritos");
			       Estadio balaidos = new Estadio("Balaidos");
			       Estadio wanda = new Estadio("Wanda");
			       Estadio mestalla = new Estadio("Mestalla");
			       Estadio mames = new Estadio("San Mamés");
			       
			       //Creación de los equipos
			       Equipo madrid = new Equipo("REAL MADRID C.F", RESISTENCIA, bernabeu);
			       Equipo barcelona = new Equipo("F.C BARCELONA", VELOCIDAD, camp);
			       Equipo malaga = new Equipo ("MÁLAGA C.F",TECNICA,rosaleda);
			       Equipo betis = new Equipo ("REAL BETIS BALOMPIÉ",RESISTENCIA,villa);
			       Equipo sevilla = new Equipo ("SEVILLA F.C",PRECISION,pizjuan);
			       Equipo espanyol = new Equipo ("ESPANYOL F.C",TECNICA,pajaritos);
			       Equipo celta = new Equipo ("CELTA F.C",FUERZA,balaidos);
			       Equipo atMadrid = new Equipo ("ATLÉTICO DE MADRID",TECNICA,wanda);
			       Equipo valencia = new Equipo ("VALENCIA C.F",VELOCIDAD,mestalla);
			       Equipo athletic = new Equipo ("ATHLETIC CLUB",PRECISION,mames);
			       
			       
				//creación de los equipos, los cuales se los añadimos con la función .put
				equipos = new HashMap <String, Equipo>();
				
				equipos.put("REAL MADRID C.F", madrid);
				equipos.put("MÁLAGA C.F", malaga);
				equipos.put("F.C BARCELONA", barcelona);
				equipos.put("REAL BETIS BALOMPIÉ", betis);
				equipos.put("SEVILLA F.C", sevilla);
				equipos.put("ESPANYOL F.C", espanyol);
				equipos.put("CELTA F.C", celta);
				equipos.put("ATLÉTICO DE MADRID",atMadrid);
				equipos.put("VALENCIA C.F", valencia);
				equipos.put("ATHLETIC CLUB",athletic);
				
				
				//creacion de los partidos
				
				//Jornada 1
				Partido p1 = new Partido(equipos.get("MÁLAGA C.F"), equipos.get("REAL MADRID C.F"));
				Partido p2 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("REAL BETIS BALOMPIÉ"));
				Partido p3 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("ESPANYOL F.C"));
				Partido p4 = new Partido(equipos.get("CELTA F.C") , equipos.get("ATLÉTICO DE MADRID"));
				Partido p5 = new Partido(equipos.get("VALENCIA C.F") , equipos.get("ATHLETIC CLUB"));
		       
				
		       //Jornada 2
		       Partido p6 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("F.C BARCELONA"));
		       Partido p7 = new Partido(equipos.get("REAL MADRID C.F") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p8 = new Partido(equipos.get("CELTA F.C") , equipos.get("REAL BETIS BALOMPIÉ"));
		       Partido p9 = new Partido(equipos.get("ESPANYOL F.C") , equipos.get("ATHLETIC CLUB"));
		       Partido p10 = new Partido(equipos.get("VALENCIA C.F") , equipos.get("SEVILLA F.C"));
		       
		       //Jornada 3
		       Partido p11 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("REAL BETIS BALOMPIÉ"));
		       Partido p12 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("REAL MADRID C.F"));
		       Partido p13 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("ATHLETIC CLUB"));
		       Partido p14 = new Partido(equipos.get("VALENCIA C.F") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p15 = new Partido(equipos.get("CELTA F.C") , equipos.get("ESPANYOL F.C"));
		       
		       //Jornada 4 
		       Partido p16 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("CELTA F.C"));
		       Partido p17 = new Partido(equipos.get("REAL MADRID C.F") , equipos.get("REAL BETIS BALOMPIÉ"));
		       Partido p18 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("F.C BARCELONA"));
		       Partido p19 = new Partido(equipos.get("ATHLETIC CLUB") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p20 = new Partido(equipos.get("VALENCIA C.F") , equipos.get("ESPANYOL F.C"));
		       
		       //Jornada 5
		       Partido p21 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("ESPANYOL F.C"));
		       Partido p22 = new Partido(equipos.get("VALENCIA C.F") , equipos.get("REAL MADRID C.F"));
		       Partido p23 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("CELTA F.C") );
		       Partido p24 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p25 = new Partido(equipos.get("REAL BETIS BALOMPIÉ") , equipos.get("ATHLETIC CLUB"));
		       
		       //jornada 6
		       Partido p26 = new Partido(equipos.get("ATHLETIC CLUB") , equipos.get("REAL MADRID C.F"));
		       Partido p27 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p28 = new Partido(equipos.get("REAL BETIS BALOMPIÉ") , equipos.get("ESPANYOL F.C"));
		       Partido p29 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("VALENCIA C.F"));
		       Partido p30 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("CELTA F.C"));
		       
		       //Jornada 7
		       Partido p31 = new Partido(equipos.get("SEVILLA F.C") , equipos.get("REAL BETIS BALOMPIÉ"));
		       Partido p32 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("VALENCIA C.F"));
		       Partido p33 = new Partido(equipos.get("CELTA F.C") , equipos.get("REAL MADRID C.F"));
		       Partido p34 = new Partido(equipos.get("ESPANYOL F.C") , equipos.get("ATLÉTICO DE MADRID"));
		       Partido p35 = new Partido(equipos.get("ATHLETIC CLUB") , equipos.get("MÁLAGA C.F"));
		       
		       //jornada 8
		       Partido p36 = new Partido(equipos.get("MÁLAGA C.F") , equipos.get("SEVILLA F.C"));
		       Partido p37 = new Partido(equipos.get("ATLÉTICO DE MADRID") , equipos.get("REAL BETIS BALOMPIÉ"));
		       Partido p38 = new Partido(equipos.get("ESPANYOL F.C") , equipos.get("REAL MADRID C.F"));
		       Partido p39 = new Partido(equipos.get("CELTA F.C") , equipos.get("VALENCIA C.F"));
		       Partido p40 = new Partido(equipos.get("F.C BARCELONA") , equipos.get("ATHLETIC CLUB"));
		       
		       //Array que contienen los partidos
		       Partido [] partidosJornada1 = {p1, p2, p3, p4, p5};
		       Partido [] partidosJornada2 = {p6, p7, p8, p9, p10};
		       Partido [] partidosJornada3 = {p11, p12, p13, p14, p15};
		       Partido [] partidosJornada4 = {p16, p17, p18, p19, p20};
		       Partido [] partidosJornada5 = {p21, p22, p23, p24, p25};
		       Partido [] partidosJornada6 = {p26, p27, p28, p29, p30};
		       Partido [] partidosJornada7 = {p31, p32, p33, p34, p35};
		       Partido [] partidosJornada8 = {p36, p37, p38, p39, p40};
		      
		      //creacion de las jornadas
		      Jornada j1 = new Jornada (1, partidosJornada1); 
		      Jornada j2 = new Jornada (2, partidosJornada2);
		      Jornada j3 = new Jornada (3, partidosJornada3);
		      Jornada j4 = new Jornada (4, partidosJornada4);
		      Jornada j5 = new Jornada (5, partidosJornada5); 
		      Jornada j6 = new Jornada (6, partidosJornada6);
		      Jornada j7 = new Jornada (7, partidosJornada7);
		      Jornada j8 = new Jornada (8, partidosJornada8);
		      
		      //array que contiene las jornadas
		      Jornada [] jornadasLiga = {j1,j2,j3,j4,j5,j6,j7,j8};
		      
		      //Creación de la liga
		      ligaSantander = new Liga("Santander", equipos, jornadasLiga);
			
		      //Conexión con la base de datos
		      Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ligaFutbol19",
		      "ligaFutbol19", "ligaFutbol19");
		      System.out.println("Conexion realizada con exito");
		    
		      
		    //Aqui se insertan los valores en la base de datos
		      
		    //ESTADIOS
		  	PreparedStatement smt = con.prepareStatement("insert into ESTADIO values(?)");
		  	
		  	Statement comparacion = con.createStatement();
		  	
		  	ResultSet rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+bernabeu.getNombre()+"'");		
		  	
		  	if(!rs.next()) {
				smt.setString(1, bernabeu.getNombre());
				smt.executeUpdate();  
			  	}
		  	
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+camp.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, camp.getNombre());
				smt.executeUpdate();  
			  	}
			
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+rosaleda.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, rosaleda.getNombre());
				smt.executeUpdate();  
			  	}
		  	
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+villa.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, villa.getNombre());
				smt.executeUpdate();  
			  	}
		  	
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+pizjuan.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, pizjuan.getNombre());
				smt.executeUpdate();  
			  	}
			
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+mames.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, mames.getNombre());
				smt.executeUpdate();  
			  	}
		  	
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+balaidos.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, balaidos.getNombre());
				smt.executeUpdate();  
			  	}
			
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+pajaritos.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, pajaritos.getNombre());
				smt.executeUpdate();  
			  	}
			
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+mestalla.getNombre()+"'");
		  	if(!rs.next()) {
				smt.setString(1, mestalla.getNombre());
				smt.executeUpdate();  
			  	}
		  	
		  	rs = comparacion.executeQuery("SELECT * FROM ESTADIO WHERE NOMBRE='"+wanda.getNombre()+"'");
			if(!rs.next()) {
				smt.setString(1, wanda.getNombre());
				smt.executeUpdate();  
				}
			
			
			//EQUIPOS
			PreparedStatement smt3 = con.prepareStatement("insert into EQUIPO values(?,?,?,?)");
			
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+madrid.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, madrid.getNombre());
				smt3.setString(2, madrid.getEntrenador().getNombre()+" "+madrid.getEntrenador().getApellido());
				smt3.setString(3, madrid.getEstadio().getNombre());
				smt3.setString(4, madrid.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
			
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+malaga.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, malaga.getNombre());
				smt3.setString(2, malaga.getEntrenador().getNombre()+" "+malaga.getEntrenador().getApellido());
				smt3.setString(3, malaga.getEstadio().getNombre());
				smt3.setString(4, malaga.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
			
			
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+barcelona.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, barcelona.getNombre());
				smt3.setString(2, barcelona.getEntrenador().getNombre()+" "+barcelona.getEntrenador().getApellido());
				smt3.setString(3, barcelona.getEstadio().getNombre());
				smt3.setString(4, barcelona.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
			
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+sevilla.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, sevilla.getNombre());
				smt3.setString(2, sevilla.getEntrenador().getNombre()+" "+sevilla.getEntrenador().getApellido());
				smt3.setString(3, sevilla.getEstadio().getNombre());
				smt3.setString(4, sevilla.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+betis.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, betis.getNombre());
				smt3.setString(2, betis.getEntrenador().getNombre()+" "+betis.getEntrenador().getApellido());
				smt3.setString(3, betis.getEstadio().getNombre());
				smt3.setString(4, betis.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+atMadrid.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, atMadrid.getNombre());
				smt3.setString(2, atMadrid.getEntrenador().getNombre()+" "+atMadrid.getEntrenador().getApellido());
				smt3.setString(3, atMadrid.getEstadio().getNombre());
				smt3.setString(4, atMadrid.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+athletic.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, athletic.getNombre());
				smt3.setString(2, athletic.getEntrenador().getNombre()+" "+athletic.getEntrenador().getApellido());
				smt3.setString(3, athletic.getEstadio().getNombre());
				smt3.setString(4, athletic.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+celta.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, celta.getNombre());
				smt3.setString(2, celta.getEntrenador().getNombre()+" "+celta.getEntrenador().getApellido());
				smt3.setString(3, celta.getEstadio().getNombre());
				smt3.setString(4, celta.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+valencia.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, valencia.getNombre());
				smt3.setString(2, valencia.getEntrenador().getNombre()+" "+valencia.getEntrenador().getApellido());
				smt3.setString(3, valencia.getEstadio().getNombre());
				smt3.setString(4, valencia.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
				
			rs = comparacion.executeQuery("SELECT NOMBRE FROM EQUIPO WHERE NOMBRE='"+espanyol.getNombre()+"'");
			if(!rs.next()) {
				smt3.setString(1, espanyol.getNombre());
				smt3.setString(2, espanyol.getEntrenador().getNombre()+" "+espanyol.getEntrenador().getApellido());
				smt3.setString(3, espanyol.getEstadio().getNombre());
				smt3.setString(4, espanyol.getCaracPrincipal().toString());
				smt3.executeUpdate();  
				}
			
			
			//ENTRENADORES
			PreparedStatement smt4 = con.prepareStatement("insert into entrenador values(?,?,?,?,?,?,?,?,?)");
			
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+1+"");
			if(!rs.next()) {
				smt4.setInt(1, 1);
				smt4.setString(2, madrid.getEntrenador().getNombre());
				smt4.setString(3, madrid.getEntrenador().getApellido());
				smt4.setFloat(4, madrid.getEntrenador().getPotFuerza());
				smt4.setFloat(5, madrid.getEntrenador().getPotResistencia());
				smt4.setFloat(6, madrid.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, madrid.getEntrenador().getPotPrecision());
				smt4.setFloat(8, madrid.getEntrenador().getPotTecnica());
				smt4.setString(9, madrid.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+2+"");
			if(!rs.next()) {
				smt4.setInt(1, 2);
				smt4.setString(2, malaga.getEntrenador().getNombre());
				smt4.setString(3, malaga.getEntrenador().getApellido());
				smt4.setFloat(4, malaga.getEntrenador().getPotFuerza());
				smt4.setFloat(5, malaga.getEntrenador().getPotResistencia());
				smt4.setFloat(6, malaga.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, malaga.getEntrenador().getPotPrecision());
				smt4.setFloat(8, malaga.getEntrenador().getPotTecnica());
				smt4.setString(9, malaga.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+3+"");
			if(!rs.next()) {
				smt4.setInt(1, 3);
				smt4.setString(2, barcelona.getEntrenador().getNombre());
				smt4.setString(3, barcelona.getEntrenador().getApellido());
				smt4.setFloat(4, barcelona.getEntrenador().getPotFuerza());
				smt4.setFloat(5, barcelona.getEntrenador().getPotResistencia());
				smt4.setFloat(6, barcelona.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, barcelona.getEntrenador().getPotPrecision());
				smt4.setFloat(8, barcelona.getEntrenador().getPotTecnica());
				smt4.setString(9, barcelona.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+4+"");
			if(!rs.next()) {
				smt4.setInt(1, 4);
				smt4.setString(2, atMadrid.getEntrenador().getNombre());
				smt4.setString(3, atMadrid.getEntrenador().getApellido());
				smt4.setFloat(4, atMadrid.getEntrenador().getPotFuerza());
				smt4.setFloat(5, atMadrid.getEntrenador().getPotResistencia());
				smt4.setFloat(6, atMadrid.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, atMadrid.getEntrenador().getPotPrecision());
				smt4.setFloat(8, atMadrid.getEntrenador().getPotTecnica());
				smt4.setString(9, atMadrid.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+5+"");
			if(!rs.next()) {
				smt4.setInt(1, 5);
				smt4.setString(2, sevilla.getEntrenador().getNombre());
				smt4.setString(3, sevilla.getEntrenador().getApellido());
				smt4.setFloat(4, sevilla.getEntrenador().getPotFuerza());
				smt4.setFloat(5, sevilla.getEntrenador().getPotResistencia());
				smt4.setFloat(6, sevilla.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, sevilla.getEntrenador().getPotPrecision());
				smt4.setFloat(8, sevilla.getEntrenador().getPotTecnica());
				smt4.setString(9, sevilla.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+6+"");
			if(!rs.next()) {
				smt4.setInt(1, 6);
				smt4.setString(2, betis.getEntrenador().getNombre());
				smt4.setString(3, betis.getEntrenador().getApellido());
				smt4.setFloat(4, betis.getEntrenador().getPotFuerza());
				smt4.setFloat(5, betis.getEntrenador().getPotResistencia());
				smt4.setFloat(6, betis.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, betis.getEntrenador().getPotPrecision());
				smt4.setFloat(8, betis.getEntrenador().getPotTecnica());
				smt4.setString(9, betis.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+7+"");
			if(!rs.next()) {
				smt4.setInt(1, 7);
				smt4.setString(2, celta.getEntrenador().getNombre());
				smt4.setString(3, celta.getEntrenador().getApellido());
				smt4.setFloat(4, celta.getEntrenador().getPotFuerza());
				smt4.setFloat(5, celta.getEntrenador().getPotResistencia());
				smt4.setFloat(6, celta.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, celta.getEntrenador().getPotPrecision());
				smt4.setFloat(8, celta.getEntrenador().getPotTecnica());
				smt4.setString(9, celta.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+8+"");
			if(!rs.next()) {
				smt4.setInt(1, 8);
				smt4.setString(2, valencia.getEntrenador().getNombre());
				smt4.setString(3, valencia.getEntrenador().getApellido());
				smt4.setFloat(4, valencia.getEntrenador().getPotFuerza());
				smt4.setFloat(5, valencia.getEntrenador().getPotResistencia());
				smt4.setFloat(6, valencia.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, valencia.getEntrenador().getPotPrecision());
				smt4.setFloat(8, valencia.getEntrenador().getPotTecnica());
				smt4.setString(9, valencia.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+9+"");
			if(!rs.next()) {
				smt4.setInt(1, 9);
				smt4.setString(2, espanyol.getEntrenador().getNombre());
				smt4.setString(3, espanyol.getEntrenador().getApellido());
				smt4.setFloat(4, espanyol.getEntrenador().getPotFuerza());
				smt4.setFloat(5, espanyol.getEntrenador().getPotResistencia());
				smt4.setFloat(6, espanyol.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, espanyol.getEntrenador().getPotPrecision());
				smt4.setFloat(8, espanyol.getEntrenador().getPotTecnica());
				smt4.setString(9, espanyol.getNombre());
				smt4.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT ID_ENTRENADOR FROM ENTRENADOR WHERE ID_ENTRENADOR="+10+"");
			if(!rs.next()) {
				smt4.setInt(1, 10);
				smt4.setString(2, athletic.getEntrenador().getNombre());
				smt4.setString(3, athletic.getEntrenador().getApellido());
				smt4.setFloat(4, athletic.getEntrenador().getPotFuerza());
				smt4.setFloat(5, athletic.getEntrenador().getPotResistencia());
				smt4.setFloat(6, athletic.getEntrenador().getPotVelocidad());
				smt4.setFloat(7, athletic.getEntrenador().getPotPrecision());
				smt4.setFloat(8, athletic.getEntrenador().getPotTecnica());
				smt4.setString(9, athletic.getNombre());
				smt4.executeUpdate();
			}
			
			
			//JORNADAS
			PreparedStatement smt5 = con.prepareStatement("insert into jornada values(?)");
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j1.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j1.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j2.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j2.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j3.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j3.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j4.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j4.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j5.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j5.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j6.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j6.getNumeroJornada());
			smt5.executeUpdate();
			}

			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j7.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j7.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT numeroJornada FROM jornada WHERE numeroJornada='"+j8.getNumeroJornada()+"'");
			
			if(!rs.next()) {
			smt5.setInt(1,j8.getNumeroJornada());
			smt5.executeUpdate();
			}
			
			//SE CREAN LOS DATOS DE LOS PARTIDOS EN LA BASE DE DATOS
			
			PreparedStatement smt6 = con.prepareStatement("insert into partido values(?,?,?,?)");
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+1+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 1);
			smt6.setString(2, p1.getEquipoLocal().getNombre());
			smt6.setString(3, p1.getEquipoVisitante().getNombre());
			smt6.setInt(4, j1.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+2+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 2);
			smt6.setString(2, p2.getEquipoLocal().getNombre());
			smt6.setString(3, p2.getEquipoVisitante().getNombre());
			smt6.setInt(4, j1.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+3+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 3);
			smt6.setString(2, p3.getEquipoLocal().getNombre());
			smt6.setString(3, p3.getEquipoVisitante().getNombre());
			smt6.setInt(4, j1.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+4+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 4);
			smt6.setString(2, p4.getEquipoLocal().getNombre());
			smt6.setString(3, p4.getEquipoVisitante().getNombre());
			smt6.setInt(4, j1.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+5+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 5);
			smt6.setString(2, p5.getEquipoLocal().getNombre());
			smt6.setString(3, p5.getEquipoVisitante().getNombre());
			smt6.setInt(4, j1.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+6+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 6);
			smt6.setString(2, p6.getEquipoLocal().getNombre());
			smt6.setString(3, p6.getEquipoVisitante().getNombre());
			smt6.setInt(4, j2.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+7+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 7);
			smt6.setString(2, p7.getEquipoLocal().getNombre());
			smt6.setString(3, p7.getEquipoVisitante().getNombre());
			smt6.setInt(4, j2.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+8+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 8);
			smt6.setString(2, p8.getEquipoLocal().getNombre());
			smt6.setString(3, p8.getEquipoVisitante().getNombre());
			smt6.setInt(4, j2.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+9+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 9);
			smt6.setString(2, p9.getEquipoLocal().getNombre());
			smt6.setString(3, p9.getEquipoVisitante().getNombre());
			smt6.setInt(4, j2.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+10+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 10);
			smt6.setString(2, p10.getEquipoLocal().getNombre());
			smt6.setString(3, p10.getEquipoVisitante().getNombre());
			smt6.setInt(4, j2.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+11+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 11);
			smt6.setString(2, p11.getEquipoLocal().getNombre());
			smt6.setString(3, p11.getEquipoVisitante().getNombre());
			smt6.setInt(4, j3.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+12+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 12);
			smt6.setString(2, p12.getEquipoLocal().getNombre());
			smt6.setString(3, p12.getEquipoVisitante().getNombre());
			smt6.setInt(4, j3.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+13+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 13);
			smt6.setString(2, p13.getEquipoLocal().getNombre());
			smt6.setString(3, p13.getEquipoVisitante().getNombre());
			smt6.setInt(4, j3.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+14+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 14);
			smt6.setString(2, p14.getEquipoLocal().getNombre());
			smt6.setString(3, p14.getEquipoVisitante().getNombre());
			smt6.setInt(4, j3.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+15+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 15);
			smt6.setString(2, p15.getEquipoLocal().getNombre());
			smt6.setString(3, p15.getEquipoVisitante().getNombre());
			smt6.setInt(4, j3.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+16+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 16);
			smt6.setString(2, p16.getEquipoLocal().getNombre());
			smt6.setString(3, p16.getEquipoVisitante().getNombre());
			smt6.setInt(4, j4.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+17+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 17);
			smt6.setString(2, p17.getEquipoLocal().getNombre());
			smt6.setString(3, p17.getEquipoVisitante().getNombre());
			smt6.setInt(4, j4.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+18+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 18);
			smt6.setString(2, p18.getEquipoLocal().getNombre());
			smt6.setString(3, p18.getEquipoVisitante().getNombre());
			smt6.setInt(4, j4.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+19+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 19);
			smt6.setString(2, p19.getEquipoLocal().getNombre());
			smt6.setString(3, p19.getEquipoVisitante().getNombre());
			smt6.setInt(4, j4.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+20+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 20);
			smt6.setString(2, p20.getEquipoLocal().getNombre());
			smt6.setString(3, p20.getEquipoVisitante().getNombre());
			smt6.setInt(4, j4.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+21+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 21);
			smt6.setString(2, p21.getEquipoLocal().getNombre());
			smt6.setString(3, p21.getEquipoVisitante().getNombre());
			smt6.setInt(4, j5.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+22+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 22);
			smt6.setString(2, p22.getEquipoLocal().getNombre());
			smt6.setString(3, p22.getEquipoVisitante().getNombre());
			smt6.setInt(4, j5.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+23+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 23);
			smt6.setString(2, p23.getEquipoLocal().getNombre());
			smt6.setString(3, p23.getEquipoVisitante().getNombre());
			smt6.setInt(4, j5.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+24+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 24);
			smt6.setString(2, p24.getEquipoLocal().getNombre());
			smt6.setString(3, p24.getEquipoVisitante().getNombre());
			smt6.setInt(4, j5.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+25+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 25);
			smt6.setString(2, p25.getEquipoLocal().getNombre());
			smt6.setString(3, p25.getEquipoVisitante().getNombre());
			smt6.setInt(4, j5.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+26+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 26);
			smt6.setString(2, p26.getEquipoLocal().getNombre());
			smt6.setString(3, p26.getEquipoVisitante().getNombre());
			smt6.setInt(4, j6.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+27+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 27);
			smt6.setString(2, p27.getEquipoLocal().getNombre());
			smt6.setString(3, p27.getEquipoVisitante().getNombre());
			smt6.setInt(4, j6.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+28+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 28);
			smt6.setString(2, p28.getEquipoLocal().getNombre());
			smt6.setString(3, p28.getEquipoVisitante().getNombre());
			smt6.setInt(4, j6.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+29+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 29);
			smt6.setString(2, p29.getEquipoLocal().getNombre());
			smt6.setString(3, p29.getEquipoVisitante().getNombre());
			smt6.setInt(4, j6.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+30+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 30);
			smt6.setString(2, p30.getEquipoLocal().getNombre());
			smt6.setString(3, p30.getEquipoVisitante().getNombre());
			smt6.setInt(4, j6.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+31+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 31);
			smt6.setString(2, p31.getEquipoLocal().getNombre());
			smt6.setString(3, p31.getEquipoVisitante().getNombre());
			smt6.setInt(4, j7.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+32+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 32);
			smt6.setString(2, p32.getEquipoLocal().getNombre());
			smt6.setString(3, p32.getEquipoVisitante().getNombre());
			smt6.setInt(4, j7.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+33+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 33);
			smt6.setString(2, p33.getEquipoLocal().getNombre());
			smt6.setString(3, p33.getEquipoVisitante().getNombre());
			smt6.setInt(4, j7.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+34+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 34);
			smt6.setString(2, p34.getEquipoLocal().getNombre());
			smt6.setString(3, p34.getEquipoVisitante().getNombre());
			smt6.setInt(4, j7.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+35+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 35);
			smt6.setString(2, p35.getEquipoLocal().getNombre());
			smt6.setString(3, p35.getEquipoVisitante().getNombre());
			smt6.setInt(4, j7.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+36+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 36);
			smt6.setString(2, p36.getEquipoLocal().getNombre());
			smt6.setString(3, p36.getEquipoVisitante().getNombre());
			smt6.setInt(4, j8.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+37+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 37);
			smt6.setString(2, p37.getEquipoLocal().getNombre());
			smt6.setString(3, p37.getEquipoVisitante().getNombre());
			smt6.setInt(4, j8.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+38+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 38);
			smt6.setString(2, p38.getEquipoLocal().getNombre());
			smt6.setString(3, p38.getEquipoVisitante().getNombre());
			smt6.setInt(4, j8.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+39+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 39);
			smt6.setString(2, p39.getEquipoLocal().getNombre());
			smt6.setString(3, p39.getEquipoVisitante().getNombre());
			smt6.setInt(4, j8.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			rs = comparacion.executeQuery("SELECT id_partido FROM partido WHERE id_partido="+40+"");
			
			if(!rs.next()) {
			smt6.setInt(1, 40);
			smt6.setString(2, p40.getEquipoLocal().getNombre());
			smt6.setString(3, p40.getEquipoVisitante().getNombre());
			smt6.setInt(4, j8.getNumeroJornada());
			smt6.executeUpdate();
			}
			
			//CREAR JUGADORES EN LA BASE DE DATOS
			
			PreparedStatement smt7 = con.prepareStatement("insert into jugadores values(?,?,?,?,?,?,?,?,?)");
			
				
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+1+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 1);
			smt7.setString(2, madrid.getJugadores().get(1).getNombre());
			smt7.setString(3, madrid.getJugadores().get(1).getApellido());
			smt7.setFloat(4, madrid.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, madrid.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, madrid.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, madrid.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, madrid.getJugadores().get(1).getTecnica());
			smt7.setString(9, madrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+2+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 2);
			smt7.setString(2, madrid.getJugadores().get(0).getNombre());
			smt7.setString(3, madrid.getJugadores().get(0).getApellido());
			smt7.setFloat(4, madrid.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, madrid.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, madrid.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, madrid.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, madrid.getJugadores().get(0).getTecnica());
			smt7.setString(9, madrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+3+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 3);
			smt7.setString(2, madrid.getJugadores().get(2).getNombre());
			smt7.setString(3, madrid.getJugadores().get(2).getApellido());
			smt7.setFloat(4, madrid.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, madrid.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, madrid.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, madrid.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, madrid.getJugadores().get(2).getTecnica());
			smt7.setString(9, madrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+4+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 4);
			smt7.setString(2, madrid.getJugadores().get(3).getNombre());
			smt7.setString(3, madrid.getJugadores().get(3).getApellido());
			smt7.setFloat(4, madrid.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, madrid.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, madrid.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, madrid.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, madrid.getJugadores().get(3).getTecnica());
			smt7.setString(9, madrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+5+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 5);
			smt7.setString(2, madrid.getJugadores().get(4).getNombre());
			smt7.setString(3, madrid.getJugadores().get(4).getApellido());
			smt7.setFloat(4, madrid.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, madrid.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, madrid.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, madrid.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, madrid.getJugadores().get(4).getTecnica());
			smt7.setString(9, madrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+6+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 6);
			smt7.setString(2, malaga.getJugadores().get(0).getNombre());
			smt7.setString(3, malaga.getJugadores().get(0).getApellido());
			smt7.setFloat(4, malaga.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, malaga.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, malaga.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, malaga.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, malaga.getJugadores().get(0).getTecnica());
			smt7.setString(9, malaga.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+7+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 7);
			smt7.setString(2, malaga.getJugadores().get(1).getNombre());
			smt7.setString(3, malaga.getJugadores().get(1).getApellido());
			smt7.setFloat(4, malaga.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, malaga.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, malaga.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, malaga.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, malaga.getJugadores().get(1).getTecnica());
			smt7.setString(9, malaga.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+8+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 8);
			smt7.setString(2, malaga.getJugadores().get(2).getNombre());
			smt7.setString(3, malaga.getJugadores().get(2).getApellido());
			smt7.setFloat(4, malaga.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, malaga.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, malaga.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, malaga.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, malaga.getJugadores().get(2).getTecnica());
			smt7.setString(9, malaga.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+9+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 9);
			smt7.setString(2, malaga.getJugadores().get(3).getNombre());
			smt7.setString(3, malaga.getJugadores().get(3).getApellido());
			smt7.setFloat(4, malaga.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, malaga.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, malaga.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, malaga.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, malaga.getJugadores().get(3).getTecnica());
			smt7.setString(9, malaga.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+10+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 10);
			smt7.setString(2, malaga.getJugadores().get(4).getNombre());
			smt7.setString(3, malaga.getJugadores().get(4).getApellido());
			smt7.setFloat(4, malaga.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, malaga.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, malaga.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, malaga.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, malaga.getJugadores().get(4).getTecnica());
			smt7.setString(9, malaga.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+11+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 11);
			smt7.setString(2, barcelona.getJugadores().get(0).getNombre());
			smt7.setString(3, barcelona.getJugadores().get(0).getApellido());
			smt7.setFloat(4, barcelona.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, barcelona.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, barcelona.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, barcelona.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, barcelona.getJugadores().get(0).getTecnica());
			smt7.setString(9, barcelona.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+12+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 12);
			smt7.setString(2, barcelona.getJugadores().get(1).getNombre());
			smt7.setString(3, barcelona.getJugadores().get(1).getApellido());
			smt7.setFloat(4, barcelona.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, barcelona.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, barcelona.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, barcelona.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, barcelona.getJugadores().get(1).getTecnica());
			smt7.setString(9, barcelona.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+13+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 13);
			smt7.setString(2, barcelona.getJugadores().get(2).getNombre());
			smt7.setString(3, barcelona.getJugadores().get(2).getApellido());
			smt7.setFloat(4, barcelona.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, barcelona.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, barcelona.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, barcelona.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, barcelona.getJugadores().get(2).getTecnica());
			smt7.setString(9, barcelona.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+14+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 14);
			smt7.setString(2, barcelona.getJugadores().get(3).getNombre());
			smt7.setString(3, barcelona.getJugadores().get(3).getApellido());
			smt7.setFloat(4, barcelona.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, barcelona.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, barcelona.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, barcelona.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, barcelona.getJugadores().get(3).getTecnica());
			smt7.setString(9, barcelona.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+15+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 15);
			smt7.setString(2, barcelona.getJugadores().get(4).getNombre());
			smt7.setString(3, barcelona.getJugadores().get(4).getApellido());
			smt7.setFloat(4, barcelona.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, barcelona.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, barcelona.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, barcelona.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, barcelona.getJugadores().get(4).getTecnica());
			smt7.setString(9, barcelona.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+16+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 16);
			smt7.setString(2, celta.getJugadores().get(0).getNombre());
			smt7.setString(3, celta.getJugadores().get(0).getApellido());
			smt7.setFloat(4, celta.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, celta.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, celta.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, celta.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, celta.getJugadores().get(0).getTecnica());
			smt7.setString(9, celta.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+17+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 17);
			smt7.setString(2, celta.getJugadores().get(1).getNombre());
			smt7.setString(3, celta.getJugadores().get(1).getApellido());
			smt7.setFloat(4, celta.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, celta.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, celta.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, celta.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, celta.getJugadores().get(1).getTecnica());
			smt7.setString(9, celta.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+18+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 18);
			smt7.setString(2, celta.getJugadores().get(2).getNombre());
			smt7.setString(3, celta.getJugadores().get(2).getApellido());
			smt7.setFloat(4, celta.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, celta.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, celta.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, celta.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, celta.getJugadores().get(2).getTecnica());
			smt7.setString(9, celta.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+19+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 19);
			smt7.setString(2, celta.getJugadores().get(3).getNombre());
			smt7.setString(3, celta.getJugadores().get(3).getApellido());
			smt7.setFloat(4, celta.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, celta.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, celta.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, celta.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, celta.getJugadores().get(3).getTecnica());
			smt7.setString(9, celta.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+20+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 20);
			smt7.setString(2, celta.getJugadores().get(4).getNombre());
			smt7.setString(3, celta.getJugadores().get(4).getApellido());
			smt7.setFloat(4, celta.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, celta.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, celta.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, celta.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, celta.getJugadores().get(4).getTecnica());
			smt7.setString(9, celta.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+21+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 21);
			smt7.setString(2, espanyol.getJugadores().get(1).getNombre());
			smt7.setString(3, espanyol.getJugadores().get(1).getApellido());
			smt7.setFloat(4, espanyol.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, espanyol.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, espanyol.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, espanyol.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, espanyol.getJugadores().get(1).getTecnica());
			smt7.setString(9, espanyol.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+22+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 22);
			smt7.setString(2, espanyol.getJugadores().get(0).getNombre());
			smt7.setString(3, espanyol.getJugadores().get(0).getApellido());
			smt7.setFloat(4, espanyol.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, espanyol.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, espanyol.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, espanyol.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, espanyol.getJugadores().get(0).getTecnica());
			smt7.setString(9, espanyol.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+23+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 23);
			smt7.setString(2, espanyol.getJugadores().get(2).getNombre());
			smt7.setString(3, espanyol.getJugadores().get(2).getApellido());
			smt7.setFloat(4, espanyol.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, espanyol.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, espanyol.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, espanyol.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, espanyol.getJugadores().get(2).getTecnica());
			smt7.setString(9, espanyol.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+24+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 24);
			smt7.setString(2, espanyol.getJugadores().get(3).getNombre());
			smt7.setString(3, espanyol.getJugadores().get(3).getApellido());
			smt7.setFloat(4, espanyol.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, espanyol.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, espanyol.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, espanyol.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, espanyol.getJugadores().get(3).getTecnica());
			smt7.setString(9, espanyol.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+25+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 25);
			smt7.setString(2, espanyol.getJugadores().get(4).getNombre());
			smt7.setString(3, espanyol.getJugadores().get(4).getApellido());
			smt7.setFloat(4, espanyol.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, espanyol.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, espanyol.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, espanyol.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, espanyol.getJugadores().get(4).getTecnica());
			smt7.setString(9, espanyol.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+26+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 26);
			smt7.setString(2, sevilla.getJugadores().get(0).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(0).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(0).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+27+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 27);
			smt7.setString(2, sevilla.getJugadores().get(1).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(1).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(1).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+28+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 28);
			smt7.setString(2, sevilla.getJugadores().get(2).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(2).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(2).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+29+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 29);
			smt7.setString(2, sevilla.getJugadores().get(3).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(3).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(3).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+30+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 30);
			smt7.setString(2, sevilla.getJugadores().get(4).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(4).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(4).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+41+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 41);
			smt7.setString(2, valencia.getJugadores().get(0).getNombre());
			smt7.setString(3, valencia.getJugadores().get(0).getApellido());
			smt7.setFloat(4, valencia.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, valencia.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, valencia.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, valencia.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, valencia.getJugadores().get(0).getTecnica());
			smt7.setString(9, valencia.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+42+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 42);
			smt7.setString(2, valencia.getJugadores().get(1).getNombre());
			smt7.setString(3, valencia.getJugadores().get(1).getApellido());
			smt7.setFloat(4, valencia.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, valencia.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, valencia.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, valencia.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, valencia.getJugadores().get(1).getTecnica());
			smt7.setString(9, valencia.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+43+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 43);
			smt7.setString(2, valencia.getJugadores().get(2).getNombre());
			smt7.setString(3, valencia.getJugadores().get(2).getApellido());
			smt7.setFloat(4, valencia.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, valencia.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, valencia.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, valencia.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, valencia.getJugadores().get(2).getTecnica());
			smt7.setString(9, valencia.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+44+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 44);
			smt7.setString(2, valencia.getJugadores().get(3).getNombre());
			smt7.setString(3, valencia.getJugadores().get(3).getApellido());
			smt7.setFloat(4, valencia.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, valencia.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, valencia.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, valencia.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, valencia.getJugadores().get(3).getTecnica());
			smt7.setString(9, valencia.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+45+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 45);
			smt7.setString(2, valencia.getJugadores().get(4).getNombre());
			smt7.setString(3, valencia.getJugadores().get(4).getApellido());
			smt7.setFloat(4, valencia.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, valencia.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, valencia.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, valencia.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, valencia.getJugadores().get(4).getTecnica());
			smt7.setString(9, valencia.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+46+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 46);
			smt7.setString(2, athletic.getJugadores().get(0).getNombre());
			smt7.setString(3, athletic.getJugadores().get(0).getApellido());
			smt7.setFloat(4, athletic.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, athletic.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, athletic.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, athletic.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, athletic.getJugadores().get(0).getTecnica());
			smt7.setString(9, athletic.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+47+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 47);
			smt7.setString(2, athletic.getJugadores().get(1).getNombre());
			smt7.setString(3, athletic.getJugadores().get(1).getApellido());
			smt7.setFloat(4, athletic.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, athletic.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, athletic.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, athletic.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, athletic.getJugadores().get(1).getTecnica());
			smt7.setString(9, athletic.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+48+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 48);
			smt7.setString(2, athletic.getJugadores().get(2).getNombre());
			smt7.setString(3, athletic.getJugadores().get(2).getApellido());
			smt7.setFloat(4, athletic.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, athletic.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, athletic.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, athletic.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, athletic.getJugadores().get(2).getTecnica());
			smt7.setString(9, athletic.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+49+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 49);
			smt7.setString(2, athletic.getJugadores().get(3).getNombre());
			smt7.setString(3, athletic.getJugadores().get(3).getApellido());
			smt7.setFloat(4, athletic.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, athletic.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, athletic.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, athletic.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, athletic.getJugadores().get(3).getTecnica());
			smt7.setString(9, athletic.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+50+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 50);
			smt7.setString(2, athletic.getJugadores().get(4).getNombre());
			smt7.setString(3, athletic.getJugadores().get(4).getApellido());
			smt7.setFloat(4, athletic.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, athletic.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, athletic.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, athletic.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, athletic.getJugadores().get(4).getTecnica());
			smt7.setString(9, athletic.getNombre());
			
			smt7.executeUpdate();
			
			}
			
rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+30+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 10);
			smt7.setString(2, sevilla.getJugadores().get(4).getNombre());
			smt7.setString(3, sevilla.getJugadores().get(4).getApellido());
			smt7.setFloat(4, sevilla.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, sevilla.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, sevilla.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, sevilla.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, sevilla.getJugadores().get(4).getTecnica());
			smt7.setString(9, sevilla.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+31+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 31);
			smt7.setString(2, betis.getJugadores().get(0).getNombre());
			smt7.setString(3, betis.getJugadores().get(0).getApellido());
			smt7.setFloat(4, betis.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, betis.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, betis.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, betis.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, betis.getJugadores().get(0).getTecnica());
			smt7.setString(9, betis.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+32+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 32);
			smt7.setString(2, betis.getJugadores().get(1).getNombre());
			smt7.setString(3, betis.getJugadores().get(1).getApellido());
			smt7.setFloat(4, betis.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, betis.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, betis.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, betis.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, betis.getJugadores().get(1).getTecnica());
			smt7.setString(9, betis.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+33+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 33);
			smt7.setString(2, betis.getJugadores().get(2).getNombre());
			smt7.setString(3, betis.getJugadores().get(2).getApellido());
			smt7.setFloat(4, betis.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, betis.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, betis.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, betis.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, betis.getJugadores().get(2).getTecnica());
			smt7.setString(9, betis.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+34+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 34);
			smt7.setString(2, betis.getJugadores().get(3).getNombre());
			smt7.setString(3, betis.getJugadores().get(3).getApellido());
			smt7.setFloat(4, betis.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, betis.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, betis.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, betis.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, betis.getJugadores().get(3).getTecnica());
			smt7.setString(9, betis.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+35+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 35);
			smt7.setString(2, betis.getJugadores().get(4).getNombre());
			smt7.setString(3, betis.getJugadores().get(4).getApellido());
			smt7.setFloat(4, betis.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, betis.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, betis.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, betis.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, betis.getJugadores().get(4).getTecnica());
			smt7.setString(9, betis.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+36+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 36);
			smt7.setString(2, atMadrid.getJugadores().get(0).getNombre());
			smt7.setString(3, atMadrid.getJugadores().get(0).getApellido());
			smt7.setFloat(4, atMadrid.getJugadores().get(0).getFuerza());
			smt7.setFloat(5, atMadrid.getJugadores().get(0).getResistencia());
			smt7.setFloat(6, atMadrid.getJugadores().get(0).getVelocidad());
			smt7.setFloat(7, atMadrid.getJugadores().get(0).getPrecision());
			smt7.setFloat(8, atMadrid.getJugadores().get(0).getTecnica());
			smt7.setString(9, atMadrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+37+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 37);
			smt7.setString(2, atMadrid.getJugadores().get(1).getNombre());
			smt7.setString(3, atMadrid.getJugadores().get(1).getApellido());
			smt7.setFloat(4, atMadrid.getJugadores().get(1).getFuerza());
			smt7.setFloat(5, atMadrid.getJugadores().get(1).getResistencia());
			smt7.setFloat(6, atMadrid.getJugadores().get(1).getVelocidad());
			smt7.setFloat(7, atMadrid.getJugadores().get(1).getPrecision());
			smt7.setFloat(8, atMadrid.getJugadores().get(1).getTecnica());
			smt7.setString(9, atMadrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+38+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 38);
			smt7.setString(2, atMadrid.getJugadores().get(2).getNombre());
			smt7.setString(3, atMadrid.getJugadores().get(2).getApellido());
			smt7.setFloat(4, atMadrid.getJugadores().get(2).getFuerza());
			smt7.setFloat(5, atMadrid.getJugadores().get(2).getResistencia());
			smt7.setFloat(6, atMadrid.getJugadores().get(2).getVelocidad());
			smt7.setFloat(7, atMadrid.getJugadores().get(2).getPrecision());
			smt7.setFloat(8, atMadrid.getJugadores().get(2).getTecnica());
			smt7.setString(9, atMadrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+39+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 39);
			smt7.setString(2, atMadrid.getJugadores().get(3).getNombre());
			smt7.setString(3, atMadrid.getJugadores().get(3).getApellido());
			smt7.setFloat(4, atMadrid.getJugadores().get(3).getFuerza());
			smt7.setFloat(5, atMadrid.getJugadores().get(3).getResistencia());
			smt7.setFloat(6, atMadrid.getJugadores().get(3).getVelocidad());
			smt7.setFloat(7, atMadrid.getJugadores().get(3).getPrecision());
			smt7.setFloat(8, atMadrid.getJugadores().get(3).getTecnica());
			smt7.setString(9, atMadrid.getNombre());
			
			smt7.executeUpdate();
			
			}
			
			rs = comparacion.executeQuery("SELECT id_jugador FROM jugadores WHERE id_jugador="+40+"");
			
			if(!rs.next()) {
			smt7.setInt(1, 40);
			smt7.setString(2, atMadrid.getJugadores().get(4).getNombre());
			smt7.setString(3, atMadrid.getJugadores().get(4).getApellido());
			smt7.setFloat(4, atMadrid.getJugadores().get(4).getFuerza());
			smt7.setFloat(5, atMadrid.getJugadores().get(4).getResistencia());
			smt7.setFloat(6, atMadrid.getJugadores().get(4).getVelocidad());
			smt7.setFloat(7, atMadrid.getJugadores().get(4).getPrecision());
			smt7.setFloat(8, atMadrid.getJugadores().get(4).getTecnica());
			smt7.setString(9, atMadrid.getNombre());
			
			smt7.executeUpdate();
			
			}
		      con.close();
		      System.out.println("conexion cerrada con exito");
		      
		      
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		 
	       
	      
		
	}
	
	public Equipo getMiEquipo() {
		return miEquipo;
	}

	public void setMiEquipo(Equipo miEquipo) {
		this.miEquipo = miEquipo;
	}


	public Liga getLigaSantander() {
		return ligaSantander;
	}

	public void setLigaSantander(Liga santander) {
		this.ligaSantander = santander;
	}

	/**
	 * @return the usuario
	 */
	/*public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	/*public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
	
	
	
	public void irAResultados() {
		if(resultados == null) {
			this.resultados = new Resultados(this);
			
		}
		if(this.resultados != null) {
			
			this.resultados.setVisible(false);
		}
		
		this.setContentPane(resultados);
		this.resultados.setVisible(true);
		
	}
	
	public void irAClasificacion() {
		if(panelClasificacion == null) {
			this.panelClasificacion = new PanelClasificacion(this);
			
		}
		if(this.seleccionEquipo!=null) {
			
			this.seleccionEquipo.setVisible(false);
		}
		this.setContentPane(panelClasificacion);
		this.panelClasificacion.setVisible(true);
	}
	
	public void irAPanelInicio() {
		if(panelInicio == null) {
			this.panelInicio = new PanelInicio(this);
			
		}
		if(this.panelInicio!=null) {
			
			this.panelInicio.setVisible(false);
		}
		this.setContentPane(panelInicio);
		this.panelInicio.setVisible(true);
		
	}
	
	public void irAJornada() {
		if(panelJornada == null) {
			this.panelJornada = new PanelJornada(this);
			
		}
		if(this.panelJornada!=null) {
			
			this.panelJornada.setVisible(false);
		}
		this.setContentPane(panelJornada);
		this.panelJornada.setVisible(true);
	}
	
	public void irASeleccionEquipo() {
		//1 - Inicializar login si no lo está ya
		if(seleccionEquipo==null) {
			this.seleccionEquipo=new SeleccionEquipo(this);
		}
		if(this.seleccionEquipo!=null) {
			this.seleccionEquipo.setVisible(false);
		}
		//3 - Establecer el contentPane a esta nueva pantalla (JPanel)
		this.setContentPane(seleccionEquipo);
		this.seleccionEquipo.setVisible(true);
	}
	
	
	public void irAPrincipal() {
		if(principal==null) {
			this.principal=new Principal(this);
		}
		if(this.principal!=null) {
			principal.setVisible(false);
		}
		if(this.principal!=null) {
			principal.setVisible(false);
		}
		this.setContentPane(principal);
		this.principal.setVisible(true);
	}

	public void repintarPanelJornada() {
		
		if(this.panelJornada != null) {
		panelJornada.removeAll();
		panelJornada.initComponents();
		}
		
	}
	
public void repintarPanelResultados() {
		
	if(this.resultados != null) {
		panelJornada.removeAll();
		resultados.initComponents();
		
	}
	}

public void repintarClasificacion() {
	
	if(this.panelClasificacion != null) {
		panelClasificacion.removeAll();
		panelClasificacion.initComponents();
	}
	
}
	
}
