package ProjectID.ProjectID;
public class Cours {

	private long id_cours;
	private String libelle;
	private String type;
	private String niveau;
	private String heures;

	public Cours() {
		super();
	}

	public Cours(long id_cours, String libelle, String type, String niveau, String heures) {
		super();
		this.id_cours = id_cours;
		this.libelle = libelle;
		this.type = type;
		this.niveau = niveau;
		this.heures = heures;
	}

	public long getId_cours() {
		return id_cours;
	}

	public void setId_cours(long id_cours) {
		this.id_cours = id_cours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getHeures() {
		return heures;
	}

	public void setHeures(String heures) {
		this.heures = heures;
	}

}
