
public class Armchair extends Thing{

	public Armchair(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void check() {
		System.out.println(name+" check");
		Animal a2=t.getAnimal();
		if(a2==null) {
			for(Direction d:Direction.values()) {
				Tile t2=t.getNeighbour(d);
				Animal a=t2.getAnimal();
				a.Exhaust(t);
			}
		}
		else a2.reduceTime();
	}

}
