import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Panda extends Animal{
	
	// mivel az expectedeknel valaki valamikor igy talalta ki, a naptime ide kerul, mert nem csak tired pandaknal volt kimenet - tetszes szerint valtoztathato
	protected int naptime=0;
	
	// Panda mozgásáért felelõs függvény
	public void Move(Direction d) {		
		boolean b1=true;
		boolean b2=true;
		boolean wardrobex=true; //wardrobe eseten tuti nem kell belemenni az utolso agba
		// A szomszedos mezo lekerese
		Tile t2 = null;
		if(tile!=null) {
			t2=tile.getNeighbour(d);
			//szabad panda eseten
			if(!inLine()) {
				if(t2!=null) {				
					// Ha nem all elotte senki és van a valasztott iranyban szomszedos mezo,akkor elkeri az azon allo thinget es animalt
					Animal a2=t2.getAnimal();
					Thing th=t2.getThing();
					if(a2!=null) {					
						if(th!=null) {						
							// ha animal es thing is van
							b1=a2.hitBy(this);
							b2=th.hitBy(this);
						}
						// Ha csak animal van
						else if(th==null){
							b1=a2.hitBy(this);
						}
					}
					else {					
						if(th!=null) {						
							// Ha csak targy van
							b2=th.hitBy(this);
							wardrobex=th.Ward();
						}
					}				
					
					if(b1&&b2&&wardrobex) {					
						Panda anull = null; //The method setAnimal(Panda) is ambiguous for the type Tile - elkerules miatt
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
						t2.setAnimal(this);
					}
				}
			}
			// Ha sorban áll akkor mozog az elõtte lévõ állat mezõjére
			else if(inLine()){			
				Panda anull = null; //The method setAnimal(Panda) is ambiguous for the type Tile - elkerules miatt
				tile.setAnimal(anull);
				if(behind!=null) {				
					Direction d2=behind.getDirection(tile);
					behind.Move(d2);
				}		
				
				//wardrobe eseten modositani kell
				Thing th=t2.getThing();
				boolean wardr;
				if(th==null) wardr = true;
				else wardr=th.Ward();
				if(!wardr) {				
					th.hitBy(this);			
				}
				else {
					t2.setAnimal(this);
				}
			}
		}
	}
	
	// Elõtte álló állat irányának lekérése
	public Direction getDirection(Tile t) {
		for(Direction d:Direction.values()) {
			Tile t2 = null;
			if(tile != null && t!=null) {
				t2=tile.getNeighbour(d);
				if(t2!=null)
					if(t2.equals(t))
						return d;
			}
		}
		//ha nem talalt szomszedot nullal ter vissza, de ilyennek nem szabadna lennie
		return null;
	}
	
	// Elõtte lévõ beállítása
	public void setAhead(Animal a) {
		ahead= a;
	}
	
	// // Elõtte lévõ visszaadása
	public Animal getAhead() {
		return ahead;
	}

	// Ha pandák ütköznek nem történik semmi és ottmaradnak
	public boolean hitBy(Panda p) {
		return false;
	}
	
	// Ha orángután ütközik vele akkor a kimenetelt az határozza meg, hogy sorban áll-e
	public boolean hitBy(Orangutan o) {
		boolean b=inLine();
		return !b;
	}
	
	// Sor megbontása
	public void breakLine() {
		if(ahead!=null) ahead.setBehind(null);
		setAhead(null);
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
			setBehind(null);
		}
	}
	
	// Ha elkapja egy orángután
	public void caughtBy(Animal a) {
		Tile t = a.getTile();
		t.setAnimal(this);
		setAhead(a);
		Panda pb=a.getBehind();
		if(pb!=null) {
			// Beállítja az elõtte és utána lévõ állatokat megfelelõen
			setBehind(pb);
			pb.setAhead(this);
		}
		a.setBehind(this);
	}
	
	// ha meghal a panda akkor megtörik a lánc
	public void die() {
		breakLine();
		tile = null;
		Globals.gc.pandaCnt--;
	}
	
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v, Graphics g) {
		//kirajzoltatja magat a kapott viewval
		v.drawPanda(tile.posX(),tile.posY(), g);
	}
}
	
