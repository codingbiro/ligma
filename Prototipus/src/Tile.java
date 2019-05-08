import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Tile {
	// A csempén állhat egy állat és egy tárgy
	String name;
	Animal a;
	Thing th;

	// Szomszédok
	Tile neighbour[];
	
	public Tile(String s) {
		name = s;
		neighbour = new Tile[Direction.values().length];
	}
	
	// Szomszéd beállítása
	public void setNeighbour(Direction d, Tile t) {
		neighbour[d.ordinal()]  = t;
	}
	
	// Állat visszaadása
	public Animal getAnimal() {
		return a;
		
	}
	
	// Szomszéd visszaadása
	public Tile getNeighbour(Direction d) {
		return neighbour[d.ordinal()];
	}
	
	// Tárgy visszaadása
	public Thing getThing() {
		return th;
	}
	
	// Orángután beállítása
	public void setAnimal(Orangutan a2) {		
		if(a2!=null) a2.setTile(this);
		a=a2;
	}
	
	// Panda beállítása
	public void setAnimal(Panda a2) {	
		if(a2!=null) a2.setTile(this);
		a=a2;
	}
	
	// Tárgy beállítása
	public void setThing(Thing t) {
		if(t != null) t.setTile(this);
		th = t;
	}
	
	// Csempe élettartamának beállítása
	public void setLife(int l) {}
	
	//a weaktile feluldefinialja, itt nem csinal semmit
	public boolean hasLife() {
		return true;
	}

	// Tulajdonságainak kiírása
	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("neighbour_up: " + ((this.neighbour[Direction.UP.ordinal()] == null) ? "null" : this.neighbour[Direction.UP.ordinal()].name));
		out.add("neighbour_down: " + ((this.neighbour[Direction.DOWN.ordinal()] == null) ? "null" : this.neighbour[Direction.DOWN.ordinal()].name));
		out.add("neighbour_left: " + ((this.neighbour[Direction.LEFT.ordinal()] == null) ? "null" : this.neighbour[Direction.LEFT.ordinal()].name));
		out.add("neighbour_right: " + ((this.neighbour[Direction.RIGHT.ordinal()] == null) ? "null" : this.neighbour[Direction.RIGHT.ordinal()].name));
		return out;
	}
	
	public void shouldDraw(View v) {
		if(!hasLife())
			v.drawWeakTileBroken();
		
		if(a != null)
			a.shouldDraw(v);
	}
	
	public boolean hasLife() {
		
	}
}
