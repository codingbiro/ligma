
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
	
	public void drawRequiredFor(Tile t) {
		
	}
	

}
