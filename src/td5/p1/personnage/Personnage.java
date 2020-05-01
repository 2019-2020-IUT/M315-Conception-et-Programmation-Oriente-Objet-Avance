package td5.p1.personnage;

import td5.p1.arme.Arme;
import td5.p1.etat.*;

public class Personnage {

	private int hp;
	
	private String nom;
	private Arme weapon;
	private PlayerState state = new Vivant(this);
	
	public Personnage() {
		this("DefaultCharater");
	}
	
	public Personnage(String n) {
		this.setNom(n);
		this.setHp(100);
	}
	
	public void attack(Personnage p) {
		/**
		 * int damage = this.getWeapon().getForce() - p.getWeapon().getProtection();
		
		if(damage != 0) {
			System.out.print(this.getNom() + this.vie() + " a attaqué " + p.getNom()  + p.vie() + ".");
			p.getDamage(damage);
			System.out.println(" " + p.getNom() + " a perdu " + damage + " HP" + p.vie() + "!");
		} else {
			System.out.println(this.getNom() + " a attaqué " + p.getNom() + ". " + p.getNom() + " n'a pris aucun dégats.");
		}
		
		 */
		
		
	}
	
	public void getDamage(int a) {
		this.setHp(this.hp - a);
	}
	
	public String vie() {
		return " (" + this.getHp() + "/100 HP)";
	}
	
	//======================================================================================================
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Arme getWeapon() {
		return weapon;
	}

	public void setWeapon(Arme weapon) {
		this.weapon = weapon;
	}

	public Object getArme() {
		return this.getWeapon();
	}

	public PlayerState getState() {
		return state;
	}

	public void setState(PlayerState s) {
		this.state = s;
	}

}
