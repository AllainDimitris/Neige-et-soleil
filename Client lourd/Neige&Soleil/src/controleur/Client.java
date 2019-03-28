package controleur;

public class Client {

	private int IDCL;
	private String 	Sexecl, nomcl, prenomcl, adrmailcl, telcl, datenaicl, mdpcl;
	
	public Client(int iDCL, String sexecl, String nomcl, String prenomcl, String adrmailcl, String telcl,
			String datenaicl, String mdpcl) {

		this.IDCL = iDCL;
		this.Sexecl = sexecl;
		this.nomcl = nomcl;
		this.prenomcl = prenomcl;
		this.adrmailcl = adrmailcl;
		this.telcl = telcl;
		this.datenaicl = datenaicl;
		this.mdpcl = mdpcl;
	}
	
	public Client(String sexecl, String nomcl, String prenomcl, String adrmailcl, String telcl,
			String datenaicl, String mdpcl) {

		this.IDCL = 0;
		this.Sexecl = sexecl;
		this.nomcl = nomcl;
		this.prenomcl = prenomcl;
		this.adrmailcl = adrmailcl;
		this.telcl = telcl;
		this.datenaicl = datenaicl;
		this.mdpcl = mdpcl;
	}
	
	public Client() {

		this.IDCL = 0;
		this.Sexecl = "";
		this.nomcl = "";
		this.prenomcl = "";
		this.adrmailcl = "";
		this.telcl = "";
		this.datenaicl = "";
		this.mdpcl = "";
	}

	public int getIDCL() {
		return IDCL;
	}

	public void setIDCL(int iDCL) {
		IDCL = iDCL;
	}

	public String getSexecl() {
		return Sexecl;
	}

	public void setSexecl(String sexecl) {
		Sexecl = sexecl;
	}

	public String getNomcl() {
		return nomcl;
	}

	public void setNomcl(String nomcl) {
		this.nomcl = nomcl;
	}

	public String getPrenomcl() {
		return prenomcl;
	}

	public void setPrenomcl(String prenomcl) {
		this.prenomcl = prenomcl;
	}

	public String getAdrmailcl() {
		return adrmailcl;
	}

	public void setAdrmailcl(String adrmailcl) {
		this.adrmailcl = adrmailcl;
	}

	public String getTelcl() {
		return telcl;
	}

	public void setTelcl(String telcl) {
		this.telcl = telcl;
	}

	public String getDatenaicl() {
		return datenaicl;
	}

	public void setDatenaicl(String datenaicl) {
		this.datenaicl = datenaicl;
	}

	public String getMdpcl() {
		return mdpcl;
	}

	public void setMdpcl(String mdpcl) {
		this.mdpcl = mdpcl;
	}
	
	
}
