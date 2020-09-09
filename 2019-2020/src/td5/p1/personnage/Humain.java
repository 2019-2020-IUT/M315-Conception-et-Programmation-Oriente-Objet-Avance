package td5.p1.personnage;

import td5.p1.arme.Epée;

public class Humain extends Personnage {

	private String eyeColor;
	
	public Humain() {
		this(null, null);
	}
	
	public Humain(String n, String c) {
		super(n);
		this.setEyeColor(c);
		super.setWeapon(new Epée());
	}

	public String getEyeColor() {
		return this.eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
}
