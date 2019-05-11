
/**
 * @author Kevin
 *
 */
public class Wardrobe extends Thing{
	
	//A szekreny parja
	Wardrobe wrPair;
	
	// Szekrény vagy kijárat-e
	public boolean Ward() {
		return false;
	}

	// Ha nekimegy az orángután akkor átkerül a szekrény párjába
	public boolean hitBy(Orangutan a) {
		Tile t2 = null;
		if(wrPair!=null)
			t2 = wrPair.getTile();
		if(t2!=null)
			t2.setAnimal(a);
		if(a!=null)
			a.setTile(t2);
		return true;
	}
	
	// Ha nekimegy a panda akkor átkerül a szekrény párjába
	public boolean hitBy(Panda a) {
		Tile t2 = null;
		if(wrPair!=null)
			t2 = wrPair.getTile();
		if(t2!=null)
			t2.setAnimal(a);
		if(a!=null)
			a.setTile(t2);
		return true;
	}
	
}
