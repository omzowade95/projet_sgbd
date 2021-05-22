package org.covidsn.covid.data_acquisition;

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
    public String tab[];

    public Extraction() throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(".\\DocsProjets\\tessdata");
        tesseract.setLanguage("fra");
        String content = tesseract.doOCR(new File(".\\DocsProjets\\FilesDownloaded\\COMMUNIQUE 389.pdf"));
        String regExp[] = {"COMMUN!QUE\\s[0-9]{1,}",
                "[0-9]{1,}\\stests",
                "[0-9]{1,}\\ssont\\srevenus\\spositifs",
                "[0-9]{1,}\\sCas\\scontacts",
                "[0-9]{1,}\\scas\\sissus\\sde\\sla\\stransmission\\scommunautaire",
                "[0-9]{1,}\\spatients",
                "[0-9]{1,}\\sdécès"};

        Pattern contentPattern = null;
        Matcher contentMatcher = null;

        String[] tab = content.replace("\n"," ").split(" ");

        for (int k = 0 ; k < regExp.length ; k++){
            contentPattern = Pattern.compile(regExp[k], Pattern.DOTALL);
            contentMatcher = contentPattern.matcher(content.replace("\n"," "));
            while (contentMatcher.find()) {
                System.out.println(contentMatcher.group(0));
            }
        }
    }

}