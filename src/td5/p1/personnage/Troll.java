package td5.p1.personnage;

import td5.p1.arme.Dague;

public class Troll extends Personnage {

	private String favouriteBeer;
	
	public Troll() {
		this(null, null);
	}
	
	public Troll(String n, String b) {
		super(n);
		this.setFavouriteBeer(b);
		super.setWeapon(new Dague());
	}

	public String getFavouriteBeer() {
		return favouriteBeer;
	}

	public void setFavouriteBeer(String favouriteBeer) {
		this.favouriteBeer = favouriteBeer;
	}
}
