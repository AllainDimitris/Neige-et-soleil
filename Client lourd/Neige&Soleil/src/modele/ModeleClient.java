package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.User;

public class ModeleClient {

	private static BDD uneBdd = new BDD ("localhost", "basesite", "root", "");
	
	public static ArrayList<Client> SelectAllClients(){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "Select * from client ;";
		//On se connecte à la base de données
		ModeleClient.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete); 
			while(unResultat.next()) {
				 Client unClient = new Client(
						unResultat.getInt("iDCL"),
						unResultat.getString("sexecl"),
						unResultat.getString("nomcl"),
						unResultat.getString("prenomcl"),
						unResultat.getString("adrmailcl"),
						unResultat.getString("telcl"),
						unResultat.getString("datenaicl"),
						unResultat.getString("mdpcl")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			unResultat.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();		
		return lesClients;
	}
	
	public static void insertClient(Client unClient) {
		String requete = "insert into client values (null,'"
				+ unClient.getSexecl()+"','"
				+ unClient.getNomcl()+"','"
				+ unClient.getPrenomcl()+"','"
				+ unClient.getAdrmailcl()+"','"
				+ unClient.getTelcl()+"','"
				+ unClient.getDatenaicl()+"','"
				+ unClient.getMdpcl()+"', null);";
		 	ModeleClient.uneBdd.seConnecter();
			try {
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
			}
			ModeleClient.uneBdd.seDeconnecter();
	}

	public static void deleteClient(int idcl) {
		String requete = "delete from client where idcl =" + idcl +";";
		ModeleClient.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();
	}
	
	public static void updateClient(Client unClient) {
		String requete = "update client set sexecl ='"
				+ unClient.getSexecl() +"', nomcl = '"
			    + unClient.getNomcl() +"', prenomcl = '"
			    + unClient.getPrenomcl() +"', adrmailcl ='"
			    + unClient.getAdrmailcl()+"', telcl = '"
			    + unClient.getTelcl()+"', datenaicl = '"
			    + unClient.getDatenaicl()+"', mdpcl = '"
			    + unClient.getMdpcl()+"', null where idcl ="
			    + unClient.getIDCL()+";";
		ModeleClient.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleClient.uneBdd.seDeconnecter();
	}
	
	public static ArrayList<Client> SelectWhereClient (String mot){
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select * from client where sexecl like '%"+mot+"%' " + "or nomcl like '%"+ mot + "%' "
						 + "or prenomcl like '%"+ mot + "%' "
						 + "or adrmailcl like '%"+ mot + "%' "
						 + "or telcl like '%"+ mot + "%'" 
						 + "or datenaicl like '%" + mot + "%'"
						 + "or mdpcl like '%"+mot +"%';";
		ModeleClient.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				Client unClient = new Client(
						unRes.getInt("iDCL"),
						unRes.getString("sexecl"),
						unRes.getString("nomcl"),
						unRes.getString("prenomcl"),
						unRes.getString("adrmailcl"),
						unRes.getString("telcl"),
						unRes.getString("datenaicl"),
						unRes.getString("mdpcl")
						);
				lesClients.add(unClient);
			}
		unStat.close();
		unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
	}
	ModeleClient.uneBdd.seDeconnecter();		
	return lesClients;
	}
}
