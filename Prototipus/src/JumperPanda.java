
/**
 * @author Kevin
 *
 */
public class JumperPanda extends Panda{

	public JumperPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha sípolást hall akkor ugrik egyet
	public void hearBeep() {
		jump();
	}
	
	// Ugrás 
	public void jump() {
		tile.setAnimal(this);
	}
}
