import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
	
	public static void makemap(int a, int b) {
		
	}
	public static void setorangutan(String s, int a, int b) {
		
	}
	public static void setpanda(String s, int a, int b) {
		
	}
	public static void step(String s, String s2) {
	
	}
	public static void setrandom(String s, String s2) {
	
	}
	public static void pandastep(String s, String s2) {
		
	}
	public static void beep(String s) {
		
	}
	public static void jingle(String s) {
		
	}
	public static void stat(String s) {
		
	}
	public static void load(String s) {
		
	}
	public static void save(String s) {
		
	}
	public static void setbehind(String s, String s2) {
		
	}
	public static void setahead(String s, String s2) {
		
	}
	public static void releasepandas(String s) {
		
	}
	public static void setweaktile(String s, int a, int b) {
		
	}
	public static void setvendingmachine(String s, int a, int b) {
		
	}
	public static void setslotmachine(String s, int a, int b) {
		
	}
	public static void setwardrobe(String s, int a, int b) {
		
	}
	public static void setarmchair(String s, int a, int b) {
		
	}
	public static void check(String s) {
		
	}
	public static void setstunned(String s, int a) {
		
	}
	public static void setlife(String s, int a) {
		
	}
	public static void setexit(String s, int a, int b) {
		
	}
	public static void setentrance(String s, int a, int b) {
		
	}


	public static void main(String[] args) {
		String cmd = null;
		String p = null;
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        Globals.tab = 0;
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
		Scanner in = null;
    	switch(cmd) {
			case "1": 
			try {
				in = new Scanner(new FileReader("In_VendingMachingBeepsOnPanda.txt"));
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			break;
			case "2":
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "3": 
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnJumperPandaWithWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "4": 
				try {
					in = new Scanner(new FileReader("In_VendingMachingBeepsOnJumperPandaWithTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "5": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "6": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithPandaInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "7": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "8": 
				try {
					in = new Scanner(new FileReader("In_TileBreaksWithFreePanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "9": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "10": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "11": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesFreeAfraid.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "12": 
				try {
					in = new Scanner(new FileReader("In_SlotMachineJinglesAfraidInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "13": 
				try {
					in = new Scanner(new FileReader("In_SingleStunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "14": 
				try {
					in = new Scanner(new FileReader("In_SingleOrangutanMovesIntoSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "15": 
				try {
					in = new Scanner(new FileReader("In_SingleNon-StunnedOrangutanMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "16": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToVendingMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "17": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToSlotMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "18": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEntrance.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "19":
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEmptyWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "20": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToEmptyTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "21": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesToArmchair.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "22": 
				try {
					in = new Scanner(new FileReader("In_PandaMovesIntoPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "23": 
			try {
				in = new Scanner(new FileReader("In_PandaMovesIntoOrangutan.txt"));
			} catch (FileNotFoundException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			break;
			case "24":
				try {
					in = new Scanner(new FileReader("In_PandaInChainMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "25": 
				try {
					in = new Scanner(new FileReader("In_PandaInChainMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "26": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainReleasesPandas.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "27": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainMovesIntoSingleOrangutan.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "28": 
				try {
					in = new Scanner(new FileReader("In_OrangutanWithPandaChainMovesIntoOrangutanWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "29": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesWithPandaChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "30": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "31": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToVendingMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "32": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToSlotMachine.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "33": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "34": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEntrance.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "35": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEmptyWeakTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "36": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToEmptyTile.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "37": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesToArmchair.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "38": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesIntoPandaInChain.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "39": 
				try {
					in = new Scanner(new FileReader("In_OrangutanMovesIntoFreePanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "40":
				try {
					in = new Scanner(new FileReader("In_FreePandaMovesToWardrobe.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "41": 
				try {
					in = new Scanner(new FileReader("In_FreePandaMovesToExit.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "42": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksTired.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "43": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksPanda.txt"));
				} catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			break;
			case "44": 
				try {
					in = new Scanner(new FileReader("In_ArmchairChecksOrangutan.txt"));
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
    	}
	}
}
