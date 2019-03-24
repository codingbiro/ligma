
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
	 * Ez a f�ggv�ny �tk�zteti az or�ngut�nt a bej�rattal
	 * @param o		bej�ratba �tk�z� or�ngut�n objektuma
	 * @return		igazzal t�r vissza ha sikeres az �tk�z�s, ellenkez� esetben hamissal
	 */
	public boolean hitBy(Orangutan o) {
		System.out.println(name+" hitBy");
	}

}
