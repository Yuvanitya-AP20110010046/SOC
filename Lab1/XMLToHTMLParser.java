import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLToHTMLParser {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("details (1).xml"));

            document.getDocumentElement().normalize();

            NodeList detailsList = document.getElementsByTagName("fullName");

            String tag = "<html><body><table border=\"1\"><tr><th>Name</th><th>Phone</th><th>Date of Birth</th><th>Address</th><th>Account</th></tr>";
            for (int i = 0; i < detailsList.getLength(); i++) {
                Node details = detailsList.item(i);
                if (details.getNodeType() == Node.ELEMENT_NODE) {

                    Element detailsElement = (Element) details;
                    //System.out.println("Employee Name: " + laptopElement.getAttribute("name"));
                    tag += "<tr><td>" + detailsElement.getAttribute("name") + "</td>";

                    NodeList Details = details.getChildNodes();
                    for (int j = 0; j < Details.getLength(); j++) {
                        Node detail = Details.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            //System.out.println(detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                            tag += "<td>" + detailElement.getAttribute("value") + "</td>";
                        }
                    }
                    tag += "</tr>";
                    System.out.println();
                }
            }

            tag += "</table></body></html>";
            //System.out.println(tag);

            try {
                FileWriter myWriter = new FileWriter("index1.html");
                myWriter.write(tag);
                myWriter.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}