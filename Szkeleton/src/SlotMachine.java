
public class SlotMachine extends Thing{

	public SlotMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void jingle() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" jingle");
		for(Direction d:Direction.values()) {
			Tile t2=t.getNeighbour(d);
			Animal a=t2.getAnimal();
			if(a!=null)
				a.hearJingle();
		}
		Globals.tab--;
	}

}
