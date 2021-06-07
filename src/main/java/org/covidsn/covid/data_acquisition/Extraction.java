package org.covidsn.covid.data_acquisition;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class Extraction {
    private String nomCommunique;
    private int  nombreTest;
    private int testPositifs;
    private int casContact;
    private int transmissionCommunautaire;
    private int  nombreGueris;
    private int nombreDeces;
    public ArrayList<String> list = new ArrayList<>();
    String tab[];

    public Extraction(String nomCommunique) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(".\\DocsProjets\\tessdata");
        tesseract.setLanguage("fra");
        String content = tesseract.doOCR(new File(TelechargementController.getLien()+"\\"+nomCommunique));
        String regExp[] = {"COMMUNIQUE\\s[0-9]{1,}",
                "[0-9]{1,}\\stests",
                "[0-9]{1,}\\ssont\\srevenus\\spositifs",
                "[0-9]{1,}\\sCas\\scontacts",
                "[0-9]{1,}\\scas\\sissus\\sde\\sla\\stransmission\\scommunautaire",
                "[0-9]{1,}\\spatients",
                "[0-9]{1,}\\sd"};

        Pattern contentPattern = null;
        Matcher contentMatcher = null;


       for (int k = 0 ; k < regExp.length ; k++){
            contentPattern = Pattern.compile(regExp[k], Pattern.DOTALL);
            contentMatcher = contentPattern.matcher(content.replace("\n"," "));
            if (contentMatcher.find())
                list.add(contentMatcher.group(0));
        }

       this.nomCommunique = nomCommunique;

       tab = list.get(1).split(" ");
       this.nombreTest = Integer.parseInt(tab[0]);

       tab = list.get(2).split(" ");
       this.testPositifs = Integer.parseInt(tab[0]);

        tab = list.get(3).split(" ");
        this.casContact = Integer.parseInt(tab[0]);

        tab = list.get(4).split(" ");
        this.transmissionCommunautaire = Integer.parseInt(tab[0]);

        tab = list.get(5).split(" ");
        this.nombreGueris = Integer.parseInt(tab[0]);

        tab = list.get(6).split(" ");
        this.nombreDeces = Integer.parseInt(tab[0]);

    }

    public String getNomCommunique() {
        return nomCommunique;
    }

    public int getNombreTest() {
        return nombreTest;
    }

    public int getTestPositifs() {
        return testPositifs;
    }

    public int getCasContact() {
        return casContact;
    }

    public int getTransmissionCommunautaire() {
        return transmissionCommunautaire;
    }

    public int getNombreGueris() {
        return nombreGueris;
    }

    public int getNombreDeces() {
        return nombreDeces;
    }
}
