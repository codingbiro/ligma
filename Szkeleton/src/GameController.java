
public class GameController {
	String name;
	
	//Szkeleton
	Entrance e;

	public GameController(String s) {
		name=s;
	}
	
	public void addPoints() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" addPoints");
		Globals.tab--;
	}
	
	public void decreasePoints() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" decreasePoints");
		Globals.tab--;
	}
	
	public Entrance getEntrance() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" getEntrance");
		Globals.tab--;
		return e;
	}
	
	
	

}
