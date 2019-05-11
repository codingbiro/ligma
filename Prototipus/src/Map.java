import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Map {
	// A pályát alkotó csempék
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	// Új pálya létrehozása
	public Map() {
		//40 darab tile hozzaadasa a tombhoz
		for(int i = 0; i < 40; i++) {
			tiles.add(new Tile());
		}
		/*
		//1 bejarat
		Tile t.setThing(new Entrance());
		//1 kijarat
		Tile t.th = new Exit();
		//1 jatekgep
		Tile t.th = new SlotMachine();
		//1 csokiautomata
		Tile t.th = new VendingMachine();
		//1 fotel
		Tile t.th = new Armchair();
		//2 szekreny
		Tile t.th = new Wardrobe();
		Tile t.th = new Wardrobe();
		
		//2 orangutan
		Tile t.setAnimal(new Orangutan());
		Tile t.a = new Orangutan();
		//5 panda (2 sima, 3 kulonleges)
		Tile t.a = new Panda();
		Tile t.a = new Panda();
		Tile t.a = new AfraidPanda();
		Tile t.a = new JumperPanda();
		Tile t.a = new TiredPanda();
		*/
		//2 darab weaktile hozzaadasa a tombhoz
		tiles.add(new WeakTile());
		tiles.add(new WeakTile());
	}
	
}
