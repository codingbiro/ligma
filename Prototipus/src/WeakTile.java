import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class WeakTile extends Tile {
	int life;
	public WeakTile(String s) {
		super(s);
		life = 20;
	}
	
	// Élettartam csökkentése
	public void decreaseLife() {
		life--;
	}
	
	// Orángután beállítása
	public void setAnimal(Orangutan a) {		
		if(a!=null && life != 0) {
			// Ha rálépnek akkor csökken az élettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha eléri az élettartam a 0-t akkor a csempe eltörik
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}
				
		
	}
	
	// Panda beállítása
		public void setAnimal(Panda a) {		
		if(a!=null && life != 0) {
			// Ha rálépnek akkor csökken az élettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha eléri az élettartam a 0-t akkor a csempe eltörik
		if(life == 0) {
			a.die();
			//negighbouroknek be kel allitani hogy a weak tileos neighborjuk null legyen
			for (Direction d : Direction.values()) {
				//mindig az ellentetes oldalu neighbour lesz a weaktile
				switch(d.toString()) {
					case "UP":
						neighbour[d.ordinal()].setNeighbour(Direction.DOWN, null);
					break;
					case "DOWN":
						neighbour[d.ordinal()].setNeighbour(Direction.UP, null);
					break;
					case "LEFT":
						neighbour[d.ordinal()].setNeighbour(Direction.RIGHT, null);
					break;
					case "RIGHT":
						neighbour[d.ordinal()].setNeighbour(Direction.LEFT, null);
					break;
				}
				//a weaktilenak is beallitjuk nullra a neighbourjeit
				this.setNeighbour(d, null);
			}	
		}	
	}
	
		// Tárgy beállítása
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	// Élettartam beállítása
	public void setLife(int l) {
		life = l;
	}
	
	//kirajzolához megnezi hogy van e elete, hogy kell e x-et rajzolni
	public boolean hasLife() {
		return life!=0;
	}	
	
	// Tulajdonságok kiírása
	public ArrayList<String> stat() {
		ArrayList<String> out = new ArrayList<String>();
		out.add("neighbour_up: " + ((this.neighbour[Direction.UP.ordinal()] == null) ? "null" : this.neighbour[Direction.UP.ordinal()].name));
		out.add("neighbour_down: " + ((this.neighbour[Direction.DOWN.ordinal()] == null) ? "null" : this.neighbour[Direction.DOWN.ordinal()].name));
		out.add("neighbour_left: " + ((this.neighbour[Direction.LEFT.ordinal()] == null) ? "null" : this.neighbour[Direction.LEFT.ordinal()].name));
		out.add("neighbour_right: " + ((this.neighbour[Direction.RIGHT.ordinal()] == null) ? "null" : this.neighbour[Direction.RIGHT.ordinal()].name));
		out.add("life: " + this.life);
		return out;
	}
	
	public void shouldDraw(View v) {
		if(!hasLife())
			v.drawWeakTileBroken();
	}

}
