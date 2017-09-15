
public class Negation extends LogicalSentence {


	private LogicalSentence negatedLogSentence;
	// setter
    public Negation(LogicalSentence logSen) {
    	negatedLogSentence = logSen;
    }
    
   
    /*evaluates the logical sentence to be the opposite of the truth that is put in its parameter. if it is true, then it returns false, because it is a negation.*/
    @Override
    public Boolean evaluate(TruthAssignment truth) {
    	return !(negatedLogSentence.evaluate(truth));
    }
    
}
