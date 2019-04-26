
public class Wardrobe extends Thing{

	//Szkeleton
	Wardrobe w2;
	
	public Wardrobe(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean Ward() {
		return false;
	}

	public boolean hitBy(Orangutan a) {
		Tile t2 = null;
		if(w2!=null)
			t2 = w2.getTile();
		if(t2!=null)
			t2.setAnimal(a);
		if(a!=null)
			a.setTile(t2);
		return true;
	}
	
	public boolean hitBy(Panda a) {
		Tile t2 = null;
		if(w2!=null)
			t2 = w2.getTile();
		if(t2!=null)
			t2.setAnimal(a);
		if(a!=null)
			a.setTile(t2);
		return true;
	}
	
}
