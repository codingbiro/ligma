
public class Thing {
	
	String name;
	Tile t;
	
	public Thing(String s) {
		name=s;
	}
	
	public boolean hitBy(Animal a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + a.name + ")");
		Globals.tab--;
		return false;
	}
	
	public Tile getTile() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getTile");
		Globals.tab--;
		return t;
	}
	
	public void setTile(Tile _t) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setTile(" + _t.name + ")");
		t = _t;
		Globals.tab--;
	}
}
