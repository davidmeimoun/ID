package ProjectID.ProjectID;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adaptateur {

	private Model model = new Model();
	private List<ArrayList<String>> tableauColonne = new ArrayList<ArrayList<String>>();
	private AdaptateurExcel xls = new AdaptateurExcel();
	private AdaptateurSQL sql = new AdaptateurSQL();
	private AdaptateurXML xml = new AdaptateurXML();

	public Adaptateur() {
		super();
	}

	public void executeRequete1() {
		String requete = "Select Count(*) from Etudiant e, Inscription i where e.ID-Etudiant = i.ID-Etudiant and i.Annee = 2017 and Inscription.note  > 10";
		ajouterNomVariableAuTableau(requete);
		fusionnerModel(this.xls.executeRequete1(requete));
		fusionnerModel(this.sql.executeRequete1(requete));
		fusionnerModel(this.xml.executeRequete1(requete));
		ArrayList<String> l = new ArrayList<String>();
		l.add(String.valueOf(this.model.getEtudiants().size()));
		this.tableauColonne.add(l);

	}

	public void executeRequete2() {
		String requete = "Select Nom, Prenom from Enseignant e1, Enseigne e2 where e1.ID-Enseignant = e2.ID-Enseignant and e2.Annee = 2006";
		ajouterNomVariableAuTableau(requete);
		fusionnerModel(xls.executeRequete2(requete));
		fusionnerModel(this.sql.executeRequete2(requete));
		fusionnerModel(this.xml.executeRequete2(requete));

		for (Enseignant e : model.getEnseignants()) {
			ArrayList<String> l = new ArrayList<String>();
			l.add(e.getNom());
			l.add(e.getPrenom());
			this.tableauColonne.add(l);
		}

	}

	public void executeRequete3() {
		String requete = "Select ID-Etudiant, Nom,Prenom from Etudiant where Provenance = \"France\" ";
		ajouterNomVariableAuTableau(requete);
		fusionnerModel(xls.executeRequete3(requete));
		fusionnerModel(this.sql.executeRequete3(requete));
		fusionnerModel(this.xml.executeRequete3(requete));
		for (Etudiant e : model.getEtudiants()) {
			ArrayList<String> l = new ArrayList<String>();
			l.add(String.valueOf(e.getId_etudiant()));
			l.add(e.getNom());
			l.add(e.getPrenom());
			this.tableauColonne.add(l);
		}
	}

	private void fusionnerModel(Model m) {
		if (m != null) {
			if (m.getCours() != null)
				for (Cours c : m.getCours())
					model.getCours().add(c);
			if (m.getEnseignants() != null)
				for (Enseignant e : m.getEnseignants())
					model.getEnseignants().add(e);
			if (m.getEnseignes() != null)
				for (Enseigne e : m.getEnseignes())
					model.getEnseignes().add(e);
			if (m.getInscriptions() != null)
				for (Inscription i : m.getInscriptions())
					model.getInscriptions().add(i);
			if (m.getEtudiants() != null)
				for (Etudiant e : m.getEtudiants())
					model.getEtudiants().add(e);
		}

	}

	private void ajouterNomVariableAuTableau(String requete) {
		ArrayList<String> args = new ArrayList<String>();
		Pattern pattern = Pattern.compile("Select (.*) from .*");
		Matcher matcher = pattern.matcher(requete);
		while (matcher.find()) {
			String variables[] = matcher.group(1).split(",");
			for (int i = 0; i < variables.length; i++) {
				String variable = variables[i].replaceAll(" ", "");
				args.add(variable);

			}
		}
		this.tableauColonne.add(args);
	}

	private void ajouterTableauAuTableauGeneral(List<ArrayList<String>> tableauTmp) {
		if (tableauTmp != null) {
			for (ArrayList<String> arrayList : tableauTmp) {
				this.tableauColonne.add(arrayList);
			}
		}

	}

	public void imprimertableau() {
		for (ArrayList<String> arrayList : this.tableauColonne) {
			System.out.println("");
			for (String string : arrayList) {
				System.out.print(string + " | ");
			}
		}

	}
}
