package ProjectID.ProjectID;
public class Enseigne {
	private long id_enseignant;
	private long id_cours;
	private String annee;
	private String heures;

	public Enseigne(long id_enseignant, long id_cours, String annee, String heures) {
		super();
		this.id_enseignant = id_enseignant;
		this.id_cours = id_cours;
		this.annee = annee;
		this.heures = heures;
	}

	public Enseigne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	public long getId_cours() {
		return id_cours;
	}

	public void setId_cours(long id_cours) {
		this.id_cours = id_cours;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getHeures() {
		return heures;
	}

	public void setHeures(String heures) {
		this.heures = heures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + (int) (id_cours ^ (id_cours >>> 32));
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
		Enseigne other = (Enseigne) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (id_cours != other.id_cours)
			return false;
		if (id_enseignant != other.id_enseignant)
			return false;
		return true;
	}



}
