

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
		return a;
		
	}
	
	public Tile getNeighbour(Direction d) {
		return neighbour[d.ordinal()];
	}
	
	public Thing getThing() {
		return th;
	}
	
	public void setAnimal(Animal a2) {	
		if(a2!=null) a2.setTile(this);
		a=a2;
	}
	
	public void setAnimal(Animal a2, boolean st) {
		if(a2!=null) a2.setTile(this, true);
		a=a2;
	}
	
	public void setThing(Thing t) {
		if(t != null) t.setTile(this);
		th = t;
	}
	
	public void setThing(Thing t, boolean st) {		
		if(t != null) {			
			t.setTile(this, true);
		}
		th = t;
	}
}
