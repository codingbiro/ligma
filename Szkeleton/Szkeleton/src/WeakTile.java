
public class WeakTile extends Tile {
	int life = 0;
	public WeakTile(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void decreaseLife() {
		life--;
	}
	public void decreaseLife(boolean set) {		
	}
	
	public void setAnimal(Animal a) {
		
		if(a!=null && life != 0) {
			decreaseLife();
		}
		
		if(life == 0)
			a.die();
	}
	
	public void setAnimal(Animal a, boolean set) {
		
		if(a!=null && life != 0) {
			
			decreaseLife(true);
		}
		
		if(life == 0)
			a.die();
	}
	
	public void setThing(Thing t) {
		if(t!= null) {
			t.setTile(this);
		}
		th = t;
	}
	
	public void setThing(Thing t, boolean set) {		
		if(t!= null) {
		
		t.setTile(this);
		}
		th = t;
	}

}
