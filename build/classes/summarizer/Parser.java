package summarizer;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import java.util.Collection;

public class Parser {
    
    LexicalizedParser lp;
            
    public Parser(){
        lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        lp.setOptionFlags(new String[]{"-maxLength", "80", "-retainTmpSubcategories"});
    }
    public int score(String sent, String key, int score) {
        
        Tree parse = (Tree) lp.parse(sent);
        String treeString = parse.toString();
        Tree tree = Tree.valueOf(treeString);
        SemanticGraph graph = SemanticGraphFactory.generateUncollapsedDependencies(tree);
        Collection<TypedDependency> td = graph.typedDependencies();
        Object[] x = td.toArray();
        for (Object x1 : x) {
            if (x1.toString().contains("nsubj")) {
                if (x1.toString().contains(key)) {
                    score += 3;
                    if (x1.toString().contains("dobj")) {
                        if (x1.toString().contains(key)) {
                            score -= 1;
                            return score;
                        }
                    }
                }
            }
            if (x1.toString().contains("dobj")) {
                if (x1.toString().contains(key)) {
                    score += 1;
                }
            }
        }
        return score;
    }
}