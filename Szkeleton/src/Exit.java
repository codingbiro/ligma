
public class Exit extends Thing{

	//Szkeleton
	GameController g;
	
	public Exit(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Panda p) {
		System.out.println(name+" hitBy(" + p.name + ")");
		if(!p.inLine()) {
			return false;
		}
		else {
			g.addPoints();
			return true;
		}
	}
	
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy(" + o.name + ")");
		Entrance e = g.getEntrance();
		o.setBehind(null);
		Tile t1 = e.getTile();
		t1.setAnimal(o);
		return true;
	}

}
