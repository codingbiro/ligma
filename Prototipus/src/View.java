import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class View {
	private GameController gc = Globals.gc;
	private Map m;
	//kepek amiket dinamikusan akarunk kirajzolni
	BufferedImage img_map;
	BufferedImage img_orangutan;
	BufferedImage img_panda;
	BufferedImage img_afraidPanda;
	BufferedImage img_jumperPanda;
	BufferedImage img_tiredPanda;
	
	public View(Map map) {
		m = map;
	}
	
	//updates the view, draws everything
	public void update(Graphics g) {
		//for each tile on the map
		for(Tile t : m.tiles) {
			//calling drawrequiredfor to start the drawing
			gc.drawRequiredFor(t, g);
		}
		int points = gc.getPoints();
		boolean gameover = gc.isGameOver();
	}
	
	public void init() {
		//kezdeti palya kirajzolasa
		//drawMap();
		//dinamikusan kirajzolando kepek
		
		//orangutan kepe
		try {
		    img_orangutan = ImageIO.read(new File("images/orangutan.jpg"));
		} catch (IOException e) {
		}
		//panda kepe
		try {
		    img_panda = ImageIO.read(new File("images/panda.jpg"));
		} catch (IOException e) {
		}
		//afraid panda kepe
		try {
			img_afraidPanda = ImageIO.read(new File("images/panda_afraid.jpg"));
		} catch (IOException e) {
		}
		//jumper panda kepe
		try {
			img_jumperPanda = ImageIO.read(new File("images/panda_jumper.jpg"));
		} catch (IOException e) {
		}
		//tired panda kepe
		try {
			img_tiredPanda = ImageIO.read(new File("images/panda_tired.jpg"));
		} catch (IOException e) {
		}
		//az inicializalas vegen updatelunk, hogy minden kirajzolodjon
		//update();
	}
	
	public void drawOrangutan(int x, int y, Graphics g) {
		g.drawImage(img_orangutan, x-5, y-6, null);
	}
	
	public void drawPanda(int x, int y, Graphics g) {
		g.drawImage(img_panda, x-5, y-6, null);
	}
	
	public void drawTired(int x, int y, Graphics g) {
		g.drawImage(img_tiredPanda, x-5, y-6, null);
	}
	
	public void drawAfraid(int x, int y, Graphics g) {
		g.drawImage(img_afraidPanda, x-5, y-6, null);
	}
	
	public void drawJumper(int x, int y, Graphics g) {
		g.drawImage(img_jumperPanda, x-5, y-6, null);
	}
	
	public void drawTile(int x, int y, Graphics g) {
	}
	
	public void drawWeakTileBroken(int x, int y, Graphics g) {
		/*
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/weakTileBroken.jpg"));
		} catch (IOException e) {
		}
		//g.drawImage(img, 0, 0, null);
		*/
		 
	}
	
	public void drawMap(Graphics g) {
		if(img_map == null) {
			//pálya képe
			try {
				img_map = ImageIO.read(new File("images/map_default.jpg"));
				//System.out.println("sikeres beolvasas");
			} catch (IOException e) {
				System.out.println("sikertelen beolvasas");
			}
		}
		g.drawImage(img_map, 0, 0, null);
	}
	
	
	
	public int getPoints() {
		return gc.getPoints();
	}
}
