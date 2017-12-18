package ProjectID.ProjectID;
public class Inscription {

	private long id_etudiant;
	private long id_cours;
	private String annee;
	private String note;

	public Inscription(long id_etudiant, long id_cours, String annee, String note) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_cours = id_cours;
		this.annee = annee;
		this.note = note;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(long id_etudiant) {
		this.id_etudiant = id_etudiant;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
