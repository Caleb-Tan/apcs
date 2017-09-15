
public class Nand extends LogicalSentence {
	private LogicalSentence sentence1, sentence2;
	
	public Nand(LogicalSentence logSen, Negation neg) {
		this.sentence1 = logSen;
		this.sentence2 = neg;
	}
	
	/* nand returns true or false. will return true as long as both of the sentences are not true */
	@Override
	public Boolean evaluate(TruthAssignment truth){
		return !(sentence1.evaluate(truth) && sentence2.evaluate(truth));
	}
	
}
