
public class Entrance extends Thing{

	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t;
	}
	
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy");
	}

}
