package controleur;
import javax.swing.JOptionPane;

import modele.BDD;
import modele.Modele;
import modele.ModeleUser;
import vue.VueConnexion;
import vue.VueGenerale;

public class Main {

	private static VueConnexion uneVueConnexion;
	private static VueGenerale uneVueGenerale;
	
	public static void setVisible (boolean action) {
		uneVueConnexion.setVisible(action);
	}
	public static void main(String[] args) {
		uneVueConnexion = new VueConnexion();
	}

	public static void verifConnexion(String email, String mdp) {
		if(email.equals("") || mdp.equals("")) {
			JOptionPane.showMessageDialog(null, "Veuillez remplir les identifiants !", "Erreur", 
											JOptionPane.ERROR_MESSAGE);
	} else {
		User unUser = ModeleUser.selectWhereUser(email, mdp);
	    if(unUser == null) {
	    	JOptionPane.showMessageDialog(null, "Veuillez vérifiez les identifiants !", "Erreur", 
					JOptionPane.ERROR_MESSAGE);
	    } else {
	    	JOptionPane.showMessageDialog(null, "Bienvenue Mm/M."+ unUser.getNom() + " " + unUser.getPrenom(), "Information", 
					JOptionPane.INFORMATION_MESSAGE);	
	    	uneVueGenerale = new VueGenerale(unUser);
	    	uneVueConnexion.setVisible(false);
	    	
	   }
	 }
   }
}	
