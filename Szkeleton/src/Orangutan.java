
public class Orangutan extends Animal{
	//Szkeleton
	GameController g;
	int stunned = 0;

	public Orangutan(String s) {
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
					// 5.4.11-et es 5.4.12-t elrontja ez
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
	
	public boolean hitBy(Orangutan o) {
		return false;
	}
	
	public boolean hitBy(Panda p) {
		return false;
	}

	public void die() {
		g.decreasePoints();
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		Entrance en = g.getEntrance();
		Tile ten = en.getTile();
		Animal a = ten.getAnimal();		
		ten.setAnimal(this);
	}

	public void stat() {
		// TODO Auto-generated method stub
		System.out.println("Tile: " + ((this.t1.name == null) ? null : this.t1.name));
		System.out.println("Behind: " + ((this.behind.name == null) ? null : this.behind.name));
		System.out.println("Stunned: " + stunned);
	}

	public void breakLine() {
		// TODO Auto-generated method stub
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		setBehind(null);
	}
}
