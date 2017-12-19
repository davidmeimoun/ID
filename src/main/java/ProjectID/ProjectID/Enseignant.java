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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_enseignant ^ (id_enseignant >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		if (id_enseignant != other.id_enseignant)
			return false;
		return true;
	}
	
	

}
