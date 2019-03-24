
public class SlotMachine extends Thing{

	public SlotMachine(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void jingle() {
		System.out.println(name+" jingle");
		for(Direction d:Direction.values()) {
			Tile t2=t.getNeighbour(d);
			Animal a=t2.getAnimal();
			a.hearJingle();
		}
	}

}
