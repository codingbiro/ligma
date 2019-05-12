import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class TiredPanda extends Panda{
	
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
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v, Graphics g) {
		//kirajzoltatja magat a kapott viewval
		v.drawTired(tile.posX(),tile.posY(), g);
	}
	
}
