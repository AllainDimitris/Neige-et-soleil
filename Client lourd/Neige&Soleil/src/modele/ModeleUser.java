package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.User;

public class ModeleUser {
	private static BDD uneBdd = new BDD("localhost","basesite","root","");
	
	public static ArrayList<User> selectAllUsers(){
		ArrayList<User> lesUser = new ArrayList<User>();
		String requete = "Select * from user ;";
		//On se connecte à la base de données
		ModeleUser.uneBdd.seConnecter();
		try {
			//On définit un statement
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete); 
			while(unResultat.next()) {
				 User unUser = new User(
						unResultat.getInt("iduser"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("nom"),
						unResultat.getString("prenom"),
						unResultat.getString("droits")
						);
				lesUser.add(unUser);
			}
			unStat.close();
			unResultat.close();
		}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
		}
		ModeleUser.uneBdd.seDeconnecter();		
		return lesUser;
	}
	
	public static void insertUser(User unUser) {
		String requete = "insert into user values (null,'"
				+ unUser.getEmail()+"','"
				+ unUser.getMdp()+","
				+ unUser.getNom()+",'"
				+ unUser.getPrenom()+"','"
				+ unUser.getDroits()+"');";
		 	ModeleUser.uneBdd.seConnecter();
			try {
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			}catch(SQLException exp) {
			System.out.println("Erreur execution : " + requete);
			}
			ModeleUser.uneBdd.seDeconnecter();
}

	
	public static void deleterUser(int idUser) {
		String requete = "delete from user where iduser=" + idUser +";";
		ModeleUser.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleUser.uneBdd.seDeconnecter();
	}
	
	public static void updateUser (User unUser) {
		String requete = "update user set email ='"
				+ unUser.getEmail() +"', mdp = '"
			    + unUser.getMdp() +"', prenom= '"
			    + unUser.getPrenom() +"', nom ='"
			    + unUser.getNom()+"', droits = '"
			    + unUser.getDroits()+"' where iduser ="
			    + unUser.getIduser()+";";
		ModeleUser.uneBdd.seConnecter();
		try {
		Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}catch(SQLException exp) {
		System.out.println("Erreur execution : " + requete);
		}
		ModeleUser.uneBdd.seDeconnecter();
	}
	
	public static User selectWhereUser(String email, String mdp) {
		
		User unUser = null;
		String requete = "select * from user where email = '"+ email +"' "
						+ "and mdp = '"+ mdp +"';";
		ModeleUser.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete); 
			if(unRes.next()) {
				 unUser = new User(
						unRes.getInt("iduser"),
						unRes.getString("email"),
						unRes.getString("mdp"),
						unRes.getString("nom"),
						unRes.getString("prenom"),
						unRes.getString("droits")
						);
			}
			unStat.close();
			unRes.close();
		}catch(SQLException exp) {
			System.out.println("Erreur exception : " + requete);
		}
		
		ModeleUser.uneBdd.seDeconnecter();
		return unUser;
	}
}
	
