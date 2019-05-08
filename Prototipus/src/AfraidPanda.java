
// A félõs pandákat reprezentáló osztály
/**
 * @author Kevin
 *
 */
public class AfraidPanda extends Panda{

	public AfraidPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingelést hall megijed és elszakítja a láncot
	public void hearJingle() {		
		breakLine();
	}
	
	public void shouldDraw(View v) {
		v.drawAfraid();
	}

}
