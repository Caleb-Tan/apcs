
public class LogicalSentence {

	String logSentence;
	public LogicalSentence(PropositionConstant x) {
		this.logSentence = x.PropConstant;
	}
	public String evaluate(TruthAssignment assignment) {
		return logSentence;
		// ODO Auto-generated method stub
	}

}
