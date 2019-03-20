
public class GameController {
	String name;
	
	//Szkeleton
	Entrance e;

	public GameController(String s) {
		name=s;
	}
	
	public void addPoints() {
		System.out.println(name+" addPoints");
	}
	
	public void decreasePoints() {
		System.out.println(name+" decreasePoints");
	}
	
	public Entrance getEntrance() {
		System.out.println(name+" getEntrance");
		return e;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
