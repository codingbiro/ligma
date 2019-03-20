
public class Orangutan extends Animal{

	public Orangutan(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy");
		return false;
	}

}
