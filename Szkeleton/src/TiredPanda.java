
public class TiredPanda extends Panda{
	
	// most csak adtam egy random értéket
	private int naptime=3;

	public TiredPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Exhaust(Tile tar) {
		if(inLine()) {
			breakLine();
		}
		t1.setAnimal(null);
		tar.setAnimal(this);
	}

	public void reduceTime() {
		naptime--;
	}
	
}
