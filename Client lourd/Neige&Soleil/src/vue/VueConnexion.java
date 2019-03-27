package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controleur.Main;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {

		private JPanel unPanel = new JPanel();
		private JTextField txtEmail = new JTextField();
		private JPasswordField txtMdp = new JPasswordField();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btSeconnecter = new JButton("Se connecter");
		
		public VueConnexion() {
			
			this.setTitle("Administration Neige et Soleil");
			this.setResizable(false);
			this.setBounds(200, 200, 700, 300);
			this.setLayout(null);
			this.getContentPane().setBackground(Color.white);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.unPanel.setBounds(300, 40, 350, 200);
			this.unPanel.setBackground(Color.cyan);
			this.unPanel.setLayout(new GridLayout (3, 2));
			this.unPanel.add(new JLabel ("Email :"));
			this.unPanel.add(this.txtEmail);
			this.unPanel.add(new JLabel ("MDP :"));
			this.unPanel.add(this.txtMdp);
			this.unPanel.add(this.btAnnuler);
			this.unPanel.add(this.btSeconnecter);
			this.add(this.unPanel);
			
			//Changement de la police des objets graphiques du panel
			Font unePolice = new Font ("Arial", Font.ITALIC, 20);
			for(int i = 0 ; i<this.unPanel.getComponentCount(); i++)
			{
				this.unPanel.getComponent(i).setFont(unePolice);
			}
			//Rendre les boutons cliquables
			this.btAnnuler.addActionListener(this);
			this.btSeconnecter.addActionListener(this);
			
			//Rendre les textes ecoutables
			this.txtEmail.addKeyListener(this);
			this.txtMdp.addKeyListener(this);
			
			//Insertion de l'image
			ImageIcon uneImage = new ImageIcon ("src/images/neige.jpg");
			JLabel monImage = new JLabel(uneImage);
			monImage.setBounds(30, 40, 200, 200);
			this.add(monImage);
			
			this.setVisible(true);
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				//Permet de switcher selon ce qui est écrit sur le button et non pas le button lui-même
			case "Annuler" : this.txtEmail.setText("");
							 this.txtMdp.setText("");
							 break;
			case "Se connecter" : 
							String email = this.txtEmail.getText();
							String mdp = new String (this.txtMdp.getPassword());
							Main.verifConnexion (email,mdp);
							break;
			}
		}


		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				String email = this.txtEmail.getText();
				String mdp = new String (this.txtMdp.getPassword());
				Main.verifConnexion (email,mdp);
			}
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
}
