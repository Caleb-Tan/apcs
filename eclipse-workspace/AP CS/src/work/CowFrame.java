package work;

import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
// this gives me a set of colors
	private final Color black = new Color(0x000000);
	private final Color white = new Color(0xF8F8FF);
	
	public CowFrame () {
		init();
	}
	// This is my drawing board 
	public void init() {
		setSize(700,600);
		setBackground(Color.WHITE);
		repaint();
	}
	// This is the main body
	public void paint(Graphics g) {
		g.setColor(black);
		g.fillRect(50, 100, 400, 200);
		// the head 
		g.setColor(Color.BLACK);
		g.drawOval(350, 50, 200, 100);
		// legs 
		g.fillRect(70, 300, 30, 100);
		g.fillRect(400, 300, 30, 100);
		//spot
		g.setColor(white);
		g.fillOval(200, 140, 100, 100);
	}
}