package summarizer;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.DOMException;

public class TextExtractor {

    private String[] text;

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }


    public String extractSentencesToXML(String path) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Reader reader;
            DocumentPreprocessor dp;
            String[] sentences = getText();
            Element rootElement = doc.createElement("Pages");
            doc.appendChild(rootElement);
            for (int i = 0; i < sentences.length; i++) {
                
                int sen = 1;
                String s = sentences[i];
                reader = new StringReader(s);
                dp = new DocumentPreprocessor(reader);
                Element page = doc.createElement("page");
                Attr pNum = doc.createAttribute("num");
                pNum.setValue(Integer.toString(i + 1));
                page.setAttributeNode(pNum);
                for (List<HasWord> senten : dp) {
                    if (!s.isEmpty()) {
                        String sentenceString = Sentence.listToString(senten);
                        sentenceString = sentenceString.replace("-LRB-","(");
                        sentenceString = sentenceString.replace("-RRB-",")");
                        if (sentenceString.length() < 300) {
                            Element sentence = doc.createElement("sentence");
                            Attr attrType = doc.createAttribute("num");
                            attrType.setValue(Integer.toString(sen));
                            sentence.setAttributeNode(attrType);
                            sentence.appendChild(doc.createTextNode(sentenceString));
                            page.appendChild(sentence);
                            rootElement.appendChild(page);
                            sen++;
                        }
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
            return path;
        } catch (ParserConfigurationException | DOMException | TransformerException e) {
            e.printStackTrace();
        }
        return path;
    }

}
