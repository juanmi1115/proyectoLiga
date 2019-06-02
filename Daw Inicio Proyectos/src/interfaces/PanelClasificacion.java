package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import competiciones.Jornada;
import competiciones.Liga;
import competiciones.Partido;

import static equiposJugadores.Caracteristicas.FUERZA;
import static equiposJugadores.Caracteristicas.PRECISION;
import static equiposJugadores.Caracteristicas.RESISTENCIA;
import static equiposJugadores.Caracteristicas.TECNICA;
import static equiposJugadores.Caracteristicas.VELOCIDAD;

import equiposJugadores.Equipo;
import equiposJugadores.Estadio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class PanelClasificacion extends JPanel implements Serializable{
	private Ventana ventana;
	private JTable table;
	private Equipo equipo;

	
	public PanelClasificacion(Ventana v){
		super();
		this.ventana = v;
		initComponents();

	}

		public void initComponents() {
			

		setBackground(SystemColor.textHighlight);
		
		setSize(800,550);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(204, 255, 255));
		scrollPane.setBackground(Color.GREEN);
		
		JLabel lblClasificacin = new JLabel("CLASIFICACIÓN");
		lblClasificacin.setForeground(new Color(153, 255, 255));
		lblClasificacin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		
		Comparator<Equipo> comparator = new Comparator<Equipo>() {
			public int compare(Equipo a, Equipo b) {

				int resultado = Integer.compare(a.getPuntos(), b.getPuntos());
				if (resultado != 0) {
					return resultado;
				}

				resultado = Integer.compare(a.getGF() - a.getGC(),
						b.getGF() - b.getGC());
				if (resultado != 0) {
					return resultado;
				}

				return resultado;

			}
		};
		
		table = new JTable();
		table.setRowHeight(25);
		Object[][] clas=new Object[10][];
		Iterator itEquipos=ventana.getLigaSantander().getEquipo().entrySet().iterator();
		int numEquipo=0;
		while(itEquipos.hasNext()) {
			Equipo e=((Equipo)((Entry)itEquipos.next()).getValue());
			String nombre=e.getNombre();
			int puntos = e.getPuntos();	
			int V = e.getV();
			int E = e.getE();
			int D = e.getD();
			int GF = e.getGF();
			int GC = e.getGC();
			int PJ = e.getPartidosJugados();
			
			
			if(e.equals(ventana.getMiEquipo())) {
				nombre="<html><body><b>"+nombre+"</b></body></html>";

			}
			
			
			clas[numEquipo]= new Object[]{numEquipo,nombre,puntos,V,E,D,GF,GC,PJ};
			numEquipo++;
		}
		
		table.setModel(new DefaultTableModel(
				clas,
			new String[] {
				"POS", "EQUIPO", "Puntos", "V", "E", "D", "GF", "GC", "PJ"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		
		
		
		
		
		JButton botonSiguienteJornada = new JButton("");
		botonSiguienteJornada.setIcon(new ImageIcon(PanelClasificacion.class.getResource("/interfaces/Forwardarrow_262.png")));
		botonSiguienteJornada.setBorderPainted(false);
		botonSiguienteJornada.setContentAreaFilled(false);
		botonSiguienteJornada.setBorder(null);
		botonSiguienteJornada.setPreferredSize(new Dimension(120, 120));
		botonSiguienteJornada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
			    ventana.repintarPanelJornada();   
				ventana.irAJornada();
				}	
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(295, Short.MAX_VALUE)
					.addComponent(lblClasificacin, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(236))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(637, Short.MAX_VALUE)
					.addComponent(botonSiguienteJornada, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblClasificacin, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(botonSiguienteJornada, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		

		
		setVisible(true);
		
		}
		
}
	

	     

