package TD7.armes;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public abstract class Arme {
	
	private int force;
	private int protection;
	
	public Arme(int f, int p) {
		this.setForce(f);
		this.setProtection(p);
	}
	
	/**
	 * @return the force
	 */
	public int getForce() {
		return force;
	}
	/**
	 * @return the protection
	 */
	public int getProtection() {
		return protection;
	}
	/**
	 * @param force the force to set
	 */
	private void setForce(int force) {
		this.force = force;
	}
	/**
	 * @param protection the protection to set
	 */
	private void setProtection(int protection) {
		this.protection = protection;
	}


}
