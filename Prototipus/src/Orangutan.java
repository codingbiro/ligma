import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Orangutan extends Animal{
	//Szkeleton
	GameController gc;
	int stunned = 0;
	
	// A sorban �ll�st mondja meg
	public boolean inLine() {
		return ahead!=null;
	} 
	
	// Or�ngut�n mozg�s��rt felel�s f�ggv�ny
	public void Move(Direction d) {
		if(stunned != 0)
			stunned--;
		boolean b1=true;
		boolean b2=true;
		
		// A szomsz�dos mez� lek�r�se
		Tile t2 = null;
		if(tile!=null)
			t2=tile.getNeighbour(d);
		boolean b=inLine();
		boolean wardrobex=true; //Exit es Wardrobe eseten visszarakna a program algoritmusa a moveolt helyre (pair-ra vagy Entrancera)		
		
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
						wardrobex=th.Ward();
					}
				}
				
				// Ha mozoghat az adott mez�re
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
					// Ha nem kij�ratra vagy szekr�nyre l�pett akkor odal�p (azokn�l m�shogy ker�l oda)
					if(wardrobex)
					t2.setAnimal(this);					
				}
			}
		}
		// Ha sorban �ll
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
	
	// Ha �tk�zik m�s or�ngut�nnal
	public boolean hitBy(Orangutan o) {
		Panda pb1 = o.getBehind();
		// Ha eleget tesz a panda lop�s felt�teleinek, ellopja a m�sik pand�it
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
	
	// Panda nem mozoghat r�
	public boolean hitBy(Panda p) {
		return false;
	}

	// Az or�ngut�n ha meghal akkor cs�kkennek a pontjai �s visszaker�l a bej�ratra
	public void die() {
		// Elveszti a pand�it is
		breakLine();			
		if(gc!=null) {
			points-=10;
			Entrance en = gc.getEntrance();
			Tile ten = null;
			if(en!=null) {
				ten = en.getTile();
				if(ten!=null) {			
					ten.setAnimal(this);
				}
			}	
		}	
	}

	// Felbontja a panda sor�t
	public void breakLine() {
		// TODO Auto-generated method stub
		Panda pb = getBehind();
		if(pb!=null) {
			pb.breakLine();
		}
		setBehind(null);
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v, Graphics g) {
		//kirajzoltatja magat a kapott viewval
		v.drawOrangutan(tile.posX(),tile.posY(), g);
	}
	
}
