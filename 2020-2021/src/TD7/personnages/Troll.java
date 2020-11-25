package TD7.personnages;

import TD7.armes.Dague;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public class Troll extends Personnage {

	private String regen;
	
	public Troll(String n, String r) {
		super(n);
		this.setArmeCourante(new Dague());
		this.setRegen(r);
	}

	public String getRegen() {
		return regen;
	}

	private void setRegen(String regen) {
		this.regen = regen;
	}

}
