
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
	
	public String stat() {
		String out = null;
		out += "Tile: " + ((this.t1.name == null) ? null : this.t1.name);
		out += "Behind: " + ((this.behind.name == null) ? null : this.behind.name);
		out += "Ahead: " + ((this.ahead.name == null) ? null : this.ahead.name);
		out += "Naptime: " + this.naptime;
		return out;
	}
	
}
