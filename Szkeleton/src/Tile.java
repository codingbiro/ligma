

public class Tile {
	String name;
	Animal a;
	Thing th;

	Tile neighbour[];
	
	public Tile(String s) {
		name = s;
		neighbour = new Tile[Direction.values().length];
	}
	
	public void setNeighbour(Direction d, Tile t) {
		neighbour[d.ordinal()]  = t;
	}
	
	public Animal getAnimal() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getAnimal");
		Globals.tab--;
		return a;
		
	}
	
	public Tile getNeighbour(Direction d) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getNeighbour(" + d.name() + ")");
		Globals.tab--;
		return neighbour[d.ordinal()];
	}
	
	public Thing getThing() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getThing");
		Globals.tab--;
		return th;
	}
	
	public void setAnimal(Animal a2) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setAnimal(" + a2.name + ")");
		
		if(a2!=null) {
			a2.setTile(this);
		}
		Globals.tab--;
	}
	
	public void setThing(Thing t) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setThing(" + t.name + ")");
		t.setTile(this);
		th = t;
		Globals.tab--;
	}
}
