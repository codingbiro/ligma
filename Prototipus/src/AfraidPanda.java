
// A f�l�s pand�kat reprezent�l� oszt�ly
/**
 * @author Kevin
 *
 */
public class AfraidPanda extends Panda{

	public AfraidPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingel�st hall megijed �s elszak�tja a l�ncot
	public void hearJingle() {		
		breakLine();
	}
	
	public void shouldDraw(View v) {
		v.drawAfraid();
	}

}
