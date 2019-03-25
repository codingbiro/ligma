
public class Panda extends Animal{

	public Panda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Move(Direction d) {
		boolean b1=true;
		boolean b2=true;
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		
		System.out.println(name+" Move(" + d.name() + ")");
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
		Globals.tab--;
	}
	
	public Direction getDirection(Tile t) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getDirection(" + t.name + ")");
		for(Direction d:Direction.values()) {
			Tile t2=t1.getNeighbour(d);
			if(t2.equals(t)) {
				return d;
			}
		}
		Globals.tab--;
		return Direction.UP;
	}
	
	public void setAhead(Animal a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		if(a!=null)
			System.out.println(name+" setAhead(" + a.name + ")");
		ahead= a;
		Globals.tab--;
	}
	
	public Animal getAhead() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getAhead");
		Globals.tab--;
		return ahead;
	}

	public boolean hitBy(Panda p) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hitBy(" + p.name + ")");
		Globals.tab--;
		return false;
	}
	
	public boolean hitBy(Orangutan o) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+ "hitBy(" + o.name + ")");
		boolean b=inLine();
		Globals.tab--;
		return !b;
	}
	
	public void breakLine() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" breakLine");
		setAhead(null);
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		Globals.tab--;
	}
	
	public void caughtBy(Animal a) {
		Globals.tab++;
			for(int i = 0; i<Globals.tab; i++)
				System.out.print("\t");
		System.out.println(name+" caughtBy(" + a.name + ")");
		Tile t = a.getTile();
		t.setAnimal(this);
		setAhead(a);
		Panda pb=a.getBehind();
		if(pb!=null) {
			setBehind(pb);
			pb.setAhead(this);
		}
		a.setBehind(this);
		Globals.tab--;
	}
	
	public void die() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" die");
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		Globals.tab--;
		
	}
}
	
