package ProjectID.ProjectID;

import java.util.ArrayList;
import java.util.List;

public class Adaptateur extends Utils {

	private Model model = new Model();
	private List<ArrayList<String>> tableauColonne = new ArrayList<ArrayList<String>>();
	private AdaptateurExcel xls = new AdaptateurExcel();
	private AdaptateurSQL sql = new AdaptateurSQL();
	private AdaptateurXML xml = new AdaptateurXML();

	public Adaptateur() {
		super();
	}

	public void executeRequete1() {
		String requete = "Select Count(*) from Etudiant e, Inscription i where e.ID-Etudiant = i.ID-Etudiant and i.Annee >= 2007 and Inscription.note  > 10";
		ajouterNomVariableAuTableau(requete, this.tableauColonne);
		fusionnerModel(this.xls.executeRequete1(requete), this.model);
		fusionnerModel(this.sql.executeRequete1(requete), this.model);
		fusionnerModel(this.xml.executeRequete1(requete), this.model);
		ArrayList<String> l = new ArrayList<String>();
		l.add(String.valueOf(this.model.getEtudiants().size()));
		this.tableauColonne.add(l);
		

	}

	public void executeRequete2() {
		String requete = "Select Nom, Prenom from Enseignant e1, Enseigne e2 where e1.ID-Enseignant = e2.ID-Enseignant and e2.Annee = 2006";
		ajouterNomVariableAuTableau(requete, this.tableauColonne);
		fusionnerModel(xls.executeRequete2(requete), this.model);
		fusionnerModel(this.sql.executeRequete2(requete), this.model);
		fusionnerModel(this.xml.executeRequete2(requete), this.model);

		for (Enseignant e : model.getEnseignants()) {
			ArrayList<String> l = new ArrayList<String>();
			l.add(e.getNom());
			l.add(e.getPrenom());
			this.tableauColonne.add(l);
		}

	}

	public void executeRequete3() {
		String requete = "Select ID-Etudiant, Nom,Prenom from Etudiant where Provenance = \"France\" ";
		ajouterNomVariableAuTableau(requete, this.tableauColonne);
		fusionnerModel(xls.executeRequete3(requete), this.model);
		fusionnerModel(this.sql.executeRequete3(requete), this.model);
		fusionnerModel(this.xml.executeRequete3(requete), this.model);
		for (Etudiant e : model.getEtudiants()) {
			ArrayList<String> l = new ArrayList<String>();
			l.add(String.valueOf(e.getId_etudiant()));
			l.add(e.getNom());
			l.add(e.getPrenom());
			this.tableauColonne.add(l);
		}
	}

	public void imprimertableau() {
		for (ArrayList<String> arrayList : this.tableauColonne) {
			System.out.println("");
			for (String string : arrayList) {
				if(string == null){
					System.out.print("-          ");
				}
				else{
					System.out.print(string);
					for (int i = 0; i < 11 - string.length(); i++) {
						System.out.print(" ");
					}	
				}

				System.out.print("| ");
			}
		}

	}

}
