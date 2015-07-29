/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcryad.dataprocess;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author abhu
 */
public class FetchData {
    
    private Element data;
    private Elements tds;
    
    public Elements initial(){
        
        try {
            Document doc = Jsoup.connect("http://seismonepal.gov.np/index.php?action=earthquakes&show=recent").timeout(10000).get();
            data = doc.select("tbody").first();
            tds = doc.select("td");
            return tds;
            
        } catch (IOException ex) {
            System.err.println("Error During Connection");
           
        }
        return null;

    }
}
