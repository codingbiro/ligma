import java.util.ArrayList;

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

	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.t == null) ? "null" : this.t.name));
		return out;
	}
}
