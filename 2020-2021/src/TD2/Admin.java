package TD2;

public class Admin {

    private String nom;
    private Forum forum;

    public Admin() {
    	this(null,null);
    }

    public Admin(String n, Forum f) {
    	this.setNom(n);
    	this.forum = f;
    }

    public void knowMembers() {
        System.out.println(this.forum.getMembers().toString());
    }

    public int knowMembersCount() {
    	return this.forum.getMembers().size();
    }

    public Forum getForum() {
        return this.forum;
    }

	public void addForum(Forum forum) {
		this.forum = forum;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
}