
public class Conditional extends LogicalSentence {
	private LogicalSentence sentence1, sentence2;
	
	public Conditional(LogicalSentence logSen, Negation neg) {
		this.sentence1 = logSen;
		this.sentence2 = neg;
	}
	
	@Override
	/* conditional returns true as long as [1st sentence is not true and 2nd sentence is not false] */
	public Boolean evaluate(TruthAssignment truth){
		return !sentence1.evaluate(truth) || sentence2.evaluate(truth);
	
	}
}