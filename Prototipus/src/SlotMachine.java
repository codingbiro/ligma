
public class SlotMachine extends Thing{

	public SlotMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// A csilingel�st minden ir�nyba hallj�k
	public void jingle() {
		for(Direction d:Direction.values()) {
			Tile t2 = null;
			if(t!=null)
				t2=t.getNeighbour(d);
			Animal a = null;
			if(t2!=null)
			a=t2.getAnimal();
			// Ha l�tezik a szomsz�dos mez� �s van rajta �llat akkor csilingel�st hall
			if(a!=null)
				a.hearJingle();
		}
	}

}
