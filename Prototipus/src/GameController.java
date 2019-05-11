import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * @author Kevin
 *
 */
public class GameController {
	private int points=0;
	private View view;
	
	//Szkeleton
	Entrance e;
	
	// A pontok hozzáadását végzõ függvény
	public void addPoints() {
		points+=10;
	}
	
	// A pontok elvételét végzõ függvény
	public void decreasePoints() {
		points-=5;
	}
	
	// A bejárat visszaadása
	public Entrance getEntrance() {
		return e;
	}
	
	public int getPoints() {
		return points;
	}
	//egy mezot megker arra, hogy rajzoljon
	public void drawRequiredFor(Tile t) {
		t.shouldDraw(view);
	}
	//meghatarozza, hogy vege van e a jateknak
	public boolean isGameOver() {
		return false;
	}

	//Main
	public static void main(String[] args) {
		//view letrehozasa
		View v = new View();
		v.drawMap();
		
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
	}
	
}
