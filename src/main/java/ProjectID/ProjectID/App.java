package ProjectID.ProjectID;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Adaptateur a = new Adaptateur();
		a.executeRequete1();
		a.imprimertableau();
		
		Adaptateur a2 = new Adaptateur();
		a2.executeRequete2();
		a2.imprimertableau();
		
		Adaptateur a3 = new Adaptateur();
		a3.executeRequete3();
		a3.imprimertableau();
	}

}
