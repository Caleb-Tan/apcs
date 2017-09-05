
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
		return x;
	}
	
	
	
	
	
	// paints the elements
	 public void paint(Graphics g){
		paintStripes(g, 0);
		paintUnion(g);
		

		for(int x=1; x<=9; x+=2) {
			double offsety = height()*0.054;
			offsety = offsety*x;
			for (int i=1; i<=11; i+=2) {
				double offsetx = height()*0.063;
				offsetx = offsetx*i;
				paintStars(g,offsetx, offsety);
			}
		}
		
		for (int x=2; x<=8; x+=2) {
			double offsety = height()*0.054;
			offsety = offsety*x;
			for (int i=2; i<=10; i+=2) {
				double offsetx = height()*0.063;
				offsetx = offsetx*i;
				paintStars(g, offsetx, offsety);
			}
		}
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
		 double height = height()*7/13;
		 // makes the width always equal to height * union ratio
		 double width = height()*0.76;	 	
		 g.setColor(Color.blue);
		 g.fillRect(0, 0, (int)width, (int)height);
	 }

	 private void paintStars(Graphics g, double offsetx, double offsety){
		 g.setColor(Color.white);
		 double radius = height()*0.0616/2; 
		 
		 int[] xcoord = new int[5];
		 int[] ycoord = new int[5];
		 for (int i=0; i<5; i++) {
			xcoord[i] = (int) (Math.cos(i*(Math.PI*2)/5+6)*radius + offsetx);
			ycoord[i] = (int) (Math.sin(i*(Math.PI*2)/5+6)*radius + offsety); 
		 }
		 
		 g.fillPolygon(xcoord, ycoord, xcoord.length);
	 }

}