package summarizer;

import freetts.Freetts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Database.ConnectDB;

public class Generator {

    private InputDocument inputDoc;
    String xmlFileName = null, keyword = null, readSummary = "", filename, allResults = "", readAll = "", summary = "";
    Parser p = new Parser();
    Freetts freeTTS = new Freetts();

    public void loadFile(String inputFile) {
        inputDoc = new InputDocument();
        inputDoc.loadFile(inputFile);
    }

    public String extractSentences(String name) {
        xmlFileName = inputDoc.extractSentences(name);
        filename = name;
        return xmlFileName;
    }

    public ArrayList getAllSentences(String name) {
        try {

            File xmlFile = new File(name);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("page");
            ArrayList<Sentence> senArray = new ArrayList<>();
            for (int i = 0; i < nl.getLength(); i++) {
                NodeList sentence = nl.item(i).getChildNodes();
                for (int j = 0; j < sentence.getLength(); j++) {
                    senArray.add(new Sentence((i + 1),(sentence.item(j).getTextContent()),0));
                }
            }
            return senArray;
        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
        return null;
    }

    public ArrayList<Sentence> calcAllScores(ArrayList<Sentence> al) {
        for (int i = 0; i < al.size(); i++) {
            int score = calcSentenceScore(al.get(i).getSen());
            al.get(i).setScore(score);
        }
        return al;
    }

    public int calcSentenceScore(String n) {
        int score = 0;
        if (n.toLowerCase().matches("(?s).*\\b"+keyword.toLowerCase()+"\\b.*")) {
            score = 1;
            score = p.score(n, keyword, score);
        } else {
            score = 0;
        }
        return score;
    }

    public void setKeyword(String kword) {
        keyword = kword;
    }

    public String generateSummary(ConnectDB db, String uname, String dl) throws FileNotFoundException {
        ArrayList<Sentence> sentenceArray = getAllSentences(xmlFileName);
        ArrayList<Sentence> summaryArray = new ArrayList();
        sentenceArray = calcAllScores(sentenceArray);
        summary = "Summary of " + filename + " for the keyword: " + keyword;
        for (int i = 0; i< sentenceArray.size(); i++){
            if(sentenceArray.get(i).getScore() > 0){
                summaryArray.add(sentenceArray.get(i));
            }
        }
        allResults = summary;
        Collections.sort(summaryArray);
        int x;
        if (summaryArray.size() > 10) {
            x = 10;
        } else {
            x = summaryArray.size();
        }
        for (int i = 0; i<x ; i++){
                summary += "\n" + summaryArray.get(i).getSen() + " || Page no: " + summaryArray.get(i).getPnum() + "\n";
                readSummary += summaryArray.get(i).getSen() + ". ";
        }
        for (int i = 0; i<summaryArray.size() ; i++){
                allResults += "\n" + summaryArray.get(i).getSen() + " || Page no: " + summaryArray.get(i).getPnum() + "\n";
                readAll += summaryArray.get(i).getSen() + ". ";
        }
        if(x < 10){
            summary += "Displaying top " + x + " of " + summaryArray.size() + " results";
        }else{
            summary += "Displaying top 10 of " + summaryArray.size() + " results";
        }
        if ("".equals(summary)) {
            summary = "No sentences contain that keyword";
        } else {
            db.inputSummary(keyword, uname, dl);
            
        }

        return summary;
    }

    public void readSummary(String readS) {
        freeTTS.setText(readS);
        freeTTS.speak();
    }
    
    public void stopReadSummary(){
        freeTTS.cancel();
    }
    
    public void reset() {
        inputDoc = null;
        xmlFileName = null;
        keyword = null;
        readSummary = "";
    }
}
