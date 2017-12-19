package ProjectID.ProjectID;

public class Etudiant {
	private int id_etudiant;
	private String nom;
	private String prenom;
	private String provenance;
	private String formationPrecedente;
	private String paysDeFormationPrecedente;
	private String anneeDebut;
	private String age;
	private String niveauInsertion;
	private String telephone;

	public Etudiant() {
		super();
	}

	public Etudiant(int id_etudiant, String nom, String prenom, String provenance, String formationPrecedente,
			String paysDeFormationPrecedente, String anneeDebut, String age, String niveauInsertion, String telephone) {
		super();
		this.id_etudiant = id_etudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.provenance = provenance;
		this.formationPrecedente = formationPrecedente;
		this.paysDeFormationPrecedente = paysDeFormationPrecedente;
		this.anneeDebut = anneeDebut;
		this.age = age;
		this.niveauInsertion = niveauInsertion;
		this.telephone = telephone;
	}

	public int getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public String getNom() {
		return nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public String getFormationPrecedente() {
		return formationPrecedente;
	}

	public void setFormationPrecedente(String formationPrecedente) {
		this.formationPrecedente = formationPrecedente;
	}

	public String getPaysDeFormationPrecedente() {
		return paysDeFormationPrecedente;
	}

	public void setPaysDeFormationPrecedente(String paysDeFormationPrecedente) {
		this.paysDeFormationPrecedente = paysDeFormationPrecedente;
	}

	public String getAnneeDebut() {
		return anneeDebut;
	}

	public void setAnneeDebut(String anneeDebut) {
		this.anneeDebut = anneeDebut;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNiveauInsertion() {
		return niveauInsertion;
	}

	public void setNiveauInsertion(String niveauInsertion) {
		this.niveauInsertion = niveauInsertion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_etudiant;
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
		Etudiant other = (Etudiant) obj;
		if (id_etudiant != other.id_etudiant)
			return false;
		return true;
	}

}
