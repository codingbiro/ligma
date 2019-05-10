
// Az állatokat reprezentáló osztály
/**
 * @author Kevin
 *
 */
public abstract class Animal implements IViewable {
	// Az állatok állnak valamilyen mezõn, állhatnak a sorban elõttük és utánuk
	Tile tile;
	Panda behind;
	Animal ahead;
	public String random;

	// Az állatok mozgását jelölõ absztrakt függvény
	public abstract void Move(Direction d);
	
	// A sorban állást vizsgáló függvény
	public boolean inLine() {
		return ahead!=null;
	} 
	
	// Az állatok pandával való ütközését jelölõ absztrakt függvény
	public abstract boolean hitBy(Panda p);
	
	// Az állatok orángutánnal való ütközését jelölõ absztrakt függvény
	public abstract boolean hitBy(Orangutan o);
	
	// A pandák elkapását jelöli, az implementáció a panda osztályban
	public void caughtBy(Animal a) {
		return;
	}
	
	// A mezõ beállítása
	public void setTile(Tile t) {
		tile=t;
	}
	
	// Az állat mögötti panda lekérése
	public Panda getBehind() {
		return behind;
	}
	
	// // Az állat elõtti panda beállítása
	public void setBehind(Panda p) {
		this.behind = p;		
	}
	
	// Ha sima állat sípolást hall nem csinál semmit
	public void hearBeep() {
	}
	
	// Ha sima állat csilingelést hall nem csinál semmit
	public void hearJingle() {
	}
	
	// A mezõ visszaadása
	public Tile getTile() {
		return tile;
	}
	
	// Ha sima állatot elfárasztják nem történik semmi
	public void Exhaust(Tile t) {
	}
	
	// Elpusztulást jelölõ absztrakt metódus
	public abstract void die();
	
	// A pihenési idõt csökkentõ függvény, sima állatnál nem csinál semmit
	public void reduceTime() {
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		
	}
}
