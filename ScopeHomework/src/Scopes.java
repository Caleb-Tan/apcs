
public class Scopes {
	int x (GLOBAL) = 17;
	int y (generator) = 15;
	
	private void generator() {
		y+=2;
	}
	
	private void safety() {
		x-=5;
	}
}
