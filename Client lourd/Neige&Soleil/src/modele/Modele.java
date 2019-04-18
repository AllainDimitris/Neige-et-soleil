package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Equipement;

public class Modele {
	private static BDD uneBdd = new BDD("localhost","basesite","root","");
	
	public static ArrayList<Equipement> selectAllEquipement(){
		ArrayList<Equipement> lesEquipements = new ArrayList<Equipement>();
		String requete = "Select * from equipement ;";
		//On se connecte à la base de données
		Modele.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete); 
			while(desResultats.next()) {
				Equipement unEquipement = new Equipement(
						desResultats.getInt("codee"),
						desResultats.getInt("idt"),
						desResultats.getString("nome"),
						desResultats.getString("taille")
						);
				lesEquipements.add(unEquipement);
			}
			unStat.close();
			desResultats.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBdd.seDeconnecter();		
		return lesEquipements;
	}
	
	public static void insertEquipement (Equipement unEquipement) {
		String requete = "insert into equipement values (null,"
						+ unEquipement.getIdte()+",'"
						+ unEquipement.getNome()+"','"
						+ unEquipement.getTaille()+"');";
	Modele.uneBdd.seConnecter();
	try {
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
	}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
	Modele.uneBdd.seDeconnecter();
	}
	
	public static void deleteEquipement (int codee) {
		String requete = "delete from equipement where idequipement =" + codee +";";
		Modele.uneBdd.seConnecter();
		try {
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBdd.seDeconnecter();
	}
	
	public static void updateEquipement (Equipement unEquipement) {
		String requete = "update equipement set idt = "
				+ unEquipement.getIdte() +", nome = '"
			    + unEquipement.getNome() +"', taille ='"
			    + unEquipement.getTaille()+"' where codee ="
			    + unEquipement.getCodee()+";";
		Modele.uneBdd.seConnecter();
		try {
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBdd.seDeconnecter();
	}

	public static Equipement SelectWhereEquipement(String mot) {
		ArrayList<Equipement> lesEquipements = new ArrayList<Equipement>();
		Equipement unE = null;
		String requete =  "select * from equipement where idt like '%" +mot+ "%' " + "or  nome like '%"+ mot + "%' "
				 + "or taille like '%"+ mot + "%';";
		Modele.uneBdd.seConnecter();
		try {
			Statement unSat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unSat.executeQuery(requete);
			if (unRes.next()) {
				unE = new Equipement(unRes.getInt("codee"),
								  unRes.getInt("Idt"),
								  unRes.getString("nome"),
								  unRes.getString("taille"));
			}
		}catch(SQLException exp) {
			System.out.println("Erreur requête : "+requete);
		}
		Modele.uneBdd.seDeconnecter();
		return unE;
	}
	
}
