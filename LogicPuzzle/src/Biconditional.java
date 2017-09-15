
public class Biconditional extends LogicalSentence {
	private LogicalSentence sentence1, sentence2;
	
	public Biconditional(LogicalSentence logSen, Negation neg) {
		this.sentence1 = logSen;
		this.sentence2 = neg;
	}
	
	@Override
	/* biconditional returns true only if both sentences are either both true or both false */
	public Boolean evaluate(TruthAssignment truth){
		return (sentence1.evaluate(truth) == sentence2.evaluate(truth));
		
	}
}