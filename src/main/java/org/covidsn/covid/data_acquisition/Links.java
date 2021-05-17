package org.covidsn.covid.data_acquisition;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

public class Links {
    private HashMap<String,String> links = new HashMap<>();

    public Links(){

    }

    public HashMap<String,String> getLinks() throws IOException,InterruptedException{
        Document doc;
        doc = Jsoup.connect("https://sante.sec.gouv.sn/actualites").timeout(100000).get();
        Document pages;
        HashMap<String, String> liens = new HashMap<>();
        ArrayList<String> content = new ArrayList<>();

        for (int k =  1 ; k <= 2 ; k++) {
            Elements el2 = doc.select("h4.card-title a");

            for (Element element : el2) {
                content.add(element.attr("href"));
            }

            for (int e = 0; e < content.size(); e++) {
                pages = Jsoup.connect("https://sante.sec.gouv.sn/" + content.get(e)).timeout(100000).get();
                liens.put(pages.select("span.file a").text(), pages.select("span.file a").attr("href"));
            }
            doc = Jsoup.connect("https://sante.sec.gouv.sn/actualites?page="+k).timeout(100000).get();
            content.clear();

        }

        return liens;
    }

}
