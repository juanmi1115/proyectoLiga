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
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelClasificacion extends JPanel{
	private Ventana ventana;
	private JTable table;
	private Equipo equipo;
	
	
	public PanelClasificacion(Ventana v){
		super();
		this.ventana = v;
		setBackground(new Color(135, 206, 250));
		setSize(769,600);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		
		JLabel lblClasificacin = new JLabel("CLASIFICACIÓN");
		lblClasificacin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		
		JButton botonSiguienteJornada = new JButton("Siguiente Jornada");
		botonSiguienteJornada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			       ventana.irAJornada();
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonSiguienteJornada, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(249)
							.addComponent(lblClasificacin, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(101, Short.MAX_VALUE)));
				
				
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblClasificacin, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(botonSiguienteJornada, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		
		table = new JTable();
		table.setRowHeight(25);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1,"REAL MADRID C.F", "-", "-", "-", "-", "-", "-", "-"},
				{2, "F.C BARCELONA", "-", "-", "-", "-", "-", "-", "-"},
				{3, "MÁLAGA C.F", "-", "-", "-", "-", "-", "-", "-"},
				{4, "CELTA F.C", "-", "-", "-", "-", "-", "-", "-"},
				{5, "SEVILLA F.C", "-", "-", "-", "-", "-", "-", "-"},
				{6, "REAL BETIS B", "-", "-", "-", "-", "-", "-", "-"},
				{7, "ESPANYOL F.C", "-", "-", "-", "-", "-", "-", "-"},
				{8, "ATHLETIC", "-", "-", "-", "-", "-", "-", "-"},
				{9, "ATLÉTICO", "-", "-", "-", "-", "-", "-", "-"},
				{10, "VALENCIA F.C", "-", "-", "-", "-", "-", "-", "-"},
			},
			new String[] {
				"POS", "EQUIPO", "PJ", "V", "E", "D", "GF", "GC", "DIF"
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
		setLayout(groupLayout);
		
		setVisible(true);
		
		
	}
	

	     
}
