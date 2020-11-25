package TD7.personnages;

import TD7.armes.Epee;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public class Orc extends Personnage {

	private int fureur;
	
	public Orc(String n, int f) {
		super(n);
		this.setArmeCourante(new Epee());
		this.setFureur(f);
	}

	/**
	 * @return the fureur
	 */
	public int getFureur() {
		return fureur;
	}

	/**
	 * @param fureur the fureur to set
	 */
	private void setFureur(int fureur) {
		this.fureur = fureur;
	}

}
