
/**
 * @author Kevin
 *
 */
public class Armchair extends Thing{

	public Armchair(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// A fotel a környezõ pandákat fárasztja
	public void check() {
		Animal a2=t.getAnimal();
		// Ha nincs a fotelben állat minden irányba fárasztja a pandákat
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
		// Ha ül már benne panda akkor csökkenti a pihenõidejét
		else a2.reduceTime();
	}

}
