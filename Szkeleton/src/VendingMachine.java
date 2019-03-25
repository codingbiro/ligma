
public class VendingMachine extends Thing{

	public VendingMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void beep() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" beep");
		for(Direction d:Direction.values()) {
			Tile t2=t.getNeighbour(d);
			Animal a=t2.getAnimal();
			a.hearBeep();
		}
		Globals.tab--;
	}

}
