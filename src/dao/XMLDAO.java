package dao;

import model.Enseignant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import model.Etudiant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDAO {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    String filepath = "resources/source3.xml";

    public XMLDAO(){

    }

    public int heureTotalEnseignant(Enseignant ens){
        int heures=0;

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File(filepath);
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();

            String expression = "//Enseigne";

            NodeList list = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
            int nodesLength = list.getLength();

            for(int i = 0 ; i < nodesLength; i++){
                Node n = list.item(i);

                path.compile("NumEns");
                path.compile("Nb_heures");

                NodeList list1 = (NodeList)path.evaluate("NumEns", n, XPathConstants.NODESET);
                NodeList list2 = (NodeList)path.evaluate("Nb_heures", n, XPathConstants.NODESET);

                int nodesLength2 = list1.getLength();

                for(int j = 0; j < nodesLength2; j++){

                    Node n1 = list1.item(j);
                    Node n2 = list2.item(j);

                    if(ens.getId() == Integer.parseInt(n1.getTextContent())){
                        heures = heures + Integer.parseInt(n2.getTextContent());
                    }
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return heures;
    }

    public List<Enseignant> listEnseignants() {
        List<Enseignant> listEns = new ArrayList<Enseignant>();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File(filepath);
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();

            String expression = "//Enseignant";

            NodeList list = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
            int nodesLength = list.getLength();

            for(int i = 0 ; i < nodesLength; i++){
                Node n = list.item(i);

                path.compile("NumEns");
                path.compile("Nom");
                path.compile("Prenom");
                path.compile("adresseMail");

                NodeList list1 = (NodeList)path.evaluate("NumEns", n, XPathConstants.NODESET);
                NodeList list2 = (NodeList)path.evaluate("Nom", n, XPathConstants.NODESET);
                NodeList list3 = (NodeList)path.evaluate("Prenom", n, XPathConstants.NODESET);
                NodeList list4 = (NodeList)path.evaluate("adresseMail", n, XPathConstants.NODESET);

                int nodesLength2 = list1.getLength();

                for(int j = 0; j < nodesLength2; j++){

                    Node n1 = list1.item(j);
                    Node n2 = list2.item(j);
                    Node n3 = list3.item(j);
                    Node n4 = list4.item(j);

                    Enseignant ens = new Enseignant(Integer.parseInt(n1.getTextContent()),n2.getTextContent(),n3.getTextContent(),n4.getTextContent());

                    listEns.add(ens);
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return listEns;
    }

    public List<Etudiant> listEtudiants() {
        List<Etudiant> listEt = new ArrayList<Etudiant>();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File(filepath);
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();

            String expression = "//Etudiant";

            NodeList list = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
            int nodesLength = list.getLength();

            for(int i = 0 ; i < nodesLength; i++){
                Node n = list.item(i);

                path.compile("NumEt");
                path.compile("nom");
                path.compile("Provenance");
                path.compile("FormationPrecedante");
                path.compile("Pays_formation_precedante");
                path.compile("AnneeDebut");
                path.compile("dateNaissance");
                path.compile("Niveau_insertion");

                NodeList list1 = (NodeList)path.evaluate("NumEt", n, XPathConstants.NODESET);
                NodeList list2 = (NodeList)path.evaluate("nom", n, XPathConstants.NODESET);
                NodeList list3 = (NodeList)path.evaluate("Provenance", n, XPathConstants.NODESET);
                NodeList list4 = (NodeList)path.evaluate("FormationPrecedante", n, XPathConstants.NODESET);
                NodeList list5 = (NodeList)path.evaluate("Pays_formation_precedante", n, XPathConstants.NODESET);
                NodeList list6 = (NodeList)path.evaluate("AnneeDebut", n, XPathConstants.NODESET);
                NodeList list7 = (NodeList)path.evaluate("dateNaissance", n, XPathConstants.NODESET);
                NodeList list8 = (NodeList)path.evaluate("Niveau_insertion", n, XPathConstants.NODESET);

                int nodesLength2 = list1.getLength();

                for(int j = 0; j < nodesLength2; j++){

                    Node n1 = list1.item(j);
                    Node n2 = list2.item(j);
                    Node n3 = list3.item(j);
                    Node n4 = list4.item(j);
                    Node n5 = list5.item(j);
                    Node n6 = list6.item(j);
                    Node n7 = list7.item(j);
                    Node n8 = list8.item(j);

                    // On souhaite l'age alors qu'on a la date de naissance
                    int age = getAge(new SimpleDateFormat("yyyy/mm/dd").parse(n7.getTextContent()),new Date());

                    Etudiant et = new Etudiant(Integer.parseInt(n1.getTextContent()),n2.getTextContent(),"",n3.getTextContent(),n4.getTextContent(),n5.getTextContent(),Integer.parseInt(n6.getTextContent().substring(0,4)),age,n8.getTextContent());

                    listEt.add(et);
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listEt;
    }

    public int getAge(Date birthDate, Date currentDate){
    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        int age = (d2 - d1) / 10000;
        return age;
    }
}
