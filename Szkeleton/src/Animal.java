
public class Animal {
	String name;
	Tile t1;
	Panda behind;
	Animal ahead;
	
	public Animal(String s) {
		name = s;
	}
	

	public void Move(Directions d) {
		boolean b1=true;
		boolean b2=true;
		
		System.out.println(name+" Move");
		Tile t2=t1.getNeighbour(d);
		boolean b=inLine();
		
		
		if(!b) {
			if(t2!=null) {
				Animal a2=t2.getAnimal();
				Thing th=t2.getThing();
				if(a2!=null) {
					if(th!=null) {
						b1=a2.hitBy(this);
						b2=th.hitBy(this);
					}
					else if(th==null){
						b1=a2.hitBy(this);
					}
				}
				else if(a2==null){
					if(th!=null) {
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
							Directions d2=behind.getDirection(t1);
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
				Directions d2=behind.getDirection(t1);
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
