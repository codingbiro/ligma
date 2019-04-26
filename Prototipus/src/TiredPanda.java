import java.util.ArrayList;

public class TiredPanda extends Panda{
	
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
	
	public ArrayList<String> stat() {
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.t1 == null) ? "null" : this.t1.name));
		out.add("behind: " + ((this.behind == null) ? "null" : this.behind.name));
		out.add("ahead: " + ((this.ahead == null) ? "null" : this.ahead.name));
		out.add("naptime: " + this.naptime);
		return out;
	}
	
}
