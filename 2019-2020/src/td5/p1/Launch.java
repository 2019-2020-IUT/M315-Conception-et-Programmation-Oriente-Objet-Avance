package td5.p1;

import td5.p1.personnage.Orc;
import td5.p1.personnage.Tauren;

public class Launch {

	public static void main(String[] args) {
		
 		Tauren diablon = new Tauren("Diablon", 15);
		Orc azag = new Orc("Azag", 5);
		
		diablon.attack(azag);
		azag.attack(diablon);
		
		azag.setHp(15);
		
		System.out.println(azag.getState());
		System.out.println(diablon.getState());
		

		
	}
	
	
}
