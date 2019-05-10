
/**
 * @author Kevin
 *
 */
public class GameController {
	private int points=0;
	private View view;
	
	//Szkeleton
	Entrance e;
	
	// A pontok hozz�ad�s�t v�gz� f�ggv�ny
	public void addPoints() {
		points+=10;
	}
	
	// A pontok elv�tel�t v�gz� f�ggv�ny
	public void decreasePoints() {
		points-=5;
	}
	
	// A bej�rat visszaad�sa
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
