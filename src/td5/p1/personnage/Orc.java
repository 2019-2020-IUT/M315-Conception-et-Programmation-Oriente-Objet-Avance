package td5.p1.personnage;

import td5.p1.arme.Epée;

public class Orc extends Personnage {

	private int earSize;
	
	public Orc() {
		this(null, 0);
	}
	
	public Orc(String n, int e) {
		super(n);
		this.setEarSize(e);;
		super.setWeapon(new Epée());
	}

	public int getEarSize() {
		return earSize;
	}

	public void setEarSize(int earSize) {
		this.earSize = earSize;
	}
	
}
