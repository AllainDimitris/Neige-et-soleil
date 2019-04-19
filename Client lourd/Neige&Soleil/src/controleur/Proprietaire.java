package controleur;

public class Proprietaire {

	private int idP;
	private String 	nomP, prenomP;
	
	public Proprietaire(int idP, String nomP, String prenomP) {

		this.idP = idP;
		this.nomP = nomP;
		this.prenomP = prenomP;
	}
	
	public Proprietaire(String nomP, String prenomP) {

		this.idP = 0;
		this.nomP = nomP;
		this.prenomP = prenomP;
	}
	
	public Proprietaire() {

		this.idP = 0;
		this.nomP = "";
		this.prenomP = "";
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getPrenomP() {
		return prenomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}
}
