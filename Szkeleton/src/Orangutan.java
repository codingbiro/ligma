
public class Orangutan extends Animal{
	//Szkeleton
	GameController g;

	public Orangutan(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy");
		return false;
	}

	public void die() {
		System.out.println(name+" die");
		g.decreasePoints();
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		Entrance en = g.getEntrance();
		Tile ten = en.getTile();
		Animal a = ten.getAnimal();
		if(a!=null) {
			ten.setAnimal(a);
		}
	}
}
