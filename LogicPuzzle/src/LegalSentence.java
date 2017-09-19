import java.util.Arrays;

public class LegalSentence {
	/* this method parses the string into an array of the words. It then begins going through 
	 * each string value and checking it with cases that are in the other method. */
	
	public boolean check(String sentence) {
		String[] splitted = sentence.split("\\s+");//splits the string into an array based on spaces
		String prevValue = "start"; 				// beginning token
		for (int i = 0; i < splitted.length; i++) {
			String[] nextValue = possibleTokens(prevValue); //calls the possibleTokens method and gets the return value
			if (Arrays.asList(nextValue).contains(splitted[i])) {    // if statement checks to see if the next value is one of the possible tokens, if not, returns false, if yes, continues to parse the string
				prevValue = splitted[i];
			} else {
				System.out.println("Not a legal sentence.");
				return false;
			}
		}

		// if statement checks to see if the last value is p or q
		if (splitted[splitted.length-1].matches("p|q")){
			System.out.println("Is a legal sentence.");
            return true;
		}
		else {
			System.out.println("Not a legal sentence.");
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
