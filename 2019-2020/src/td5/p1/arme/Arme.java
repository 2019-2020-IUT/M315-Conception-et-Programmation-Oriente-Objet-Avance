package td5.p1.arme;

public class Arme {

	private int force;
	private int protection;
	private String nom;
	
	public Arme() {
		this(0, 0, null);
	}
	
	public Arme(String n) {
		this(0, 0, n);
	}
	
	public Arme(int f, int p, String n) {
		this.setForce(f);
		this.setProtection(p);
		this.setNom(n);
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arme other = (Arme) obj;
		if (force != other.force)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (protection != other.protection)
			return false;
		return true;
	}
	
}
