
public class JumperPanda extends Panda{

	public JumperPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void hearBeep() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hearBeep");
		jump();
		Globals.tab--;
	}
	
	public void jump() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" jump");
		t1.setAnimal(this);
		Globals.tab--;
	}
}
