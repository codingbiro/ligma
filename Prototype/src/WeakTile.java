
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
	
	public String stat() {
		String out = null;
		out += "neighbour_up: " + ((this.neighbour[Direction.UP.ordinal()].name == null) ? "null" : this.neighbour[Direction.UP.ordinal()].name);
		out += "neighbour_down: " + ((this.neighbour[Direction.DOWN.ordinal()].name == null) ? "null" : this.neighbour[Direction.DOWN.ordinal()].name);
		out += "neighbour_left: " + ((this.neighbour[Direction.LEFT.ordinal()].name == null) ? "null" : this.neighbour[Direction.LEFT.ordinal()].name);
		out += "neighbour_right: " + ((this.neighbour[Direction.RIGHT.ordinal()].name == null) ? "null" : this.neighbour[Direction.RIGHT.ordinal()].name);
		out += "life: " + this.life;
		return out;
	}

}
