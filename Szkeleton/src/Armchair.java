
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
	 * Ez a f�ggv�ny ellen�rzi, hogy van-e a fotel k�zel�ben AfraidPanda
	 * Ha van ilyen panda a k�zelben, akkor azt le�lteti a fotelbe
	 */
	public void check() {
		System.out.println(name+" check");
	}

}
