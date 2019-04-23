package controleur;

public class Proprietaire {

	private int idP, habitation;
	private String 	nomP, prenomP, dateDebut, dateFin;
	
	public Proprietaire(int idP, int habitation, String nomP, String prenomP, String dateDebut, String dateFin) {

		this.idP = idP;
		this.habitation = habitation;
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Proprietaire(int habitation, String nomP, String prenomP, String dateDebut, String dateFin) {

		this.idP = 0;
		this.habitation = habitation;
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Proprietaire() {

		this.idP = 0;
		this.habitation = 0;
		this.nomP = "";
		this.prenomP = "";
		this.dateDebut = "";
		this.dateFin = "";
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public int getHabitation() {
		return habitation;
	}

	public void setHabitation(int habitation) {
		this.habitation = habitation;
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

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	
}
