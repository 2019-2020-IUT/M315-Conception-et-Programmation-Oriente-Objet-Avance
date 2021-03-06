package td5.p1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import td5.p1.arme.Arme;
import td5.p1.personnage.Orc;
import td5.p1.personnage.Personnage;
import td5.p1.personnage.Tauren;

public class testArmes {

	@Test
	public void test1() {
		Tauren diablon = new Tauren("Diablon", 15);
		Orc azag = new Orc("Azag", 5);

		diablon.attack(azag);
		azag.attack(diablon);
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
			assertEquals(Class.forName("td5.p1.arme.Epée"), azag.getArme().getClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

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

}
