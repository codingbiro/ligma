
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
	 * Ez a függvény hívódik meg, ha léptetni szeretnénk az állatot egy másik mezõre
	 * @param d 	melyik irányba szeretne lépni az állat
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
	 * Ez a függvény vizsgálja, hogy az adott állat láncban van-e (van-e elõtte vagy mögötte másik állat)
	 * @return 		igazzal tér vissza, ha láncban van, ellenkezõ esetben hamissal
	 */
	public boolean inLine() {
		System.out.println(name+" inLine");
		return ahead!=null;
	}
	
	/**
	 * Ez a függvény hívódik meg ha egy állat ütközik egy másik állattal
	 * @param a		az ütközõ állat objektuma, amelyik beleütközött a másikba
	 * @return 		igazzal tér vissza, ha az ütközés sikeres volt (vagyis ha az ütközõ állat elfoglalhatja a másik állat helyét), ellenkezõ esetben hamissal
	 */
	public boolean hitBy(Animal a) {
		System.out.println(name+" hitBy");
	}
	
	/**
	 * Ez a függvény állítja be, hogy melyik Tile-on áll az állat
	 * @param t		beállítandó Tile objektuma
	 */
	public void setTile(Tile t) {
		System.out.println(name+" setTile");
	}
	
	/**
	 * Ez a függvény visszaadja, hogy melyik Tile-on áll az állat
	 * @return		az a Tile típusú objektum, amelyik áll ez az állat
	 */
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t1;
	}
	
	/**
	 * Ezzel a függvénnyel kaphatjuk meg, hogy ki áll emögött az állat mögött
	 * @return		mögöttünk lévõ állat objektumat adja vissza
	 */
	public Panda getBehind() {
		System.out.println(name+" getBehind");
		return behind;
	}
	
	/**
	 * Beállítja, hogy álljon mögöttünk állat
	 * @param p		beállítandó állat paramétere
	 */
	public void setBehind(Panda p) {
		System.out.println(name+" setBehind");
	}
	
	/**
	 * Ez a függvény felelõs azért, hogy az állatok meghallják a sípolást
	 */
	public void hearBeep() {
		System.out.println(name+" hearBeep");
	}
	
	/**
	 * Ez a függvény felelõs azért, hogy az állatok meghallják a csilingelést
	 */
	public void hearJingle() {
		System.out.println(name+" hearJingle");
	}
	
	/**
	 * Fotel mellett elhaladó állat elfárasztásáért felelõs függvény
	 * @param t		az a Tile amin a fotel van
	 */
	public void Exhaust(Tile t) {
		System.out.println(name+" Exhaust");
	}
	
	/**
	 * Állat haláláért felelõs függvény
	 */
	public void die() {
		System.out.println(name+" Die");
	}
	
	/**
	 * Elfáradt állatok pihenési idejét csökkenti
	 */
	public void reduceTime() {
		System.out.println(name+" reduceTime");
	}
}
