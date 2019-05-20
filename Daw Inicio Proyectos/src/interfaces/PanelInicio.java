package interfaces;

import javax.swing.JPanel;

import static equiposJugadores.Caracteristicas.FUERZA;
import static equiposJugadores.Caracteristicas.PRECISION;
import static equiposJugadores.Caracteristicas.RESISTENCIA;
import static equiposJugadores.Caracteristicas.TECNICA;
import static equiposJugadores.Caracteristicas.VELOCIDAD;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.HashMap;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;

import componentes.BotonNuevaPartida;
import componentes.MiLabel;
import equiposJugadores.Equipo;
import equiposJugadores.Estadio;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class PanelInicio extends JPanel {
	private Ventana ventana;
	private Image imagenFondo;
	private URL fondo;
	
	
	public PanelInicio(Ventana v) {
		super();
		setForeground(new Color(255, 255, 255));
		this.ventana=v;
		setSize(new Dimension(600, 600));
		setBackground(new Color(150, 200, 150));
		setLayout(null);
		
		BotonNuevaPartida botonNuevaPartida = new BotonNuevaPartida("Nueva Partida");
		
		botonNuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				   
			       
			       
			       ventana.setEquipos(new HashMap<String,Equipo>());
			       ventana.getEquipos().put("REAL MADRID C.F", new Equipo("REAL MADRID C.F", RESISTENCIA, bernabeu));
			       ventana.getEquipos().put("F.C BARCELONA", new Equipo("F.C BARCELONA", VELOCIDAD, camp));
			       ventana.getEquipos().put("MÁLAGA C.F", new Equipo("MÁLAGA C.F", TECNICA, rosaleda));
			       ventana.getEquipos().put("REAL BETIS B", new Equipo("REAL BETIS B", RESISTENCIA, villa));
			       ventana.getEquipos().put("SEVILLA F.C", new Equipo("SEVILLA F.C", PRECISION, pizjuan));
			       ventana.getEquipos().put("ESPANYOL F.C", new Equipo("ESPANYOL F.C", TECNICA, carmenes));
			       ventana.getEquipos().put("CELTA F.C", new Equipo("CELTA F.C", FUERZA, carranza));
			       ventana.getEquipos().put("ATLÉTICO", new Equipo("ATLÉTICO", TECNICA, wanda));
			       ventana.getEquipos().put("VALENCIA F.C", new Equipo("VALENCIA F.C", VELOCIDAD, mestalla));
			       ventana.getEquipos().put("ATHLETIC", new Equipo("ATHLETIC", PRECISION, arcangel));
				   
			       ventana.irASeleccionEquipo();
			}
		});
		botonNuevaPartida.setBounds(129, 369, 199, 63);
		add(botonNuevaPartida);
		
		BotonNuevaPartida btnRegistro = new BotonNuevaPartida("Cargar Partida");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irARegistro();
			}
		});
		btnRegistro.setBounds(391, 369, 199, 63);
		add(btnRegistro);
		
		
		
		fondo = this.getClass().getResource("/interfaces/fondoFutbol2.jpg");
		imagenFondo = new ImageIcon(fondo).getImage();
		
		MiLabel labelBienvenido = new MiLabel("Bienvenido/a",35,Font.BOLD);
		labelBienvenido.setBounds(160, 78, 280, 47);
		add(labelBienvenido);
		
		MiLabel labelSubtitulo = new MiLabel("LIGA FANTASY 2019",18);
		labelSubtitulo.setDoubleBuffered(true);
		labelSubtitulo.setBounds(160, 167, 280, 63);
		add(labelSubtitulo);
		
		
		this.setVisible(true);
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		
	}

	
	
}
