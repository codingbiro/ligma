
// Az �llatokat reprezent�l� oszt�ly
public abstract class Animal {
	// Az �llatok �llnak valamilyen mez�n, �llhatnak a sorban el�tt�k �s ut�nuk
	String name;
	Tile t1;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	// Az �llatok mozg�s�t le�r� f�ggv�ny
	public abstract void Move(Direction d);
	
	public boolean inLine() {
		System.out.println(name+" inLine");
		return ahead!=null;
	} 
	
	public abstract boolean hitBy(Panda p);
	
	public abstract boolean hitBy(Orangutan o);
	
	public void caughtBy(Animal a) {
		return;
	}
	
	public void setTile(Tile t) {
		System.out.println(name+" setTile(" + t.name + ")");
		t1=t;
	}
	
	public Panda getBehind() {
		System.out.println(name+" getBehind");
		return behind;
	}
	
	public void setBehind(Panda p) {
		System.out.println(name+" setBehind");
		behind = p;
	}
	
	public void hearBeep() {
		System.out.println(name+" hearBeep");
	}
	
	public void hearJingle() {
		System.out.println(name+" hearJingle");
	}
	
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t1;
	}
	
	public void Exhaust(Tile t) {
		System.out.println(name+" Exhaust");
	}
	
	public abstract void die();
	
	public void reduceTime() {
		System.out.println(name+" reduceTime");
	}
}
