package td5.p1;

import td5.p1.arme.*;

public class ModernWeaponFactory extends WeaponFactory {
	
	public ModernWeaponFactory() {
		super();
	}
	
	public Arme createWeapon(String t, String n) {
		Arme a;
		switch (t) {
		case "Epee":
			a = new Epée(n);
			break;
		case "Dague":
			a = new Dague(n);
			break;
		case "Bouclier":
			a = new Bouclier(n);
			break;
		case "Fusil":
			a = new Fusil(n);
			break;
		default:
			a = null;
			break;
		}
		super.ajoute(a);
		return a;
	}
	
	public Arme getWeapon(String n) {
		return super.getWeapon(n);
	}
}
