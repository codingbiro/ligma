import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * @author Kevin
 *
 */
public class GameController {
	//private int points=0;
	private View view;
	public int time_left = 1000;
	//a palyan levo pandak
	public ArrayList<Panda> pandas = new ArrayList<Panda>();
	//palyan levo pandak szama
	int pandaCnt = 5;
	//palyan levo orangutanok
	public Orangutan o1;
	public Orangutan o2;
	//palyan levo targyak
	public VendingMachine vm;
	public SlotMachine sm;
	public Armchair ac;
	//exit
	public Exit ex;
	//Tarolja a bejaratot, hogy az orangutant ra tudja rakni miutan meghalt, vagy kilepett az exiten
	public Entrance e;
	
	// A pontok hozzáadását végzõ függvény
	/*public void addPoints() {
		points+=10;
	}*/
	
	// A pontok elvételét végzõ függvény
	/*public void decreasePoints() {
		points-=5;
	}*/
	
	// A bejárat visszaadása
	public Entrance getEntrance() {
		return e;
	}
	
	/*public int getPoints() {
		return points;
	}*/
	//egy mezot megker arra, hogy rajzoljon
	public void drawRequiredFor(Tile t, Graphics g) {
		t.shouldDraw(view, g);
	}
	//a jateknak vege van ha elfogy az ido, vagy a pandak
	public boolean isGameOver() {
		return time_left<=0 || pandaCnt == 0;
	}
	
	public void setView(View v) {
		view = v;
	}

	//Main
	/*public static void main(String[] args) {
		//view letrehozasa
		View v = new View();
		v.drawMap();
		Map m = new Map();
		m.init();
		m.tiles.get(36).getThing().check();
		System.out.println(m.tiles.get(0).getAnimal().getTile().getNeighbour(Direction.FOUR).posX());
		
		JFrame obj = new JFrame();
		obj.setSize(222,147);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setTitle("Panda Pláza");
		obj.setLocationRelativeTo(null);
		
		Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(222,147));
        obj.add(canvas);
        BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/map_default.jpg"));
		} catch (IOException e) {
			System.out.println("kep betoltese sikertelen");
		}
        canvas.getGraphics().drawImage(img, 0, 0, null);
		obj.pack();
	}*/
	
}
