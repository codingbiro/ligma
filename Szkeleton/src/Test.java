import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static ArrayList<Panda> pandas=new ArrayList<Panda>();
	static ArrayList<Orangutan> orangutans=new ArrayList<Orangutan>();
	static ArrayList<Thing> things=new ArrayList<Thing>();
	static AfraidPanda af=new AfraidPanda("a1");
	static JumperPanda jp=new JumperPanda("j1");
	static TiredPanda tp=new TiredPanda("t1");
	static Armchair ar=new Armchair("ac");
	static Entrance en=new Entrance("e");
	static Exit ex=new Exit("ex");
	static GameController gc=new GameController("gc");
	static Map map;
	static SlotMachine sm=new SlotMachine("sm");
	static VendingMachine vm=new VendingMachine("vm");
	static Wardrobe w=new Wardrobe("w");
	static WeakTile wt=new WeakTile("wt");
	
	static ArrayList<String> out = new ArrayList<String>();
	
	public static void init() {
		pandas.add(new Panda("p1"));
		pandas.add(new Panda("p2"));
		pandas.add(new Panda("p3"));
		
		orangutans.add(new Orangutan("o1"));
		orangutans.add(new Orangutan("o2"));
		
		things.add(new Thing("th"));
		
	}
	
	public static void clear() {
		pandas.clear();
		orangutans.clear();
		things.clear();
	}
	
	public static void makemap(int a, int b) {
		map=new Map(a,b);
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				map.tiles[i][j]=new Tile("t");
			}
		}
	}
	
	public static void setorangutan(String s, int a, int b) {
		Orangutan o1 = null;
		for(int i = 0; i < orangutans.size(); i++){
			if(s.equals(orangutans.get(i).name)) o1=orangutans.get(i);
		}
		if(o1 != null)
			map.tiles[a][b].setAnimal(o1);
	}
	
	public static void setpanda(String s, int a, int b) {
		Panda p1 = null;
		for(int i = 0; i < pandas.size(); i++){
			if(s.equals(pandas.get(i).name)) p1=pandas.get(i);
		}
		if(p1 != null)
			map.tiles[a][b].setAnimal(p1);
	}
	
	public static void step(String s, String s2) {
		Orangutan o1=null;
		for(int i=0;i<orangutans.size();i++) {
			if(s.equals(orangutans.get(i).name)) o1=orangutans.get(i);
		}
		if(o1!=null) {
			o1.Move(Direction.valueOf(s2));
		}
	}
	
	public static void setrandom(String s, String s2) {
		
	}
	
	public static void pandastep(String s, String s2) {
		Panda p1 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(s.equals(pandas.get(i).name)) p1 = pandas.get(i);
		}
		if(p1!=null) {
			p1.Move(Direction.valueOf(s2));
		}
	}
	
	public static void beep(String s) {
		vm.beep();
	}
	
	public static void jingle(String s) {
		sm.jingle();
	}
	
	public static void stat(String s) {
		Panda p1 = null;
		Thing t = null;
		Orangutan o1 = null;
		Tile ti = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(s.equals(pandas.get(i).name)){
				p1 = pandas.get(i);
				out.add(p1.stat());
				return;
			}
		}
		
		for(int i = 0; i < orangutans.size(); i++) {
			if(s.equals(orangutans.get(i).name)){ 
				o1 = orangutans.get(i);
				out.add(o1.stat());
				return;
			}
		}
		
		for(int i = 0; i < things.size(); i++) {
			if(s.equals(things.get(i).name)){ 
				t = things.get(i);
				out.add(t.stat());
				return;
			}
		}
		
		 for (int i = 0; i < map.tiles.length; i++) {
			for (int j = 0; j < map.tiles[i].length; j++) {
				if(s.equals(map.tiles[i][j].name)){
					ti = map.tiles[i][j];
					out.add(ti.stat());
					return;
				}
			}
		}

	}
	
	public static void load(String s) {
		
	}
	
	public static void save(String s) {
		
	}
	
	public static void setbehind(String s, String s2) {
		Orangutan o1 = null;
		Panda p1 = null;
		Panda p2 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(s.equals(pandas.get(i).name)) p1 = pandas.get(i);
			if(s2. equals(pandas.get(i).name)) p2 = pandas.get(i);
		}
		
		for(int i = 0; i < orangutans.size(); i++) {
			if(s.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		// orángután mögé kerül a panda
		if(o1 != null && p1 == null && p2 != null){
			o1.setBehind(p2);
		// panda mögé kerül a panda
		} else if(o1 == null && p1 != null && p2 != null){
			p1.setBehind(p2);
		}
	}
	
	public static void setahead(String s, String s2) {
		Panda p1 = null;
		Panda p2 = null;
		Orangutan o1 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(s.equals(pandas.get(i).name)) p1 = pandas.get(i);
			if(s2. equals(pandas.get(i).name)) p2 = pandas.get(i);
		}
		
		for(int i = 0; i < orangutans.size(); i++) {
			if(s.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		// orángutánt állít be maga elé a panda
		if(p1 != null && p2 == null && o1 != null){
			p1.setAhead(o1);
		// pandát állít be maga elé a panda
		} else if(p1 != null && p2 != null && o1 == null){
			p1.setAhead(p2);
		}
	}
	
	public static void releasepandas(String s) {
		Orangutan o1 = null;
		for(int i = 0; i < orangutans.size(); i++) {
			if(s.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		if(o1 != null){
			o1.breakLine();
		}
	}
	
	public static void setweaktile(String s, int a, int b) {
		map.tiles[a][b] = wt;
	}
	
	public static void setvendingmachine(String s, int a, int b) {
		map.tiles[a][b].setThing(vm);
	}
	
	public static void setslotmachine(String s, int a, int b) {
		map.tiles[a][b].setThing(sm);
	}
	
	public static void setwardrobe(String s, int a, int b) {
		map.tiles[a][b].setThing(w);
	}
	
	public static void setarmchair(String s, int a, int b) {
		map.tiles[a][b].setThing(ar);
	}
	
	public static void check(String s) {
		ar.check();
	}
	
	public static void setstunned(String s, int a) {
		Orangutan o1 = null;
		for(int i = 0; i < orangutans.size(); i++) {
			if(s.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		if(o1 != null){
			o1.stunned = a;
		}
	}
	
	public static void setlife(String s, int a) {
		wt.life = a;
	}
	
	public static void setexit(String s, int a, int b) {
		map.tiles[a][b].setThing(ex);
	}
	
	public static void setentrance(String s, int a, int b) {
		map.tiles[a][b].setThing(en);
	}


	public static boolean compare(Scanner exp, ArrayList<String> out) {
		if(exp != null) {
			int i=0;
			while (exp.hasNext()) {
				if(i>=out.size()) return false;
				String line = exp.nextLine();
				if(!line.equals(out.get(i++))) return false;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		init();
		String cmd = null;
		String p = null;
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        while(true) {
        	System.out.println("A megfelelo teszt beolvasasahoz, irja be a megfelelo szamot a 'loadcommands' utan!\n"
        			+ "(pl: loadcommands 12)\n");
        	System.out.println("1. In_VendingMachingBeepsOnPanda");
        	System.out.println("2. In_VendingMachingBeepsOnOrangutan");
        	System.out.println("3. In_VendingMachingBeepsOnJumperPandaWithWeakTile");
        	System.out.println("4. In_VendingMachingBeepsOnJumperPandaWithTile");
        	System.out.println("5. In_TileBreaksWithSingleOrangutan");
        	System.out.println("6. In_TileBreaksWithPandaInChain");
        	System.out.println("7. In_TileBreaksWithOrangutanWithPandaChain");
        	System.out.println("8. In_TileBreaksWithFreePanda");
        	System.out.println("9. In_SlotMachineJinglesPanda");
        	System.out.println("10. In_SlotMachineJinglesOrangutan");
        	System.out.println("11. In_SlotMachineJinglesFreeAfraid");
        	System.out.println("12. In_SlotMachineJinglesAfraidInChain");
        	System.out.println("13. In_SingleStunnedOrangutanMovesIntoOrangutanWithPandaChain");
        	System.out.println("14. In_SingleOrangutanMovesIntoSingleOrangutan");
        	System.out.println("15. In_SingleNon-StunnedOrangutanMovesIntoOrangutanWithPandaChain");
        	System.out.println("16. In_PandaMovesToVendingMachine");
        	System.out.println("17. In_PandaMovesToSlotMachine");
        	System.out.println("18. In_PandaMovesToEntrance");
        	System.out.println("19. In_PandaMovesToEmptyWeakTile");
        	System.out.println("20. In_PandaMovesToEmptyTile");
        	System.out.println("21. In_PandaMovesToArmchair");
        	System.out.println("22. In_PandaMovesIntoPanda");
        	System.out.println("23. In_PandaMovesIntoOrangutan");
        	System.out.println("24. In_PandaInChainMovesToWardrobe");
        	System.out.println("25. In_PandaInChainMovesToExit");
        	System.out.println("26. In_OrangutanWithPandaChainReleasesPandas");
        	System.out.println("27. In_OrangutanWithPandaChainMovesIntoSingleOrangutan");
			System.out.println("28. In_OrangutanWithPandaChainMovesIntoOrangutanWithPandaChain");
			System.out.println("29. In_OrangutanMovesWithPandaChain");
			System.out.println("30. In_OrangutanMovesToWardrobe");
			System.out.println("31. In_OrangutanMovesToVendingMachine");
			System.out.println("32. In_OrangutanMovesToSlotMachine");
			System.out.println("33. In_OrangutanMovesToExit");
			System.out.println("34. In_OrangutanMovesToEntrance");
			System.out.println("35. In_OrangutanMovesToEmptyWeakTile");
			System.out.println("36. In_OrangutanMovesToEmptyTile");
			System.out.println("37. In_OrangutanMovesToArmchair");
			System.out.println("38. In_OrangutanMovesIntoPandaInChain");
			System.out.println("39. In_OrangutanMovesIntoFreePanda");
			System.out.println("40. In_FreePandaMovesToWardrobe");
			System.out.println("41. In_FreePandaMovesToExit");
			System.out.println("42. In_ArmchairChecksTired");
			System.out.println("43. In_ArmchairChecksPanda");
			System.out.println("44. In_ArmchairChecksOrangutan");

        	System.out.println("\nKilepeshez gepelje be az 'exit' parancsot");
        	try {
        		cmd = reader.readLine();
        	} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	String[] parts = cmd.split(" ");
        	Scanner in = null;
        	String[] parameters = null;
        	switch(parts[0]) {
	        	case "loadcommands": 
	        		loadcommands(parts[1]);
				break;
	        	case "load": 
	        		load(parts[1]);
				break;
	        	case "save": 
	        		save(parts[1]);
				break;
    			case "exit": System.exit(0);
    			break;
    			case "makemap": 
    				makemap(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    			break;
    			case "setbehind":
    				setbehind(parts[1], parts[2]);
    			break;
    			case "setahead": 
    				setahead(parts[1], parts[2]);
    			break;
    			case "releasepandas":
    				releasepandas(parts[1]);
    			break;
    			case "setweaktile":
    				parameters = parts[2].split("_");
    				setweaktile(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setvendingmachine":
    				parameters = parts[2].split("_");
    				setvendingmachine(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setslotmachine":
    				parameters = parts[2].split("_");
    				setslotmachine(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setwardrobe":
    				parameters = parts[2].split("_");
    				setwardrobe(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setarmchair":
    				parameters = parts[2].split("_");
    				setarmchair(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "check":
    				check(parts[1]);
    			break;
    			case "setstunned":
    				setstunned(parts[1], Integer.parseInt(parts[2]));
    			break;
    			case "setlife":
    				setlife(parts[1], Integer.parseInt(parts[2]));
    			break;
    			case "setexit":
    				parameters = parts[2].split("_");
    				setexit(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setentrance":
    				parameters = parts[2].split("_");
    				setentrance(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setorangutan":
    				parameters = parts[2].split("_");
    				setorangutan(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setpanda":
    				parameters = parts[2].split("_");
    				setpanda(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "step":
    				step(parts[1], parts[2]);
    			break;
    			case "setrandom":
    				setrandom(parts[1], parts[2]);
    			break;
    			case "pandastep":
    				pandastep(parts[1], parts[2]);
    			break;
    			case "beep":
    				beep(parts[1]);
    			break;
    			case "jingle":
    				jingle(parts[1]);
    			break;
    			case "stat":
    				stat(parts[1]);
    			break;
    			default: break;
        	}	
        }
	}
	
	public static void loadcommands(String cmd) {
		init();
		Scanner in = null;
		Scanner exp = null;
		//System.out.println(cmd);
    	switch(cmd) {
			case "1": 
			try {
				in = new Scanner(new FileReader("In_VendingMachingBeepsOnPanda.txt"));
				exp = new Scanner(new FileReader("Expected_VendingMachingBeepsOnPanda.txt"));
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			break;
			case "2":
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachingBeepsOnOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "3": 
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnJumperPandaWithWeakTile.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachingBeepsOnJumperPandaWithWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "4": 
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnJumperPandaWithTile.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachingBeepsOnJumperPandaWithTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "5": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithSingleOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_TileBreaksWithSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "6": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithPandaInChain.txt"));
					exp = new Scanner(new FileReader("Expected_TileBreaksWithPandaInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "7": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithOrangutanWithPandaChain.txt"));
					exp = new Scanner(new FileReader("Expected_TileBreaksWithOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "8": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithFreePanda.txt"));
					exp = new Scanner(new FileReader("Expected_TileBreaksWithFreePanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "9": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesPanda.txt"));
					exp = new Scanner(new FileReader("Expected_SlotMachineJinglesPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "10": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_SlotMachineJinglesOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "11": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesFreeAfraid.txt"));
					exp = new Scanner(new FileReader("Expected_SlotMachineJinglesFreeAfraid.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "12": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesAfraidInChain.txt"));
					exp = new Scanner(new FileReader("Expected_SlotMachineJinglesAfraidInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "13": 
				try {
					in = new Scanner(new FileReader("In_SingleStunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
					exp = new Scanner(new FileReader("Expected_SingleStunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "14": 
				try {
					in = new Scanner(new FileReader("In_SingleOrangutanMovesIntoSingleOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_SingleOrangutanMovesIntoSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "15": 
				try {
					in = new Scanner(new FileReader("In_SingleNon-StunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
					exp = new Scanner(new FileReader("Expected_SingleNon-StunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "16": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToVendingMachine.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToVendingMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "17": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToSlotMachine.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToSlotMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "18": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEntrance.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToEntrance.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "19":
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEmptyWeakTile.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToEmptyWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "20": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEmptyTile.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToEmptyTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "21": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToArmchair.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesToArmchair.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "22": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesIntoPanda.txt"));
					exp = new Scanner(new FileReader("Expected_PandaMovesIntoPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "23": 
			try {
				in = new Scanner(new FileReader("In_PandaMovesIntoOrangutan.txt"));
				exp = new Scanner(new FileReader("Expected_PandaMovesIntoOrangutan.txt"));
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			break;
			case "24":
				try {
					in = new Scanner(new FileReader("In_PandaInChainMovesToWardrobe.txt"));
					exp = new Scanner(new FileReader("Expected_PandaInChainMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "25": 
				try {
					in = new Scanner(new FileReader("In_PandaInChainMovesToExit.txt"));
					exp = new Scanner(new FileReader("Expected_PandaInChainMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "26": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainReleasesPandas.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanWithPandaChainReleasesPandas.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "27": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainMovesIntoSingleOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanWithPandaChainMovesIntoSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "28": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainMovesIntoOrangutanWithPandaChain.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanWithPandaChainMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "29": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesWithPandaChain.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "30": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToWardrobe.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "31": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToVendingMachine.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToVendingMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "32": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToSlotMachine.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToSlotMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "33": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToExit.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "34": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEntrance.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToEntrance.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "35": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEmptyWeakTile.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToEmptyWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "36": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEmptyTile.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToEmptyTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "37": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToArmchair.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesToArmchair.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "38": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesIntoPandaInChain.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesIntoPandaInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "39": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesIntoFreePanda.txt"));
					exp = new Scanner(new FileReader("Expected_OrangutanMovesIntoFreePanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "40":
				try {
					in = new Scanner(new FileReader("In_FreePandaMovesToWardrobe.txt"));
					exp = new Scanner(new FileReader("Expected_FreePandaMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "41": 
				try {
					in = new Scanner(new FileReader("In_FreePandaMovesToExit.txt"));
					exp = new Scanner(new FileReader("Expected_FreePandaMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "42": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksTired.txt"));
					exp = new Scanner(new FileReader("Expected_ArmchairChecksTired.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "43": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksPanda.txt"));
					exp = new Scanner(new FileReader("Expected_ArmchairChecksPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "44": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_ArmchairChecksOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			
			case "45": System.exit(0);
			break;
    	}
    	
    	if(in != null) {
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] parts = line.split(" ");
				String[] parameters = null;
    		    switch(parts[0]) {
        			case "makemap": 
        				makemap(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        			break;
        			case "setbehind":
        				setbehind(parts[1], parts[2]);
        			break;
        			case "setahead": 
        				setahead(parts[1], parts[2]);
        			break;
        			case "releasepandas":
        				releasepandas(parts[1]);
        			break;
        			case "setweaktile":
        				parameters = parts[2].split("_");
        				setweaktile(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setvendingmachine":
        				parameters = parts[2].split("_");
        				setvendingmachine(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setslotmachine":
        				parameters = parts[2].split("_");
        				setslotmachine(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setwardrobe":
        				parameters = parts[2].split("_");
        				setwardrobe(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setarmchair":
        				parameters = parts[2].split("_");
        				setarmchair(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "check":
        				check(parts[1]);
        			break;
        			case "setstunned":
        				setstunned(parts[1], Integer.parseInt(parts[2]));
        			break;
        			case "setlife":
        				setlife(parts[1], Integer.parseInt(parts[2]));
        			break;
        			case "setexit":
        				parameters = parts[2].split("_");
        				setexit(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setentrance":
        				parameters = parts[2].split("_");
        				setentrance(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setorangutan":
        				parameters = parts[2].split("_");
        				setorangutan(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setpanda":
        				parameters = parts[2].split("_");
        				setpanda(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "step":
        				step(parts[1], parts[2]);
        			break;
        			case "setrandom":
        				setrandom(parts[1], parts[2]);
        			break;
        			case "pandastep":
        				pandastep(parts[1], parts[2]);
        			break;
        			case "beep":
        				beep(parts[1]);
        			break;
        			case "jingle":
        				jingle(parts[1]);
        			break;
        			case "stat":
        				stat(parts[1]);
        			break;
        			default: break;
    		    }
			}
			in.close();

			if(!compare(exp, out)) System.out.println("Hiba a tesztesetben");
			exp.close();
			
    	}
    	clear();
	}
}
