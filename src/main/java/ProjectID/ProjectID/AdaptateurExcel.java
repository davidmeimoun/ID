package ProjectID.ProjectID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class AdaptateurExcel {
	private String pathSource = "Source3.xls";

	public AdaptateurExcel() {
		super();

	}

	// "Select Count(*) from Etudiant e, Inscription i where e.ID-Etudiant =
	// i.ID-Etudiant and i.Annee = 2007 and Inscription.note > 10";
	public Model executeRequete1(String requete) {
		Model model = new Model();
		try {
			FileInputStream excelFile = new FileInputStream(new File(pathSource));
			Workbook workbook = new HSSFWorkbook(excelFile);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				String annee = sheet.getSheetName();

				for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {
					Row row = sheet.getRow(j + 1);
					String statut = row.getCell(3).getStringCellValue();
					int id = (int) row.getCell(0).getNumericCellValue();
					String nom = row.getCell(1).getStringCellValue();
					String prenom = row.getCell(2).getStringCellValue();

					String provenance = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
					String formationPrecedente = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
					String niveauInsertion = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null;
					int id_cours = (int) row.getCell(7).getNumericCellValue();
					String libelle_cours = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null;
					String type_cours = row.getCell(9) != null ? row.getCell(9).getStringCellValue() : null;
					String niveau_cours = row.getCell(10) != null ? row.getCell(10).getStringCellValue() : null;
					String note = row.getCell(11) != null ? String.valueOf(row.getCell(11).getNumericCellValue())
							: null;
					if (Integer.parseInt(annee) >= 2007)
						if (statut.equals("etudiant")) {
							if (row.getCell(11).getNumericCellValue() > 10) {

								Etudiant etudiant = new Etudiant((id), nom, prenom, provenance, formationPrecedente,
										null, annee, null, niveauInsertion, null);
								model.getEtudiants().add(etudiant);
								Inscription inscription = new Inscription(id, id_cours, annee, note);
								model.getInscriptions().add(inscription);
							}
							Cours c = new Cours(id_cours, libelle_cours, type_cours, niveau_cours, null);
							model.getCours().add(c);

						}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return model;
	}

	public Model executeRequete2(String requete) {
		Model model = new Model();
		try {
			FileInputStream excelFile = new FileInputStream(new File(pathSource));
			Workbook workbook = new HSSFWorkbook(excelFile);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				String annee = sheet.getSheetName();

				for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {
					Row row = sheet.getRow(j + 1);
					String statut = row.getCell(3).getStringCellValue();
					int id = (int) row.getCell(0).getNumericCellValue();
					String nom = row.getCell(1).getStringCellValue();
					String prenom = row.getCell(2).getStringCellValue();

					String provenance = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
					String formationPrecedente = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
					String niveauInsertion = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null;
					int id_cours = (int) row.getCell(7).getNumericCellValue();
					String libelle_cours = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null;
					String type_cours = row.getCell(9) != null ? row.getCell(9).getStringCellValue() : null;
					String niveau_cours = row.getCell(10) != null ? row.getCell(10).getStringCellValue() : null;
					String note = row.getCell(11) != null ? String.valueOf(row.getCell(11).getNumericCellValue())
							: null;
					if (annee.equals("2006"))
						if (statut.equals("enseignant")) {
							Enseignant enseignant = new Enseignant(id, nom, prenom, null, null);
							model.getEnseignants().add(enseignant);
							Enseigne enseigne = new Enseigne(id, id_cours, annee, null);
							model.getEnseignes().add(enseigne);

						}
					Cours c = new Cours(id_cours, libelle_cours, type_cours, niveau_cours, null);
					model.getCours().add(c);

				}

			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return model;
	}

	public Model executeRequete3(String requete) {
		Model model = new Model();
		try {
			FileInputStream excelFile = new FileInputStream(new File(pathSource));
			Workbook workbook = new HSSFWorkbook(excelFile);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				String annee = sheet.getSheetName();

				for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {
					Row row = sheet.getRow(j + 1);
					String statut = row.getCell(3).getStringCellValue();
					int id = (int) row.getCell(0).getNumericCellValue();
					String nom = row.getCell(1).getStringCellValue();
					String prenom = row.getCell(2).getStringCellValue();

					String provenance = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
					String formationPrecedente = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
					String niveauInsertion = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null;
					int id_cours = (int) row.getCell(7).getNumericCellValue();
					String libelle_cours = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null;
					String type_cours = row.getCell(9) != null ? row.getCell(9).getStringCellValue() : null;
					String niveau_cours = row.getCell(10) != null ? row.getCell(10).getStringCellValue() : null;
					String note = row.getCell(11) != null ? String.valueOf(row.getCell(11).getNumericCellValue())
							: null;
					if (statut.equals("etudiant"))
						if (provenance.equals("France")) {

							Etudiant etudiant = new Etudiant((id), nom, prenom, provenance, formationPrecedente, null,
									annee, null, niveauInsertion, null);
							model.getEtudiants().add(etudiant);
							Inscription inscription = new Inscription(id, id_cours, annee, note);
							model.getInscriptions().add(inscription);
						}

				}

			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return model;
	}

}
