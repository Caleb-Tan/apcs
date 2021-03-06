
import java.util.HashMap;

public class TruthAssignment {
    
    private HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();
    
    /* put function adds the values given to the params to the hashmap. basically it sets the constant that is given to correspond to true or false */
    public void put(PropositionConstant propC, boolean truthVal) {
        hmap.put(propC.getConstant(), truthVal);
    }
    
    /* based on the proposition constant that this method takes in, it will return the value of that constant, which is whether or not it is true or false*/
    public Boolean getHmap(String constant) {
        return hmap.get(constant);
    }
    
}
