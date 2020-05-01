package td5.p1.personnage;

import td5.p1.arme.Bouclier;

public class Tauren extends Personnage {

	private int hornSize;
	
	public Tauren() {
		this(null, 0);
	}
	
	public Tauren(String n, int c) {
		super(n);
		this.setHornSize(c);
		super.setWeapon(new Bouclier());
	}

	public int getHornSize() {
		return hornSize;
	}

	public void setHornSize(int hornSize) {
		this.hornSize = hornSize;
	}
}
