package org.covidsn.covid.data_acquisition;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EssaiXML {

    public void essai (){
        SAXBuilder builder = new SAXBuilder();
        File fichierXML = new File("C:\\Users\\User\\Desktop\\essai.xml");
        Document document ;
        try {
            /* Parsing du fichier */
            document = builder.build(fichierXML);

            /* Racine du document XML : dans notre cas <diagramme> */
            Element rootNode = document.getRootElement();

            /* On récupère tous les élément classe du fichier XML */
            List<Element> liste = rootNode.getChildren("f01-01-2020");

            /* Boucle sur tous les éléments "classe" du fichier XML */
            for (Element eClasse : liste) {
                /* Affichage du nom du la classe */
                System.out.println(eClasse.getChild("nombre-test").getText());
                System.out.println(eClasse.getChild("nombre-nouveaux-cas").getText());
                System.out.println(eClasse.getChild("nombre-cas-contact").getText());
                System.out.println(eClasse.getChild("nombre-gueris").getText());
                System.out.println(eClasse.getChild("nombre-deces").getText());


                /* Récupération de tous les attributs de la classe */
                List<Element> attributs = eClasse.getChildren("nombre-cas-communautaires");
                for(Element eAttribut : attributs){
                    String nomAttribut = eAttribut.getChildText("nom-localite");
                    String type = eAttribut.getChildText("nombre-cas");

                    System.out.println(type+" "+nomAttribut+"=");

                }

            }
        }
        catch (JDOMException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
