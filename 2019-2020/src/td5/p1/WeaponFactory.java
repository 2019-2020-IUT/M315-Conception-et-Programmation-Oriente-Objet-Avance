package td5.p1;

import java.util.ArrayList;

import td5.p1.arme.*;

public class WeaponFactory {

	private static ArrayList<Arme> l = new ArrayList<Arme>();

	public WeaponFactory() {
		Arme d = new Arme("Arme1");
		l.add(d);
	}

	public Arme createWeapon(String t, String n) {
		Arme a;
		switch (t) {
		case "SWORD":
			a = new Epée(n);
			break;
		case "DAG":
			a = new Dague(n);
			break;
		case "SHIELD":
			a = new Bouclier(n);
			break;
		default:
			a = new Arme(n);
			break;
		}
		l.add(a);
		return a;
	}

	public Arme getWeapon(String n) {
		boolean trouve = false;
		int i = 0;

		if (l.isEmpty()) {
			return null;
		} else {
			while (!trouve) {
				l.get(i);
				if (i < l.size()) {
					if (l.get(i).getNom().equals(n)) {
						trouve = true;
						return l.get(i);
					}
					i++;
				} else {
					return null;
				}

			}
		}
		return null;
	}

	// ==========================================================================

	public ArrayList<Arme> getL() {
		return l;
	}

	public void setL(ArrayList<Arme> l) {
		this.l = l;
	}
	
	public void ajoute(Arme a) {
		l.add(a);
	}

}
