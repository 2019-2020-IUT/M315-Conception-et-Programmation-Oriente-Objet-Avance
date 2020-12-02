package TD7;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 02-12-2020 13:50
 */

import java.util.HashMap;
import java.util.Map;

import TD7.armes.Arme;
import TD7.armes.Bouclier;
import TD7.armes.Dague;
import TD7.armes.Epee;

public class WeaponFactory {
	
	private Map<String, Arme> armes;
	
	public WeaponFactory() {
		this.armes = new HashMap<String, Arme>();
	}
	
	public Arme createWeapon(String typeArme, String nomArme) {
		Arme a;
		switch (typeArme) {
		case "SWORD":
			a = new Epee();
			armes.put(nomArme, a);
			break;
		case "DAGGER":
			a = new Dague();
			armes.put(nomArme, a);
			break;
		case "SHIELD":
			a = new Bouclier();
			armes.put(nomArme, a);
			break;
		default:
			a = null;
			break;
		}
		return a;
	}
	
	public Arme getWeapon(String nom) {
		return armes.get(nom);
	}
	
}
