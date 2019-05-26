package controleur;

public class Equipement {
	private int codee;
	private int idte;
	private String nome;
	private String taille;
	
	public Equipement(int codee, int idte, String nome, String taille) {
		
		this.codee = codee;
		this.idte = idte;
		this.nome = nome;
		this.taille = taille;
	}
	
	public Equipement(int idte, String nome, String taille) {
		
		this.codee = 0;
		this.idte = idte;
		this.nome = nome;
		this.taille = taille;
	}
	
	public Equipement() {
		
		this.codee = 0;
		this.idte = 0;
		this.nome = "";
		this.taille = "";
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

}