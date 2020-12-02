package TD7.personnages;

import java.util.ArrayList;
import java.util.List;

import TD7.armes.Arme;
import TD7.etat.EtatPersonnage;
import TD7.etat.Vivant;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

public abstract class Personnage {
	
	private String nom;
	private double maxHp;
	private double hp;
	private List<Arme> armes;
	private Arme armeCourante; 
	private EtatPersonnage etat;
	
	public Personnage(String s) {
		this.setNom(s);
		this.setMaxHp(100);
		this.setHp(this.getMaxHp());
		this.setArmes(new ArrayList<Arme>());
		this.setArmeCourante(null);
		this.setEtat(new Vivant(this));
	}

	public void vielli() {
		this.vielli(1);
	}
	
	public void vielli(int value) {
		this.setMaxHp(this.getMaxHp()-value);
	}
	
	public void ajouterArme(Arme a) {
		if(this.armeCourante != null) {
			this.armes.add(this.getArmeCourante());
		}
		this.setArmeCourante(a);
	}
	
	public int getForce() {
		return this.armeCourante.getForce();
	}
	
	public int getProtection() {
		return this.armeCourante.getProtection();
	}
	
	private void getDamage(double a) {
		double calcul = this.hp - a;
		
		if(calcul <= 0) {
			this.setHp(0);
		} else {
			this.setHp(calcul);
		}
	}
	
	public void attaquer(Personnage p) {
		double damage = this.getEtat().calculerDegats(p);
			if(damage > 0) {
				System.out.print(this.getNom() + "(" + this.getHp() + ")" + " a attaqué " + p.getNom()  + "(" + p.getHp() + ")" + ".");
				p.getDamage(damage);
				System.out.println(" " + p.getNom() + " a perdu " + damage + " HP " + "(" + p.getHp() + ")!");
				System.out.println(p.getNom() + " est maintenant " + this.getEtat());
			} else {
				System.out.println(this.getNom() + " a attaqué " + p.getNom() +" et n'a pris aucun dégats.");
			}
		this.getEtat().verifierEtatCourant(p);
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	private void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the hp
	 */
	public double getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	private void setHp(double hp) {
		this.hp = hp;
	}

	/**
	 * @return the maxHp
	 */
	public double getMaxHp() {
		return maxHp;
	}

	/**
	 * @param maxHp the maxHp to set
	 */
	private void setMaxHp(double maxHp) {
		this.maxHp = maxHp;
	}

	/**
	 * @return the armes
	 */
	public List<Arme> getArmes() {
		return armes;
	}

	/**
	 * @return the armeCourante
	 */
	public Arme getArmeCourante() {
		return armeCourante;
	}

	/**
	 * @param armes the armes to set
	 */
	private void setArmes(List<Arme> armes) {
		this.armes = armes;
	}

	/**
	 * @param armeCourante the armeCourante to set
	 */
	protected void setArmeCourante(Arme armeCourante) {
		this.armeCourante = armeCourante;
	}

	/**
	 * @return the etat
	 */
	public EtatPersonnage getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatPersonnage etat) {
		this.etat = etat;
	}
	
	
}
