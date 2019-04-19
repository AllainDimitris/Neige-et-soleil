package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Proprietaire;

public class ModeleProprietaire {
private static BDD uneBdd = new BDD ("localhost", "basesite", "root", "");
	
	public static ArrayList<Proprietaire> SelectAllProprietaire(){
		ArrayList<Proprietaire> lesProprietaires = new ArrayList<Proprietaire>();
		String requete = "Select * from client ;";
		//On se connecte à la base de données
		ModeleProprietaire.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = ModeleProprietaire.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete); 
			while(unResultat.next()) {
				 Proprietaire unProprietaire = new Proprietaire(
						unResultat.getInt("idP"),
						unResultat.getString("nomP"),
						unResultat.getString("prenomP")
						);
				lesProprietaires.add(unProprietaire);
			}
			unStat.close();
			unResultat.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleProprietaire.uneBdd.seDeconnecter();		
		return lesProprietaires;
	}
	
	public static void insertProprietaire(Proprietaire unProprietaire) {
		String requete = "insert into Proprietaire values (null,'"
				+ unProprietaire.getNomP()+"','"
				+ unProprietaire.getPrenomP()+"');";
		 	ModeleProprietaire.uneBdd.seConnecter();
			try {
			Statement unStat = ModeleProprietaire.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
			}
			ModeleProprietaire.uneBdd.seDeconnecter();
	}

	public static void deleteProprietaire(int idP) {
		String requete = "delete from proprietaire where idP =" + idP +";";
		ModeleProprietaire.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleProprietaire.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleProprietaire.uneBdd.seDeconnecter();
	}
	
	public static void updateProprietaire(Proprietaire unProprietaire) {
		String requete = "update proprietaire set idP ="
				+ unProprietaire.getIdP() +", nomp = '"
			    + unProprietaire.getNomP() +"', prenomP = '"
			    + unProprietaire.getPrenomP() +"' null where idP ="
			    + unProprietaire.getIdP()+";";
		ModeleProprietaire.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleProprietaire.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleProprietaire.uneBdd.seDeconnecter();
	}
	
	public static ArrayList<Proprietaire> SelectWhereProprietaire (String mot){
		ArrayList<Proprietaire> lesProprietaires = new ArrayList<Proprietaire>();
		String requete = "select * from proprietaire where nomP like '%"+mot+"%' " + "or prenomP like '%"+ mot + "%';";
		ModeleProprietaire.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleProprietaire.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				Proprietaire unProprietaire = new Proprietaire(
						unRes.getInt("idP"),
						unRes.getString("nomP"),
						unRes.getString("prenomP"));
				lesProprietaires.add(unProprietaire);
			}
		unStat.close();
		unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
	}
	ModeleProprietaire.uneBdd.seDeconnecter();		
	return lesProprietaires;
	}
}
