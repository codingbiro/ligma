
/**
 * @author Kevin
 *
 */
public class JumperPanda extends Panda{

	public JumperPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha s�pol�st hall akkor ugrik egyet
	public void hearBeep() {
		jump();
	}
	
	// Ugr�s 
	public void jump() {
		tile.setAnimal(this);
	}
}
