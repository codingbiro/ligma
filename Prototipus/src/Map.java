import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class Map {
	// A p�ly�t alkot� csemp�k
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	// �j p�lya l�trehoz�sa
	public Map() {
		//40 darab tile hozzaadasa a tombhoz
		for(int i = 0; i < 40; i++) {
			tiles.add(new Tile());
		}
		//2 darab weaktile hozzaadasa a tombhoz
		tiles.add(new WeakTile());
		tiles.add(new WeakTile());
	}
	
}
