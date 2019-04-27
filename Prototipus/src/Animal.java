
// Az állatokat reprezentáló osztály
public abstract class Animal {
	// Az állatok állnak valamilyen mezõn, állhatnak a sorban elõttük és utánuk
	String name;
	Tile tile;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	// Az állatok mozgását leíró függvény
	public abstract void Move(Direction d);
	
	public boolean inLine() {
		return ahead!=null;
	} 
	
	public abstract boolean hitBy(Panda p);
	
	public abstract boolean hitBy(Orangutan o);
	
	public void caughtBy(Animal a) {
		return;
	}
	
	public void setTile(Tile t) {
		tile=t;
	}
	public void setTile(Tile t, boolean tt) {
		
		tile=t;
	}
	
	public Panda getBehind() {
		return behind;
	}
	
	public void setBehind(Panda p) {
		behind = p;
	}
	
	public void setBehind(Panda p, boolean set) {
		
		behind = p;
		
	}
	
	public void hearBeep() {
	}
	
	public void hearJingle() {
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public void Exhaust(Tile t) {
	}
	
	public abstract void die();
	
	public void reduceTime() {
	}
}
