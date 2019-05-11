
// A félõs pandákat reprezentáló osztály
/**
 * @author Kevin
 *
 */
public class AfraidPanda extends Panda{

	public AfraidPanda() {
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingelést hall megijed és elszakítja a láncot
	public void hearJingle() {		
		breakLine();
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		//kirajzoltatja magat a kapott viewval
		v.drawAfraid(tile.posX(),tile.posY());
	}

}
