package ProjectID.ProjectID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdaptateurSQL {

	public Model executeRequete1(String requete) {
		Model m = new Model();
		String requete2 = "Select * from Etudiant e, Inscription i where e.ID_Etudiant = i.NumEt and i.Annee >= 2007 and i.Note_cours  > 10";
		ResultSet resultat = null;
		String url = "jdbc:mysql://localhost:3306/td_id_miage?autoReconnect=true&useSSL=false";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, utilisateur, motDePasse);
			st = con.createStatement();
			resultat = st.executeQuery(requete2);
			boolean encore = resultat.next();
			while (encore) {
				Etudiant e = new Etudiant(resultat.getInt(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), resultat.getString(6), resultat.getString(7),
						resultat.getString(10), resultat.getString(8), resultat.getString(9));
				m.getEtudiants().add(e);
				encore = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	public Model executeRequete2(String requete) {
		Model m = new Model();
		String requete2 = "Select * from Enseignant e1, Enseigne e2 where e1.ID_Ens = e2.NumEns  and e2.Annee = 2006";
		ResultSet resultat = null;
		String url = "jdbc:mysql://localhost:3306/td_id_miage?autoReconnect=true&useSSL=false";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, utilisateur, motDePasse);
			st = con.createStatement();
			resultat = st.executeQuery(requete2);
			boolean encore = resultat.next();
			while (encore) {
				Enseignant e = new Enseignant(resultat.getInt(1), resultat.getString(2), resultat.getString(3), null,
						resultat.getString(4));
				m.getEnseignants().add(e);
				encore = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	public Model executeRequete3(String requete) {
		Model m = new Model();
		String requete2 = "Select * from Etudiant where Provenance = \"fr\" ";
		ResultSet resultat = null;
		String url = "jdbc:mysql://localhost:3306/td_id_miage?autoReconnect=true&useSSL=false";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, utilisateur, motDePasse);
			st = con.createStatement();
			resultat = st.executeQuery(requete2);
			boolean encore = resultat.next();
			while (encore) {
				Etudiant e = new Etudiant(resultat.getInt(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5), resultat.getString(6), resultat.getString(7),
						resultat.getString(10), resultat.getString(8), resultat.getString(9));
				m.getEtudiants().add(e);
				encore = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

}
