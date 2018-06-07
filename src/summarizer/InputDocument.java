package summarizer;
import pdfbox.PDFBoxTest; 

public class InputDocument{

        protected String[] content;

        public void loadFile(String filePath){          
              setContent(PDFBoxTest.convert(filePath));
        }

        public String[] getContent() {
                return content;
        }

        public void setContent(String[] content) {
                this.content = content;
        }

        public String extractSentences(String name) {
                return createTextExtractor().extractSentencesToXML(name + ".xml");
        }

        private TextExtractor createTextExtractor() {
                TextExtractor b = new TextExtractor();
                b.setText(getContent());
                return b;
        }

}

