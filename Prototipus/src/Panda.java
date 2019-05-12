import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Panda extends Animal{
	
	// mivel az expectedeknel valaki valamikor igy talalta ki, a naptime ide kerul, mert nem csak tired pandaknal volt kimenet - tetszes szerint valtoztathato
	protected int naptime=0;
	
	// Panda mozg�s��rt felel�s f�ggv�ny
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
					// Ha nem all elotte senki �s van a valasztott iranyban szomszedos mezo,akkor elkeri az azon allo thinget es animalt
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
			// Ha sorban �ll akkor mozog az el�tte l�v� �llat mez�j�re
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
	
	// El�tte �ll� �llat ir�ny�nak lek�r�se
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
	
	// El�tte l�v� be�ll�t�sa
	public void setAhead(Animal a) {
		ahead= a;
	}
	
	// // El�tte l�v� visszaad�sa
	public Animal getAhead() {
		return ahead;
	}

	// Ha pand�k �tk�znek nem t�rt�nik semmi �s ottmaradnak
	public boolean hitBy(Panda p) {
		return false;
	}
	
	// Ha or�ngut�n �tk�zik vele akkor a kimenetelt az hat�rozza meg, hogy sorban �ll-e
	public boolean hitBy(Orangutan o) {
		boolean b=inLine();
		return !b;
	}
	
	// Sor megbont�sa
	public void breakLine() {
		if(ahead!=null) ahead.setBehind(null);
		setAhead(null);
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
			setBehind(null);
		}
	}
	
	// Ha elkapja egy or�ngut�n
	public void caughtBy(Animal a) {
		Tile t = a.getTile();
		t.setAnimal(this);
		setAhead(a);
		Panda pb=a.getBehind();
		if(pb!=null) {
			// Be�ll�tja az el�tte �s ut�na l�v� �llatokat megfelel�en
			setBehind(pb);
			pb.setAhead(this);
		}
		a.setBehind(this);
	}
	
	// ha meghal a panda akkor megt�rik a l�nc
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
	
