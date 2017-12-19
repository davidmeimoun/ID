package ProjectID.ProjectID;

public class Inscription {

	private int id_etudiant;
	private int id_cours;
	private String annee;
	private String note;

	public Inscription(int id_etudiant, int id_cours, String annee, String note) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_cours = id_cours;
		this.annee = annee;
		this.note = note;
	}

	public int getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public int getId_cours() {
		return id_cours;
	}

	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + id_cours;
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
		Inscription other = (Inscription) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (id_cours != other.id_cours)
			return false;
		if (id_etudiant != other.id_etudiant)
			return false;
		return true;
	}



}
