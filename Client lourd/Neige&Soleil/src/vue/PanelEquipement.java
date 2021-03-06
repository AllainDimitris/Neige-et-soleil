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

import controleur.Equipement;
import controleur.Tableau;
import modele.Modele;
import modele.ModeleEquipement;

public class PanelEquipement extends Panel implements ActionListener {

	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtIdEquipement = new JTextField();
	private JTextField txtIdte = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtTaille = new JTextField();
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
	
	public PanelEquipement() {
		this.setBackground(Color.white);
		String entetes[] = {"Code", "IDT", "Nom", "Taille", "Montant", "Image"};
		unTableau = new Tableau(this.getLesEquipements(ModeleEquipement.selectAllEquipements()), entetes);
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
		this.unPanelAjout.setLayout(new GridLayout(3,4));
		
		this.txtIdEquipement.setEditable(false);
		this.unPanelAjout.add(new JLabel("Code Equipement : "));
		this.unPanelAjout.add(txtIdEquipement);
		this.unPanelAjout.add(new JLabel("IDT : "));
		this.unPanelAjout.add(txtIdte);
		this.unPanelAjout.add(new JLabel("Nom :"));
		this.unPanelAjout.add(txtNome);
		this.unPanelAjout.add(new JLabel("Taille : "));
		this.unPanelAjout.add(txtTaille);
		this.unPanelAjout.add(new JLabel("Montant :"));
		this.unPanelAjout.add(txtMontant);
		this.unPanelAjout.add(new JLabel("Image : "));
		this.unPanelAjout.add(txtImage);
		this.unPanelAjout.setBounds(20, 220, 750, 60);
		this.add(this.unPanelAjout);
		
		//Construction du panel Boutons
		this.unPanelBoutons.setLayout(new GridLayout(1,3));
		this.unPanelBoutons.setBounds(20, 300, 750, 25);
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
			txtIdEquipement.setText((int)uneTable.getValueAt(ligne, 0) + "");
			txtIdte.setText((int)uneTable.getValueAt(ligne, 1) + "");
			txtNome.setText((String)uneTable.getValueAt(ligne, 2));
			txtTaille.setText((String)uneTable.getValueAt(ligne, 3));
			txtMontant.setText((String)uneTable.getValueAt(ligne, 4));
			txtImage.setText((String)uneTable.getValueAt(ligne, 5));
			}
		});
			
	}
	public Object [][] getLesEquipements(ArrayList<Equipement> lesEquipements) {
		
		Object [][] matrice = new Object[lesEquipements.size()][11];
		int i = 0;
		for (Equipement unEquipement : lesEquipements) {
			matrice[i][0] = unEquipement.getCodee();
			matrice[i][1] = unEquipement.getIdte();
			matrice[i][2] = unEquipement.getNome();
			matrice[i][3] = unEquipement.getTaille();
			matrice[i][4] = unEquipement.getMontant();
			matrice[i][5] = unEquipement.getImage();
			i++;
		}
		return matrice;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btOk) {
			String mot = this.txtMot.getText();
			Object [][] matrice = this.getLesEquipements(ModeleEquipement.selectWhereEquipement(mot));
			unTableau.setDonnees(matrice);
		}else if (e.getSource() == this.btAnnuler){
			txtIdEquipement.setText("");
			txtIdte.setText("");
			txtNome.setText("");
			txtTaille.setText("");
			txtMontant.setText("");
			txtImage.setText("");
			
		}else if(e.getSource() == this.btAjouter) {
			Equipement unEquipement = new Equipement(Integer.parseInt(txtIdte.getText()), txtNome.getText(),
					txtTaille.getText(), txtMontant.getText(),
					txtImage.getText());
			ModeleEquipement.insertEquipement(unEquipement);
			Object ligne [] = {unEquipement.getCodee(), unEquipement.getIdte(),
								unEquipement.getNome(), unEquipement.getTaille(),
								unEquipement.getMontant(), unEquipement.getImage()};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion r�ussie !", "Insertion d'un Equipement", JOptionPane.INFORMATION_MESSAGE);
			txtIdEquipement.setText("");
			txtIdte.setText("");
			txtNome.setText("");
			txtTaille.setText("");
			txtMontant.setText("");
			txtImage.setText("");
		}else if(e.getSource() == this.btModifier) {
			int codee = Integer.parseInt(txtIdEquipement.getText());
			Equipement unEquipement = new Equipement(Integer.parseInt(txtIdEquipement.getText()), Integer.parseInt(txtIdte.getText()),
					txtNome.getText(), txtTaille.getText(), txtMontant.getText(), txtImage.getText());
			ModeleEquipement.updateEquipement(unEquipement);
			Object ligne [] = { unEquipement.getCodee(), unEquipement.getIdte(),
					unEquipement.getNome(), unEquipement.getTaille(), unEquipement.getMontant(), unEquipement.getImage()};
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.updateTable(ligne, indiceLigne);
		
		}else if (e.getSource() == this.btSupprimer) {
			int idEquipement = Integer.parseInt(txtIdEquipement.getText());
			ModeleEquipement.deleteEquipement(idEquipement);
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.deleteTable(indiceLigne);
		
		}
		
	}

}
