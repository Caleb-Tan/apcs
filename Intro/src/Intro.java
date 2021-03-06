
public class Intro {

	public static void main(String[] args) {
		// print the return value of method ret
		System.out.println(ret());
		// print the return value of method logic
		System.out.println(logic(true, true, true));
		// print the return value of method stars
		System.out.println(stars(6));
		// print the return value of method coins
		System.out.println(coins(7));
		
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
	public static int coins(int n) {
		int coins = n; 					// making coins variable
		int amountFives = 0;			// counter for amount of 5 cent coins
		int amountTwos = 0;				// counter for amount of 2 cent coins
		// adds a five cent coin for every five cents that are in the value of money
		for(int i=5; i<=n; i+=5){ 
			amountFives += 1; 			// adds a five cent coin
			coins -= 5; 				// deducts 5 cents from the amount of coins
		}
		// if statement checks if remainder is divisible by two
		if (coins%2 == 0){
			amountTwos += coins/2;	// if remainder is divisible by two, then add amount of two cent coins that adds up to the remainder 
		} else if (coins%2 != 0){
			amountFives -= 1;  		// if not divisible by two, backtrack by subtracting a five cent coin and dividing the remaining amount of coins by two
			amountTwos += (coins+5)/2;
		}
		
		int total = amountFives + amountTwos;
		// if original value is equal to 1 or 3, then it is impossible to give change, and the if statement changes the total to -1 
		if (n == 1 | n == 3){ 
			total = -1;  
		}
		
		return total;

	}
}
