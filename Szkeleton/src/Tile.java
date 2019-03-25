
public class Tile {
	String name;
	Animal a;
	Thing th;
	
	Tile neighbour[];
	
	public Tile(String s) {
		name = s;
	}
	
	public Animal getAnimal() {
		System.out.println(name+" getAnimal");
		return a;
		
	}
	
	public void setNeighbour(Direction d, Tile t) {
		neighbour[d.ordinal()] = t;
	}
	
	public Tile getNeighbour(Direction d) {
		System.out.println(name+" getNeighbour");
		return neighbour[d.ordinal()];
	}
	
	public Thing getThing() {
		System.out.println(name+" getThing");
		return th;
	}
	
	public void setAnimal(Animal a2) {
		System.out.println(name+" setAnimal");
		if(a2!=null) {
			a2.setTile(this);
		}
	}
	
	public void setThing(Thing t) {
		System.out.println(name+" setThing");
	}
}
