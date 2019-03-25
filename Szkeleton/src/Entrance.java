
public class Entrance extends Thing{

	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public Tile getTile() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getTile");
		Globals.tab--;
		return t;
	}
	
	public boolean hitBy(Orangutan o) {Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + o.name + ")");
		Globals.tab--;
		return false;
	}

}
