
public class Exit extends Thing{

	//Szkeleton
	GameController g;
	
	public Exit(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Panda p) {Globals.tab++;
	for(int i = 0; i<Globals.tab; i++)
		System.out.print("\t");
		System.out.println(name+" hitBy(" + p.name + ")");
		if(!p.inLine()) {
			Globals.tab--;
			return false;
		}
		else {
			g.addPoints();
			Globals.tab--;
			return true;
		}
	}
	
	public boolean hitBy(Orangutan o) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + o.name + ")");
		Entrance e = g.getEntrance();
		o.setBehind(null);
		Tile t1 = e.getTile();
		t1.setAnimal(o);
		Globals.tab--;
		return true;
	}

}
