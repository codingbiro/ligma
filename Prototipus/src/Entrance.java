
public class Entrance extends Thing{

	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Visszaadja a mez�j�t
	public Tile getTile() {
		return t;
	}
	
	// Nem mehet neki or�ngut�n
	public boolean hitBy(Orangutan o) {
		return false;
	}

}
