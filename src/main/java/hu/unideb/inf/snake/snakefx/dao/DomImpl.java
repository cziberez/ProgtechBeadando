package hu.unideb.inf.snake.snakefx.dao;

import hu.unideb.inf.snake.snakefx.model.dto.userdto.User;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DomImpl implements Dom {

    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    public static ArrayList<User> users;

    public DomImpl() {
        dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(getClass().getClassLoader().getResourceAsStream("database/scoreboard.xml"));
            makeList();
        } catch (SAXException | IOException e) {
            e.getMessage();
        } catch (ParserConfigurationException e) {
            e.getMessage();
        }
    }

    @Override
    public void saveScore(String name, int score) {
        NodeList nodes = doc.getElementsByTagName("players");
        Element rootElement = (Element) nodes.item(0);

        Element playerNode = doc.createElement("player");

        Element nameNode = doc.createElement("name");
        nameNode.appendChild(doc.createTextNode(name));

        Element scoreNode = doc.createElement("score");
        scoreNode.appendChild(doc.createTextNode((String.valueOf(score))));
        try {
            playerNode.appendChild(nameNode);
            playerNode.appendChild(scoreNode);

            rootElement.appendChild(playerNode);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource source = new DOMSource(doc);

            URL url = this.getClass().getClassLoader().getResource("database/scoreboard.xml");
            File file;
            file = new File(URLDecoder.decode(url.getPath(), "UTF-8"));
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            makeList();
        } catch (TransformerException ex) {
            Logger.getLogger(DomImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DomImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void makeList() {
        NodeList nodeList = doc.getChildNodes();

        Element root = (Element) nodeList.item(0);
        NodeList playerList = root.getElementsByTagName("player");

        users = new ArrayList<>();
        for (int i = 0; i < playerList.getLength(); i++) {
            Element playerElement = (Element) playerList.item(i);
            User user = new User();
            user.setName(playerElement.getElementsByTagName("name").item(0).getTextContent());
            user.setScore(Integer.parseInt(playerElement.getElementsByTagName("score").item(0).getTextContent()));
            users.add(user);
        }
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }
}
