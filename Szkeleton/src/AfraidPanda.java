
public class AfraidPanda extends Panda{

	/**
	 * Konstruktor
	 * @param s		objektum neve
	 */
	public AfraidPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Ez a f�ggv�ny felel�s az�rt, hogy az �llatok meghallj�k a csilingel�st
	 */
	public void hearJingle() {
		System.out.println(name+" hearJingle");
		breakLine();
	}

}
