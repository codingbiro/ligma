
/**
 * @author Kevin
 *
 */
public class Entrance extends Thing{
	// Visszaadja a mez�j�t
	public Tile getTile() {
		return t;
	}
	
	// Nem mehet neki or�ngut�n
	public boolean hitBy(Orangutan o) {
		return false;
	}

}
