
public class Orangutan extends Animal{
	//Szkeleton
	GameController g;

	public Orangutan(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void Move(Direction d) {
		boolean b1=true;
		boolean b2=true;
		
		System.out.println(name+" Move(" + d.name() + ")" );
		// A szomsz�dos mez� lek�r�se
		Tile t2=t1.getNeighbour(d);
		boolean b=inLine();
		
		
		if(!b) {
			if(t2!=null) {
				// Ha nem �ll el�tte senki �s van a v�lasztott ir�nyban szomsz�dos mez� akkor elk�ri az azon �ll� dolgot �s �llatot
				Animal a2=t2.getAnimal();
				Thing th=t2.getThing();
				if(a2!=null) {
					if(th!=null) {
						// Ha �llat �s dolog is van
						b1=a2.hitBy(this);
						b2=th.hitBy(this);
					}
					// Ha csak �llat van
					else if(th==null){
						b1=a2.hitBy(this);
					}
				}
				else if(a2==null){
					if(th!=null) {
						// Ha csak t�rgy van
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
	
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy(" + o.name + ")");
		return false;
	}
	
	public boolean hitBy(Panda p) {
		System.out.println(name+" hitBy(" + p.name + ")");
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
