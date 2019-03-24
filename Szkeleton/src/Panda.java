
public class Panda extends Animal{

	public Panda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public Direction getDirection(Tile t) {
		System.out.println(name+" getDirection");
		for(Direction d:Direction.values()) {
			Tile t2=t1.getNeighbour(d);
			if(t2.equals(t)) {
				return d;
			}
		}
		return Direction.UP;
	}
	
	public void setAhead(Animal a) {
		System.out.println(name+" setAhead(" + a.name + ")");
	}
	
	public Animal getAhead() {
		System.out.println(name+" getAhead");
		return ahead;
	}

	public boolean hitBy(Panda p) {
		System.out.println(name+" hitBy");
		
	}
	
	public void breakLine() {
		System.out.println(name+" breakLine");
		setAhead(null);
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
	}
	
	public void caughtBy(Orangutan o) {
		System.out.println(name+" caughtBy");
		Tile t = o.getTile();
		t.setAnimal(this);
		setAhead(o);
		Panda pb=o.getBehind();
		if(pb!=null) {
			setBehind(pb);
			pb.setAhead(this);
		}
		o.setBehind(this);
	}
	
	public void die() {
		System.out.println(name+" die");
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		
	}
}
	
