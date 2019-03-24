
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
	
	//starting ini 8/14
	public void OrangutanMovesIntoPanda2() {
		Orangutan o = new Orangutan("o");
		Orangutan o2 = new Orangutan("o2");
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(p);
		t2.setThing(null);
		t1.setNeighbour();
		t2.setNeighbour();
		p.setAhead(o2);
		o.Move(d);
	}
	
	public void OrangutanMovesWithPandaChain() {
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
	
	//Animal moves to Tile with Thing
	public void OrangutanMovesToTileWithThing() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Thing t = new Object("t"); //Thing
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(t);
		t1.setNeighbour();
		t2.setNeighbour();
		o.Move(d);
	}
	//Animal moves to Tile with Wardrobe
	public void OrangutanMovesToTileWithWardrobe() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Wardrobe w1 = new Wardrobe("w1");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(w1);
		t1.setNeighbour();
		o.Move(d);
		//w2 ? t3.setAnimal(null);t3.setThing(w2); ?
	}
	
	public void OrangutanMovesToExit() {
		Orangutan o = new Orangutan("o");
		Exit ex = new Exit("ex");
		GameController gc = new GameController("gc"); //Entrance?
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(ex);
		
	}
	
	public void PandaInChainMovesToExit() {
		Panda p1 = new Panda("p1");
		Orangutan o = new Orangutan("o");
		p1.setAhead(o);
		Exit ex = new Exit("ex");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		GameController gc = new GameController("gc");
		t1.setAnimal(p1);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(ex);
		t1.setNeighbour();
		t2.setNeighbour();
		p1.Move(d);
	}
	public void VendingMachingBeepsOnJumperPanda() {
		VendingMachine vm = new VendingMachine("vm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		JumperPanda p = new JumperPanda("p");
		t1.setThing(vm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		vm.beep();
		
	}
	//endof ini 14/14
	
	public void VendingMachingBeepsOnOrangutan() {
		VendingMachine vm = new VendingMachine("vm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		t1.setThing(vm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		vm.beep();
		
	}
	
	public void VendingMachingBeepsOnPanda() {
		VendingMachine vm = new VendingMachine("vm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		t1.setThing(vm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		vm.beep();
		
	}
	
	public void ArmchairChecksTired(boolean inLine) {
		Armchair ac = new Armchair("ac");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		TiredPanda tp = new TiredPanda("tp");
		Panda pb = new Panda("pb");
		if(inLine) {
			tp.setBehind(pb);
			pb.setAhead(tp);
		}
		t1.setThing(ac);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(tp);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		ac.check();
		
	}
	
	public void ArmchairChecksPanda() {
		Armchair ac = new Armchair("ac");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		t1.setThing(ac);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(p);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		ac.check();
		
	}
	
	public void ArmchairChecksOrangutan() {
		Armchair ac = new Armchair("ac");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		t1.setThing(ac);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		ac.check();
		
	}
	
	public void SlotMachineJinglesAfraid(boolean inLine) {
		SlotMachine sm = new SlotMachine("sm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		AfraidPanda ap = new AfraidPanda("ap");
		Panda pb = new Panda("pb");
		if(inLine) {
			ap.setBehind(pb);
			pb.setAhead(ap);
		}
		t1.setThing(sm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(ap);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		
		sm.jingle();
		
	}
	
	public void SlotMachineJinglesPanda() {
		SlotMachine sm = new SlotMachine("sm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		t1.setThing(sm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(p);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		sm.jingle();
		
	}
	
	public void SlotMachineJinglesOrangutan() {
		SlotMachine sm = new SlotMachine("sm");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		t1.setThing(sm);
		t1.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		t1.setNeighbour();
		t2.setNeighbour();
		t3.setNeighbour();
		t4.setNeighbour();
		t5.setNeighbour();
		sm.jingle();
		
	}
	
	public void TileBreaksWithOrangutan(boolean inLine) {
		GameController g = new GameController("g");
		Orangutan o = new Orangutan("o");
		Panda pb = new Panda("pb");
		Tile wt = new WeakTile("wt");
		Entrance en = new Entrance("en");
		Tile ten = new Tile("ten");
		if(inLine) {
			o.setBehind(pb);
			pb.setAhead(o);
		}	
		wt.setThing(null);
		ten.setThing(en);
		ten.setAnimal(null);
		g.e = en;
		wt.setAnimal(o);
		
	}
	
	public void TileBreaksWithPanda(boolean inLine) {
		Panda p = new Panda("p");
		Panda pb = new Panda("pb");
		Tile wt = new WeakTile("wt");
		if(inLine) {
			p.setBehind(pb);
			pb.setAhead(p);
		}
		wt.setThing(null);
		wt.setAnimal(p);
		
	}

}
