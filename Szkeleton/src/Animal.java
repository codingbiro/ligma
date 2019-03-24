
public class Animal {
	String name;
	Tile t1;
	Panda behind;
	Animal ahead;
	
	/**
	 * Konstruktor
	 * @param s 	objektum neve
	 */
	public Animal(String s) {
		name = s;
		behind = null;
		ahead = null;
	}

	/**
	 * Ez a f�ggv�ny h�v�dik meg, ha l�ptetni szeretn�nk az �llatot egy m�sik mez�re
	 * @param d 	melyik ir�nyba szeretne l�pni az �llat
	 */
	public void Move(Directions d) {
		boolean b1=true;
		boolean b2=true;
		
		System.out.println(name+" Move");
		Tile t2=t1.getNeighbour(d);
		boolean b=inLine();
		
		
		if(!b) {
			if(t2!=null) {
				Animal a2=t2.getAnimal();
				Thing th=t2.getThing();
				if(a2!=null) {
					if(th!=null) {
						b1=a2.hitBy(this);
						b2=th.hitBy(this);
					}
					else if(th==null){
						b1=a2.hitBy(this);
					}
				}
				else if(a2==null){
					if(th!=null) {
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
							Directions d2=behind.getDirection(t1);
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
				Directions d2=behind.getDirection(t1);
				behind.Move(d2);
			}
			t2.setAnimal(this);
		}
	}
	
	private void caughtBy(Animal animal) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Ez a f�ggv�ny vizsg�lja, hogy az adott �llat l�ncban van-e (van-e el�tte vagy m�g�tte m�sik �llat)
	 * @return 		igazzal t�r vissza, ha l�ncban van, ellenkez� esetben hamissal
	 */
	public boolean inLine() {
		System.out.println(name+" inLine");
		return ahead!=null;
	}
	
	/**
	 * Ez a f�ggv�ny h�v�dik meg ha egy �llat �tk�zik egy m�sik �llattal
	 * @param a		az �tk�z� �llat objektuma, amelyik bele�tk�z�tt a m�sikba
	 * @return 		igazzal t�r vissza, ha az �tk�z�s sikeres volt (vagyis ha az �tk�z� �llat elfoglalhatja a m�sik �llat hely�t), ellenkez� esetben hamissal
	 */
	public boolean hitBy(Animal a) {
		System.out.println(name+" hitBy");
	}
	
	/**
	 * Ez a f�ggv�ny �ll�tja be, hogy melyik Tile-on �ll az �llat
	 * @param t		be�ll�tand� Tile objektuma
	 */
	public void setTile(Tile t) {
		System.out.println(name+" setTile");
	}
	
	/**
	 * Ez a f�ggv�ny visszaadja, hogy melyik Tile-on �ll az �llat
	 * @return		az a Tile t�pus� objektum, amelyik �ll ez az �llat
	 */
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t1;
	}
	
	/**
	 * Ezzel a f�ggv�nnyel kaphatjuk meg, hogy ki �ll em�g�tt az �llat m�g�tt
	 * @return		m�g�tt�nk l�v� �llat objektumat adja vissza
	 */
	public Panda getBehind() {
		System.out.println(name+" getBehind");
		return behind;
	}
	
	/**
	 * Be�ll�tja, hogy �lljon m�g�tt�nk �llat
	 * @param p		be�ll�tand� �llat param�tere
	 */
	public void setBehind(Panda p) {
		System.out.println(name+" setBehind");
	}
	
	/**
	 * Ez a f�ggv�ny felel�s az�rt, hogy az �llatok meghallj�k a s�pol�st
	 */
	public void hearBeep() {
		System.out.println(name+" hearBeep");
	}
	
	/**
	 * Ez a f�ggv�ny felel�s az�rt, hogy az �llatok meghallj�k a csilingel�st
	 */
	public void hearJingle() {
		System.out.println(name+" hearJingle");
	}
	
	/**
	 * Fotel mellett elhalad� �llat elf�raszt�s��rt felel�s f�ggv�ny
	 * @param t		az a Tile amin a fotel van
	 */
	public void Exhaust(Tile t) {
		System.out.println(name+" Exhaust");
	}
	
	/**
	 * �llat hal�l��rt felel�s f�ggv�ny
	 */
	public void die() {
		System.out.println(name+" Die");
	}
	
	/**
	 * Elf�radt �llatok pihen�si idej�t cs�kkenti
	 */
	public void reduceTime() {
		System.out.println(name+" reduceTime");
	}
}
