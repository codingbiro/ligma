import java.util.ArrayList;

public class Orangutan extends Animal{
	//Szkeleton
	GameController g;
	int stunned = 0;

	public Orangutan(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean inLine() {
		return behind!=null;
	} 
	
	public void Move(Direction d) {		
		boolean b1=true;
		boolean b2=true;
		
		// A szomszédos mezõ lekérése
		Tile t2 = null;
		if(t1!=null)
			t2=t1.getNeighbour(d);
		boolean b=inLine();
		boolean wardrobex=true; //Exit es Wardrobe eseten visszarakna a program algoritmusa a moveolt helyre (pair-ra vagy Entrancera)		
		
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
						wardrobex=th.Ward();
					}
				}
				
				if(b1&&b2&&wardrobex) {
					Orangutan anull = null; //The method setAnimal(Orangutan) is ambiguous for the type Tile - elkerules miatt
					if(t1!=null)
						t1.setAnimal(anull);
					if(behind!=null) {						
						if(a2!=null) {							
							a2.caughtBy(this);
						}
						else if(a2==null){
							Direction d2=behind.getDirection(t1);
							behind.Move(d2);
						}
					}
					//ezt az else-t a protonal irtam hozza, enelkul nem kapja el a pandat az orangutan
					else {
						if(a2!=null) {							
							a2.caughtBy(this);
						}
					}
					t2.setAnimal(this);					
				}
			}
		}
		else if(b){			
			Orangutan anull = null; //The method setAnimal(Orangutan) is ambiguous for the type Tile - elkerules miatt
			t1.setAnimal(anull);
			if(behind!=null) {
				Direction d2=behind.getDirection(t1);
				behind.Move(d2);
			}
			if(t2!=null)
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
		if(g!=null)
			g.decreasePoints();
		
		Panda pb = getBehind();
		if(pb!=null)
			pb.breakLine();
		
		Entrance en = null;
		if(g!=null) 
			en = g.getEntrance();

		Tile ten = null;
		if(en!=null)
			ten = en.getTile();
		
		if(ten!=null) {			
			ten.setAnimal(this);
		}
	}

	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((t1 == null) ? "null" : this.t1.name));
		out.add("behind: " + ((this.behind == null) ? "null" : this.behind.name));
		out.add("stunned: " + stunned);
		return out;
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
