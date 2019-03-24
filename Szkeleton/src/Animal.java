
// Az �llatokat reprezent�l� oszt�ly
public class Animal {
	// Az �llatok �llnak valamilyen mez�n, �llhatnak a sorban el�tt�k �s ut�nuk
	String name;
	Tile t1;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	// Az �llatok mozg�s�t le�r� f�ggv�ny
	public void Move(Direction d) {
		boolean b1=true;
		boolean b2=true;
		
		System.out.println(name+" Move");
		// A szomsz�dos mez� lek�r�se
		Tile t2=t1.getNeighbour(d);
		boolean b=inLine();
		
		
		if(!b) {
			if(t2!=null) {
				// Ha nem �ll el�tte senki �s van a v�lasztott ir�nyban szomsz�dos mez� akkor elk�ri az azon �ll� dolgot �s �llatot
				Animal a2=t2.getAnimal();
				Thing th=t2.getThing();
				if(a2!=null) {
					if(th!=null) {
						// Ha �llat �s dolog is van
						b1=a2.hitBy(this);
						b2=th.hitBy(this);
					}
					// Ha csak �llat van
					else if(th==null){
						b1=a2.hitBy(this);
					}
				}
				else if(a2==null){
					if(th!=null) {
						// Ha csak t�rgy van
						b2=th.hitBy(this);
					}
				}
				
				if(b1&&b2) {
					t1.setAnimal(null);
					if(behind!=null) {
						if(a2!=null) {
							a2.caughtBy(this);
						}
						else if(a2==null){
							Direction d2=behind.getDirection(t1);
							behind.Move(d2);
						}
					}
					t2.setAnimal(this);
				}
			}
		}
		else if(b){
			t1.setAnimal(null);
			if(behind!=null) {
				Direction d2=behind.getDirection(t1);
				behind.Move(d2);
			}
			t2.setAnimal(this);
		}
	}
	
	public boolean inLine() {
		System.out.println(name+" inLine");
		return ahead!=null;
	}
	
	public boolean hitBy(Animal a) {
		System.out.println(name+" hitBy");
	}
	
	public void setTile(Tile t) {
		System.out.println(name+" setTile");
	}
	
	public Panda getBehind() {
		System.out.println(name+" getBehind");
		return behind;
	}
	
	public void setBehind(Panda p) {
		System.out.println(name+" setBehind");
	}
	
	public void hearBeep() {
		System.out.println(name+" hearBeep");
	}
	
	public void hearJingle() {
		System.out.println(name+" hearJingle");
	}
	
	public Tile getTile() {
		System.out.println(name+" getTile");
		return t1;
	}
	
	public void Exhaust(Tile t) {
		System.out.println(name+" Exhaust");
	}
	
	public void die() {
		System.out.println(name+" Die");
	}
	
	public void reduceTime() {
		System.out.println(name+" reduceTime");
	}
}
