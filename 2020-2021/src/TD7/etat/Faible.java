package TD7.etat;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 02-12-2020 13:50
 */

import TD7.personnages.Personnage;

public class Faible extends EtatPersonnage {

	public Faible(Personnage p) {
		super(p);
	}

	@Override
	public double calculerDegats(Personnage p) {
		return (getPersonnage().getForce() - (p.getProtection()*(1-(1.0/p.getHp()))));
	}
	
	@Override
	public String getEtat() {
		return super.getEtat() + "FAIBLE";
		
	}
}
