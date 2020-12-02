package TD7;

/**
 * @ Author: CrewmateGroup (Kitabdjian Léo - Longuemare Hugo - Rizzo Michael - Srifi Pauline)
 * @ Copyright: Creative Common 4.0 (CC BY 4.0)
 * @ Create Time: 25-11-2020 13:50
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import TD7.armes.Arme;
import TD7.personnages.Elfe;
import TD7.personnages.Orc;
import TD7.personnages.Personnage;
import TD7.personnages.Tauren;



public class testArmes {

	@Test
	public void testPartie1() {
		Tauren diablon = new Tauren("Diablon", 15);
		Orc azag = new Orc("Azag", 5);

		diablon.attaquer(azag);
		azag.attaquer(diablon);
		assertEquals(100, azag.getHp());
		assertEquals(95, diablon.getHp());
	}

	
	@Test
	public void test2() {
		WeaponFactory wf = new WeaponFactory();
		Arme w = wf.createWeapon("SWORD", "excalibur");
		Arme w1 = wf.getWeapon("excalibur");
		assertEquals(w, w1);
		Personnage azag = new Orc("Azag", 5);
		try {
			assertEquals(Class.forName("TD7.armes.Epee"), azag.getArmeCourante().getClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void test3() {
		Elfe a = new Elfe("a", "3");
		Elfe b = new Elfe("b", "3");
		
		for (int i = 0; i < 5; ++i) {
			a.attaquer(b);
		}
	}
	
	/*
	@Test
	public void test3() {
		WeaponFactory wp = new WeaponFactory();
		WeaponFactory wp2 = new ModernWeaponFactory();
		String nom = "Ref";
		int i = 0;
		Arme a1 = wp.createWeapon("SWORD", nom + i);
		i++;
		Arme a2 = wp2.createWeapon("Dague", nom + i);
		i++;
		Arme a3 = wp2.createWeapon("Fusil", nom + i);
		i++;
		Arme a4 = wp2.createWeapon("Missil", nom + i); // Type non reconnu
		assertTrue(a1 != null);
		assertTrue(a2 != null);
		assertTrue(a3 != null);
		assertTrue(a4 == null);
		assertEquals(a1, wp.getWeapon(nom + 0)); // On retrouve une arme créée par un autre
		assertEquals(a3, wp.getWeapon(nom + 2));
	}
	*/

}
