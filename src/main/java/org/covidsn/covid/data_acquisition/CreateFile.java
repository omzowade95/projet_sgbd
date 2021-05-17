package org.covidsn.covid.data_acquisition;
import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;

public class CreateFile {
    public CreateFile(){

    }

    public void fileXml() {
        try {
            Element date = new Element("_2020-01");
            Document doc = new Document(date);

            Element communique = new Element("_01-01-2020");
            communique.addContent(new Element("nombre-test").setText("valeur"));
            communique.addContent(new Element("nombre-cas-contact").setText("valeur"));
            communique.addContent(new Element("nombre-cas-communautaires")).setAttribute("nombre","valeur");
            communique.addContent(new Element("nombre-gueris").setText("valeur"));
            communique.addContent(new Element("nombre-deces").setText("valeur"));
            communique.addContent(new Element("nombre-fichier-source").setText("valeur"));
            doc.getRootElement().addContent(communique);

            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter(".\\FilesCreated\\file.xml"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
