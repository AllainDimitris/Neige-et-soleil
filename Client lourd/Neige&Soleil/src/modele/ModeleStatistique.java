package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Statistique;

public class ModeleStatistique {
private static BDD uneBdd = new BDD ("localhost", "basesite", "root", "");
	
	public static ArrayList<Statistique> SelectAllStatistiques(){
		ArrayList<Statistique> lesStatistiques = new ArrayList<Statistique>();
		String requete = "Select * from statequimois ;";
		//On se connecte à la base de données
		ModeleStatistique.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = ModeleStatistique.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete); 
			while(unResultat.next()) {
				 Statistique unStatistique = new Statistique(
						unResultat.getInt("saison"),
						unResultat.getInt("nombreDeReservation")
						);
				lesStatistiques.add(unStatistique);
			}
			unStat.close();
			unResultat.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleStatistique.uneBdd.seDeconnecter();		
		return lesStatistiques;
	}
}
