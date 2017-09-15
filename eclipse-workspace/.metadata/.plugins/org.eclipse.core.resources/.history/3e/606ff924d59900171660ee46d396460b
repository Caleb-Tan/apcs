
public class Negation extends LogicalSentence {


	private LogicalSentence negatedLogSentence;
	
    public Negation(LogicalSentence logSen) {
    	negatedLogSentence = logSen;
    }
    
    
    public LogicalSentence getNegation(){
    	return negatedLogSentence;
    }
    
    public Boolean evaluate(TruthAssignment truth) {
    	return !(negatedLogSentence.evaluate(truth));
    }
    
}
