package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Habitation;

public class ModeleHabitation {
	private static BDD uneBdd = new BDD("localhost","basesite","root","");
	
	public static ArrayList<Habitation> selectAllHabitations(){
		ArrayList<Habitation> lesHabitations = new ArrayList<Habitation>();
		String requete = "Select * from habitation;";
		//On se connecte � la base de donn�es
		
		ModeleHabitation.uneBdd.seConnecter();
		System.out.println("connect�");
		try {
			//On d�finit un statement
			Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete); 
			while(desResultats.next()) {
				Habitation uneHabitation = new Habitation(
						desResultats.getInt("idh"),
						desResultats.getInt("idt"),
						desResultats.getInt("idp"),
						desResultats.getString("adrh"),
						desResultats.getInt("numeroh"),
						desResultats.getInt("cph"),
						desResultats.getString("villeh"),
						desResultats.getString("expoh"),
						desResultats.getInt("surfacehabh"),
						desResultats.getInt("surfacebalh"),
						desResultats.getInt("capacch"),
						desResultats.getString("distancepisteh"),
						desResultats.getString("montant"),
						desResultats.getString("image")
						);
				lesHabitations.add(uneHabitation);
			}
			unStat.close();
			desResultats.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleHabitation.uneBdd.seDeconnecter();		
		return lesHabitations;
	}
	
	public static void insertHabitation (Habitation uneHabitation) {
		String requete = "insert into Habitation values (null,"
						+ uneHabitation.getIdt()+","
						+ uneHabitation.getIdt()+",'"
						+ uneHabitation.getAdrh()+"',"
						+ uneHabitation.getNumeroh()+","
						+ uneHabitation.getCph()+",'"
						+ uneHabitation.getVilleh()+"','"
						+ uneHabitation.getExpoh()+"',"
						+ uneHabitation.getSurfacehabh()+","
						+ uneHabitation.getSurfacebalh()+","
						+ uneHabitation.getCapacch()+",'"
						+ uneHabitation.getDistancepisteh()+"','"
						+ uneHabitation.getMontant()+"','"
						+ uneHabitation.getImage()+"');";
	ModeleHabitation.uneBdd.seConnecter();
	try {
		Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
	}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
	ModeleHabitation.uneBdd.seDeconnecter();
	}
	
	public static void deleteHabitation (int idH) {
		String requete = "delete from Habitation where idH =" + idH+";";
		ModeleHabitation.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleHabitation.uneBdd.seDeconnecter();
	}
	
	public static void updateHabitation (Habitation uneHabitation) {
		String requete = "update Habitation set Idt = "
				+ uneHabitation.getIdt() +", Idp = "
				+ uneHabitation.getIdp() +", Adrh = '"
			    + uneHabitation.getAdrh() +"', Numeroh = "
			    + uneHabitation.getNumeroh() +", Cph="
			    + uneHabitation.getCph()+", villeh = '"
			    + uneHabitation.getVilleh() +"', expoh = '"
			    + uneHabitation.getExpoh() +"', surfacehabh = "
			    + uneHabitation.getSurfacehabh() +", surfacebalh = "
			    + uneHabitation.getSurfacebalh() +", capacch = "
			    + uneHabitation.getCapacch() +", distancepisteh = '"
			    + uneHabitation.getDistancepisteh() +"', montant ='"
			    + uneHabitation.getMontant()+"', image ='"
				+ uneHabitation.getImage()+"' where idh ="
			    + uneHabitation.getIdh()+";";
		ModeleHabitation.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		System.out.println(requete);
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleHabitation.uneBdd.seDeconnecter();
	}

	public static ArrayList<Habitation> selectWhereHabitations(String mot)
	{
		ArrayList<Habitation> lesHabitations = new ArrayList<Habitation>();
		String requete = "select * from Habitation where idh like '%"+mot+"%';";
		ModeleHabitation.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete); 
			while (unRes.next()) {
				 Habitation uneHabitation = new Habitation(
						unRes.getInt("idh"),
						unRes.getInt("idt"),
						unRes.getInt("idp"),
						unRes.getString("adrh"),
						unRes.getInt("numeroh"),
						unRes.getInt("cph"),
						unRes.getString("villeh"),
						unRes.getString("expoh"),
						unRes.getInt("surfacehabh"),
						unRes.getInt("surfacebalh"),
						unRes.getInt("capacch"),
						unRes.getString("distancepisteh"),
						unRes.getString("montant"),
						unRes.getString("image")
						);
				 lesHabitations.add(uneHabitation);
			}
			unStat.close();
			unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur exception : " + requete);
		}
		
		ModeleHabitation.uneBdd.seDeconnecter();
		return lesHabitations;
	}
	
}
