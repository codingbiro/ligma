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
		Panda anull = null; //The method setAnimal(Panda) is ambiguous for the type Tile - elkerules miatt
		tile.setAnimal(anull);
		tar.setAnimal(this);
		naptime = 5;
	}

	public void reduceTime() {
		naptime--;
	}
	
	public ArrayList<String> stat() {
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.tile == null) ? "null" : this.tile.name));
		out.add("behind: " + ((this.behind == null) ? "null" : this.behind.name));
		out.add("ahead: " + ((this.ahead == null) ? "null" : this.ahead.name));
		out.add("naptime: " + this.naptime);
		return out;
	}
	
}
