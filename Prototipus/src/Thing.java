import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Thing {
	
	// A t�rgy �ll egy csemp�n
	Tile t;
	
	// Exit vagy szekr�ny-e (megt�veszt� de a true itt az hogy nem)
	public boolean Ward() {
		return true;
	}
	
	// Alapvet�en nem mehet t�rgynak �llat p�r kiv�tellel
	public boolean hitBy(Panda a) {
		return false;
	}
	public boolean hitBy(Orangutan a) {
		return false;
	}
	
	// Csemp�t visszaadja
	public Tile getTile() {
		return t;
	}
	
	// Csempe be�ll�t�sa
	public void setTile(Tile _t) {
		t = _t;
	}
	
	// A tulajdons�gainak ki�r�sa
	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.t == null) ? "null" : this.t.name));
		return out;
	}
	// A speci�lis m�k�d�sek, gyermekek irjak felul
	public void check() {}
	public void beep() {}
	public void jingle() {}
	
	
}
