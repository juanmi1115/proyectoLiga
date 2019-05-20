package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class BotonNuevaPartida extends JButton {
	public BotonNuevaPartida(String txt) {
		super(txt);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Miriam Libre", Font.PLAIN, 23));
		this.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		this.setBackground(new Color(65, 105, 225));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(95, 135, 255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(new Color(65, 105, 225));
			}
		});
	
	}
	
	public BotonNuevaPartida(String txt,Color c) {
		super(txt);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Miriam Libre", Font.PLAIN, 23));
		this.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		this.setBackground(c);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
