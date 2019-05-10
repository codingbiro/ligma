
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
	}
}
