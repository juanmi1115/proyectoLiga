package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import equiposJugadores.Equipo;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionEquipo extends JPanel{
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private Ventana ventana;
	private Equipo equipo;
	
	public SeleccionEquipo(Ventana v) {
		super();
		setBackground(new Color(175, 238, 238));
		this.ventana=v;
		setSize(600,600);
		setLayout(null);
		
		
		JLabel lblSeleccionaTuEquipo = new JLabel("SELECCIONA TU EQUIPO");
		lblSeleccionaTuEquipo.setFont(new Font("Book Antiqua", Font.PLAIN, 24));
		lblSeleccionaTuEquipo.setBounds(201, 40, 334, 23);
		add(lblSeleccionaTuEquipo);
		
		JButton botonMalaga = new JButton("MÁLAGA C.F");
		botonMalaga.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(0, 0, 255)));
		botonMalaga.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonMalaga.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonMalaga.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/malaga_cf_footballteam_18013 (1).png")));
		botonMalaga.setBackground(SystemColor.scrollbar);
		botonMalaga.setBounds(114, 110, 190, 50);
		add(botonMalaga);
		botonMalaga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.setMiEquipo(ventana.getEquipos().get(botonMalaga.getText()));
				System.out.println(ventana.getMiEquipo());
				
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonBarcelona = new JButton("F.C BARCELONA");
		botonBarcelona.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/fc_barcelona_footballteam_18015 (1).png")));
		botonBarcelona.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
		botonBarcelona.setBackground(SystemColor.scrollbar);
		botonBarcelona.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonBarcelona.setBounds(400, 110, 190, 50);
		add(botonBarcelona);
		botonBarcelona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonBarcelona.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonRealMadrid = new JButton("REAL MADRID C.F");
		botonRealMadrid.setBorder(new MatteBorder(1, 3, 5, 1, (Color) Color.WHITE));
		botonRealMadrid.setBackground(SystemColor.scrollbar);
		botonRealMadrid.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/real_madrid_footballteam_18009.png")));
		botonRealMadrid.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonRealMadrid.setBounds(114, 192, 190, 54);
		add(botonRealMadrid);
		botonRealMadrid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonRealMadrid.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonCelta = new JButton("CELTA F.C");
		botonCelta.setBorder(new MatteBorder(1, 1, 3, 3, (Color) Color.CYAN));
		botonCelta.setBackground(SystemColor.scrollbar);
		botonCelta.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonCelta.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/celta-de-vigo_109482.png")));
		botonCelta.setBounds(400, 191, 190, 54);
		add(botonCelta);
		botonCelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonCelta.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonSevilla = new JButton("SEVILLA F.C");
		botonSevilla.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(255, 153, 153)));
		botonSevilla.setBackground(SystemColor.scrollbar);
		botonSevilla.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/sevilla_109492.png")));
		botonSevilla.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonSevilla.setBounds(114, 285, 190, 54);
		add(botonSevilla);
		botonSevilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonSevilla.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		
		JButton botonBetis = new JButton("REAL BETIS B");
		botonBetis.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(51, 255, 0)));
		botonBetis.setBackground(SystemColor.scrollbar);
		botonBetis.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonBetis.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/betis_109480.png")));
		botonBetis.setBounds(400, 285, 190, 54);
		add(botonBetis);
		botonBetis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonBetis.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonEspanyol = new JButton("ESPANYOL F.C");
		botonEspanyol.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(0, 102, 255)));
		botonEspanyol.setBackground(SystemColor.scrollbar);
		botonEspanyol.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonEspanyol.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/espanyol_footballteam_18016.png")));
		botonEspanyol.setBounds(114, 375, 190, 50);
		add(botonEspanyol);
		botonEspanyol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonEspanyol.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		
		JButton botonAtletico = new JButton("ATLÉTICO");
		botonAtletico.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(255, 0, 0)));
		botonAtletico.setBackground(SystemColor.scrollbar);
		botonAtletico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonAtletico.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/atletico_madrid_footballteam_18020.png")));
		botonAtletico.setBounds(400, 375, 190, 50);
		add(botonAtletico);
		botonAtletico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonAtletico.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonAthletic = new JButton("ATHLETIC ");
		botonAthletic.setBorder(new MatteBorder(1, 3, 3, 1, (Color) new Color(204, 0, 0)));
		botonAthletic.setBackground(SystemColor.scrollbar);
		botonAthletic.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonAthletic.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/athletic_bilbao_footballteam_18021.png")));
		botonAthletic.setBounds(116, 465, 188, 50);
		add(botonAthletic);
		botonAthletic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonAthletic.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		
		JButton botonValencia = new JButton("VALENCIA F.C");
		botonValencia.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		botonValencia.setBackground(SystemColor.scrollbar);
		botonValencia.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		botonValencia.setIcon(new ImageIcon(SeleccionEquipo.class.getResource("/interfaces/valencia_109487.png")));
		botonValencia.setBounds(394, 465, 196, 50);
		add(botonValencia);
		botonValencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.setMiEquipo(ventana.getEquipos().get(botonValencia.getText()));
				System.out.println(ventana.getMiEquipo());
				ventana.irAClasificacion();
			}
			
			
		});
		
		JButton btnAtrs = new JButton("atrás");
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		btnAtrs.setBounds(304, 541, 91, 23);
		add(btnAtrs);
		this.setVisible(true);
	}

}
