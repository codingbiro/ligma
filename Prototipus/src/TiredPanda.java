import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class TiredPanda extends Panda{
	
	public TiredPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha egy fotel mellett van ami elfárasztja akkor megtöri a sort és beleül a fotelbe
	public void Exhaust(Tile tar) {
		if(inLine()) {
			breakLine();
		}
		Panda anull = null; //The method setAnimal(Panda) is ambiguous for the type Tile - elkerules miatt
		tile.setAnimal(anull);
		tar.setAnimal(this);
		// 5 körig ülve marad
		naptime = 5;
	}

	// Pihenõidõ csökkentése
	public void reduceTime() {
		naptime--;
	}
	
	// Tulajdonságok kiírása
	public ArrayList<String> stat() {
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((this.tile == null) ? "null" : this.tile.name));
		out.add("behind: " + ((this.behind == null) ? "null" : this.behind.name));
		out.add("ahead: " + ((this.ahead == null) ? "null" : this.ahead.name));
		out.add("naptime: " + this.naptime);
		return out;
	}
	
	public void shouldDraw(View v) {
		v.drawTired();
	}
	
}
