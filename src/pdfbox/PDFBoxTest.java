package pdfbox;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;



public class PDFBoxTest {

    public static String[] convert(String filePath) {
        PDFTextStripper pdfStripper;
        PDDocument pdDoc;
        COSDocument cosDoc;
        String path = filePath;
        File file = new File(path);
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file,"r"));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            int numPages = pdDoc.getNumberOfPages();
            String[] parsedText = new String[numPages];
            for(int i =0; i<numPages; i ++){
            pdfStripper.setStartPage(i+1);
            pdfStripper.setEndPage(i+1);
            parsedText[i] = pdfStripper.getText(pdDoc);
            }
            pdDoc.close();
            return(parsedText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
}
