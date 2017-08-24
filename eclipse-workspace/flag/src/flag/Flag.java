package flag;
import java.awt.*;
import javax.swing.JPanel;


public class Flag extends JPanel{
	
	
	 public void paint(Graphics g){
		 paintRectangle(g, 0);
			 
	 }
	 
	 public void paintRectangle(Graphics g, int i) {
			g.setColor(Color.red);
			g.fillRect(0, i, 468, 20);
			g.setColor(Color.white);
			g.fillRect(0, i+20, 468, 20);
			if(i <= 199){
				paintRectangle(g, i+40);
			}
			g.setColor(Color.red);
			g.fillRect(0, 240, 468, 20);
	 }
}
