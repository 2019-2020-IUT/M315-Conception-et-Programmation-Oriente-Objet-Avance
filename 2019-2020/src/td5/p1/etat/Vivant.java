package td5.p1.etat;

import td5.p1.personnage.Personnage;

public class Vivant extends PlayerState {

	public Vivant(Personnage p) {
		super(p);
	}

	public void attack(Personnage p) {
		int damage = player.getWeapon().getForce() - p.getWeapon().getProtection();
		
		if(damage != 0) {
			System.out.print(player.getNom() + player.vie() + " a attaqué " + p.getNom()  + p.vie() + ".");
			p.getDamage(damage);
			System.out.println(" " + p.getNom() + " a perdu " + damage + " HP" + p.vie() + "!");
		} else {
			System.out.println(player.getNom() + " a attaqué " + p.getNom() + ". " + p.getNom() + " n'a pris aucun dégats.");
		}
		
	}
	
}
