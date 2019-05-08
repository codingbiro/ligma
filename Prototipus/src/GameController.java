
/**
 * @author Kevin
 *
 */
public class GameController {
	String name;
	private int points=0;
	private View view;
	
	//Szkeleton
	Entrance e;

	public GameController(String s) {
		name=s;
	}
	
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
	
	public void drawRequiredFor(Tile t) {
		
	}
	

}
