
import java.awt.*;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;


public class Flag extends JPanel{
	Flag(){
		setPreferredSize(new Dimension(468,260));
	};
	
	 public void paint(Graphics g){
		paintStripes(g, 0);
		paintUnion(g);
		paintStars(g);
	 }
	 
	 private void paintStripes(Graphics g, int i) {
			g.setColor(Color.red);
			g.fillRect(0, i, 468, 20);
			g.setColor(Color.white);
			g.fillRect(0, i+20, 468, 20);
			if(i <= 199){
				paintStripes(g, i+40);
			}
			g.setColor(Color.red);
			g.fillRect(0, 240, 468, 20);			
	 }
	 private void paintUnion(Graphics g){
		 g.setColor(Color.blue);
		 g.fillRect(0, 0, 187, 140);
	 }

	 private void paintStars(Graphics g){
		 g.setColor(Color.white);
		 for(int y=9; y<=117; y+=27){
			 for(int x=10; x<=160; x+=30){
				 g.fillOval(x, y, 15, 15);
			 }
	 	}
		for (int y=23; y<=104; y+=27){
			for(int x=25; x<=145; x+=30){
				g.fillOval(x, y, 15, 15);
			}
		}
	 }

}