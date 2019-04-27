import java.util.ArrayList;

public class WeakTile extends Tile {
	int life;
	public WeakTile(String s) {
		super(s);
		life = 20;
	}
	
	// �lettartam cs�kkent�se
	public void decreaseLife() {
		life--;
	}
	
	// Or�ngut�n be�ll�t�sa
	public void setAnimal(Orangutan a) {		
		if(a!=null && life != 0) {
			// Ha r�l�pnek akkor cs�kken az �lettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha el�ri az �lettartam a 0-t akkor a csempe elt�rik
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}
				
		
	}
	
	// Panda be�ll�t�sa
		public void setAnimal(Panda a) {		
		if(a!=null && life != 0) {
			// Ha r�l�pnek akkor cs�kken az �lettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha el�ri az �lettartam a 0-t akkor a csempe elt�rik
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}	
	}
	
		// T�rgy be�ll�t�sa
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	// �lettartam be�ll�t�sa
	public void setLife(int l) {
		life = l;
	}
	
	// Tulajdons�gok ki�r�sa
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
