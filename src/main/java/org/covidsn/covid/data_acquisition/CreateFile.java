package org.covidsn.covid.data_acquisition;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jdom2.*;
import org.jdom2.output.*;

public class CreateFile {
    public CreateFile(){

    }

    public void fileXml(String nomSource, int nombreTest, int testPositifs , int casContacts , int tC , int nombreGueris, int nombreDeces) {
        try {
            Element date = new Element("_"+LocalDateTime.now().getYear()+LocalDateTime.now().getMonth());
            Document doc = new Document(date);

            Element communique = new Element("_01-01-2020");
            communique.addContent(new Element("nombre-test").setText(String.valueOf(nombreTest)));
            communique.addContent(new Element("nombre-cas-contact").setText(String.valueOf(casContacts)));
            communique.addContent(new Element("nombre-cas-communautaires")).setAttribute("nombre", String.valueOf(tC));
            communique.addContent(new Element("nombre-gueris").setText(String.valueOf(nombreGueris)));
            communique.addContent(new Element("nombre-deces").setText(String.valueOf(nombreDeces)));
            communique.addContent(new Element("nombre-fichier-source").setText(nomSource));
            communique.addContent(new Element("date-heure-extraction").setText(String.valueOf(LocalDateTime.now())));

            doc.getRootElement().addContent(communique);

            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter(".\\DocsProjets\\FilesCreated\\"+LocalDateTime.now().getYear()+"-"+LocalDateTime.now().getMonth()+".xml"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
