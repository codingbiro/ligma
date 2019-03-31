
public class TiredPanda extends Panda{
	
	// most csak adtam egy random értéket
	private int naptime=3;

	public TiredPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Exhaust(Tile tar) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" Exhaust(" + tar.name + ")");
		if(inLine()) {
			breakLine();
		}
		t1.setAnimal(null);
		tar.setAnimal(this);
		Globals.tab--;
	}

	public void reduceTime() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" reduceTime");
		Globals.tab--;
		
		naptime--;
	}
	
}
