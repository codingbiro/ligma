import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class WeakTile extends Tile {
	int life;
	//deafult konstruktor
	public WeakTile() {
		//os konstruktor meghivasa
		super();
		//kezdo elet beallitasa
		life = 20;
	}
	//konstruktor a csempe kozepenek megadasaval egyutt
	public WeakTile(int posx, int posy){
		//os konstruktor meghivasa
		super(posx, posy);
		//kezdo elet beallitasa
		life = 20;
	}
	
	// �lettartam cs�kkent�se
	public void decreaseLife() {
		life--;
	}
	
	// Or�ngut�n be�ll�t�sa
	public void setAnimal(Orangutan a) {		
		if(a!=null && life != 0) {
			// Ha r�l�pnek akkor cs�kken az �lettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha el�ri az �lettartam a 0-t akkor a csempe elt�rik
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}
	}
	
	// Panda be�ll�t�sa
		public void setAnimal(Panda a) {		
		if(a!=null && life != 0) {
			// Ha r�l�pnek akkor cs�kken az �lettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha el�ri az �lettartam a 0-t akkor a csempe elt�rik
		if(life == 0) {
			a.die();
			//minden iranyban vegigmegyunk a szomszedokon
			for (Direction d : Direction.values()) {
				switch(d.toString()) {
				//Hogyha eltorik egy weaktile, akkor minden szomszednak
				//be kell allitani, abba a directionbe egy null negihbourz, amerre
				//a weaktile van hozza kepest
					case "TWO":
						neighbour[d.ordinal()].setNeighbour(Direction.SEVEN, null);
						break;
					case "FOUR":
						neighbour[d.ordinal()].setNeighbour(Direction.EIGHT, null);
						break;
					case "SIX":
						neighbour[d.ordinal()].setNeighbour(Direction.ONE, null);
						break;
					case "SEVEN":
						neighbour[d.ordinal()].setNeighbour(Direction.THREE, null);
						break;
					case "NINE":
						neighbour[d.ordinal()].setNeighbour(Direction.FIVE, null);
						break;
					default: break;
				}
				//a weaktilenak is beallitjuk nullra a neighbourjeit
				this.setNeighbour(d, null);
			}	
		}	
	}
	
		// T�rgy be�ll�t�sa
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	// �lettartam be�ll�t�sa
	public void setLife(int l) {
		life = l;
	}
	
	//kirajzol�hoz megnezi hogy van e elete, hogy kell e x-et rajzolni
	public boolean hasLife() {
		return life!=0;
	}	
	
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v, Graphics g) {
		if(!hasLife())
			//ha eltorott a csempe, akkor kirajzoltatja az eltorest a view-al
			v.drawWeakTileBroken(posX(),posY(), g);		
		if(a != null)
			//jelzi a rajta allo allatnak hogy ki kell ot rajzolni
			a.shouldDraw(v, g);
	}

}
