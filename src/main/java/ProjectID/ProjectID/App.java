package ProjectID.ProjectID;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Requete 1");
		Adaptateur a = new Adaptateur();
		a.executeRequete1();
		a.imprimertableau();
		System.out.println("\nRequete 2");
		Adaptateur a2 = new Adaptateur();
		a2.executeRequete2();
		a2.imprimertableau();
		System.out.println("\nRequete 3");
		Adaptateur a3 = new Adaptateur();
		a3.executeRequete3();
		a3.imprimertableau();
	}

}
