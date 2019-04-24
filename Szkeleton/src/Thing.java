
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

	public String stat() {
		// TODO Auto-generated method stub
		String out = null;
		out += "tile: " + ((this.t.name == null) ? "null" : this.t.name);
		return out;
	}
}
