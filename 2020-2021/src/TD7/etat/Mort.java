package TD7.etat;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 02-12-2020 13:50
 */

import TD7.personnages.Personnage;

public class Mort extends EtatPersonnage {

	public Mort(Personnage p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double calculerDegats(Personnage p) {
		return 0;
	}
	
	@Override
	public String getEtat() {
		return super.getEtat() + "MORT";
		
	}
	
	
}
