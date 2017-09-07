
import javax.swing.*;

public class Main {
	
	/* This main method consists of the flag object and jframe object. The flag panel is 
	 * essentially placed on the jframe. */
	public static void main(String [] args){
		Flag flag = new Flag();				// creates flag object
		JFrame frame = new JFrame("Flag");	// creates jframe
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(flag);	// adds the flag panel to the jframe
		
		frame.pack();		// sizes frame so that all contents are at preferred sizes
		frame.setVisible(true);	
	}
}