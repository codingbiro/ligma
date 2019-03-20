
public class WeakTile extends Tile {

	public WeakTile(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void decreaseLife() {
		System.out.println(name+" decreaseLife");
	}
	
	public void setAnimal(Animal a) {
		System.out.println(name+" setAnimal");
		if(a!=null) {
			decreaseLife();
		}
		// if(life==null) elvileg tesztesetben ez 0 (?)
		a.die();
	}

}
