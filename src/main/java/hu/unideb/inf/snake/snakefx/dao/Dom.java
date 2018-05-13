package hu.unideb.inf.snake.snakefx.dao;

import hu.unideb.inf.snake.snakefx.model.user.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Zoli
 */
public class Dom {

    private Document doc;

    public ArrayList<User> getUsers() {
        ArrayList<User> userListArray = new ArrayList<User>();
        User user;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;
            Document doc;
            DocumentBuilderFactory dom = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dom.newDocumentBuilder();
            //létező fájl beolvasás
            doc = db.parse(getClass().getResourceAsStream("/database/scoreboard.xml"));

            //olyan mint a trim()
            doc.normalize();

            NodeList userNodeList = doc.getElementsByTagName("user");

            for (int i = 0; i < userNodeList.getLength(); i++) {

                user = new User();

                Element e = (Element) userNodeList.item(i);
                user.setName(e.getElementsByTagName("name").item(0).getTextContent());
                user.setScore(Integer.parseInt(e.getElementsByTagName("score").item(0).getTextContent()));
                userListArray.add(user);
            }
        } catch (SAXException ex) {
            Logger.getLogger(Dom.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Dom.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Dom.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < userListArray.size(); i++) {
            System.err.println(userListArray.get(i).toString());
        }
        return userListArray;
    }

    public void insertScore(String name, int score) {
        try {
            DocumentBuilderFactory dom = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dom.newDocumentBuilder();

            doc = db.newDocument();

            Element rootElement = (Element) doc.getElementsByTagName("users").item(0);

            Element userElement = doc.createElement("user");
            Element nameElemet = doc.createElement("name");
            Element scoreElement = doc.createElement("score");
            nameElemet.appendChild(doc.createTextNode(name));
            scoreElement.appendChild(doc.createTextNode(String.valueOf(score)));

            userElement.appendChild(nameElemet);
            userElement.appendChild(scoreElement);

            rootElement.appendChild(userElement);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            //tördelés
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            //behúzás
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
//            URL xmlUrl = getClass().getResource("/database/scoreboard.xml");
//            File file = new File(xmlUrl.getPath());
            File file = new File("src/main/resources/database/scoreboard.xml");
            StreamResult result = new StreamResult(file);

            t.transform(source, result);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
