import java.util.ArrayList;

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
	
	public void setAnimal(Orangutan a2) {		
		if(a2!=null) a2.setTile(this);
		a=a2;
	}
	
	public void setAnimal(Panda a2) {	
		if(a2!=null) a2.setTile(this);
		a=a2;
	}
	
	public void setThing(Thing t) {
		if(t != null) t.setTile(this);
		th = t;
	}

	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("neighbour_up: " + ((this.neighbour[Direction.UP.ordinal()] == null) ? "null" : this.neighbour[Direction.UP.ordinal()].name));
		out.add("neighbour_down: " + ((this.neighbour[Direction.DOWN.ordinal()] == null) ? "null" : this.neighbour[Direction.DOWN.ordinal()].name));
		out.add("neighbour_left: " + ((this.neighbour[Direction.LEFT.ordinal()] == null) ? "null" : this.neighbour[Direction.LEFT.ordinal()].name));
		out.add("neighbour_right: " + ((this.neighbour[Direction.RIGHT.ordinal()] == null) ? "null" : this.neighbour[Direction.RIGHT.ordinal()].name));
		return out;
	}
}
