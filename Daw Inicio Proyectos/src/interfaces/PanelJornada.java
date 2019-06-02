package interfaces;

import javax.swing.JPanel;

import competiciones.Jornada;
import competiciones.Liga;
import competiciones.Partido;
import equiposJugadores.Equipo;
import equiposJugadores.Estadio;
import excepciones.restriccionEquipo;

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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.SystemColor;

public class PanelJornada extends JPanel implements Serializable{
	private Ventana ventana;
	private Jornada jornada;
	private Equipo equipo;
	private Partido partido;
	
	
	public PanelJornada(Ventana v) {
		super();
		
		this.ventana = v;
		initComponents();
		
	}
		public void initComponents() {
		setBackground(SystemColor.textHighlight);
		setSize(769,600);
	        
	       
	       
	            	
	       JButton btnNewButton = new JButton("Ir a clasificacion");

	       setLayout(null);
	       
	       JTextPane ultima = new JTextPane();
	       ultima.setForeground(new Color(204, 255, 255));
	       ultima.setFont(new Font("Power Clear", Font.PLAIN, 22));
	       ultima.setEditable(false);
	       ultima.setBackground(SystemColor.textHighlight);
	       ultima.setBounds(200, 83, 480, 259);
	       add(ultima);
	       

	       try {
	       for (int i = 0; i < ventana.getLigaSantander().getJornada().length; i++) {
			
	    	   ultima.setText(ventana.getLigaSantander().proximaJornada());
	       }

	       }catch(Exception e) {
			JOptionPane.showMessageDialog(ventana,"Tu equipo:"+ventana.getMiEquipo().getNombre()+"ha finalizado con :"+ventana.getMiEquipo().getPuntos()+"puntos", "La liga a finalizado", JOptionPane.WARNING_MESSAGE);
			ventana.irAPanelInicio();
		}
	      
		 	
	      	JButton btnResultados = new JButton("RESULTADOS");
	      	btnResultados.setBorder(null);
	      	btnResultados.setBackground(new Color(204, 255, 255));
	      	btnResultados.setForeground(Color.ORANGE);
	      	btnResultados.addMouseListener(new MouseAdapter() {
	      		@Override
	      		public void mouseClicked(MouseEvent arg0) {
	      			
	      			
	      			ventana.getLigaSantander().simularSiguienteJornada();
	      			ventana.repintarPanelResultados();
	 
	      			ventana.irAResultados();
	      		}
	      	});
	      	
	      	

	      	btnResultados.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent arg0) {
	      		}
	      	});
	      	btnResultados.setBounds(316, 353, 173, 60);
	      	add(btnResultados);

	      
	       
	       setVisible(true);
		
		}
	}

