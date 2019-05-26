package controleur;

public class Habitation {
	private int idh;
	private int idt;
	private int idp;
	private String adrh;
	private int numeroh;
	private int cph;
	private String villeh;
	private String expoh;
	private int surfacehabh;
	private int surfacebalh;
	private int capacch;
	private String distancepisteh;
	private String montant;
	private String image;
	
	public Habitation(int idh, int idt, int idp, String adrh, int numeroh, int cph,
			String villeh, String expoh, int surfacehabh, int surfacebalh,
			int capacch, String distancepisteh, String montant, String image) {
		this.idh = idh;
		this.idt = idt;
		this.idp = idp;
		this.adrh = adrh;
		this.numeroh = numeroh;
		this.cph = cph;
		this.villeh = villeh;
		this.expoh = expoh;
		this.surfacehabh = surfacehabh;
		this.surfacebalh = surfacebalh;
		this.capacch = capacch;
		this.distancepisteh = distancepisteh;
		this.montant = montant;
		this.image = image;
	}
	
	public Habitation(int idt, int idp, String adrh, int numeroh, int cph,
			String villeh, String expoh, int surfacehabh, int surfacebalh,
			int capacch, String distancepisteh, String montant, String image) {
		this.idh = 0;
		this.idt = idt;
		this.idp = idp;
		this.adrh = adrh;
		this.numeroh = numeroh;
		this.cph = cph;
		this.villeh = villeh;
		this.expoh = expoh;
		this.surfacehabh = surfacehabh;
		this.surfacebalh = surfacebalh;
		this.capacch = capacch;
		this.distancepisteh = distancepisteh;
		this.montant = montant;
		this.image = image;
	}
	
	public Habitation() {
		this.idh = 0;
		this.idt = 0;
		this.idp = 0;
		this.adrh = "";
		this.numeroh = 0;
		this.cph = 0;
		this.villeh = "";
		this.expoh = "";
		this.surfacehabh = 0;
		this.surfacebalh = 0;
		this.capacch = 0;
		this.distancepisteh = "";
		this.montant = "";
		this.image = "";
	}
	//getter and setters

	public int getIdh() {
		return idh;
	}

	public void setIdh(int idh) {
		this.idh = idh;
	}

	public int getIdt() {
		return idt;
	}

	public void setIdt(int idt) {
		this.idt = idt;
	}

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public String getAdrh() {
		return adrh;
	}

	public void setAdrh(String adrh) {
		this.adrh = adrh;
	}

	public int getNumeroh() {
		return numeroh;
	}

	public void setNumeroh(int numeroh) {
		this.numeroh = numeroh;
	}

	public int getCph() {
		return cph;
	}

	public void setCph(int cph) {
		this.cph = cph;
	}

	public String getVilleh() {
		return villeh;
	}

	public void setVilleh(String villeh) {
		this.villeh = villeh;
	}

	public String getExpoh() {
		return expoh;
	}

	public void setExpoh(String expoh) {
		this.expoh = expoh;
	}

	public int getSurfacehabh() {
		return surfacehabh;
	}

	public void setSurfacehabh(int surfacehabh) {
		this.surfacehabh = surfacehabh;
	}

	public int getSurfacebalh() {
		return surfacebalh;
	}

	public void setSurfacebalh(int surfacebalh) {
		this.surfacebalh = surfacebalh;
	}

	public int getCapacch() {
		return capacch;
	}

	public void setCapacch(int capacch) {
		this.capacch = capacch;
	}

	public String getDistancepisteh() {
		return distancepisteh;
	}

	public void setDistancepisteh(String distancepisteh) {
		this.distancepisteh = distancepisteh;
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
