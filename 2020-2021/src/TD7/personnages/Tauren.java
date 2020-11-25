package TD7.personnages;

import TD7.armes.Bouclier;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public class Tauren extends Personnage {

	private int muscle;
	
	public Tauren(String n, int m) {
		super(n);
		this.setArmeCourante(new Bouclier());
		this.setMuscle(m);
	}

	/**
	 * @return the muscle
	 */
	public int getMuscle() {
		return muscle;
	}

	/**
	 * @param muscle the muscle to set
	 */
	private void setMuscle(int muscle) {
		this.muscle = muscle;
	}

}
