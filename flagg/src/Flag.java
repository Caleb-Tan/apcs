
import java.awt.*;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;


public class Flag extends JPanel{
	Flag(){
		setPreferredSize(new Dimension(700,450));
	};
	
	// returns the height of the window
	public int height() {
		int x = getHeight();
		System.out.println(x);
		return x;
	}
	
	// paints the elements
	 public void paint(Graphics g){
		paintStripes(g, 0);
		paintUnion(g);

	 }
	 
	 // paints stripes
	 private void paintStripes(Graphics g, int i) {
		 	// gets the width of the panel
		 	int height = height()/13;
		 	// makes the height always equal the 
		 	int width = (int) (height()*1.9);	 	
			g.setColor(Color.red);
			g.fillRect(0, i, width, height);
			g.setColor(Color.white);
			g.fillRect(0, i+height, width, height);
			if(i <= height*13){
				paintStripes(g, i+height*2);
			}
			g.setColor(Color.red);
			g.fillRect(0, height*12, width, height);			
	 }
	 
	 private void paintUnion(Graphics g){

		 g.setColor(Color.blue);
		 g.fillRect(0, 0, 187, 140);
	 }

	 /*private void paintStars(Graphics g){
		 g.setColor(Color.white);
		 int[] xcoord = new int[5];
		 int[] ycoord = new int[5];
		 for (int i=0; i<5; i++) {
			xcoord[i] = (int) Math.cos(i*(Math.PI*2)/5); 
			ycoord[i] = (int) Math.sin(i*(Math.PI*2)/5); 
		 }
		 
		 g.fillPolygon(xcoord, xcoord, 5);
	 }*/

}