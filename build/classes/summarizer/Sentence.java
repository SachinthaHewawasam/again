package summarizer;
public class Sentence implements Comparable{
    
    private String sentence;
    private int pageno,score;
    
    public Sentence (int p, String s, int sc){
        pageno = p;
        sentence = s;
        score = sc;
    }
    public void setSen(String sen){
        sentence = sen;
    }
    
    public void setPnum(int pnum){
        pageno = pnum;
    }
    
    public void setScore(int sco){
        score = sco;
    }
    
    public String getSen(){
        return sentence;
    }
    
    public int getPnum(){
        return pageno;
    }
    
    public int getScore(){
        return score;
    }

    @Override
    public int compareTo(Object comparesen) {
        int compareScore=((Sentence)comparesen).getScore();
        return compareScore-this.score;
    }
    
}
