
public class Thing {
	
	String name;
	Tile t;
	
	public Thing(String s) {
		name=s;
	}
	
	public boolean hitBy(Panda a) {
		return false;
	}
	public boolean hitBy(Orangutan a) {
		return false;
	}
	
	public Tile getTile() {
		return t;
	}
	
	public void setTile(Tile _t) {
		t = _t;
	}
	public void setTile(Tile _t, boolean ts) {	
		t = _t;
	}
}
