
/**
 * @author Kevin
 *
 */
public class Map {
	// A pályát alkotó csempék
	public Tile[][] tiles;
	
	// Új pálya létrehozása
	public Map(int x, int y) {
		tiles=new Tile[x][y];
	}
	
}
