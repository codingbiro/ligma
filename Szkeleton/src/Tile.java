
public class Tile {
	String name;
	Animal a;
	Thing th;
	
	
	public Tile(String s) {
		name = s;
	}
	
	public Animal getAnimal() {
		System.out.println(name+" getAnimal");
		return a;
		
	}
	
	public Tile getNeighbour(Direction d) {
		System.out.println(name+" getNeighbour");

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
