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
	
	// Élettartam csökkentése
	public void decreaseLife() {
		life--;
	}
	
	// Orángután beállítása
	public void setAnimal(Orangutan a) {		
		if(a!=null && life != 0) {
			// Ha rálépnek akkor csökken az élettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha eléri az élettartam a 0-t akkor a csempe eltörik
		if(life == 0) {
			a.die();
			for (Direction d : Direction.values()) {
				this.setNeighbour(d, null);
			}	
		}
	}
	
	// Panda beállítása
		public void setAnimal(Panda a) {		
		if(a!=null && life != 0) {
			// Ha rálépnek akkor csökken az élettartam
			decreaseLife();
			a.setTile(this);
			this.a=a;
		}
		
		// Ha eléri az élettartam a 0-t akkor a csempe eltörik
		if(life == 0) {
			a.die();
			//negighbouroknek be kel allitani hogy a weak tileos neighborjuk null legyen
			for (Direction d : Direction.values()) {
				//mindig az ellentetes oldalu neighbour lesz a weaktile
				switch(d.toString()) {
				//TODO: Ha kesz a map akkor lehet ezt megmondani
				//A problema az, hogyha eltorik egy weaktile, akkor minden szomszednak
				//be kell allitani, abba a directionbe egy null negihbour, amerre
				//a weaktile van hozza kepest
				/*
					case "ONE":
						neighbour[d.ordinal()].setNeighbour(Direction.ONE, null);
					break;*/
				}
				//a weaktilenak is beallitjuk nullra a neighbourjeit
				this.setNeighbour(d, null);
			}	
		}	
	}
	
		// Tárgy beállítása
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	// Élettartam beállítása
	public void setLife(int l) {
		life = l;
	}
	
	//kirajzolához megnezi hogy van e elete, hogy kell e x-et rajzolni
	public boolean hasLife() {
		return life!=0;
	}	
	
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		if(!hasLife())
			//ha eltorott a csempe, akkor kirajzoltatja az eltorest a view-al
			v.drawWeakTileBroken();		
		if(a != null)
			//jelzi a rajta allo allatnak hogy ki kell ot rajzolni
			a.shouldDraw(v);
	}

}
