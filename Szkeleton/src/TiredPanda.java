
public class TiredPanda extends Panda{

	public TiredPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Exhaust(Tile tar) {
		System.out.println(name+" Exhaust(" + tar.name + ")");
		boolean b=inLine();
		if(b) {
			breakLine();
		}
		t1.setAnimal(null);
		tar.setAnimal(this);
	}

	public void reduceTime() {
		System.out.println(name+" reduceTime");
	}
	
}
