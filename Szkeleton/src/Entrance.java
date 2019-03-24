
public class Entrance extends Thing{

	/**
	 * Konstruktor
	 * @param s		objektum neve
	 */
	public Entrance(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t;
	}
	
	/**
	 * Ez a függvény ütközteti az orángutánt a bejárattal
	 * @param o		bejáratba ütközõ orángután objektuma
	 * @return		igazzal tér vissza ha sikeres az ütközés, ellenkezõ esetben hamissal
	 */
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy");
	}

}
