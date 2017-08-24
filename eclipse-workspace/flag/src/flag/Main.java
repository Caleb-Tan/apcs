package flag;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	
	public static void main(String [] args){
		Flag f = new Flag();

		JFrame frame = new JFrame("Flag");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(f);
		frame.pack();
		frame.setVisible(true);
	}
}
