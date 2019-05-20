package interfaces;

import javax.swing.JPanel;

import competiciones.Jornada;
import competiciones.Liga;
import competiciones.Partido;
import equiposJugadores.Equipo;
import equiposJugadores.Estadio;

import static equiposJugadores.Caracteristicas.FUERZA;
import static equiposJugadores.Caracteristicas.PRECISION;
import static equiposJugadores.Caracteristicas.RESISTENCIA;
import static equiposJugadores.Caracteristicas.TECNICA;
import static equiposJugadores.Caracteristicas.VELOCIDAD;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Point;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelJornada extends JPanel{
	private Ventana ventana;
	private Jornada jornada;
	private Equipo equipo;
	private Partido partido;
	
	public PanelJornada(Ventana v) {
		super();
		setBackground(new Color(144, 238, 144));
		this.ventana = v;
		setSize(769,600);
		
		
		
		
		
		
		
		
		String [][]matrizCampo = new String [3][4];
		
		   Estadio rosaleda = new Estadio("La Rosaleda",matrizCampo);
	       Estadio bernabeu = new Estadio("Santiago Bernabeu",matrizCampo);
	       Estadio camp = new Estadio("Camp Nou",matrizCampo);
	       Estadio villa = new Estadio("Benito Villamarín",matrizCampo);
	       Estadio pizjuan = new Estadio("Sánchez Pizjuán",matrizCampo);
	       Estadio carmenes= new Estadio("Los Cármenes",matrizCampo);
	       Estadio carranza = new Estadio("Nuevo Carranza",matrizCampo);
	       Estadio wanda = new Estadio("Wanda Metropolitano",matrizCampo);
	       Estadio mestalla = new Estadio("Mestalla",matrizCampo);
	       Estadio arcangel = new Estadio("Nuevo Arcángel",matrizCampo);
		 
		   Equipo madrid = new Equipo("REAL MADRID C.F", RESISTENCIA, bernabeu);
	       Equipo barcelona = new Equipo("F.C BARCELONA", VELOCIDAD, camp);
	       Equipo malaga = new Equipo ("MÁLAGA C.F",TECNICA,rosaleda);
	       Equipo betis = new Equipo ("REAL BETIS BALOMPIÉ",RESISTENCIA,villa);
	       Equipo sevilla = new Equipo ("SEVILLA F.C",PRECISION,pizjuan);
	       Equipo espanyol = new Equipo ("ESPANYOL F.C",TECNICA,carmenes);
	       Equipo celta = new Equipo ("CELTA F.C",FUERZA,carranza);
	       Equipo atMadrid = new Equipo ("ATLÉTICO DE MADRID",TECNICA,wanda);
	       Equipo valencia = new Equipo ("VALENCIA C.F",VELOCIDAD,mestalla);
	       Equipo athletic = new Equipo ("ATHLETIC CLUB",PRECISION,arcangel);
	      
	       Equipo [] equiposLiga = {madrid, barcelona, malaga, betis, sevilla, espanyol, celta, atMadrid, valencia, athletic};
	       
	       
	     //Jornada 1
	       Partido p1 = new Partido(malaga , madrid);
	       Partido p2 = new Partido(barcelona , betis);
	       Partido p3 = new Partido(sevilla , espanyol);
	       Partido p4 = new Partido(celta , atMadrid);
	       Partido p5 = new Partido(valencia , athletic);
	       
	     //Jornada 2
	       Partido p6 = new Partido(malaga , barcelona);
	       Partido p7 = new Partido(madrid , atMadrid);
	       Partido p8 = new Partido(celta , betis);
	       Partido p9 = new Partido(espanyol , athletic);
	       Partido p10 = new Partido(valencia , sevilla);
	       
	       //Jornada 3
	       Partido p11 = new Partido(malaga , betis);
	       Partido p12 = new Partido(barcelona , madrid);
	       Partido p13 = new Partido(sevilla , athletic);
	       Partido p14 = new Partido(valencia , atMadrid);
	       Partido p15 = new Partido(celta , espanyol);
	       
	       //Jornada 4 
	       Partido p16 = new Partido(malaga , celta);
	       Partido p17 = new Partido(madrid , betis);
	       Partido p18 = new Partido(sevilla , barcelona);
	       Partido p19 = new Partido(athletic , atMadrid);
	       Partido p20 = new Partido(valencia , espanyol);
	       
	       //Jornada 5
	       Partido p21 = new Partido(malaga , espanyol);
	       Partido p22 = new Partido(valencia , madrid);
	       Partido p23 = new Partido(sevilla , celta );
	       Partido p24 = new Partido(barcelona , atMadrid);
	       Partido p25 = new Partido(betis , athletic);
	       
	       //jornada 6
	       Partido p26 = new Partido(athletic , madrid);
	       Partido p27 = new Partido(sevilla , atMadrid);
	       Partido p28 = new Partido(betis , espanyol);
	       Partido p29 = new Partido(malaga , valencia);
	       Partido p30 = new Partido(barcelona , celta);
	       
	       //Jornada 7
	       Partido p31 = new Partido(sevilla , betis);
	       Partido p32 = new Partido(barcelona , valencia);
	       Partido p33 = new Partido(celta , madrid);
	       Partido p34 = new Partido(espanyol , atMadrid);
	       Partido p35 = new Partido(athletic , malaga);
	       
	       //jornada 8
	       Partido p36 = new Partido(malaga , sevilla);
	       Partido p37 = new Partido(atMadrid , betis);
	       Partido p38 = new Partido(espanyol , madrid);
	       Partido p39 = new Partido(celta , valencia);
	       Partido p40 = new Partido(barcelona , athletic);
	       
	       
	       Partido [] partidosJornada1 = {p1, p2, p3, p4, p5};
	       Partido [] partidosJornada2 = {p6, p7, p8, p9, p10};
	       Partido [] partidosJornada3 = {p11, p12, p13, p14, p15};
	       Partido [] partidosJornada4 = {p16, p17, p18, p19, p20};
	       Partido [] partidosJornada5 = {p21, p22, p23, p24, p25};
	       Partido [] partidosJornada6 = {p26, p27, p28, p29, p30};
	       Partido [] partidosJornada7 = {p31, p32, p33, p34, p35};
	       Partido [] partidosJornada8 = {p36, p37, p38, p39, p40};
	      
	      Jornada j1 = new Jornada (1, partidosJornada1); 
	      Jornada j2 = new Jornada (2, partidosJornada2);
	      Jornada j3 = new Jornada (3, partidosJornada3);
	      Jornada j4 = new Jornada (4, partidosJornada4);
	      Jornada j5 = new Jornada (5, partidosJornada5); 
	      Jornada j6 = new Jornada (6, partidosJornada6);
	      Jornada j7 = new Jornada (7, partidosJornada7);
	      Jornada j8 = new Jornada (8, partidosJornada8);
	      
	      Jornada [] jornadasLiga = {j1, j2 , j3 , j4 , j5 , j6 , j7 , j8};
	       
	       
	       
	       
	       
	       Liga santander = new Liga("Santander",equiposLiga,jornadasLiga);
	      
	       
	       
	       
	       for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 5; j++) {
	              
	              String jornada1;
	              santander.getJornada()[i].getPartido()[j].simular();  
	              JTextPane textPane = new JTextPane();
	   	       		textPane.setBounds(253, 115, 219, 185);
	   	       add(textPane);
	        
	            switch(jornada.getNumeroJornada()) {
	            case 1:
	            	jornada1 = j1.toString();
	            	
	            	textPane.setText(jornada1);
	       
	       		
	       
	       }
	       }
	       }  
	
	

	       setLayout(null);
	       
	       
	       
	       setVisible(true);
		
	
	}
}
