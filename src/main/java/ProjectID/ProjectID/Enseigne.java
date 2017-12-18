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

}
