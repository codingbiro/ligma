
public class Armchair extends Thing{

	public Armchair(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void check() {
		Animal a2=t.getAnimal();
		if(a2==null) {
			for(Direction d:Direction.values()) {
				Tile t2=t.getNeighbour(d);
				Animal a = null;
				if(t2 != null)
					a = t2.getAnimal();
				if(a!=null)
					a.Exhaust(t);
			}
		}
		else a2.reduceTime();
	}

}
