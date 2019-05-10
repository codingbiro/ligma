
// Az �llatokat reprezent�l� oszt�ly
/**
 * @author Kevin
 *
 */
public abstract class Animal implements IViewable {
	// Az �llatok �llnak valamilyen mez�n, �llhatnak a sorban el�tt�k �s ut�nuk
	Tile tile;
	Panda behind;
	Animal ahead;
	public String random;

	// Az �llatok mozg�s�t jel�l� absztrakt f�ggv�ny
	public abstract void Move(Direction d);
	
	// A sorban �ll�st vizsg�l� f�ggv�ny
	public boolean inLine() {
		return ahead!=null;
	} 
	
	// Az �llatok pand�val val� �tk�z�s�t jel�l� absztrakt f�ggv�ny
	public abstract boolean hitBy(Panda p);
	
	// Az �llatok or�ngut�nnal val� �tk�z�s�t jel�l� absztrakt f�ggv�ny
	public abstract boolean hitBy(Orangutan o);
	
	// A pand�k elkap�s�t jel�li, az implement�ci� a panda oszt�lyban
	public void caughtBy(Animal a) {
		return;
	}
	
	// A mez� be�ll�t�sa
	public void setTile(Tile t) {
		tile=t;
	}
	
	// Az �llat m�g�tti panda lek�r�se
	public Panda getBehind() {
		return behind;
	}
	
	// // Az �llat el�tti panda be�ll�t�sa
	public void setBehind(Panda p) {
		this.behind = p;		
	}
	
	// Ha sima �llat s�pol�st hall nem csin�l semmit
	public void hearBeep() {
	}
	
	// Ha sima �llat csilingel�st hall nem csin�l semmit
	public void hearJingle() {
	}
	
	// A mez� visszaad�sa
	public Tile getTile() {
		return tile;
	}
	
	// Ha sima �llatot elf�rasztj�k nem t�rt�nik semmi
	public void Exhaust(Tile t) {
	}
	
	// Elpusztul�st jel�l� absztrakt met�dus
	public abstract void die();
	
	// A pihen�si id�t cs�kkent� f�ggv�ny, sima �llatn�l nem csin�l semmit
	public void reduceTime() {
	}
	//ezen keresztul kap felkerest, hogy rajzoltassa ki magat a view-al
	public void shouldDraw(View v) {
		
	}
}
