import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Gui extends JFrame{
	Container cp;
	public static final int xdim=300;
	public static final int ydim=300;
	
	private GameGraphics gg;
	View v;
	
	JPanel p = new JPanel();
	
	private int o1dir=0;
	private int o2dir=0;
	
	public Gui(Map m) {
		cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    
	    gg=new GameGraphics();
	    v = new View(m);
	    Globals.gc.setView(v);
	    
	    gg.setPreferredSize(new Dimension(xdim,ydim));
	    p.setPreferredSize(new Dimension(xdim,ydim));
	    window();
	    
	    addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent evt) {
	            switch(evt.getKeyCode()) {
	               case KeyEvent.VK_LEFT:
	            	   o1dir--;
	            	   if(o1dir<0) o1dir=9;
	            	   System.out.println("left key pressed"+o1dir);
	            	   break;
	               case KeyEvent.VK_RIGHT:
	            	   o1dir++;
	            	   if(o1dir>9) o1dir=0;
	            	  System.out.println("right key pressed"+o1dir);
	                  break;
	               case KeyEvent.VK_UP:
	            	   Globals.gc.o1.Move(Direction.values()[o1dir]);
	            	   System.out.println("forward key pressed");
	            	   gg.repaint();
	            	   break;
	            	   // 2. Orángután
	               case KeyEvent.VK_A:
	            	   o2dir--;
	            	   if(o2dir<0) o2dir=9;
	            	   System.out.println("'A' key pressed"+o2dir);
	            	   break;
	               case KeyEvent.VK_D:
	            	   o2dir++;
	            	   if(o2dir>9) o2dir=0;
	            	   System.out.println("'D' key pressed"+o2dir);
	            	   break;
	               case KeyEvent.VK_W:
	            	   Globals.gc.o2.Move(Direction.values()[o2dir]);
	            	   System.out.println("'W' key pressed");
	            	   gg.repaint();
	            	   break;
	            }
	         }
	      });

	    
	    requestFocus();
	}
	
	public void window() {
		setPreferredSize(new Dimension(xdim,ydim));
		setContentPane(gg);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	
	class GameGraphics extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);		
			//paintek meghívása
			
			v.drawMap(g);
			v.update(g);
		}
	}
	
	public static void main(String[] args) {
		//palya letrehozasa
		Map map = new Map();
		//palya inicializalasa, ez hoz letre mindent
		map.init();
		Gui g=new Gui(map);
		g.v.init();
		g.repaint();
	}
	
}