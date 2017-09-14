
public class Negation extends LogicalSentence {

	private LogicalSentence negationLogSentence;
	private String negatedPropConstant;
	
    public Negation(LogicalSentence logSen) {
        this.negationLogSentence = logSen;
    }
    
    public void Negate(){
    	negatedPropConstant = "~" + this.negationLogSentence.getPropositionConstant().getConstant() + this.negatedPropConstant;
    }
    
    public String getNegation(){
    	return negatedPropConstant;
    }
    /*public boolean evaluate(TruthAssignment truthVal) {
        boolean retVal = !logSen.evaluate(truthVal);
        
        return retVal;
    }*/
}
