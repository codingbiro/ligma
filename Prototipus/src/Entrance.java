
/**
 * @author Kevin
 *
 */
public class Entrance extends Thing{
	// Visszaadja a mezõjét
	public Tile getTile() {
		return t;
	}
	
	// Nem mehet neki orángután
	public boolean hitBy(Orangutan o) {
		return false;
	}

}
