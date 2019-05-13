
/**
 * @author Kevin
 *
 */
public class Exit extends Thing{
	
	// Ha panda ütközik vele
	public boolean hitBy(Panda p) {
		//Ha nincs sorban nem léphet rá panda
		if(!p.inLine()) {
			return false;
		}
		// Ha sorban van akkor kivezetik a kijáraton, tehát a játékos pontot kap és a panda elpusztul
		else {
			Globals.gc.addPoints();
			p.die();
			return true;
		}
	}
	
	// Jelzi, hogy az orángután kijáratra lépett 
	public boolean Ward() {
		return false;
	}
	
	// Ha orángután ütközik vele
	public boolean hitBy(Orangutan o) {
		Entrance e = null;
		// Lekéri a controllertõl a bejáratot
		if(Globals.gc!=null)
			e = Globals.gc.getEntrance();
		if(o!=null) {
			// Mozgatja a mögötte álló pandákat
			if(o.getBehind()!=null) o.getBehind().exited();
			o.setBehind(null);
		}
		// Átmozog az orángután a bejáratra
		Orangutan anull=null;
		o.tile.setAnimal(anull);
		Tile t1 = null;
		if(e!=null)
			t1 = e.getTile();
		if(t1!=null)
			t1.setAnimal(o);
		
		return true;
	}

}
