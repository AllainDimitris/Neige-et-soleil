package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Habitation;
import controleur.Tableau;
import modele.Modele;
import modele.ModeleHabitation;

public class PanelHabitation extends Panel implements ActionListener {

	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtIdHabitation = new JTextField();
	private JTextField txtType = new JTextField();
	private JTextField txtPropri = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtNumero = new JTextField();
	private JTextField txtCode = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtExpo = new JTextField();
	private JTextField txtSurfacehab = new JTextField();
	private JTextField txtSurfacebal = new JTextField();
	private JTextField txtCapacite = new JTextField();
	private JTextField txtDistance = new JTextField();
	private JTextField txtMontant = new JTextField();
	private JTextField txtImage = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btModifier = new JButton("Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btOk = new JButton("Ok");
	private JTextField txtMot = new JTextField();
	private JPanel unPanelRecherche = new JPanel();
	private JPanel unPanelBoutons = new JPanel();
	
	public PanelHabitation() {
		this.setBackground(Color.white);
		String entetes[] = {"ID Habitation", "Type", "ID Propri", "Adresse", "Numero", "Code Postal", "Ville", "Exposition", "Surface Habitable", "Surface Balcon", "Capacite", "Distance des Pistes", "Montant", "Image"};
		unTableau = new Tableau(this.getLesHabitations(ModeleHabitation.selectAllHabitations()), entetes);
		uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20, 10, 750, 150);
		this.add(uneScroll);
	

		//Construction du panel
		this.unPanelRecherche.setLayout(new GridLayout(1,3));
		this.unPanelRecherche.add(new JLabel("Filtre par colonnes : "));
		this.unPanelRecherche.add(txtMot);
		this.unPanelRecherche.add(btOk);
		this.unPanelRecherche.setBounds(150, 170, 500, 30);
		this.add(unPanelRecherche);
		this.btOk.addActionListener(this);
		
		//Construction du panel Ajouter
		this.unPanelAjout.setLayout(new GridLayout(5,6));
		
		this.txtIdHabitation.setEditable(false);
		this.unPanelAjout.add(new JLabel("ID Habitation : "));
		this.unPanelAjout.add(txtIdHabitation);
		this.unPanelAjout.add(new JLabel("Type : "));
		this.unPanelAjout.add(txtType);
		this.unPanelAjout.add(new JLabel("ID Propri : "));
		this.unPanelAjout.add(txtPropri);
		this.unPanelAjout.add(new JLabel("Adresse :"));
		this.unPanelAjout.add(txtAdresse);
		this.unPanelAjout.add(new JLabel("Numero : "));
		this.unPanelAjout.add(txtNumero);
		this.unPanelAjout.add(new JLabel("Code Postal : "));
		this.unPanelAjout.add(txtCode);
		this.unPanelAjout.add(new JLabel("Ville : "));
		this.unPanelAjout.add(txtVille);
		this.unPanelAjout.add(new JLabel("Exposition : "));
		this.unPanelAjout.add(txtExpo);
		this.unPanelAjout.add(new JLabel("Surface Habitable : "));
		this.unPanelAjout.add(txtSurfacehab);
		this.unPanelAjout.add(new JLabel("Surface Balcon : "));
		this.unPanelAjout.add(txtSurfacebal);
		this.unPanelAjout.add(new JLabel("Capacite : "));
		this.unPanelAjout.add(txtCapacite);
		this.unPanelAjout.add(new JLabel("Distance des Pistes : "));
		this.unPanelAjout.add(txtDistance);
		this.unPanelAjout.add(new JLabel("Montant : "));
		this.unPanelAjout.add(txtMontant);
		this.unPanelAjout.add(new JLabel("Image : "));
		this.unPanelAjout.add(txtImage);
		this.unPanelAjout.setBounds(20, 220, 750, 90);
		this.add(this.unPanelAjout);
		
		//Construction du panel Boutons
		this.unPanelBoutons.setLayout(new GridLayout(1,4));
		this.unPanelBoutons.setBounds(20, 350, 750, 25);
		this.unPanelBoutons.add(this.btAnnuler);
		this.unPanelBoutons.add(this.btAjouter);
		this.unPanelBoutons.add(this.btModifier);
		this.unPanelBoutons.add(this.btSupprimer);
		this.add(this.unPanelBoutons);
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		this.btOk.addActionListener(this);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int ligne = uneTable.getSelectedRow();
			txtIdHabitation.setText((int)uneTable.getValueAt(ligne, 0) + "");
			txtType.setText((int)uneTable.getValueAt(ligne, 1) + "");
			txtPropri.setText((int)uneTable.getValueAt(ligne, 2) + "");
			txtAdresse.setText((String)uneTable.getValueAt(ligne, 3));
			txtNumero.setText((int)uneTable.getValueAt(ligne, 4) + "");
			txtCode.setText((int)uneTable.getValueAt(ligne, 5) + "");
			txtVille.setText((String)uneTable.getValueAt(ligne, 6));
			txtExpo.setText((String)uneTable.getValueAt(ligne, 7));
			txtSurfacehab.setText((int)uneTable.getValueAt(ligne, 8) + "");
			txtSurfacebal.setText((int)uneTable.getValueAt(ligne, 9) + "");
			txtCapacite.setText((int)uneTable.getValueAt(ligne, 10) + "");
			txtDistance.setText((String)uneTable.getValueAt(ligne, 11));
			txtMontant.setText((String)uneTable.getValueAt(ligne, 12));
			txtImage.setText((String)uneTable.getValueAt(ligne, 13));
			}
		});
			
	}
	public Object [][] getLesHabitations(ArrayList<Habitation> lesHabitations) {
		
		Object [][] matrice = new Object[lesHabitations.size()][14];
		int i = 0;
		for (Habitation uneHabitation : lesHabitations) {
			matrice[i][0] = uneHabitation.getIdh();
			matrice[i][1] = uneHabitation.getIdt();
			matrice[i][2] = uneHabitation.getIdt();
			matrice[i][3] = uneHabitation.getAdrh();
			matrice[i][4] = uneHabitation.getNumeroh();
			matrice[i][5] = uneHabitation.getCph();
			matrice[i][6] = uneHabitation.getVilleh();
			matrice[i][7] = uneHabitation.getExpoh();
			matrice[i][8] = uneHabitation.getSurfacehabh();
			matrice[i][9] = uneHabitation.getSurfacebalh();
			matrice[i][10] = uneHabitation.getCapacch();
			matrice[i][11] = uneHabitation.getDistancepisteh();
			matrice[i][12] = uneHabitation.getMontant();
			matrice[i][13] = uneHabitation.getImage();
			i++;
		}
		return matrice;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btOk) {
			String mot = this.txtMot.getText();
			Object [][] matrice = this.getLesHabitations(ModeleHabitation.selectWhereHabitations(mot));
			unTableau.setDonnees(matrice);
		}else if (e.getSource() == this.btAnnuler){
			txtIdHabitation.setText("");
			txtType.setText("");
			txtPropri.setText("");
			txtAdresse.setText("");
			txtNumero.setText("");
			txtCode.setText("");
			txtVille.setText("");
			txtExpo.setText("");
			txtSurfacehab.setText("");
			txtSurfacebal.setText("");
			txtCapacite.setText("");
			txtDistance.setText("");	
			txtMontant.setText("");
			txtImage.setText("");
			
		}else if(e.getSource() == this.btAjouter) {
			Habitation uneHabitation = new Habitation(Integer.parseInt(txtType.getText()),Integer.parseInt(txtType.getText()),
					txtAdresse.getText(), Integer.parseInt(txtNumero.getText()),
					Integer.parseInt(txtCode.getText()), txtVille.getText(),
					txtExpo.getText(), Integer.parseInt(txtSurfacehab.getText()),
					Integer.parseInt(txtSurfacebal.getText()), Integer.parseInt(txtCapacite.getText()),
					txtDistance.getText(), txtMontant.getText(),
					txtImage.getText());
			ModeleHabitation.insertHabitation(uneHabitation);
			Object ligne [] = { uneHabitation.getIdh(), uneHabitation.getIdt(), uneHabitation.getIdp(),
								uneHabitation.getAdrh(), uneHabitation.getNumeroh() ,uneHabitation.getCph(),
								uneHabitation.getVilleh(), uneHabitation.getExpoh(), 
								uneHabitation.getSurfacehabh(), uneHabitation.getSurfacebalh(),
								uneHabitation.getCapacch(), uneHabitation.getDistancepisteh(),
								uneHabitation.getMontant(), uneHabitation.getImage()};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie !", "Insertion d'une Habitation", JOptionPane.INFORMATION_MESSAGE);
			txtIdHabitation.setText("");
			txtType.setText("");
			txtPropri.setText("");
			txtAdresse.setText("");
			txtNumero.setText("");
			txtCode.setText("");
			txtVille.setText("");
			txtExpo.setText("");
			txtSurfacehab.setText("");
			txtSurfacebal.setText("");
			txtCapacite.setText("");
			txtDistance.setText("");
			txtMontant.setText("");
			txtImage.setText("");
		}else if(e.getSource() == this.btModifier) {
			int idh = Integer.parseInt(txtIdHabitation.getText());
			Habitation uneHabitation = new Habitation(Integer.parseInt(txtIdHabitation.getText()), Integer.parseInt(txtType.getText()), Integer.parseInt(txtPropri.getText()),
					txtAdresse.getText(), Integer.parseInt(txtNumero.getText()),
					Integer.parseInt(txtCode.getText()), txtVille.getText(),
					txtExpo.getText(), Integer.parseInt(txtSurfacehab.getText()),
					Integer.parseInt(txtSurfacebal.getText()), Integer.parseInt(txtCapacite.getText()),
					txtDistance.getText(),txtMontant.getText(),
					txtImage.getText());
			ModeleHabitation.updateHabitation(uneHabitation);
			Object ligne [] = { uneHabitation.getIdh(), uneHabitation.getIdt(), uneHabitation.getIdp(),
					uneHabitation.getAdrh(), uneHabitation.getNumeroh() ,uneHabitation.getCph(),
					uneHabitation.getVilleh(), uneHabitation.getExpoh(), 
					uneHabitation.getSurfacehabh(), uneHabitation.getSurfacebalh(),
					uneHabitation.getCapacch(), uneHabitation.getDistancepisteh(),
					uneHabitation.getMontant(), uneHabitation.getImage()};
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.updateTable(ligne, indiceLigne);
		
		}else if (e.getSource() == this.btSupprimer) {
			int idHabitation = Integer.parseInt(txtIdHabitation.getText());
			ModeleHabitation.deleteHabitation(idHabitation);
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.deleteTable(indiceLigne);
		
		}
		
	}

}
