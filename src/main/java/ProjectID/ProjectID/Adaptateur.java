package ProjectID.ProjectID;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adaptateur {

	private List<ArrayList<String>> tableauColonne = new ArrayList<ArrayList<String>>();
	private AdaptateurExcel xls = new AdaptateurExcel();
	private AdaptateurSQL sql = new AdaptateurSQL();
	private AdaptateurXML xml = new AdaptateurXML();

	public Adaptateur() {
		super();
	}

	public void executeRequete1() {
		String requete = "SELECT Count(*) from Etudiant, Inscription where Libelle_Cours=\"ID\" and Inscription.note  > 10";
		ajouterNomVariableAuTableau(requete);
		int cpt =0;
		cpt+=this.xls.executeRequete1();
		cpt+=this.sql.executeRequete1();
		cpt+=this.xml.executeRequete1();
		ArrayList<String> l = new ArrayList<String>();
		l.add(String.valueOf(cpt));
		this.tableauColonne.add(l);
		

	}

	public void executeRequete2() {
		String requete = "";
		ajouterNomVariableAuTableau(requete);
		ajouterTableauAuTableauGeneral(this.xls.executeRequete2());
		ajouterTableauAuTableauGeneral(this.sql.executeRequete2());
		ajouterTableauAuTableauGeneral(this.xml.executeRequete2());
	}

	public void executeRequete3() {
		String requete = "";
		ajouterNomVariableAuTableau(requete);
		ajouterTableauAuTableauGeneral(this.xls.executeRequete3());
		ajouterTableauAuTableauGeneral(this.sql.executeRequete3());
		ajouterTableauAuTableauGeneral(this.xml.executeRequete3());

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
