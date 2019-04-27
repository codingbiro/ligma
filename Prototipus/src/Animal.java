
// Az �llatokat reprezent�l� oszt�ly
public abstract class Animal {
	// Az �llatok �llnak valamilyen mez�n, �llhatnak a sorban el�tt�k �s ut�nuk
	String name;
	Tile tile;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	// Az �llatok mozg�s�t le�r� f�ggv�ny
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
