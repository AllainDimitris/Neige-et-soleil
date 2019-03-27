package controleur;

public class Equipement {
	private int codee;
	private int idt;
	private String nome;
	private String taille;
	
	public Equipement(int codee, int idt, String nome, String taille) {
		
		this.codee = codee;
		this.idt = idt;
		this.nome = nome;
		this.taille = taille;
	}
	
	public Equipement(int idt, String nome, String taille) {
		
		this.codee = 0;
		this.idt = 0;
		this.nome = nome;
		this.taille = taille;
	}
	
	public Equipement() {
		
		this.codee = 0;
		this.idt = 0;
		this.nome = "";
		this.taille = "";
	}

	public int getCodee() {
		return codee;
	}

	public void setCodee(int codee) {
		this.codee = codee;
	}

	public int getIdt() {
		return idt;
	}

	public void setIdt(int idt) {
		this.idt = idt;
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