package interfaces;

import javax.swing.JPanel;

import componentes.MiLabel;

import javax.swing.JLabel;

public class Principal extends JPanel{
	private Ventana ventana;
	
	public Principal(Ventana v) {
		super();
		ventana=v;
		setLayout(null);
		MiLabel lblHola = new MiLabel
		("Hola ,"+ventana.getUsuario().getNombre(),30);
		lblHola.setBounds(10, 11, 430, 42);
		add(lblHola);
		this.ventana.setSize(400,400);
	}
}
