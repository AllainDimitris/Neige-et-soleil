package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Main;
import controleur.User;

public class VueGenerale  extends JFrame implements ActionListener {
	
	private JButton btQuitter = new JButton("Quitter");
	private JPanel panelProfil = new JPanel();

	private static PanelHabitation unPanelHabitation = new PanelHabitation();
	private JButton btHabitation = new JButton("Habitation");
	
	private JButton btClient = new JButton("Client");
	private PanelClient unPanelClient = new PanelClient();
	
	private static PanelEquipement unPanelEquipement = new PanelEquipement();
	private JButton btEquipement = new JButton("Equipement");
	
	private static PanelProprietaire unPanelProprietaire = new PanelProprietaire();
	private JButton btProprietaire = new JButton("Proprietaire");
	
	private static PanelStatistique unPanelStatistique= new PanelStatistique();
	private JButton btStatistique = new JButton("Statistique");
	
	public VueGenerale(User unUser) {
		this.setTitle("Adminstration de Neige et Soleil");
		this.setBounds(100, 100, 1000, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.gray);
		//Ajout des panels
		
		this.btClient.setBounds(500, 10, 80, 40);
		this.add(this.btClient);
		this.btClient.addActionListener(this);
		this.add(this.unPanelClient);
		
		this.add(this.unPanelHabitation);
		
		this.btHabitation.setBounds(250, 10, 100, 40);
		this.add(this.btHabitation);
		this.btHabitation.addActionListener(this);
		
		this.add(this.unPanelEquipement);
		this.btEquipement.setBounds(375, 10, 120, 40);
		this.add(this.btEquipement);
		this.btEquipement.addActionListener(this);
		
		this.add(this.unPanelProprietaire);
		this.btProprietaire.setBounds(600, 10, 140, 40);
		this.add(this.btProprietaire);
		this.btProprietaire.addActionListener(this);
		
		this.add(this.unPanelStatistique);
		this.btStatistique.setBounds(900, 10, 160, 40);
		this.add(this.btStatistique);
		this.btStatistique.addActionListener(this);
	

		//Construction du panel profil
//		this.panelProfil.setBounds(20, 20, 200, 300);
//		this.panelProfil.setBackground(Color.cyan);
//		this.panelProfil.setLayout(new GridLayout(6,1));
//		this.panelProfil.add(new JLabel("Votre profil : "));
//		this.panelProfil.add(new JLabel("Votre nom : "+ unUser.getNom()));
//		this.panelProfil.add(new JLabel("Votre prénom : "+ unUser.getPrenom()));
//		this.panelProfil.add(new JLabel("Votre email : "+ unUser.getEmail()));
//		this.panelProfil.add(new JLabel("Votre êtes : "+ unUser.getDroits()));
		
		this.add(this.panelProfil);
		
		this.btQuitter.setBounds(650, 520, 100, 40);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btQuitter) {
			this.dispose();
			Main.setVisible(true);
		}else if(e.getSource() == this.btClient) {
			unPanelClient.setVisible(true);
			unPanelHabitation.setVisible(false);
			unPanelEquipement.setVisible(false);
			unPanelProprietaire.setVisible(false);
			unPanelStatistique.setVisible(false);
		}else if(e.getSource() == this.btHabitation) {
			unPanelHabitation.setVisible(true);
			unPanelClient.setVisible(false);
			unPanelEquipement.setVisible(false);
			unPanelProprietaire.setVisible(false);
			unPanelStatistique.setVisible(false);
		}else if(e.getSource() == this.btEquipement) {
			unPanelEquipement.setVisible(true);
			unPanelClient.setVisible(false);
			unPanelHabitation.setVisible(false);
			unPanelProprietaire.setVisible(false);
			unPanelStatistique.setVisible(false);
		}else if(e.getSource() == this.btProprietaire) {
			unPanelEquipement.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelHabitation.setVisible(false);
			unPanelProprietaire.setVisible(true);
			unPanelStatistique.setVisible(false);
		}else if(e.getSource() == this.btStatistique) {
			unPanelEquipement.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelHabitation.setVisible(false);
			unPanelProprietaire.setVisible(false);
			unPanelStatistique.setVisible(true);
		}
		
	}
}
