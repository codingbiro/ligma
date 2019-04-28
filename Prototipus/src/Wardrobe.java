
/**
 * @author Kevin
 *
 */
public class Wardrobe extends Thing{

	//Szkeleton
	Wardrobe w2;
	
	public Wardrobe(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Szekr�ny vagy kij�rat-e
	public boolean Ward() {
		return false;
	}

	// Ha nekimegy az or�ngut�n akkor �tker�l a szekr�ny p�rj�ba
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
	
	// Ha nekimegy a panda akkor �tker�l a szekr�ny p�rj�ba
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
