	
public class Panda extends Animal{

	public Panda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Move(Direction d) {
		boolean b1=true;
		boolean b2=true;
		// A szomszédos mezõ lekérése
		Tile t2=t1.getNeighbour(d);
		boolean b=inLine();
		
		
		if(!b) {
			if(t2!=null) {
				// Ha nem áll elõtte senki és van a választott irányban szomszédos mezõ akkor elkéri az azon álló dolgot és állatot
				Animal a2=t2.getAnimal();
				Thing th=t2.getThing();
				if(a2!=null) {
					if(th!=null) {
						// Ha állat és dolog is van
						b1=a2.hitBy(this);
						b2=th.hitBy(this);
					}
					// Ha csak állat van
					else if(th==null){
						b1=a2.hitBy(this);
					}
				}
				else if(a2==null){
					if(th!=null) {
						// Ha csak tárgy van
						b2=th.hitBy(this);
					}
				}
				
				if(b1&&b2) {
					t1.setAnimal(null);
					if(behind!=null) {
						if(a2!=null) {
							a2.caughtBy(this);
						}
						else if(a2==null){
							Direction d2=behind.getDirection(t1);
							behind.Move(d2);
						}
					}
					t2.setAnimal(this);
				}
			}
		}
		else if(b){
			t1.setAnimal(null);
			if(behind!=null) {
				Direction d2=behind.getDirection(t1);
				behind.Move(d2);
			}
			t2.setAnimal(this);
		}
	}
	
	public Direction getDirection(Tile t) {
		for(Direction d:Direction.values()) {
			Tile t2=t1.getNeighbour(d);
			if(t2.equals(t)) {
				return d;
			}
		}
		return Direction.UP;
	}
	
	public void setAhead(Animal a) {
		ahead= a;
	}
	
	public void setAhead(Animal a, boolean set) {
		ahead= a;
	}
	
	public Animal getAhead() {
		return ahead;
	}

	public boolean hitBy(Panda p) {
		return false;
	}
	
	public boolean hitBy(Orangutan o) {
		boolean b=inLine();
		return !b;
	}
	
	public void breakLine() {
		setAhead(null);
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
	}
	
	public void caughtBy(Animal a) {
		Tile t = a.getTile();
		t.setAnimal(this);
		setAhead(a);
		Panda pb=a.getBehind();
		if(pb!=null) {
			setBehind(pb);
			pb.setAhead(this);
		}
		a.setBehind(this);
	}
	
	public void die() {
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		
	}

	public String stat() {
		// TODO Auto-generated method stub
		String out = null;
		out += "Tile: " + ((this.t1.name == null) ? null : this.t1.name);
		out += "Behind: " + ((this.behind.name == null) ? null : this.behind.name);
		out += "Ahead: " + this.ahead.name;
		return out;
	}
}
	
