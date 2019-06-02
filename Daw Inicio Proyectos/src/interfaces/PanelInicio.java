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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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

import competiciones.Jornada;
import competiciones.Liga;
import competiciones.Partido;

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
				
				   ventana.irASeleccionEquipo();
    
			}
		});
		botonNuevaPartida.setBounds(91, 150, 199, 63);
		add(botonNuevaPartida);
		

		
		
		
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
