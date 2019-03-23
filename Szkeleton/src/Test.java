
public class Test {
	public void OrangutanMovesToEmptyTile() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		o.Move(d);
	}
	
	public void PandaMovesToEmptyTile() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		p.Move(d);
	}
	
	public void OrangutanMovesToEmptyWeakTile() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		WeakTile wt = new WeakTile("wt");
		t1.setAnimal(o);
		t1.setThing(null);
		wt.setAnimal(null);
		wt.setThing(null);
		t1.setNeighbour();
		wt.setNeighbour();
		o.Move(d);
	}
	
	public void PandaMovesToEmptyWeakTile() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		WeakTile wt = new WeakTile("wt");
		t1.setAnimal(p);
		t1.setThing(null);
		wt.setAnimal(null);
		wt.setThing(null);
		t1.setNeighbour();
		wt.setNeighbour();
		p.Move(d);
	}
	
	public void PandaMovesIntoPanda() {
		Panda p1 = new Panda("p1");
		Panda p2 = new Panda("p2");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(p1);
		t1.setThing(null);
		t2.setAnimal(p2);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		p1.Move(d);
	}
	
	public void PandaMovesIntoOrangutan() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Orangutan o = new Orangutan("o");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(o);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		p.Move(d);
	}
	
	public void OrangutanMovesIntoOrangutan() {
		Orangutan o1 = new Orangutan("o1");
		Orangutan o2 = new Orangutan("o2");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o1);
		t1.setThing(null);
		t2.setAnimal(o2);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		o1.Move(d);
	}
	
	public void OrangutanMovesIntoPanda() {
		Orangutan o = new Orangutan("o");
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(p);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		o.Move(d);
	}
}
