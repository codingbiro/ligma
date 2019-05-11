import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Map {
	// A pályát alkotó csempék
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public void init() {
		//Mezok allatok, thingek letrehozasa, elhelyezese
		//Tile with orangutan
		Tile to1 = new Tile(37,32);
		Orangutan o1 = new Orangutan();
		//game controller beallitasa az orangutannak
		o1.gc = Globals.gc;
		to1.setAnimal(o1);
		tiles.add(to1);
		//Tile with entrance
		Tile ten = new Tile(35,60);
		Entrance en = new Entrance();
		Globals.gc.e = en;
		ten.setThing(en);
		tiles.add(ten);
		//Tile with orangutan
		Tile to2 = new Tile(16,84);
		Orangutan o2 = new Orangutan();
		//game controller beallitasa az orangutannak
		o2.gc = Globals.gc;
		to2.setAnimal(o2);
		tiles.add(to2);
		//basic tiles
		tiles.add(new Tile(55,38));
		tiles.add(new Tile(34,91));
		tiles.add(new Tile(64,54));
		tiles.add(new Tile(63,72));
		tiles.add(new Tile(51,86));
		tiles.add(new Tile(43,105));
		//tile with TiredPanda
		Tile ttp = new Tile(77,39);
		Panda tp = new TiredPanda();
		//hozzaadjuk a gamecontroller pandaihoz
		Globals.gc.pandas.add(tp);
		ttp.setAnimal(tp);
		tiles.add(ttp);
		//basic tile
		tiles.add(new Tile(74,87));
		//WeakTile
		tiles.add(new WeakTile(62,102));
		//Tile with Wardrobe
		Tile twr1 = new Tile(61,121);
		Wardrobe wr1 = new Wardrobe();
		twr1.setThing(wr1);
		tiles.add(twr1);
		//basic tiles
		tiles.add(new Tile(94,34));
		tiles.add(new Tile(93,65));
		//Tile with panda
		Tile tp1 = new Tile(91,94);
		Panda p1 = new Panda();
		//hozzaadjuk a gamecontroller pandaihoz
		Globals.gc.pandas.add(p1);
		tp1.setAnimal(p1);
		tiles.add(tp1);
		//basic tiles
		tiles.add(new Tile(80,108));
		tiles.add(new Tile(80,127));
		//tile with JumperPanda
		Tile tjp = new Tile(112,41);
		Panda jp = new JumperPanda();
		//hozzaadjuk a gamecontroller pandaihoz
		Globals.gc.pandas.add(jp);
		tjp.setAnimal(jp);
		tiles.add(tjp);
		//basic tiles
		tiles.add(new Tile(111,89));
		//Tile with vending machine
		Tile tvm = new Tile(108,120);
		tvm.setThing(new VendingMachine());
		tiles.add(tvm);
		//basic tile
		tiles.add(new Tile(131,36));
		//Tile with SlotMachine
		Tile tsm = new Tile(131,65);
		tsm.setThing(new SlotMachine());
		tiles.add(tsm);
		//basic tiles
		tiles.add(new Tile(129,94));
		tiles.add(new Tile(138,111));
		tiles.add(new Tile(138,129));
		tiles.add(new Tile(149,43));
		tiles.add(new Tile(159,59));
		//Tile with panda
		Tile tp2 = new Tile(159,77);
		Panda p2 = new Panda();
		//hozzaadjuk a gamecontroller pandaihoz
		Globals.gc.pandas.add(p2);
		tp2.setAnimal(p2);
		tiles.add(tp2);
		//basic tiles
		tiles.add(new Tile(147,91));
		//WeakTile
		tiles.add(new WeakTile(156,106));
		//basic tiles
		tiles.add(new Tile(155,124));
		tiles.add(new Tile(161,28));
		tiles.add(new Tile(171,45));
		tiles.add(new Tile(168,92));
		//Tile with AfraidPanda
		Tile tap = new Tile(174,112);
		Panda ap = new AfraidPanda();
		//hozzaadjuk a gamecontroller pandaihoz
		Globals.gc.pandas.add(ap);
		tap.setAnimal(ap);
		tiles.add(tap);
		//Tile with Armchair
		Tile tar = new Tile(174,131);
		tar.setThing(new Armchair());
		tiles.add(tar); 
		//basic tiles
		tiles.add(new Tile(178,23));
		tiles.add(new Tile(189,39));
		//Tile with exit
		Tile tex = new Tile(190,65);
		tex.setThing(new Exit());
		tiles.add(tex);
		//basic tile
		tiles.add(new Tile(186,99));
		//Tile with Wardrobe
		Tile twr2 = new Tile(203,94);
		Wardrobe wr2 = new Wardrobe();
		//wardrobeok beallitasa egymas parjanak
		wr2.wrPair = wr1;
		wr1.wrPair = wr2;
		twr2.setThing(wr2);
		tiles.add(twr2); 
		
		//mezo szomszedok beallitasa
		for(int i = 0; i < tiles.size(); i++) {
			switch(i) {
				case 0://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(3));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(1));
					break;
				case 1://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(0));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(3));
					tiles.get(i).setNeighbour(Direction.THREE, tiles.get(5));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(6));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(7));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(4));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(2));
					break;
				case 2://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(1));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(4));
					break;
				case 3://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(5));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(1));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(0));
					break;
				case 4://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(1));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(7));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(8));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(2));
					break;
				case 5://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(9));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(6));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(1));
					break;
				case 6://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(5));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(10));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(7));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(1));
					break;
				case 7://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(6));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(11));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(4));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(1));
					break;
				case 8://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(11));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(4));
					break;
				case 9://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(13));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(5));
					break;
				case 10://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(15));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(11));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(6));
					break;
				case 11://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(10));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(16));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(12));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(8));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(7));
					break;
				case 12://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(11));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(17));
					break;
				case 13://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(18));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(9));
					break;
				case 14://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(13));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(18));
					tiles.get(i).setNeighbour(Direction.THREE, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(19));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(15));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(10));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(6));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(5));
					tiles.get(i).setNeighbour(Direction.TEN, tiles.get(9));
					break;
				case 15://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(19));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(10));
					break;
				case 16://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(15));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(17));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(11));
					break;
				case 17://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(16));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(12));
					break;
				case 18://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(21));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(13));
					break;
				case 19://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(23));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(15));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(14));
					break;
				case 20://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(19));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(23));
					tiles.get(i).setNeighbour(Direction.THREE, tiles.get(24));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(25));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(17));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(16));
					tiles.get(i).setNeighbour(Direction.TEN, tiles.get(15));
					break;
				case 21://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(26));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(18));
					break;
				case 22://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(21));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(26));
					tiles.get(i).setNeighbour(Direction.THREE, tiles.get(27));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(28));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(29));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(23));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(19));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(14));
					tiles.get(i).setNeighbour(Direction.TEN, tiles.get(18));
					break;
				case 23://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(29));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(24));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(19));
					break;
				case 24://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.THREE, tiles.get(30));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(25));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(20));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(23));
					break;
				case 25://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(24));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(31));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(20));
					break;
				case 26://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(32));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(27));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(21));
					break;
				case 27://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(33));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(28));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(22));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(26));
					break;
				case 28://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(27));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(34));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(29));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(22));
					break;
				case 29://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(28));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(30));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(23));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(22));
					break;
				case 30://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(34));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(35));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(31));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(24));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(29));
					break;
				case 31://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(30));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(36));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(25));		
					break;
				case 32://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(37));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(33));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(26));
					break;
				case 33://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(38));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(27));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(32));
					break;
				case 34://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(40));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(30));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(29));
					break;
				case 35://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(40));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(36));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(30));
					break;
				case 36://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(35));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(31));
					break;
				case 37://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.FOUR, tiles.get(38));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(32));
					break;
				case 38://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(33));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(37));
					break;
				case 39://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(38));
					tiles.get(i).setNeighbour(Direction.FIVE, tiles.get(41));
					tiles.get(i).setNeighbour(Direction.SIX, tiles.get(40));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(34));
					tiles.get(i).setNeighbour(Direction.EIGHT, tiles.get(28));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(27));
					tiles.get(i).setNeighbour(Direction.TEN, tiles.get(33));
					break;
				case 40://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.ONE, tiles.get(39));
					tiles.get(i).setNeighbour(Direction.TWO, tiles.get(41));
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(35));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(34));
					break;
				case 41://a palyanak megfelelo szomszedok beallitasa
					tiles.get(i).setNeighbour(Direction.SEVEN, tiles.get(40));
					tiles.get(i).setNeighbour(Direction.NINE, tiles.get(39));
					break;
				default: 
					System.out.println("hiba a mezok tombjeben");
					break;
			}
		}
	}
	
}
