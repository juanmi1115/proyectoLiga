package interfaces;
import javax.swing.JFrame;

import clases.Usuario;
import equiposJugadores.Equipo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Ventana extends JFrame {
	private PanelInicio elr;
	private SeleccionEquipo seleccionEquipo;
	private Registro registro;
	private Usuario usuario;
	private Principal principal;
	private HashMap<String,Equipo> equipos;
	private Equipo miEquipo;
	private PanelClasificacion panelClasificacion;
	private PanelJornada panelJornada;
	//private Connection con;
	
	public Equipo getMiEquipo() {
		return miEquipo;
	}

	public void setMiEquipo(Equipo miEquipo) {
		this.miEquipo = miEquipo;
	}

	public HashMap<String, Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(HashMap<String, Equipo> equipo) {
		this.equipos = equipo;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	/*public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}*/

	public Ventana() {
		super();
		elr=new PanelInicio(this);
		this.setTitle("Mi programa");
		this.setSize(720,600);
		this.setContentPane(elr);
		this.setResizable(false);
		this.setVisible(true);
		
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
		if(this.elr!=null) {
			this.elr.setVisible(false);
		}
		//3 - Establecer el contentPane a esta nueva pantalla (JPanel)
		this.setContentPane(seleccionEquipo);
		this.seleccionEquipo.setVisible(true);
	}
	
	public void irARegistro() {
		if(this.registro==null) {
			registro=new Registro(this);
		}
		if(this.elr!=null) {
			this.elr.setVisible(false);
		}
		this.setContentPane(registro);
		this.registro.setVisible(true);
	}

	public void irAEligeLoginRegistro() {
		if(elr==null) {
			this.elr=new PanelInicio(this);
		}
		if(this.registro!=null) {
			registro.setVisible(false);
		}
		if(this.seleccionEquipo!=null) {
			seleccionEquipo.setVisible(false);
		}
		this.setContentPane(elr);
		this.elr.setVisible(true);
	}
	
	public void irAPrincipal() {
		if(principal==null) {
			this.principal=new Principal(this);
		}
		if(this.registro!=null) {
			registro.setVisible(false);
		}
		if(this.seleccionEquipo!=null) {
			seleccionEquipo.setVisible(false);
		}
		this.setContentPane(principal);
		this.principal.setVisible(true);
	}

	
}
