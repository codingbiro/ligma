
// A f�l�s pand�kat reprezent�l� oszt�ly
/**
 * @author Kevin
 *
 */
public class AfraidPanda extends Panda{

	public AfraidPanda() {
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingel�st hall megijed �s elszak�tja a l�ncot
	public void hearJingle() {		
		breakLine();
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		//kirajzoltatja magat a kapott viewval
		v.drawAfraid(tile.posX(),tile.posY());
	}

}
