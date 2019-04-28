
/**
 * @author Kevin
 *
 */
public class Armchair extends Thing{

	public Armchair(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// A fotel a k�rnyez� pand�kat f�rasztja
	public void check() {
		Animal a2=t.getAnimal();
		// Ha nincs a fotelben �llat minden ir�nyba f�rasztja a pand�kat
		if(a2==null) {
			for(Direction d:Direction.values()) {
				Tile t2=t.getNeighbour(d);
				Animal a = null;
				if(t2 != null)
					a = t2.getAnimal();
				if(a!=null)
					a.Exhaust(t);
			}
		}
		// Ha �l m�r benne panda akkor cs�kkenti a pihen�idej�t
		else a2.reduceTime();
	}

}
