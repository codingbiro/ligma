
// A f�l�s pand�kat reprezent�l� oszt�ly
public class AfraidPanda extends Panda{

	public AfraidPanda(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	// Ha csilingel�st hall megijed �s elszak�tja a l�ncot
	public void hearJingle() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" hearJingle");
		breakLine();
		Globals.tab--;
	}

}
