import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void OrangutanMovesToEmptyTile() {

		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesToEmptyTile() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p.Move(Direction.RIGHT);
	}
	
	public static void OrangutanMovesToEmptyWeakTile() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		WeakTile wt = new WeakTile("wt");
		wt.life = 1;
		t1.setAnimal(o);
		t1.setThing(null);
		wt.setAnimal(null);
		wt.setThing(null);
		t1.setNeighbour(Direction.RIGHT, wt);
		wt.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesToEmptyWeakTile() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		WeakTile wt = new WeakTile("wt");
		wt.life = 1;
		t1.setAnimal(p);
		t1.setThing(null);
		wt.setAnimal(null);
		wt.setThing(null);
		t1.setNeighbour(Direction.RIGHT, wt);
		wt.setNeighbour(Direction.LEFT, t1);
		p.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesIntoPanda() {
		Panda p1 = new Panda("p1");
		Panda p2 = new Panda("p2");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(p1);
		t1.setThing(null);
		t2.setAnimal(p2);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p1.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesIntoOrangutan() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Orangutan o = new Orangutan("o");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(o);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p.Move(Direction.RIGHT);
	}
	
	public static void OrangutanMovesIntoOrangutan() {
		Orangutan o1 = new Orangutan("o1");
		Orangutan o2 = new Orangutan("o2");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o1);
		t1.setThing(null);
		t2.setAnimal(o2);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o1.Move(Direction.RIGHT);
	}
	
	public static void OrangutanMovesIntoPanda() {
		Orangutan o = new Orangutan("o");
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(p);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	
	//starting ini 8/14
	public static void OrangutanMovesIntoInlinePanda() {
		Orangutan o = new Orangutan("o");
		Orangutan o2 = new Orangutan("o2");
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(p);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);		
		p.setAhead(o2);
		o2.setBehind(p);
		o.Move(Direction.RIGHT);
	}
	
	public static void OrangutanMovesWithPandaChain() {
		Orangutan o = new Orangutan("o");
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		t1.setAnimal(o);
		t1.setThing(null);
		t3.setAnimal(p);
		t3.setThing(null);
		t2.setAnimal(null);
		t2.setThing(null);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		t3.setNeighbour(Direction.UP, t1);
		t1.setNeighbour(Direction.DOWN, t3);
		o.setBehind(p);
		p.setAhead(o);
		p.setBehind(null);
		o.Move(Direction.RIGHT);
	}
	
	//Animal moves to Tile with Thing
	public static void OrangutanMovesToTileWithVendingMachine() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		VendingMachine vm = new VendingMachine("vm");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(vm);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	public static void OrangutanMovesToTileWithArmchair() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Armchair ac = new Armchair("ac");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(ac);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	public static void OrangutanMovesToTileWithSlotMachine() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		SlotMachine sm = new SlotMachine("sm");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(sm);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesToTileWithArmchair() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Armchair ac = new Armchair("ac");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(ac);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p.Move(Direction.RIGHT);
	}
	
	public static void PandaMovesToTileWithVendingMachine() {
		Panda p = new Panda("p");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		SlotMachine sm = new SlotMachine("sm");
		t1.setAnimal(p);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(sm);
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p.Move(Direction.RIGHT);
	}
	
	//Animal moves to Tile with Wardrobe
	public static void OrangutanMovesToTileWithWardrobe() {
		Orangutan o = new Orangutan("o");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Wardrobe w1 = new Wardrobe("w1");
		Wardrobe w2 = new Wardrobe("w2");
		t1.setAnimal(o);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(w1);
		t3.setThing(w2);
		t3.setAnimal(null);
		w1.w2 = w2;
		w2.w2 = w1;
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		o.Move(Direction.RIGHT);
		
	}
	
	public static void OrangutanMovesToExit() {
		Orangutan o = new Orangutan("o");
		o.setBehind(null);
		Tile t1 = new Tile("t1");
		
		t1.setAnimal(o);
		t1.setThing(null);
		
		Exit ex = new Exit("ex");
		Tile t2 = new Tile("t2");
		t2.setAnimal(null);
		t2.setThing(ex);
		t2.setNeighbour(Direction.LEFT, t1);
		t1.setNeighbour(Direction.RIGHT, t2);
		
		GameController gc = new GameController("gc");
		Entrance en = new Entrance("en");
		Tile t3 = new Tile("t3");
		
		t3.setAnimal(null);
		t3.setThing(en);
		
		gc.e = en;
		ex.g = gc;
		
		
		o.Move(Direction.RIGHT);
	}
	
	public static void PandaInChainMovesToExit() {
		Panda p1 = new Panda("p1");
		
		Exit ex = new Exit("ex");
		Tile t1 = new Tile("t1");
		Tile t2 = new Tile("t2");		
		t1.setAnimal(p1);
		t1.setThing(null);
		t2.setAnimal(null);
		t2.setThing(ex);
		
		GameController gc = new GameController("gc");
		ex.g = gc;
		
		t1.setNeighbour(Direction.RIGHT, t2);
		t2.setNeighbour(Direction.LEFT, t1);
		p1.Move(Direction.RIGHT);
	}
	public static void VendingMachingBeepsOnJumperPanda() {
		VendingMachine vm = new VendingMachine("vm");
		Tile tvm = new Tile("tvm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		JumperPanda jp = new JumperPanda("jp");
		tvm.setThing(vm);
		tvm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(jp);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tvm.setNeighbour(Direction.RIGHT, t2);
		tvm.setNeighbour(Direction.LEFT, t3);
		tvm.setNeighbour(Direction.UP, t4);
		tvm.setNeighbour(Direction.DOWN, t5);

		vm.beep();
		
	}
	//endof ini 14/14
	
	public static void VendingMachingBeepsOnOrangutan() {
		VendingMachine vm = new VendingMachine("vm");
		Tile tvm = new Tile("tvm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		tvm.setThing(vm);
		tvm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tvm.setNeighbour(Direction.UP, t2);
		tvm.setNeighbour(Direction.DOWN, t3);
		tvm.setNeighbour(Direction.RIGHT, t4);
		tvm.setNeighbour(Direction.LEFT, t5);

		vm.beep();
		
	}
	
	public static void VendingMachingBeepsOnPanda() {
		VendingMachine vm = new VendingMachine("vm");
		Tile tvm = new Tile("tvm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		tvm.setThing(vm);
		tvm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(p);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tvm.setNeighbour(Direction.UP, t2);
		tvm.setNeighbour(Direction.DOWN, t3);
		tvm.setNeighbour(Direction.RIGHT, t4);
		tvm.setNeighbour(Direction.LEFT, t5);
		vm.beep();
		
	}
	
	public static void ArmchairChecksTired(boolean inLine) {
		Armchair ac = new Armchair("ac");
		Tile tac = new Tile("tac");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		TiredPanda tp = new TiredPanda("tp");
		Panda pb = new Panda("pb");
		Orangutan o = new Orangutan("o");
		if(inLine) {
			tp.setAhead(o);
			o.setBehind(tp);
			tp.setBehind(pb);
			pb.setAhead(tp);
		}
		tac.setThing(ac);
		tac.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(tp);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tac.setNeighbour(Direction.UP, t2);
		tac.setNeighbour(Direction.DOWN, t3);
		tac.setNeighbour(Direction.RIGHT, t4);
		tac.setNeighbour(Direction.LEFT, t5);
		ac.check();
		
	}
	
	public static void ArmchairChecksPanda() {
		Armchair ac = new Armchair("ac");
		Tile tac = new Tile("tac");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		tac.setThing(ac);
		tac.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(p);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tac.setNeighbour(Direction.UP, t2);
		tac.setNeighbour(Direction.DOWN, t3);
		tac.setNeighbour(Direction.RIGHT, t4);
		tac.setNeighbour(Direction.LEFT, t5);
		ac.check();
		
	}
	
	public static void ArmchairChecksOrangutan() {
		Armchair ac = new Armchair("ac");
		Tile tac= new Tile("tac");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		tac.setThing(ac);
		tac.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tac.setNeighbour(Direction.UP, t2);
		tac.setNeighbour(Direction.DOWN, t3);
		tac.setNeighbour(Direction.RIGHT, t4);
		tac.setNeighbour(Direction.LEFT, t5);
		ac.check();
		
	}
	
	public static void SlotMachineJinglesAfraid(boolean inLine) {
		SlotMachine sm = new SlotMachine("sm");
		Tile tsm = new Tile("tsm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		AfraidPanda ap = new AfraidPanda("ap");
		Panda pb = new Panda("pb");
		Orangutan o = new Orangutan("o");
		if(inLine) {
			ap.setAhead(o);
			o.setBehind(ap);
			ap.setBehind(pb);
			pb.setAhead(ap);
		}
		tsm.setThing(sm);
		tsm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(ap);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tsm.setNeighbour(Direction.UP, t2);
		tsm.setNeighbour(Direction.DOWN, t3);
		tsm.setNeighbour(Direction.RIGHT, t4);
		tsm.setNeighbour(Direction.LEFT, t5);
		
		sm.jingle();
		
	}
	
	public static void SlotMachineJinglesPanda() {
		SlotMachine sm = new SlotMachine("sm");
		Tile tsm = new Tile("tsm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Panda p = new Panda("p");
		tsm.setThing(sm);
		tsm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(p);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tsm.setNeighbour(Direction.UP, t2);
		tsm.setNeighbour(Direction.DOWN, t3);
		tsm.setNeighbour(Direction.RIGHT, t4);
		tsm.setNeighbour(Direction.LEFT, t5);
		sm.jingle();
		
	}
	
	public static void SlotMachineJinglesOrangutan() {
		SlotMachine sm = new SlotMachine("sm");
		Tile tsm = new Tile("tsm");
		Tile t2 = new Tile("t2");
		Tile t3 = new Tile("t3");
		Tile t4 = new Tile("t4");
		Tile t5 = new Tile("t5");
		Orangutan o = new Orangutan("o");
		tsm.setThing(sm);
		tsm.setAnimal(null);
		t2.setThing(null);
		t2.setAnimal(o);
		t3.setThing(null);
		t3.setAnimal(null);
		t4.setThing(null);
		t4.setAnimal(null);
		t5.setThing(null);
		t5.setAnimal(null);
		tsm.setNeighbour(Direction.UP, t2);
		tsm.setNeighbour(Direction.DOWN, t3);
		tsm.setNeighbour(Direction.RIGHT, t4);
		tsm.setNeighbour(Direction.LEFT, t5);
		sm.jingle();
		
	}
	
	public static void TileBreaksWithOrangutan(boolean inLine) {
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
		o.g = g;
		wt.setAnimal(o);
		
	}
	
	public static void TileBreaksWithPanda(boolean inLine) {
		Panda p = new Panda("p");
		Panda pb = new Panda("pb");
		Tile wt = new WeakTile("wt");
		Orangutan o = new Orangutan("o");
		if(inLine) {
			p.setAhead(o);
			o.setBehind(p);
			p.setBehind(pb);
			pb.setAhead(p);
		}
		wt.setThing(null);
		wt.setAnimal(p);
		
	}

	public static void main(String[] args) {
		String cmd = null;
		String p = null;
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        Globals.tab = 0;
        while(true) {
        	System.out.println("A megfelelõ teszthez írd be a megfelelõ számot!");
        	System.out.println("1. Orangutan moves to empty Tile");
        	System.out.println("2. Panda moves to empty Tile");
        	System.out.println("3. Orangutan moves to empty WeakTile");
        	System.out.println("4. Panda moves to empty WeakTile");
        	System.out.println("5. Panda moves into Panda");
        	System.out.println("6. Panda moves into Orangutan");
        	System.out.println("7. Orangutan moves into Orangutan");
        	System.out.println("8. Orangutan moves into Panda");
        	System.out.println("9. Orangutan moves into Panda2");
        	System.out.println("10. Orangutan moves with Panda Chain");
        	System.out.println("Orangutan moves to Tile with Thing(11-14)");
        	System.out.println("11.Orangutan Moves To Tile With VendingMachine");
        	System.out.println("12. Orangutan moves to Tile with Wardrobe");
        	System.out.println("13. Orangutan Moves To Tile With Armchair");
        	System.out.println("14. Orangutan Moves To Tile With SlotMachine");
        	System.out.println("15. OrangutanMovesToExit");
        	System.out.println("16. PandaInChainMovesToExit");
        	System.out.println("17. VendingMachingBeepsOnJumperPanda");
        	System.out.println("18. VendingMachingBeepsOnOrangutan");
        	System.out.println("19. VendingMachingBeepsOnPanda");
        	System.out.println("20. ArmchairChecksTired");
        	System.out.println("21. ArmchairChecksPanda");
        	System.out.println("22. ArmchairChecksOrangutan");
        	System.out.println("23. SlotMachineJinglesAfraid");
        	System.out.println("24. SlotMachineJinglesPanda");
        	System.out.println("25. SlotMachineJinglesOrangutan");
        	System.out.println("26. TileBreaksWithOrangutan");
        	System.out.println("27. TileBreaksWithPanda");
        	System.out.println("28. Exit");
        	try {
        		cmd = reader.readLine();
        	} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}  
        	
        	switch(cmd) {
    			case "1": OrangutanMovesToEmptyTile();
    			break;
    			case "2": PandaMovesToEmptyTile();
    			break;
    			case "3": OrangutanMovesToEmptyWeakTile();
    			break;
    			case "4": PandaMovesToEmptyWeakTile();
				break;
    			case "5": PandaMovesIntoPanda();
				break;
    			case "6": PandaMovesIntoOrangutan();
				break;
    			case "7": OrangutanMovesIntoOrangutan();
				break;
    			case "8": OrangutanMovesIntoPanda();
				break;
    			case "9": OrangutanMovesIntoInlinePanda();
				break;
    			case "10": OrangutanMovesWithPandaChain();
				break;
    			case "11": OrangutanMovesToTileWithVendingMachine();
				break;
    			case "12": OrangutanMovesToTileWithWardrobe();
				break;
    			case "13": OrangutanMovesToTileWithArmchair();
    			break;
    			case "14": OrangutanMovesToTileWithSlotMachine();
    			break;
    			case "15": OrangutanMovesToExit();
				break;
    			case "16": PandaInChainMovesToExit();
				break;
    			case "17": VendingMachingBeepsOnJumperPanda();
				break;
    			case "18": VendingMachingBeepsOnOrangutan();
				break;
    			case "19": VendingMachingBeepsOnPanda();
				break;
    			case "20": System.out.println("Legyen sorban a panda? (I/N)");
    			try {
					p = reader.readLine();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
    			if(p.equals("I")){
    				boolean inline = true;
    				ArmchairChecksTired(inline);
    			} else {
    				boolean inline = false;
    				ArmchairChecksTired(inline);
    			}
				break;
    			case "21": ArmchairChecksPanda();
				break;
    			case "22": ArmchairChecksOrangutan();
				break;
    			case "23": System.out.println("Legyen sorban a panda? (I/N)");
    			try {
					p = reader.readLine();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
    			if(p.equals("I")){
    				boolean inline = true;
    				SlotMachineJinglesAfraid(inline);
    			} else {
    				boolean inline = false;
    				SlotMachineJinglesAfraid(inline);
    			}
				break;
    			case "24": SlotMachineJinglesPanda();
				break;
    			case "25": SlotMachineJinglesOrangutan();
				break;
    			case "26": System.out.println("Legyen sorban a panda? (I/N)");
    			try {
					p = reader.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			if(p.equals("I")){
    				boolean inline = true;
    				TileBreaksWithOrangutan(inline);
    			} else {
    				boolean inline = false;
    				TileBreaksWithOrangutan(inline);
    			} 	
				break;
    			case "27": System.out.println("Legyen sorban a panda? (I/N)");
    			try {
					p = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			if(p.equals("I")){
    				boolean inline = true;
    				TileBreaksWithPanda(inline);
    			} else {
    				boolean inline = false;
    				TileBreaksWithPanda(inline);
    			}
				break;
    			
    			case "28": System.exit(0);
    			break;
        	}
    	}
	}
}
