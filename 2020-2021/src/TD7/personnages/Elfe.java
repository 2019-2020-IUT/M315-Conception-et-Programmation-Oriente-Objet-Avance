package TD7.personnages;

import TD7.armes.Epee;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public class Elfe extends Personnage {

	private String accuite;
	
	public Elfe(String n, String a) {
		super(n);
		this.setArmeCourante(new Epee());
		this.setAccuite(a);
	}

	/**
	 * @param accuite the accuite to set
	 */
	private void setAccuite(String accuite) {
		this.accuite = accuite;
	}

	/**
	 * @return the accuite
	 */
	public String getAccuite() {
		return accuite;
	}

}
