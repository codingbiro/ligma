
public class VendingMachine extends Thing{

	public VendingMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void beep() {
		for(Direction d:Direction.values()) {
			Tile t2=t.getNeighbour(d);
			if(t2!=null) Animal a=t2.getAnimal();
			if(a!=null && t2!=null)
				a.hearBeep();
		}
	}

}
