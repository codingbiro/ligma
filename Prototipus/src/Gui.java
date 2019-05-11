import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

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
	
	public Gui() {
		cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    
	    gg=new GameGraphics();
	    v = new View();
	    
	    gg.setPreferredSize(new Dimension(xdim,ydim));
	    p.setPreferredSize(new Dimension(xdim,ydim));
	    window();
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
		}
	}
	
	public static void main(String[] args) {
		Gui g=new Gui();
		//palya letehozasa
		Map map = new Map();
		//palya inicializalasa, ez hoz letre mindent
		map.init();
	}
	
}