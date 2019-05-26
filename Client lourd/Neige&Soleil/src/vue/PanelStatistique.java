package vue;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Equipement;
import controleur.Statistique;
import controleur.Tableau;
import modele.Modele;
import modele.ModeleStatistique;

public class PanelStatistique extends Panel {

	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtSaison = new JTextField();
	private JTextField txtNombre = new JTextField();
	private ArrayList<Equipement> listequipement = new ArrayList<Equipement>();

	
	public PanelStatistique() {
		this.setBackground(Color.white);
		String entetes[] = {"Saison", "Nombre de reservation"};
		unTableau = new Tableau(this.getLesStatistiques(ModeleStatistique.SelectAllStatistiques()), entetes);
		uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(10, 10, 580, 150);
		
		this.add(uneScroll);
		
			
	}
	public Object [][] getLesStatistiques(ArrayList<Statistique> lesStatistiques) {
		
		Object [][] matrice = new Object[lesStatistiques.size()][2];
		int i = 0;
		for (Statistique unStatistique : lesStatistiques) {
			matrice[i][0] = unStatistique.getSaison();
			matrice[i][1] = unStatistique.getNombreDeReservation();
			i++;
		}
		return matrice;
	}
}	