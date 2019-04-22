
public class Entrance extends Thing{

	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public Tile getTile() {
		return t;
	}
	
	public boolean hitBy(Orangutan o) {
		return false;
	}

}
