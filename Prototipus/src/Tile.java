import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Tile {
	// A csempén állhat egy állat és egy tárgy
	Animal a;
	Thing th;
	//csempe kozepenek koordinatai
	private int[] centerPos = new int[2];
	
	// Szomszédok
	Tile neighbour[];
	//deafult konstruktor
	public Tile() {
		neighbour = new Tile[Direction.values().length];
	}
	//konstruktor a csempe kozepenek megadasaval egyutt
	public Tile(int posx, int posy) {
		//csempe kozepenek beallitasa
		centerPos = new int[] {posx, posy};
		neighbour = new Tile[Direction.values().length];
	}
	
	//Koordinatak beallitasa
	public void setCenter(int posx, int posy) {
		centerPos = new int[] {posx, posy};
	}
	
	//x koordinata lekerese
	public int posX() {
		return centerPos[0];
	}
	
	//y koordinata lekerese
	public int posY() {
		return centerPos[1];
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
	
	/*
	//a weaktile feluldefinialja, itt nem csinal semmit
	public boolean hasLife() {
		return true;
	}
	*/
	
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		if(a != null)
			//jelzi a rajta allo allatnak hogy ki kell ot rajzolni
			a.shouldDraw(v);
	}
	
}
