package controleur;

public class Statistique {
	
	private int saison, nombreDeReservation;
	
	public  Statistique (int saison, int nombreDeReservation) {
		this.saison = saison;
		this.nombreDeReservation = nombreDeReservation;
	}
	
	public Statistique (int nombreDeReservation) {
		this.saison = 0;
		this.nombreDeReservation = nombreDeReservation;
	}
	
	public Statistique () {
		this.saison = 0;
		this.nombreDeReservation = 0;
	}

	public int getSaison() {
		return saison;
	}

	public void setSaison(int saison) {
		this.saison = saison;
	}

	public int getNombreDeReservation() {
		return nombreDeReservation;
	}

	public void setNombreDeReservation(int nombreDeReservation) {
		this.nombreDeReservation = nombreDeReservation;
	}


}
