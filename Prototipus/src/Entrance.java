
public class Entrance extends Thing{

	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Visszaadja a mezõjét
	public Tile getTile() {
		return t;
	}
	
	// Nem mehet neki orángután
	public boolean hitBy(Orangutan o) {
		return false;
	}

}
