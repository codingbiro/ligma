
public class JumperPanda extends Panda{

	public JumperPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void hearBeep() {
		jump();
	}
	
	public void jump() {
		t1.setAnimal(this);
	}
}
