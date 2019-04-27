import java.util.ArrayList;

public class WeakTile extends Tile {
	int life;
	public WeakTile(String s) {
		super(s);
		life = 20;
	}
	
	public void decreaseLife() {
		life--;
	}
	
	public void setAnimal(Orangutan a) {		
		if(a!=null && life != 0) {
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}
				
		
	}
	
		public void setAnimal(Panda a) {		
		if(a!=null && life != 0) {
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}	
	}
	
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	public void setLife(int l) {
		life = l;
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
