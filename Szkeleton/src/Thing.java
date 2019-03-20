
public class Thing {
	
	String name;
	Tile t;
	
	public Thing(String s) {
		name=s;
	}
	
	public boolean hitBy(Animal a) {
		System.out.println(name+" hitBy");
		return false;
	}
	
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t;
	}
}
