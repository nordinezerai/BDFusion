package dao;

import model.Enseignant;

import java.util.ArrayList;
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
}
