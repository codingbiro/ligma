
public class Wardrobe extends Thing{

	//Szkeleton
	Wardrobe w2;
	
	public Wardrobe(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public boolean hitBy(Orangutan a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + a.name + ")");
		Tile t2 = w2.getTile();
		t2.setAnimal(a);
		a.setTile(t2);
		Globals.tab--;
		return true;
	}
	public boolean hitBy(Panda a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + a.name + ")");
		Tile t2 = w2.getTile();
		t2.setAnimal(a);
		a.setTile(t2);
		Globals.tab--;
		return true;
	}
	
}
