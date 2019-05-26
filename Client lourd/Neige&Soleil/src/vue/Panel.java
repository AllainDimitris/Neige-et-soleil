package vue;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	public Panel() {
		this.setBounds(100, 60, 800	, 400);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		this.setVisible(false);
	}
}
