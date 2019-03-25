

public class Tile {
	String name;
	Animal a;
	Thing th;

	Tile neighbour[];
	
	public Tile(String s) {
		name = s;
		neighbour = new Tile[Direction.values().length];
	}
	
	public void setNeighbour(Direction d, Tile t) {
		neighbour[d.ordinal()]  = t;
	}
	
	public Animal getAnimal() {
		System.out.println(name+" getAnimal");
		return a;
		
	}
	
	public Tile getNeighbour(Direction d) {
		System.out.println(name+" getNeighbour(" + d.name() + ")");
		return neighbour[d.ordinal()];
	}
	
	public Thing getThing() {
		System.out.println(name+" getThing");
		return th;
	}
	
	public void setAnimal(Animal a2) {
		System.out.println(name+" setAnimal(" + a2.name + ")");
		
		if(a2!=null) {
			a2.setTile(this);
		}
	}
	
	public void setThing(Thing t) {
		System.out.println(name+" setThing(" + t.name + ")");
		t.setTile(this);
		th = t;
	}
}
