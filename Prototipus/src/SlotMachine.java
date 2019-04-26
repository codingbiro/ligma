
public class SlotMachine extends Thing{

	public SlotMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void jingle() {
		for(Direction d:Direction.values()) {
			Tile t2 = null;
			if(t!=null)
				t2=t.getNeighbour(d);
			Animal a = null;
			if(t2!=null)
			a=t2.getAnimal();
			if(a!=null)
				a.hearJingle();
		}
	}

}
