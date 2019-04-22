
public class Wardrobe extends Thing{

	//Szkeleton
	Wardrobe w2;
	
	public Wardrobe(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public boolean hitBy(Orangutan a) {
		Tile t2 = w2.getTile();
		t2.setAnimal(a);
		a.setTile(t2);
		return true;
	}
	public boolean hitBy(Panda a) {
		Tile t2 = w2.getTile();
		t2.setAnimal(a);
		a.setTile(t2);
		return true;
	}
	
}
