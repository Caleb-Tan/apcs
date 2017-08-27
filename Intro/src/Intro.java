
public class Intro {

	public static void main(String[] args) {
		// print the return value of method ret
		System.out.println(ret());
		// print the return value of method logic
		System.out.println(logic(true, true, true));
		// print the return value of method stars
		System.out.println(stars(6));
		// print the return value of method coins
		System.out.println(coins(23));
		
	}
	
	// method ret returns 7
	public static int ret(){
		return 7;
	}
	
	// method logic takes 3 boolean parameters and returns if they are true or false when they are a & b & c
	public static boolean logic(boolean a, boolean b, boolean c){
		return a & b & c;
	}
	
	// method stars takes an int value and returns a string of the stars incremented in each line.
	public static String stars(int n){
		// define the string "stars" which will store the stars 
		String stars = "";
		// for loop loops through as many times as the int n, each loop through will make 1 star line. 
		for (int i=1; i < n+1; i++){
			// for loop within for loop that adds as many stars as needed in each line. (starts at 0 then keeps incrementing by 1)
			for (int x=0; x<i; x++){
				stars = stars + "*";
			}
			// once for loop that adds stars is completed, new line is added to String, and the first for loop repeats.
			stars = stars + "\n";
		}
		// returns the final concatenated string after for loop is finished
		return stars;
	}
	
	// method coins takes in the value of money and returns an int value of the minimum # coins needed to exchange
	public static String coins(int n) {
		int coins = n;
		int amountFives = 0;
		int amountTwos = 0;
		for(int i=5; i<=n; i+=5){
			amountFives += 1;
			coins -= 5;
		}
		if (coins%2 == 0){
			amountTwos += coins/2;
		} else if (coins%2 != 0){
			amountFives -= 1;
			amountTwos += (coins+5)/2;
		}
		if (n == 1 | n == 3){
			amountFives = -1;
			amountTwos = -1;
		}
		
		String coinsAmount = "# of 5 cent coins: " + Integer.toString(amountFives) + "\n# of 2 cent coins: " + Integer.toString(amountTwos);
		return coinsAmount;

	}
}
