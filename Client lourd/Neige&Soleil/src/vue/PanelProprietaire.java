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

import controleur.Proprietaire;
import controleur.Tableau;
import modele.Modele;
import modele.ModeleProprietaire;

public class PanelProprietaire extends Panel implements ActionListener {

	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtIdP = new JTextField();
	private JTextField txtHabitation = new JTextField();
	private JTextField txtNomP = new JTextField();
	private JTextField txtPrenomP = new JTextField();
	private JTextField txtDateDebut = new JTextField();
	private JTextField txtDateFin = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btModifier = new JButton("Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btOk = new JButton("Ok");
	private JTextField txtMot = new JTextField();
	private JPanel unPanelRecherche = new JPanel();
	private JPanel unPanelBoutons = new JPanel();
	
	public PanelProprietaire() {
		this.setBackground(Color.white);
		String entetes[] = {"Code", "IDT", "Nom", "Taille", "Date debut", "Date fin"};
		unTableau = new Tableau(this.getLesProprietaires(ModeleProprietaire.SelectAllProprietaire()), entetes);
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
		this.unPanelAjout.setLayout(new GridLayout(3,5));
		
		this.txtIdP.setEditable(false);
		this.unPanelAjout.add(new JLabel("ID Propriétaire : "));
		this.unPanelAjout.add(txtIdP);
		this.unPanelAjout.add(new JLabel("Habitation : "));
		this.unPanelAjout.add(txtHabitation);
		this.unPanelAjout.add(new JLabel("Nom :"));
		this.unPanelAjout.add(txtNomP);
		this.unPanelAjout.add(new JLabel("Prénom : "));
		this.unPanelAjout.add(txtPrenomP);
		this.unPanelAjout.add(new JLabel("Date début : "));
		this.unPanelAjout.add(txtDateDebut);
		this.unPanelAjout.add(new JLabel("Date fin : "));
		this.unPanelAjout.add(txtDateFin);
		this.unPanelAjout.setBounds(20, 220, 750, 60);
		this.add(this.unPanelAjout);
		
		//Construction du panel Boutons
		this.unPanelBoutons.setLayout(new GridLayout(1,4));
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
			txtIdP.setText((int)uneTable.getValueAt(ligne, 0) + "");
			txtHabitation.setText((int)uneTable.getValueAt(ligne, 1) + "");
			txtNomP.setText((String)uneTable.getValueAt(ligne, 2));
			txtPrenomP.setText((String)uneTable.getValueAt(ligne, 3));
			txtDateDebut.setText((String)uneTable.getValueAt(ligne, 4));
			txtDateFin.setText((String)uneTable.getValueAt(ligne, 5));
			}
		});
			
	}
	public Object [][] getLesProprietaires(ArrayList<Proprietaire> lesProprietaires) {
		
		Object [][] matrice = new Object[lesProprietaires.size()][6];
		int i = 0;
		for (Proprietaire unProprietaire : lesProprietaires) {
			matrice[i][0] = unProprietaire.getIdP();
			matrice[i][1] = unProprietaire.getHabitation();
			matrice[i][2] = unProprietaire.getNomP();
			matrice[i][3] = unProprietaire.getPrenomP();
			matrice[i][4] = unProprietaire.getDateDebut();
			matrice[i][5] = unProprietaire.getDateFin();
			i++;
		}
		return matrice;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btOk) {
			String mot = this.txtMot.getText();
			Object [][] matrice = this.getLesProprietaires(ModeleProprietaire.SelectWhereProprietaire(mot));
			unTableau.setDonnees(matrice);
		}else if (e.getSource() == this.btAnnuler){
			txtIdP.setText("");
			txtHabitation.setText("");
			txtNomP.setText("");
			txtPrenomP.setText("");
			txtDateDebut.setText("");
			txtDateFin.setText("");
			
		}else if(e.getSource() == this.btAjouter) {
			Proprietaire unProprietaire = new Proprietaire(Integer.parseInt(txtIdP.getText()),
					Integer.parseInt(txtHabitation.getText()), txtNomP.getText(),
					txtPrenomP.getText(), txtDateDebut.getText(), txtDateFin.getText());
			ModeleProprietaire.insertProprietaire(unProprietaire);
			Object ligne [] = {unProprietaire.getIdP(), unProprietaire.getHabitation(),
								unProprietaire.getNomP(), unProprietaire.getPrenomP(),
								unProprietaire.getDateDebut(), unProprietaire.getDateFin()};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie !", "Insertion d'un Propriétaire", JOptionPane.INFORMATION_MESSAGE);
			txtIdP.setText("");
			txtHabitation.setText("");
			txtNomP.setText("");
			txtPrenomP.setText("");
			txtDateDebut.setText("");
			txtDateFin.setText("");
		}else if(e.getSource() == this.btModifier) {
			int idP = Integer.parseInt(txtIdP.getText());
			Proprietaire unProprietaire= new Proprietaire(Integer.parseInt(txtIdP.getText()), Integer.parseInt(txtHabitation.getText()),
					txtNomP.getText(), txtPrenomP.getText(), txtDateDebut.getText(), txtDateFin.getText());
			ModeleProprietaire.updateProprietaire(unProprietaire);
			Object ligne [] = { unProprietaire.getIdP(), unProprietaire.getHabitation(),
					unProprietaire.getNomP(), unProprietaire.getPrenomP(), unProprietaire.getDateDebut(), unProprietaire.getDateFin()};
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.updateTable(ligne, indiceLigne);
		
		}else if (e.getSource() == this.btSupprimer) {
			int idP = Integer.parseInt(txtIdP.getText());
			ModeleProprietaire.deleteProprietaire(idP);
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.deleteTable(indiceLigne);
		
		}
		
	}

}
