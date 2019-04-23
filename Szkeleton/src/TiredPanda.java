
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
	
	public void stat() {
		System.out.println("Tile: " + ((this.t1.name == null) ? null : this.t1.name));
		System.out.println("Behind: " + ((this.behind.name == null) ? null : this.behind.name));
		System.out.println("Ahead: " + ((this.ahead.name == null) ? null : this.ahead.name));
		System.out.println("Naptime: " + this.naptime);
	}
	
}
