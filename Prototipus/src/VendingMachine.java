
public class VendingMachine extends Thing{

	public VendingMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// S�pol�s minden ir�nyba
	public void beep() {
		for(Direction d:Direction.values()) {
			Tile t2 = null;
			if(t!=null)
				t2=t.getNeighbour(d);
			Animal a=null;
			if(t2!=null) a=t2.getAnimal();
			// Ha van mez� �s azon �llat
			if(a!=null && t2!=null)
				a.hearBeep();
		}
	}

}
