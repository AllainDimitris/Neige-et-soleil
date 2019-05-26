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
		//On se connecte à la base de données
		
		ModeleHabitation.uneBdd.seConnecter();
		System.out.println("connecté");
		try {
			//On définit un statement
			Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete); 
			while(desResultats.next()) {
				Habitation uneHabitation = new Habitation(
						desResultats.getInt("idh"),
						desResultats.getInt("idt"),
						desResultats.getString("adrh"),
						desResultats.getInt("numeroh"),
						desResultats.getInt("cph"),
						desResultats.getString("villeh"),
						desResultats.getString("expoh"),
						desResultats.getInt("surfacehabh"),
						desResultats.getInt("surfacebalh"),
						desResultats.getInt("capacch"),
						desResultats.getString("distancepisteh")
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
						+ uneHabitation.getIdt()+",'"
						+ uneHabitation.getAdrh()+"',"
						+ uneHabitation.getNumeroh()+","
						+ uneHabitation.getCph()+",'"
						+ uneHabitation.getVilleh()+"','"
						+ uneHabitation.getExpoh()+"',"
						+ uneHabitation.getSurfacehabh()+","
						+ uneHabitation.getSurfacebalh()+","
						+ uneHabitation.getCapacch()+",'"
						+ uneHabitation.getDistancepisteh()+"');";
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
				+ uneHabitation.getIdt() +", Adrh = '"
			    + uneHabitation.getAdrh() +"', Numeroh = "
			    + uneHabitation.getNumeroh() +", Cph="
			    + uneHabitation.getCph()+", villeh = '"
			    + uneHabitation.getVilleh() +"', expoh = '"
			    + uneHabitation.getExpoh() +"', surfacehabh = "
			    + uneHabitation.getSurfacehabh() +", surfacebalh = "
			    + uneHabitation.getSurfacebalh() +", capacch = "
			    + uneHabitation.getCapacch() +", distancepisteh = '"
			    + uneHabitation.getDistancepisteh() +"' where idh ="
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
		String requete = "select * from Habitation where idt like '%"+mot+"%'"
				+ " or adrh like '%" + mot +"%'"
				+ " or numeroh like '%" + mot +"%'"
				+ " or cph like '%" + mot +"%'"
				+ " or villeh like '%" + mot +"%'"
				+ " or expoh like '%" + mot +"%'"
				+ " or surfacehabh like '%" + mot +"%'"
				+ " or surfacebalh like '%" + mot +"%'"
				+ " or capacch like '%" + mot +"%'"
				+ " or distancepisteh like '%" + mot +"%'"
					+ ";";
		ModeleHabitation.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleHabitation.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete); 
			while (unRes.next()) {
				 Habitation uneHabitation = new Habitation(
						unRes.getInt("idh"),
						unRes.getInt("idt"),
						unRes.getString("adrh"),
						unRes.getInt("numeroh"),
						unRes.getInt("cph"),
						unRes.getString("villeh"),
						unRes.getString("expoh"),
						unRes.getInt("surfacehabh"),
						unRes.getInt("surfacebalh"),
						unRes.getInt("capacch"),
						unRes.getString("distancepisteh")
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
