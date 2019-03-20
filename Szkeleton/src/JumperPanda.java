
public class JumperPanda extends Panda{

	public JumperPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void hearBeep() {
		System.out.println(name+" hearBeep");
		jump();
	}
	
	public void jump() {
		System.out.println(name+" jump");
		t1.setAnimal(this);
	}
}
