
/**
 * @author Kevin
 *
 */
public class GameController {
	String name;
	int points=0;
	
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
	
	
	

}
