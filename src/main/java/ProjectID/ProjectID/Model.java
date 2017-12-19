package ProjectID.ProjectID;

import java.util.HashSet;
import java.util.Set;

public class Model {

	private Set<Cours> cours = new HashSet<Cours>();
	private Set<Enseignant> enseignants = new HashSet<Enseignant>();
	private Set<Enseigne> enseignes = new HashSet<Enseigne>();
	private HashSet<Etudiant> etudiants = new HashSet<Etudiant>();
	private Set<Inscription> inscriptions = new HashSet<Inscription>();

	public Model() {
		super();
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public Set<Enseigne> getEnseignes() {
		return enseignes;
	}

	public void setEnseignes(Set<Enseigne> enseignes) {
		this.enseignes = enseignes;
	}

	public HashSet<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(HashSet<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public String toString() {

		return "" + etudiants + inscriptions + "";
		/*
		 * return "Model [cours=" + cours + ", enseignants=" + enseignants +
		 * ", enseignes=" + enseignes + ", etudiants=" + etudiants + ", inscriptions=" +
		 * inscriptions + "]";
		 */
	}

}
