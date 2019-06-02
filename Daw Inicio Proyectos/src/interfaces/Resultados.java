package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.SystemColor;

/*
 * 
 * Autor:Juanmi
 * Clase donde se guarda el panel de los resultados
 * */
public class Resultados extends JPanel{
	private Ventana ventana;
		
	//Constructor de Resultados al que le pasa por parámetros Ventana para que se muestre sobre ella
		public Resultados(Ventana v) {
			super();
			setForeground(new Color(204, 255, 255));
			setPreferredSize(new Dimension(800, 550));
			setBackground(SystemColor.textHighlight);
			this.ventana = v;
			initComponents();
		}
			
			//Iniciamos InitCOmponents para que sea interactivo el panel, e introducimos todos los cambios en ella
			public void initComponents() {
			setLayout(null);
			
			//TextPane que contiene los resultados de la jornada actual
			JTextPane textPane = new JTextPane();
			textPane.setForeground(new Color(204, 255, 255));
			textPane.setFont(new Font("Power Clear", Font.PLAIN, 22));
			textPane.setEditable(false);
			textPane.setBackground(SystemColor.textHighlight);
			textPane.setBounds(200, 83, 480, 259);
			textPane.setText(ventana.getLigaSantander().resultadosUltimaJornada());
			add(textPane);
	
			//JButton que te lleva hasta la ventana de clasificación
			JButton btnClasificacin = new JButton("Clasificación");
			btnClasificacin.setBorder(null);
			btnClasificacin.setBackground(new Color(204, 255, 255));
			btnClasificacin.setForeground(SystemColor.textHighlight);
			btnClasificacin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					ventana.repintarClasificacion();
					ventana.irAClasificacion();
					
				}
				
			});
			btnClasificacin.setBounds(307, 353, 156, 59);
			add(btnClasificacin);
			
			
			
			
		}

}
