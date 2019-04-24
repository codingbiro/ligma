import java.util.ArrayList;

public class WeakTile extends Tile {
	int life = 0;
	public WeakTile(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void decreaseLife() {
		life--;
	}
	public void decreaseLife(boolean set) {		
	}
	
	public void setAnimal(Animal a) {
		
		if(a!=null && life != 0) {
			decreaseLife();
		}
		
		if(life == 0)
			a.die();
	}
	
	public void setAnimal(Animal a, boolean set) {
		
		if(a!=null && life != 0) {
			
			decreaseLife(true);
		}
		
		if(life == 0)
			a.die();
	}
	
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	public void setThing(Thing t, boolean set) {		
		if(t!= null) {
		
		t.setTile(this);
		}
		th = t;
	}
	
	public ArrayList<String> stat() {
		ArrayList<String> out = new ArrayList<String>();
		out.add("neighbour_up: " + ((this.neighbour[Direction.UP.ordinal()] == null) ? "null" : this.neighbour[Direction.UP.ordinal()].name));
		out.add("neighbour_down: " + ((this.neighbour[Direction.DOWN.ordinal()] == null) ? "null" : this.neighbour[Direction.DOWN.ordinal()].name));
		out.add("neighbour_left: " + ((this.neighbour[Direction.LEFT.ordinal()] == null) ? "null" : this.neighbour[Direction.LEFT.ordinal()].name));
		out.add("neighbour_right: " + ((this.neighbour[Direction.RIGHT.ordinal()] == null) ? "null" : this.neighbour[Direction.RIGHT.ordinal()].name));
		out.add("life: " + this.life);
		return out;
	}

}
