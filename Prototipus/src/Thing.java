import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Thing {
	
	// A tárgy áll egy csempén
	Tile t;
	
	// Exit vagy szekrény-e (megtévesztõ de a true itt az hogy nem)
	public boolean Ward() {
		return true;
	}
	
	// Alapvetõen nem mehet tárgynak állat pár kivétellel
	public boolean hitBy(Panda a) {
		return false;
	}
	public boolean hitBy(Orangutan a) {
		return false;
	}
	
	// Csempét visszaadja
	public Tile getTile() {
		return t;
	}
	
	// Csempe beállítása
	public void setTile(Tile _t) {
		t = _t;
	}
	
	// A tulajdonságainak kiírása
	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.t == null) ? "null" : this.t.name));
		return out;
	}
	// A speciális mûködések, gyermekek irjak felul
	public void check() {}
	public void beep() {}
	public void jingle() {}
	
	
}
