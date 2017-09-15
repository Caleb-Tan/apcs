
public class Conjunction extends LogicalSentence {
	private LogicalSentence sentence1, sentence2;
	
	public Conjunction(LogicalSentence logSen, Negation neg) {
		this.sentence1 = logSen;
		this.sentence2 = neg;
	}
	
	/* conjunction returns true only if both sentences are true */
	@Override
	public Boolean evaluate(TruthAssignment truth){
		return (sentence1.evaluate(truth) && sentence2.evaluate(truth));
	}
	
}
