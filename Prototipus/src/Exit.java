
public class Exit extends Thing{
	
	public Exit(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Panda p) {
		if(!p.inLine()) {
			return false;
		}
		else {
			Globals.g.addPoints();
			p.die();
			return true;
		}
	}
	
	public boolean Ward() {
		return false;
	}
	
	public boolean hitBy(Orangutan o) {
		Entrance e = null;
		if(Globals.g!=null)
			e = Globals.g.getEntrance();
		if(o!=null) {
			if(o.getBehind()!=null) o.getBehind().Move(o.getBehind().getDirection(o.getTile()));
			o.setBehind(null);
		}
		Tile t1 = null;
		if(e!=null)
			t1 = e.getTile();
		if(t1!=null)
			t1.setAnimal(o);
		return true;
	}

}
