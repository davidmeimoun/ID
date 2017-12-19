package ProjectID.ProjectID;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AdaptateurXML {

	public Model executeRequete1(String requete) {

		Model m = new Model();
		// standard for reading an XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		XPathExpression expr = null;
		try {
			builder = factory.newDocumentBuilder();

			doc = builder.parse("Univ_BD_3.xml");

			// create an XPathFactory
			XPathFactory xFactory = XPathFactory.newInstance();

			// create an XPath object
			XPath xpath = xFactory.newXPath();

			// compile the XPath expression
			expr = xpath.compile("//Inscription[Annee_universitaire>=2007]/NumEt/text()");

			// run the query and get a nodeset
			Object result = expr.evaluate(doc, XPathConstants.NODESET);

			// cast the result to a DOM NodeList
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				XPathExpression expr2 = xpath
						.compile("//Inscription[NumEt='" + nodes.item(i).getNodeValue() + "']/Note_cours/text()");
				Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
				NodeList nodes3 = (NodeList) result2;
				if (Integer.valueOf(nodes3.item(0).getNodeValue()) > 10) {
					Etudiant e = new Etudiant();
					e.setId_etudiant(Integer.valueOf(nodes.item(i).getNodeValue()));
					NodeList nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/nom/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setNom(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/telephone/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setTelephone(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Provenance/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setProvenance(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath.compile(
							"//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/FormationPrecedante/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setFormationPrecedente(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/AnneeDebut/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setAnneeDebut(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/dateNaissance/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setAge(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath
							.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Niveau_insertion/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setNiveauInsertion(nodes2.item(0).getNodeValue());
					nodes2 = (NodeList) xpath.compile(
							"//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Pays_formation_precedante/text()")
							.evaluate(doc, XPathConstants.NODESET);
					e.setPaysDeFormationPrecedente(nodes2.item(0).getNodeValue());
					m.getEtudiants().add(e);

				}
			}
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}
		return m;
	}

	public Model executeRequete2(String requete) {
		Model m = new Model();
		// standard for reading an XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		XPathExpression expr = null;
		try {
			builder = factory.newDocumentBuilder();

			doc = builder.parse("Univ_BD_3.xml");

			// create an XPathFactory
			XPathFactory xFactory = XPathFactory.newInstance();

			// create an XPath object
			XPath xpath = xFactory.newXPath();

			// compile the XPath expression
			expr = xpath.compile("//Enseigne[Annee_universitaire=2006]/NumEns/text()");

			// run the query and get a nodeset
			Object result = expr.evaluate(doc, XPathConstants.NODESET);

			// cast the result to a DOM NodeList
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {

				Enseignant e = new Enseignant();
				e.setId_enseignant(Integer.valueOf(nodes.item(i).getNodeValue()));
				NodeList nodes2 = (NodeList) xpath
						.compile("//Enseignant[NumEns='" + nodes.item(i).getNodeValue() + "']/Nom/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setNom(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Enseignant[NumEns='" + nodes.item(i).getNodeValue() + "']/Prenom/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setPrenom(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Enseignant[NumEns='" + nodes.item(i).getNodeValue() + "']/Telephone/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setTelephone(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Enseignant[NumEns='" + nodes.item(i).getNodeValue() + "']/adresseMail/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setMail(nodes2.item(0).getNodeValue());
				m.getEnseignants().add(e);

			}

		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}
		return m;
	}

	public Model executeRequete3(String requete) {

		Model m = new Model();
		// standard for reading an XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		XPathExpression expr = null;
		try {
			builder = factory.newDocumentBuilder();

			doc = builder.parse("Univ_BD_3.xml");

			// create an XPathFactory
			XPathFactory xFactory = XPathFactory.newInstance();

			// create an XPath object
			XPath xpath = xFactory.newXPath();

			// compile the XPath expression
			expr = xpath.compile("//Etudiant[Provenance='France']/NumEt/text()");

			// run the query and get a nodeset
			Object result = expr.evaluate(doc, XPathConstants.NODESET);

			// cast the result to a DOM NodeList
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {

				Etudiant e = new Etudiant();
				e.setId_etudiant(Integer.valueOf(nodes.item(i).getNodeValue()));
				NodeList nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/nom/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setNom(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/telephone/text()")
						.evaluate(doc, XPathConstants.NODESET);
				if (nodes2.item(0) != null)
					e.setTelephone(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Provenance/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setProvenance(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/FormationPrecedante/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setFormationPrecedente(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/AnneeDebut/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setAnneeDebut(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/dateNaissance/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setAge(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath
						.compile("//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Niveau_insertion/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setNiveauInsertion(nodes2.item(0).getNodeValue());
				nodes2 = (NodeList) xpath.compile(
						"//Etudiant[NumEt='" + nodes.item(i).getNodeValue() + "']/Pays_formation_precedante/text()")
						.evaluate(doc, XPathConstants.NODESET);
				e.setPaysDeFormationPrecedente(nodes2.item(0).getNodeValue());
				m.getEtudiants().add(e);

			}

		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}
		return m;
	}

}
