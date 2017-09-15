

public class LogicalSentence{

	private PropositionConstant logSentence;
	
	public LogicalSentence() {
	}
	
	/* sets logsentence to be the proposition constant in the parameter*/
	public LogicalSentence(PropositionConstant propC) {
		this.logSentence = propC;
	}
	
	/* method that the parent class has that takes the TruthAssignment object and returns the truth value associated with the constant*/
	public Boolean evaluate(TruthAssignment truth) {
		return truth.getHmap(logSentence.getConstant());	
	}

}
