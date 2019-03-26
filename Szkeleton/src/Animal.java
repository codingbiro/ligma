
// Az állatokat reprezentáló osztály
public abstract class Animal {
	// Az állatok állnak valamilyen mezõn, állhatnak a sorban elõttük és utánuk
	String name;
	Tile t1;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	// Az állatok mozgását leíró függvény
	public abstract void Move(Direction d);
	
	public boolean inLine() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" inLine");
		Globals.tab--;
		return ahead!=null;
	} 
	
	public abstract boolean hitBy(Panda p);
	
	public abstract boolean hitBy(Orangutan o);
	
	public void caughtBy(Animal a) {
		return;
	}
	
	public void setTile(Tile t) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setTile(" + t.name + ")");
		t1=t;
		Globals.tab--;
	}
	
	public Panda getBehind() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getBehind");
		Globals.tab--;
		return behind;
	}
	
	public void setBehind(Panda p) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setBehind");
		behind = p;
		Globals.tab--;
	}
	
	public void hearBeep() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hearBeep");
		Globals.tab--;
	}
	
	public void hearJingle() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hearJingle");
		Globals.tab--;
	}
	
	public Tile getTile() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getTile");
		Globals.tab--;
		return t1;
	}
	
	public void Exhaust(Tile t) {
			//Globals.tab++;
			//for(int i = 0; i<Globals.tab; i++)
				//System.out.print("\t");
			//System.out.println(name+" Exhaust");
			//Globals.tab--;
	}
	
	public abstract void die();
	
	public void reduceTime() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" reduceTime");
		Globals.tab--;
	}
}
