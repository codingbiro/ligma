
public class Exit extends Thing{

	//Szkeleton
	GameController g;
	
	public Exit(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Panda p) {
		if(!p.inLine()) {
			return false;
		}
		else {
			g.addPoints();
			return true;
		}
	}
	
	public boolean hitBy(Orangutan o) {
		Entrance e = null;
		if(g!=null)
			e = g.getEntrance();
		if(o!=null)
			o.setBehind(null);
		Tile t1 = null;
		if(e!=null)
			t1 = e.getTile();
		if(t1!=null)
			t1.setAnimal(o);
		return false;
	}

}
