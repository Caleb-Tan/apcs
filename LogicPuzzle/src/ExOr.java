
// code borrowed from Mr. Kuszmaul
public class ExOr extends LogicalSentence{
	LogicalSentence left, right;
	
	public ExOr(LogicalSentence left, LogicalSentence right) {
		this.left = left;
		this.right = right;
	}
	
	Boolean evaluate(TruthAssignment t) {
		return left.evaluate(t) != right.evaluate(t); 
	}
}
