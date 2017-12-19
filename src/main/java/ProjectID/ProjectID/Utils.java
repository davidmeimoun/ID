package ProjectID.ProjectID;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	protected void fusionnerModel(Model m, Model modelBase) {
		if (m != null) {
			if (m.getCours() != null)
				for (Cours c : m.getCours())
					modelBase.getCours().add(c);
			if (m.getEnseignants() != null)
				for (Enseignant e : m.getEnseignants())
					modelBase.getEnseignants().add(e);
			if (m.getEnseignes() != null)
				for (Enseigne e : m.getEnseignes())
					modelBase.getEnseignes().add(e);
			if (m.getInscriptions() != null)
				for (Inscription i : m.getInscriptions())
					modelBase.getInscriptions().add(i);
			if (m.getEtudiants() != null)
				for (Etudiant e : m.getEtudiants())
					modelBase.getEtudiants().add(e);
		}

	}

	protected void ajouterNomVariableAuTableau(String requete, List<ArrayList<String>> tableauColonne) {
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
		tableauColonne.add(args);
	}

	protected void ajouterTableauAuTableauGeneral(List<ArrayList<String>> tableauTmp,
			List<ArrayList<String>> tableauColonne) {
		if (tableauTmp != null) {
			for (ArrayList<String> arrayList : tableauTmp) {
				tableauColonne.add(arrayList);
			}
		}

	}


}
