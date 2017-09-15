
public class PropositionConstant {
	// proposition constant class essentially stores the prop constant String which can be returned when needed.
	private String propConstant;
	
	/* sets the value of the propConstant variable to the same input as the parameter*/
	public PropositionConstant(String pc){
		this.propConstant = pc;
	}
	
	/*getter method to return prop constant*/
	public String getConstant() {
		return propConstant;
	}
}
