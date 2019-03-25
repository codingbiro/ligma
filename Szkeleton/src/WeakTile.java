
public class WeakTile extends Tile {

	public WeakTile(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void decreaseLife() {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" decreaseLife");
		Globals.tab--;
	}
	
	public void setAnimal(Animal a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		System.out.println(name+" setAnimal(" + a.name + ")");
		if(a!=null) {
			decreaseLife();
		}
		// if(life==null) elvileg tesztesetben ez 0 (?)
		a.die();
		Globals.tab--;
	}

}
