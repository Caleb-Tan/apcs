

public class LogicalSentence{

	private PropositionConstant logSentence;
	
	public LogicalSentence() {
	}
	
	public LogicalSentence(PropositionConstant propC) {
		this.logSentence = propC;
	}
	public PropositionConstant getPropositionConstant(){
		return logSentence;
	}
	
	public Boolean evaluate(TruthAssignment truth) {
		return truth.getHmap(logSentence.getConstant());
	}

}
