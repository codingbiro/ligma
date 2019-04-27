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
		return ahead!=null;
	} 
	
	public void Move(Direction d) {
		if(stunned != 0)
			stunned--;
		boolean b1=true;
		boolean b2=true;
		
		// A szomszédos mezõ lekérése
		Tile t2 = null;
		if(tile!=null)
			t2=tile.getNeighbour(d);
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
				
				if(b1&&b2) {
					Orangutan anull = null; //The method setAnimal(Orangutan) is ambiguous for the type Tile - elkerules miatt
					if(tile!=null)
						tile.setAnimal(anull);
					if(behind!=null) {						
						if(a2!=null) {							
							a2.caughtBy(this);
						}
						else if(a2==null){
							Direction d2=behind.getDirection(tile);
							behind.Move(d2);
						}
					}
					//ezt az else-t a protonal irtam hozza, enelkul nem kapja el a pandat az orangutan
					else {
						if(a2!=null) {							
							a2.caughtBy(this);
						}
					}
					if(wardrobex)
					t2.setAnimal(this);					
				}
			}
		}
		else if(b){			
			Orangutan anull = null; //The method setAnimal(Orangutan) is ambiguous for the type Tile - elkerules miatt
			tile.setAnimal(anull);
			if(behind!=null) {
				Direction d2=behind.getDirection(tile);
				behind.Move(d2);
			}
			if(t2!=null)
			t2.setAnimal(this);
		}
		
	}
	
	public boolean hitBy(Orangutan o) {
		Panda pb1 = o.getBehind();
		if(pb1 == null && this.behind != null && o.stunned == 0) {
			behind.setAhead(o);
			o.setBehind(behind);
			behind = null;
			Tile t1 = o.getTile();
			tile.setAnimal(o);
			t1.setAnimal(this);
			stunned = 3;
		}
		return false;
	}
	
	public boolean hitBy(Panda p) {
		return false;
	}

	public void die() {
		breakLine();			
		if(g!=null) {
			g.decreasePoints();
			Entrance en = g.getEntrance();
			Tile ten = null;
			if(en!=null) {
				ten = en.getTile();
				if(ten!=null) {			
					ten.setAnimal(this);
				}
			}	
		}	
	}

	public ArrayList<String> stat() {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		out.add("tile: " + ((tile == null) ? "null" : this.tile.name));
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
