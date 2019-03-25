
// A félõs pandákat reprezentáló osztály
public class AfraidPanda extends Panda{

	public AfraidPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingelést hall megijed és elszakítja a láncot
	public void hearJingle() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hearJingle");
		breakLine();
		Globals.tab--;
	}

}
