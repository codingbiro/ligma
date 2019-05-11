
/**
 * @author Kevin
 *
 */
public class JumperPanda extends Panda{
	
	// Ha sípolást hall akkor ugrik egyet
	public void hearBeep() {
		jump();
	}
	
	// Ugrás 
	public void jump() {
		tile.setAnimal(this);
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		//kirajzoltatja magat a kapott viewval
		v.drawJumper(tile.posX(),tile.posY());
	}
}
