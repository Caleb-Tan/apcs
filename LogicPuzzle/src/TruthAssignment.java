
import java.util.HashMap;

public class TruthAssignment {
    
    private HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();

    
    // put function adds the values given to the params to the arrays
    public void put(PropositionConstant propC, boolean truthVal) {
        hmap.put(propC.getConstant(), truthVal);
    }
    
    public Boolean getHmap(String name) {
        return hmap.get(name);
    }
    
}
