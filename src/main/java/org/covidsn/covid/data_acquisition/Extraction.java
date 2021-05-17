package org.covidsn.covid.data_acquisition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class Extraction {

    public Extraction() throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("E://tessdata");
        tesseract.setLanguage("fra");
        String content = tesseract.doOCR(new File(".\\FilesDownloaded\\COMMUNIQUE 389.pdf"));
        String regExp[] = {"COMMUN!QUE\\s[0-9]{1,}",
                "[0-9]{1,}\\stests",
                "[0-9]{1,}\\ssont\\srevenus\\spositifs",
                "[0-9]{1,}\\scas\\scontacts",
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
