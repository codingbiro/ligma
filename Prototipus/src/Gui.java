import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Gui extends JFrame{
	Container cp;
	public static final int xdim=300;
	public static final int ydim=300;
	
	private GameGraphics gg;
	View v;
	Timer pandatimer;
	Timer vmtimer;
	Timer smtimer;
	
	JPanel p = new JPanel();
	
	private int o1dir=0;
	private int o2dir=0;
	
	private void dirind(Orangutan o, int odir, Graphics g) {
		if(o.getTile().getNeighbour(Direction.values()[odir])!=null)
			g.drawLine(o.getTile().posX(), o.getTile().posY(),
					o.getTile().getNeighbour(Direction.values()[odir]).posX(), 
					o.getTile().getNeighbour(Direction.values()[odir]).posY());
	}
	
	private void behindind(Animal a,Graphics g) {
		if(a.behind!=null) {
			behindind(a.behind,g);
			g.drawLine(a.getTile().posX(), a.getTile().posY(),a.behind.getTile().posX(),a.behind.getTile().posY());
		}
	}
	
	
	public Gui(Map m) {
		cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    
	    gg=new GameGraphics();
	    v = new View(m);
	    Globals.gc.setView(v);
	    
	    gg.setPreferredSize(new Dimension(xdim,ydim));
	    p.setPreferredSize(new Dimension(xdim,ydim));
	    window();
	    
	    // pandák mozgatásához szükséges idõzítõ
	    pandatimer = new Timer();
	    pandatimer.scheduleAtFixedRate(new TimerTask() {
	    	public void run() {
	    		Random r = new Random();
	            for(int i = 0; i < Globals.gc.pandas.size(); i++) {
	            	if(!Globals.gc.pandas.get(i).inLine()) {
	            		int success = 0;
	            		int tries = 0;
	            		while(success != 1) {
	            			int dir = r.nextInt(10);
	            			if(Globals.gc.pandas.get(i).tile.neighbour[dir]  != null) {
	            					Globals.gc.pandas.get(i).Move(Direction.values()[dir]);
	            					success = 1;
	            			}
	            			tries++;
	            			if(tries==20) break;
	            		}
	            	}
	            	gg.repaint();
	            }
	            
	            if(Globals.gc.isGameOver()) {
	            	pandatimer.cancel(); //A timer szál megszüntetése
	            }
	    	}
	    }, 0, 3*1000); // elsõ paraméter: mi hajtódjon végre adott idõközönként, második: hány milisec múlva hajtsa végre elõször, 
	    // harmadik: hány milisecenként hajtsa végre
	    
	    // beepeléshez szükséges idõzítõ
	    vmtimer = new Timer();
	    vmtimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Globals.gc.vm.beep();
	    		if(Globals.gc.isGameOver()) {
	    			vmtimer.cancel();	// timer leállítása ha vége a játéknak
	    		}
			}
	    	
	    }, 3*1000, 5*1000);
	    
	    // jinglehöz szükséges idõzítõ
	    smtimer = new Timer();
	    smtimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Globals.gc.sm.jingle();
	    		if(Globals.gc.isGameOver()) {
	    			smtimer.cancel();
	    		}
			}
	    	
	    }, 6*1000, 5*1000);
	    
	    addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent evt) {
	            switch(evt.getKeyCode()) {
	               case KeyEvent.VK_LEFT:
	            	   o1dir--;
	            	   if(o1dir<0) o1dir=9;
	            	   System.out.println("left key pressed"+o1dir);
	            	   gg.repaint();
	            	   break;
	               case KeyEvent.VK_RIGHT:
	            	   o1dir++;
	            	   if(o1dir>9) o1dir=0;
	            	  System.out.println("right key pressed"+o1dir);
	            	  gg.repaint();
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
	            	   gg.repaint();
	            	   break;
	               case KeyEvent.VK_D:
	            	   o2dir++;
	            	   if(o2dir>9) o2dir=0;
	            	   System.out.println("'D' key pressed"+o2dir);
	            	   gg.repaint();
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
			
			dirind(Globals.gc.o1,o1dir,g);
			dirind(Globals.gc.o2,o2dir,g);
			behindind(Globals.gc.o1,g);
			behindind(Globals.gc.o2,g);
			
			g.drawString("1. Orángután pontjai: "+Globals.gc.o1.getPoints(), 30, 170);
			g.drawString("2. Orángután pontjai: "+Globals.gc.o2.getPoints(), 30, 190);
			
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