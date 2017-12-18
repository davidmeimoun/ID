package ProjectID.ProjectID;
public class Enseignant {

	private long id_enseignant;
	private String nom;
	private String prenom;
	private String mail;

	public Enseignant(long id_enseignant, String nom, String prenom, String mail) {
		super();
		this.id_enseignant = id_enseignant;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
