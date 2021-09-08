package vadim_nedrega.HW17_XML.XMLDataStore;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLPlayerDataStore<T> implements DataStore<Player> {
    private final String filePath;
    private List<Player> players = new ArrayList<>();
    private File file;
    private DocumentBuilder builder;
    private DocumentBuilderFactory documentBuilderFactory;
    private Document document;

    public XMLPlayerDataStore(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Player> load() {

        file = new File(filePath);
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        builder = getCheckedBuilder();
        document = getCheckedDocument(file);

        Node rootNode = document.getFirstChild();
        NodeList list = rootNode.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                try {
                    players = setPlayerDataList();
                } catch (XMLDataStoreException e) {
                    System.err.println("Load Player data error");
                }
            }
        }
        return players;
    }

    @Override
    public void save(List<Player> itemList) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert builder != null;
        DOMImplementation impl = builder.getDOMImplementation();
        Document doc = impl.createDocument(
                null, // namespaceURI
                null, // qualifiedName
                null); // doctype
        Element root = doc.createElement("root");
        doc.appendChild(root);
        for (int i = 0; i < itemList.size(); i++) {
            root.appendChild(createPlayerElement(doc, String.valueOf(i + 1), itemList.get(i).getName(),
                    String.valueOf(itemList.get(i).getAge()), String.valueOf(itemList.get(i).isAddicted())));
        }
        writeDocument(doc, filePath);
    }

    private DocumentBuilder getCheckedBuilder() {
        try {
            builder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder;
    }

    private Document getCheckedDocument(File file) {
        this.file = file;
        try {
            document = builder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    private void writeDocument(Document document, String path)
            throws TransformerFactoryConfigurationError {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private static Node createPlayerElement(Document doc, String id, String name, String age, String isAddicted) {
        Element player = doc.createElement("Player");

        player.setAttribute("id", id);
        player.appendChild(createPlayerElements(doc, player, "name", name));
        player.appendChild(createPlayerElements(doc, player, "age", age));
        player.appendChild(createPlayerElements(doc, player, "isAddicted", isAddicted));
        return player;
    }

    private static Node createPlayerElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }


    private List<Player> setPlayerDataList() throws XMLDataStoreException {
        Player player = null;
        List<Player> playerList = new ArrayList<>();
        NodeList name = document.getElementsByTagName("name");
        NodeList age = document.getElementsByTagName("age");
        NodeList isAddicted = document.getElementsByTagName("isAddicted");
        for (int i = 0; i < name.getLength(); i++) {
            player = new Player();
            NodeList fieldsName = name.item(i).getChildNodes();
            for (int j = 0; j < fieldsName.getLength(); j++) {
                player.setName(fieldsName.item(j).getNodeValue());
            }
            NodeList fieldsAge = age.item(i).getChildNodes();
            for (int j = 0; j < fieldsName.getLength(); j++) {
                player.setAge(Integer.parseInt(fieldsAge.item(j).getNodeValue()));
            }
            NodeList fieldsIsAddicted = isAddicted.item(i).getChildNodes();
            for (int j = 0; j < fieldsName.getLength(); j++) {
                player.setAddicted(Boolean.parseBoolean(fieldsIsAddicted.item(j).getNodeValue()));
            }
            playerList.add(player);
            if (playerList.size() == 0) throw new XMLDataStoreException();
        }
        return playerList;
    }
}
