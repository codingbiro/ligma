
public class Armchair extends Thing{

	/**
	 * Konstruktor
	 * @param s		objektum neve
	 */
	public Armchair(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Ez a függvény ellenõrzi, hogy van-e a fotel közelében AfraidPanda
	 * Ha van ilyen panda a közelben, akkor azt leülteti a fotelbe
	 */
	public void check() {
		System.out.println(name+" check");
	}

}
