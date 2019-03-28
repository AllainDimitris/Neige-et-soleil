package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Equipement;

public class ModeleEquipement {
	private static BDD uneBdd = new BDD("localhost","basesite","root","");
	
	public static ArrayList<Equipement> selectAllHabitations(){
		ArrayList<Equipement> lesHabitations = new ArrayList<Equipement>();
		String requete = "Select * from equipement;";
		//On se connecte à la base de données
		
		ModeleEquipement.uneBdd.seConnecter();
		System.out.println("connecté");
		try {
			//On définit un statement
			Statement unStat = ModeleEquipement.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete); 
			while(desResultats.next()) {
				Equipement unEquipement = new Equipement(
						desResultats.getInt("codee"),
						desResultats.getInt("idt"),
						desResultats.getString("nome"),
						desResultats.getString("taille")
						);
				lesHabitations.add(unEquipement);
			}
			unStat.close();
			desResultats.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleEquipement.uneBdd.seDeconnecter();		
		return lesHabitations;
	}
	
	public static void insertEquipement (Equipement unEquipement) {
		String requete = "insert into Equipement values (null,"
						+ unEquipement.getIdt()+",'"
						+ unEquipement.getNome()+"','"
						+ unEquipement.getTaille()+"');";
	ModeleEquipement.uneBdd.seConnecter();
	try {
		Statement unStat = ModeleEquipement.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
	}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
	ModeleEquipement.uneBdd.seDeconnecter();
	}
	
	public static void deleteEquipement (int Codee) {
		String requete = "delete from Equipement where codee =" + Codee+";";
		ModeleEquipement.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleEquipement.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleEquipement.uneBdd.seDeconnecter();
	}
	
	public static void updateEquipement (Equipement unEquipement) {
		String requete = "update Equipement set codee = "
				+ unEquipement.getCodee() +", idt = "
			    + unEquipement.getIdt() +", nome = '"
			    + unEquipement.getNome() +"', taille ='"
			    + unEquipement.getTaille()+"',  where codee ="
			    + unEquipement.getCodee()+";";
		ModeleEquipement.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleEquipement.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		System.out.println(requete);
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleEquipement.uneBdd.seDeconnecter();
	}

	public static ArrayList<Equipement> selectWhereEquipement(String mot)
	{
		ArrayList<Equipement> lesEquipements = new ArrayList<Equipement>();
		String requete = "select * from Equipement where codee like '%"+mot+"%'"
				+ " or idt like '%" + mot +"%'"
				+ " or nome like '%" + mot +"%'"
				+ " or taille like '%" + mot +"%'"
				+ ";";
		ModeleEquipement.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleEquipement.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete); 
			while (unRes.next()) {
				 Equipement unEquipement = new Equipement(
						unRes.getInt("codee"),
						unRes.getInt("idt"),
						unRes.getString("nome"),
						unRes.getString("taille")
						);
				 lesEquipements.add(unEquipement);
			}
			unStat.close();
			unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur exception : " + requete);
		}
		
		ModeleEquipement.uneBdd.seDeconnecter();
		return lesEquipements;
	}
	
}
