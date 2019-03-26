
public class WeakTile extends Tile {
	int life = 0;
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
	public void decreaseLife(boolean set) {		
	}
	
	public void setAnimal(Animal a) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		
		if(a!=null && life != 0) {
			System.out.println(name+" setAnimal(" + a.name + ")");
			decreaseLife();
		}
		if(a!=null) {
			System.out.println(name+" setAnimal(" + a.name + ")");			
		}
		
		if(life == 0)
			a.die();
		
		Globals.tab--;
	}
	
	public void setAnimal(Animal a, boolean set) {
		
		if(a!=null && life != 0) {
			
			decreaseLife(true);
		}
		
		if(life == 0)
			a.die();
	}
	
	public void setThing(Thing t) {
		Globals.tab++;
		for(int i = 0; i<Globals.tab; i++)
			System.out.print("\t");
		if(t!= null) {
		System.out.println(name+" setThing(" + t.name + ")");
		t.setTile(this);
		}
		th = t;
		Globals.tab--;
	}
	
	public void setThing(Thing t, boolean set) {		
		if(t!= null) {
		
		t.setTile(this);
		}
		th = t;
	}

}
