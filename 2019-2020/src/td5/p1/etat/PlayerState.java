package td5.p1.etat;

import td5.p1.personnage.Personnage;

public class PlayerState {

	protected Personnage player;
	
	public PlayerState(Personnage p) {
		this.player = p;
	}
	
	public void attack(Personnage p) {
		
	}

	public void checkState(Personnage p) {
		checkAlive(p);
		checkFaible(p);
		checkMort(p);
	}
	
	protected static void checkMort(Personnage p) {
		if(p.getHp() <= 0 ) {
			p.setState(new Mort(p));
		}
	}
	
	protected static void checkFaible(Personnage p) {
		if((p.getHp() <= 25) && (p.getHp() > 0)) {
			p.setState(new Faible(p));
		}
	}
	
	protected static void checkAlive(Personnage p) {
		if(p.getHp() >= 25) {
			p.setState(new Vivant(p));
		}
	}
	
}
