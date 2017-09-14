import java.util.Arrays;

public class Main {

	
	/*findmatch returns the index of the rightmost character in the first substring of the argument 
	 * that is enclosed by matching parens and which contains no parens.
	 */
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a &"));
		System.out.println(findMatch("a(b)", 0)); 

		String[] pc = {"p"};
		truthTable(pc);*/
	}
	
	public static void legal(String name) {
		
	}
	public boolean check(String sentence) {
		String[] splitted = sentence.split("\\s+");//splits the string into an array based on spaces
		String prevValue = "start"; 				// beginning token
		for (int i = 0; i < splitted.length; i++) {
			String[] nextValue = possibleTokens(prevValue); //calls the possibleTokens method and gets the return value
			if (Arrays.asList(nextValue).contains(splitted[i])) {    // if statement checks to see if the next value is one of the possible tokens, if not, returns false, if yes, continues to parse the string
				prevValue = splitted[i];
			} else {
				return false;
			}
		}

		// if statement checks to see if the last value is p or q
		if (splitted[splitted.length-1].matches("p|q"){
            return true;
		}
		else {
			return false;
		}
	}
	
	
	// method that contains all the possible outcomes, returns what the next values should be based on the previous token 
	public String[] possibleTokens(String token) {
		switch (token) {
			case "start":
				String[] a = {"a","b","~"};
				return a;
			case "~":
				String[] b = {"a", "b", "~"};
				return b;
			case "p":
			case "q":
				String[] c = {"&", "|", "=>", "<=>", "~"};
				return c;
			case "&":
			case "|":
			case "=>":
			case "<=>":
				String[] d = {"p", "q", "~"};
				return d;
			default:
				String[] e = {}; //returns empty string if the token does not match any case
				return e;
		}

	}
}
