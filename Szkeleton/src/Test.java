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
	public static void OrangutanMovesIntoPanda2() {
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
	
	public static void OrangutanMovesWithPandaChain() {
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
	public static void OrangutanMovesToTileWithThing() {
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
	public static void OrangutanMovesToTileWithWardrobe() {
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
	
	public static void OrangutanMovesToExit() {
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
	
	public static void PandaInChainMovesToExit() {
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
	public static void VendingMachingBeepsOnJumperPanda() {
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
	
	public static void VendingMachingBeepsOnOrangutan() {
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
	
	public static void VendingMachingBeepsOnPanda() {
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
	
	public static void ArmchairChecksTired(boolean inLine) {
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
	
	public static void ArmchairChecksPanda() {
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
	
	public static void ArmchairChecksOrangutan() {
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
	
	public static void SlotMachineJinglesAfraid(boolean inLine) {
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
	
	public static void SlotMachineJinglesPanda() {
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
	
	public static void SlotMachineJinglesOrangutan() {
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
		wt.setAnimal(o);
		
	}
	
	public static void TileBreaksWithPanda(boolean inLine) {
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

	public static void main(String[] args) {
		String cmd = null;
		String p = null;
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        
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
        	System.out.println("11. Orangutan moves to Tile with Thing");
        	System.out.println("12. Orangutan moves to Tile with Wardrobe");
        	System.out.println("13. OrangutanMovesToExit");
        	System.out.println("14. PandaInChainMovesToExit");
        	System.out.println("15. VendingMachingBeepsOnJumperPanda");
        	System.out.println("16. VendingMachingBeepsOnOrangutan");
        	System.out.println("17. VendingMachingBeepsOnPanda");
        	System.out.println("18. ArmchairChecksTired");
        	System.out.println("19. ArmchairChecksPanda");
        	System.out.println("20. ArmchairChecksOrangutan");
        	System.out.println("21. SlotMachineJinglesAfraid");
        	System.out.println("22. SlotMachineJinglesPanda");
        	System.out.println("23. SlotMachineJinglesOrangutan");
        	System.out.println("24. TileBreaksWithOrangutan");
        	System.out.println("25. TileBreaksWithPanda");
        	System.out.println("26. Exit");
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
    			case "9": OrangutanMovesIntoPanda2();
				break;
    			case "10": OrangutanMovesWithPandaChain();
				break;
    			case "11": OrangutanMovesToTileWithThing();
				break;
    			case "12": OrangutanMovesToTileWithWardrobe();
				break;
    			case "13": OrangutanMovesToExit();
				break;
    			case "14": PandaInChainMovesToExit();
				break;
    			case "15": VendingMachingBeepsOnJumperPanda();
				break;
    			case "16": VendingMachingBeepsOnOrangutan();
				break;
    			case "17": VendingMachingBeepsOnPanda();
				break;
    			case "18": System.out.println("Legyen sorban a panda? (I/N)");
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
    			case "19": ArmchairChecksPanda();
				break;
    			case "20": ArmchairChecksOrangutan();
				break;
    			case "21": System.out.println("Legyen sorban a panda? (I/N)");
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
    			case "22": SlotMachineJinglesPanda();
				break;
    			case "23": SlotMachineJinglesOrangutan();
				break;
    			case "24": System.out.println("Legyen sorban a panda? (I/N)");
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
    			case "25": System.out.println("Legyen sorban a panda? (I/N)");
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
    			case "26": System.exit(0);
    			break;
        	}
    	}
	}
}
