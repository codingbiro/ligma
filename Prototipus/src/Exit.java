
/**
 * @author Kevin
 *
 */
public class Exit extends Thing{
	
	// Ha panda �tk�zik vele
	public boolean hitBy(Panda p) {
		//Ha nincs sorban nem l�phet r� panda
		if(!p.inLine()) {
			return false;
		}
		// Ha sorban van akkor kivezetik a kij�raton, teh�t a j�t�kos pontot kap �s a panda elpusztul
		else {
			Globals.gc.addPoints();
			p.die();
			return true;
		}
	}
	
	// Jelzi, hogy az or�ngut�n kij�ratra l�pett 
	public boolean Ward() {
		return false;
	}
	
	// Ha or�ngut�n �tk�zik vele
	public boolean hitBy(Orangutan o) {
		Entrance e = null;
		// Lek�ri a controllert�l a bej�ratot
		if(Globals.gc!=null)
			e = Globals.gc.getEntrance();
		if(o!=null) {
			// Mozgatja a m�g�tte �ll� pand�kat
			if(o.getBehind()!=null) o.getBehind().exited();
			o.setBehind(null);
		}
		// �tmozog az or�ngut�n a bej�ratra
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
