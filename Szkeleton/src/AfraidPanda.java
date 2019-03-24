
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
	 * Ez a függvény felelõs azért, hogy az állatok meghallják a csilingelést
	 */
	public void hearJingle() {
		System.out.println(name+" hearJingle");
		breakLine();
	}

}
