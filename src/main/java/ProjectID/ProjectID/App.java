package ProjectID.ProjectID;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(
				"Requete 1 : Select Count(*) from Etudiant e, Inscription i where e.ID-Etudiant = i.ID-Etudiant and i.Annee > 2007 and Inscription.note  > 10");
		Adaptateur a = new Adaptateur();
		a.executeRequete1();
		a.imprimertableau();
		System.out.println(
				"\n\nRequete 2 : Select Nom, Prenom from Enseignant e1, Enseigne e2 where e1.ID-Enseignant = e2.ID-Enseignant and e2.Annee = 2006");
		Adaptateur a2 = new Adaptateur();
		a2.executeRequete2();
		a2.imprimertableau();
		System.out
				.println("\n\nRequete 3 : Select ID-Etudiant, Nom,Prenom from Etudiant where Provenance = \"France\" ");
		Adaptateur a3 = new Adaptateur();
		a3.executeRequete3();
		a3.imprimertableau();
	}

}
