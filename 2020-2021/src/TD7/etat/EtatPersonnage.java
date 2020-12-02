package TD7.etat;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 02-12-2020 13:50
 */

import TD7.personnages.Personnage;

public abstract class EtatPersonnage {

	private static Personnage personnage;
	
	public EtatPersonnage(Personnage p) {
		this.setPersonnage(p);
	}
	
	public double calculerDegats(Personnage p) {
		//redefined into concrete class
		return 0;
	}
	
	public void verifierEtatCourant(Personnage p) {
		verifierMort(p);
		verifierFaible(p);
		verifierVivant(p);
	}
	
	private static void verifierMort(Personnage p) {
		if(getPersonnage().getHp() <= 0) {
			getPersonnage().setEtat(new Mort(p));
		}
	}
	
	private static void verifierFaible(Personnage p) {
		if((getPersonnage().getHp() <= 25) && (getPersonnage().getHp() > 0)) {
			getPersonnage().setEtat(new Faible(p));
		}
	}
	
	private static void verifierVivant(Personnage p) {
		if(getPersonnage().getHp() >= 25) {
			getPersonnage().setEtat(new Vivant(p));
		}
	}

	public String getEtat() {
		return "";
	}
	
	/**
	 * @return the personnage
	 */
	protected static Personnage getPersonnage() {
		return personnage;
	}

	/**
	 * @param personnage the personnage to set
	 */
	private void setPersonnage(Personnage personnage) {
		EtatPersonnage.personnage = personnage;
	}

	
}
