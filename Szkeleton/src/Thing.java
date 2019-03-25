
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
	
	public void setTile(Tile _t) {
		System.out.println(name+" setTile(" + _t.name + ")");
		t = _t;
	}
}
