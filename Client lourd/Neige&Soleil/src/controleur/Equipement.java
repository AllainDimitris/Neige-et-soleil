package controleur;

public class Equipement {
	private int codee;
	private int idte;
	private String nome;
	private String taille;
	private String montant;
	private String image;
	
	public Equipement(int codee, int idte, String nome, String taille, String montant, String image) {
		
		this.codee = codee;
		this.idte = idte;
		this.nome = nome;
		this.taille = taille;
		this.montant = montant;
		this.image = image;
	}
	
	public Equipement(int idte, String nome, String taille, String montant, String image) {
		
		this.codee = 0;
		this.idte = idte;
		this.nome = nome;
		this.taille = taille;
		this.montant = montant;
		this.image = image;
	}
	
	public Equipement() {
		
		this.codee = 0;
		this.idte = 0;
		this.nome = "";
		this.taille = "";
		this.montant = "";
		this.image = "";
	}

	public int getCodee() {
		return codee;
	}

	public void setCodee(int codee) {
		this.codee = codee;
	}

	public int getIdte() {
		return idte;
	}

	public void setIdte(int idte) {
		this.idte = idte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}