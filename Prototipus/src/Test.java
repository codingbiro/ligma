import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {	
	// Seg�dv�ltoz�k a program m�k�d�s�hez
	static int maxmapy; //makemap (a b)-bol 'b' merete
	static int maxmapx; //makemap (a b)-bol 'a' merete
	static ArrayList<Panda> pandas=new ArrayList<Panda>();
	static ArrayList<Orangutan> orangutans=new ArrayList<Orangutan>();
	static ArrayList<Thing> things=new ArrayList<Thing>();
	static Map map;
	static ArrayList<String> out = new ArrayList<String>();
	
	// kitiszt�tja az arraylisteket a tesztesetek k�z�tt
	public static void clear() {
		pandas.clear();
		orangutans.clear();
		things.clear();
		out.clear();
		// a tesztesetek k�z�tt reseteli a v�ltoz�kat
		Globals.g.e = null;
		map = null;
		maxmapy = 0;
		maxmapx = 0;
	}
	
	// A p�lya elk�sz�t�se para�terb�l kapott m�rettel
	public static void makemap(int a, int b) {
		maxmapy = b;
		maxmapx = a;
		map=new Map(a,b);
		for(int i=0;i<a;i++) {
			// Az �j mez�k l�trehoz�sa
			for(int j=0;j<b;j++) {
				map.tiles[i][j]=new Tile("t_" + i + "_" + j);
			}
		}
		for(int i=0;i<a;i++) {
			// Mez�k szomsz�djainak be�ll�t�sa
			for(int j=0;j<b;j++) {
				if(i>0) map.tiles[i][j].setNeighbour(Direction.UP, map.tiles[i-1][j]);
				if(j>0) map.tiles[i][j].setNeighbour(Direction.LEFT, map.tiles[i][j-1]);
				if(i<a-1) map.tiles[i][j].setNeighbour(Direction.DOWN, map.tiles[i+1][j]);
				if(j<b-1) map.tiles[i][j].setNeighbour(Direction.RIGHT, map.tiles[i][j+1]);			
			}
		}
	}
	
	// Or�ngut�n be�ll�t�sa param�ter�l kapott koordin�t�kra
	public static void setorangutan(String name, int a, int b) {
		Orangutan o = new Orangutan(name);
		o.g = Globals.g;
		orangutans.add(o);
		map.tiles[a][b].setAnimal(o);
	}
	
	// Panda be�ll�t�sa param�ter�l kapott koordin�t�kra 
	public static void setpanda(String name, int a, int b) {
		Panda p = new Panda(name);
		pandas.add(p);
		map.tiles[a][b].setAnimal(p);
	}
	
	//F�radt panda be�ll�t�sa param�ter�l kapott koordin�t�kra 
	public static void settired(String name, int a, int b) {
		TiredPanda tp = new TiredPanda(name);
		pandas.add(tp);
		map.tiles[a][b].setAnimal(tp);
	}	
	
	//Ijedt panda be�ll�t�sa param�ter�l kapott koordin�t�kra 
	public static void setafraid(String name, int a, int b) {
		AfraidPanda ap = new AfraidPanda(name);
		pandas.add(ap);
		map.tiles[a][b].setAnimal(ap);
	}
	
	//Ugr� panda be�ll�t�sa param�ter�l kapott koordin�t�kra 
	public static void setjumper(String name, int a, int b) {
		JumperPanda jp = new JumperPanda(name);
		pandas.add(jp);
		map.tiles[a][b].setAnimal(jp);
	}
	
	// �llat l�ptet�se megadott ir�nyba
	public static void step(String animal1, String direction) {
		Orangutan o1=null;
		for(int i=0;i<orangutans.size();i++) {
			if(animal1.equals(orangutans.get(i).name)) o1=orangutans.get(i);
		}
		if(o1!=null) {
			o1.Move(Direction.valueOf(direction));
		}
	}
	
	public static void setrandom(String animal, String random) {
		
	}
	
	// Panda l�ptet�se megadott ir�nyba
	public static void pandastep(String panda, String direction) {
		Panda p1 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(panda.equals(pandas.get(i).name)) p1 = pandas.get(i);
		}
		if(p1!=null) {
			p1.Move(Direction.valueOf(direction));
		}
	}
	
	// S�pol�s kiv�lt�sa a param�ter�l kapott g�pen
	public static void beep(String name) {
		for(int i = 0; i < things.size(); i++) {
			if(name.equals(things.get(i).name)){ 
				things.get(i).beep();
			}
		}
		
	}
	
	// Csilingel�s kiv�lt�sa a param�ter�l kapott g�pen
	public static void jingle(String name) {
		for(int i = 0; i < things.size(); i++) {
			if(name.equals(things.get(i).name)){ 
				things.get(i).jingle();
			}
		}
	}
	
	// Objektumok adatainak ki�r�sa egy ArrayListbe amit k�s�bb �sszehasonl�t a program az elv�rt kimenettel
	public static void stat(String name) {
		Panda p1 = null;
		Thing t = null;
		Orangutan o1 = null;
		Tile ti = null;
		// Ha panda a kapott param�ter 
		for(int i = 0; i < pandas.size(); i++) {
			if(name.equals(pandas.get(i).name)){
				p1 = pandas.get(i);
				out.addAll(p1.stat());
				return;
			}
		}
		
		// Ha or�ngut�n a kapott param�ter
		for(int i = 0; i < orangutans.size(); i++) {
			if(name.equals(orangutans.get(i).name)){ 
				o1 = orangutans.get(i);
				out.addAll(o1.stat());
				return;
			}
		}
		
		// Ha t�rgy a kapott param�ter
		for(int i = 0; i < things.size(); i++) {
			if(name.equals(things.get(i).name)){ 
				t = things.get(i);
				out.addAll(t.stat());
				return;
			}
		}
		
		// Ha csempe a kapott param�ter
		 for (int i = 0; i < maxmapx; i++) {
			for (int j = 0; j < maxmapy; j++) {
				if(name.equals(map.tiles[i][j].name)){
					ti = map.tiles[i][j];
					out.addAll(ti.stat());
					return;
				}
			}
		}

	}
	
	public static void load(String s) {
		
	}
	
	public static void save(String s) {
		
	}
	
	// Az �llat m�g�tt �ll� panda be�ll�t�sa
	public static void setbehind(String animal1, String animal2) {
		Orangutan o1 = null;
		Panda p1 = null;
		Panda p2 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(animal1.equals(pandas.get(i).name)) p1 = pandas.get(i);
			if(animal2. equals(pandas.get(i).name)) p2 = pandas.get(i);
		}
		
		for(int i = 0; i < orangutans.size(); i++) {
			if(animal1.equals(orangutans.get(i).name)) {o1 = orangutans.get(i);}
		}
		
		// orangutan moge kerul a panda
		if(o1 != null && p2 != null){			
			o1.setBehind(p2);
		// panda moge kerul a panda
		} else if(o1 == null && p1 != null && p2 != null){
			p1.setBehind(p2);
		}
	}
	
	// Az �llat el�tt �ll� �llat be�ll�t�sa
	public static void setahead(String animal1, String animal2) {
		Panda p1 = null;
		Panda p2 = null;
		Orangutan o1 = null;
		for(int i = 0; i < pandas.size(); i++) {
			if(animal1.equals(pandas.get(i).name)) p1 = pandas.get(i);
			if(animal2. equals(pandas.get(i).name)) p2 = pandas.get(i);
		}
		
		for(int i = 0; i < orangutans.size(); i++) {
			if(animal2.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		// a panda orangutant allit be maga ele
		if(p1 != null && o1 != null){
			p1.setAhead(o1);
		// pandat allit be maga ele a panda
		} else if(p1 != null && p2 != null && o1 == null){
			p1.setAhead(p2);
		} else System.out.println("Test::setahead nem definialt agan vagy - check source code");
	}
	
	// Elengedi a param�ter�l kapott or�ngut�n a pand�k kezeit
	public static void releasepandas(String name) {
		Orangutan o1 = null;
		for(int i = 0; i < orangutans.size(); i++) {
			if(name.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		if(o1 != null){
			o1.breakLine();
		}
	}
	
	// Gyenge csempe be�ll�t�sa a param�ter�l kapott koordin�t�kra
	public static void setweaktile(String name, int a, int b) {		
		WeakTile wt = new WeakTile(name);
		map.tiles[a][b] = wt;
		int i = a;
		int j = b;
		
		// Szomsz�dok be�ll�t�sa
		if(i>0) map.tiles[i][j].setNeighbour(Direction.UP, map.tiles[i-1][j]);
		if(j>0) map.tiles[i][j].setNeighbour(Direction.LEFT, map.tiles[i][j-1]);
		if(i<maxmapx-1) map.tiles[i][j].setNeighbour(Direction.DOWN, map.tiles[i+1][j]);
		if(j<maxmapy-1) map.tiles[i][j].setNeighbour(Direction.RIGHT, map.tiles[i][j+1]);
		for(i=0;i<maxmapx;i++) {
			for(j=0;j<maxmapy;j++) {				
				if(i>0) map.tiles[i][j].setNeighbour(Direction.UP, map.tiles[i-1][j]);
				if(j>0) map.tiles[i][j].setNeighbour(Direction.LEFT, map.tiles[i][j-1]);
				if(i<a-1) map.tiles[i][j].setNeighbour(Direction.DOWN, map.tiles[i+1][j]);
				if(j<b-1) map.tiles[i][j].setNeighbour(Direction.RIGHT, map.tiles[i][j+1]);
				
			}
		}
		
	}
	
	// Csokiautomata be�ll�t�sa a param�ter�l kapott koordin�t�kra
	public static void setvendingmachine(String name, int a, int b) {
		VendingMachine vm = new VendingMachine(name);
		things.add(vm);
		map.tiles[a][b].setThing(vm);
	}
	
	// J�t�kg�p be�ll�t�sa a param�ter�l kapott koordin�t�kra
	public static void setslotmachine(String name, int a, int b) {
		SlotMachine sm = new SlotMachine(name);
		things.add(sm);
		map.tiles[a][b].setThing(sm);
	}
	
	// Szekr�ny �s p�rja be�ll�t�sa a param�ter�l kapott koordin�t�kra
	public static void setwardrobe(String name, int a, int b, int c, int d) {
		Wardrobe w = new Wardrobe(name);
		things.add(w);
		map.tiles[a][b].setThing(w);
		
		if(c!=-1) {
			w.w2 = (Wardrobe)map.tiles[c][d].getThing();
			w.w2.w2 = w;
		}
	}
	
	// Fotel be�ll�t�sa a param�ter�l kapott koordin�t�kra
	public static void setarmchair(String name, int a, int b) {
		Armchair ar = new Armchair(name);
		things.add(ar);
		map.tiles[a][b].setThing(ar);
	}
	
	// A fotel megn�zi, hogy �ll-e mellette f�radt panda
	public static void check(String name) {
		for(int i = 0; i < things.size(); i++) {
			if(name.equals(things.get(i).name)){ 
				Thing ar = things.get(i);
				ar.check();
			}
		}
	}
	
	// Az or�ngut�n k�bults�g�t be�ll�tja, vagyis hogy mennyi id� m�lva foghat �jra pand�t
	public static void setstunned(String name, int a) {
		Orangutan o1 = null;
		for(int i = 0; i < orangutans.size(); i++) {
			if(name.equals(orangutans.get(i).name)) o1 = orangutans.get(i);
		}
		
		if(o1 != null){
			o1.stunned = a;
		}
	}
	
	// A gyenge csempe �lethossz�t �ll�tja be
	public static void setlife(String name, int life) {
		for(int i=0;i<maxmapx;i++) {
			for(int j=0;j<maxmapy;j++) {				
				if(name.equals(map.tiles[i][j].name)){
					map.tiles[i][j].setLife(life);
				}
			}
		}
	}
	
	// A megadott koordin�t�kra be�ll�tja a kij�ratot
	public static void setexit(String name, int a, int b) {
		Exit ex = new Exit(name);
		things.add(ex);
		map.tiles[a][b].setThing(ex);
	}
	
	// A megadott koordin�t�kra be�ll�tja a bej�ratot
	public static void setentrance(String name, int a, int b) {
		Entrance en = new Entrance(name);
		Globals.g.e = en;
		things.add(en);
		map.tiles[a][b].setThing(en);
	}

	// Elv�gzi a f�jlb�l kapott kimenet �s a program �ltal adott kimenet �sszehasonl�t�s�st
	public static boolean compare(Scanner exp, ArrayList<String> out) {
		if(exp != null) {
			int i=0;
			while (exp.hasNext()) {
				if(i>=out.size()) { 
					// Ha elfogyott a program �ltal kapott kimenet de a f�jlnak m�g lenne sora
					System.out.println("A kimeneti stringnek nincs tobb sora, most kene: " + exp.nextLine());
					return false;
				}
				String line = exp.nextLine();
				System.out.println("comparing: "+ line +" and "+ out.get(i));
				if(!line.equals(out.get(i++))) return false;
			}
			// Ha egyezik minden sor �s nincs t�bb sor h�tra
			System.out.println("Sikeres teszt!");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String cmd = null;
		String p = null;
		// Ki�rja a konzolra a v�laszthat� opci�kat �s instrukci�kat
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        while(true) {
        	System.out.println("A megfelelo teszt beolvasasahoz, irja be a megfelelo szamot a 'loadcommands' utan!\n"
        			+ "(pl: loadcommands 12)\n");
        	System.out.println("1. In_VendingMachineBeepsOnPanda");
        	System.out.println("2. In_VendingMachineBeepsOnOrangutan");
        	System.out.println("3. In_VendingMachineBeepsOnJumperPandaWithWeakTile");
        	System.out.println("4. In_VendingMachineBeepsOnJumperPandaWithTile");
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
        	// A beg�pelt parancs feldarabol�sa
        	String[] parts = cmd.split(" ");
        	Scanner in = null;
        	String[] parameters = null;
        	String[] parameters2 = null;
        	// A beg�pelt parancst�l f�gg�en a megfelel� f�ggv�nyek megh�v�sa
        	switch(parts[0]) {
	        	case "l": 
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
        				if(parts.length > 3) parameters2 = parts[3].split("_");
        				else {
        					String partsx = "t_-1_-1";
        					parameters2 = partsx.split("_");
        				}
        				setwardrobe(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]), Integer.parseInt(parameters2[1]), Integer.parseInt(parameters2[2]));
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
    			case "settired":
    				parameters = parts[2].split("_");
    				settired(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;    			
    			case "setafraid":
    				parameters = parts[2].split("_");
    				setafraid(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    			break;
    			case "setjumper":
    				parameters = parts[2].split("_");
    				setjumper(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
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
	
	// Az el�re elk�sz�tett bementi f�jlok bet�lt�se a beg�pelt sorsz�m alapj�n
	public static void loadcommands(String cmd) {
		Scanner in = null;
		Scanner exp = null;
    	switch(cmd) {
			case "1": 
			try {
				in = new Scanner(new FileReader("In_VendingMachineBeepsOnPanda.txt"));
				exp = new Scanner(new FileReader("Expected_VendingMachineBeepsOnPanda.txt"));
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			break;
			case "2":
				try {
					in = new Scanner(new FileReader("In_VendingMachineBeepsOnOrangutan.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachineBeepsOnOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "3": 
				try {
					in = new Scanner(new FileReader("In_VendingMachineBeepsOnJumperPandaWithWeakTile.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachineBeepsOnJumperPandaWithWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "4": 
				try {
					in = new Scanner(new FileReader("In_VendingMachineBeepsOnJumperPandaWithTile.txt"));
					exp = new Scanner(new FileReader("Expected_VendingMachineBeepsOnJumperPandaWithTile.txt"));
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
    	
    	// A bementi f�jl �rtelmez�se
    	if(in != null) {
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] parts = line.split(" ");
				String[] parameters = null;
				String[] parameters2 = null;
				// A sor els� eleme a parancs, a t�bbi a sz�ks�ges param�terek
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
        				if(parts.length > 3) parameters2 = parts[3].split("_");
        				else {
        					String partsx = "t_-1_-1";
        					parameters2 = partsx.split("_");
        				}
        				setwardrobe(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]), Integer.parseInt(parameters2[1]), Integer.parseInt(parameters2[2]));
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
        			case "settired":
    					parameters = parts[2].split("_");
    					settired(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
    				break;
        			case "setafraid":
        				parameters = parts[2].split("_");
        				setafraid(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
        			break;
        			case "setjumper":
        				parameters = parts[2].split("_");
        				setjumper(parts[1], Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]));
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

			int i=0;
			while(out.size()-1>=i) {
				System.out.println(out.get(i));
				i++;
			}
			// Az �sszehasonl�t�s elv�gz�se
			System.out.println("Az elvart es a kapott kimenet osszehasonlitasa:");
			if(!compare(exp, out)) System.out.println("Hiba a tesztesetben");
			exp.close();
			
    	}
    	// A tesztesetek k�zti resetel�s elv�gz�se
    	clear();
	}
}
