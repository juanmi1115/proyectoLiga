package componentes;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MiLabel extends JLabel{
	public MiLabel(String txt,int fontSize) {
		super(txt);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Miriam Libre", Font.PLAIN, fontSize));
		
	}
	
	public MiLabel(String txt,int fontSize,int style) {
		super(txt);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Miriam Libre", style, fontSize));
		
	}
	
	public MiLabel(String txt) {
		super(txt);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Miriam Libre", Font.PLAIN, 16));
		
	}
}
