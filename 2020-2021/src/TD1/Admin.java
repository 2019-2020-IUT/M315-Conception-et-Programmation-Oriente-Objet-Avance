package TD1;

public class Admin {

    private String nom;
    private Forum forum;

    public Admin() {
    	this(null, null);
    }
    
    public Admin(String n, Forum f) {
    	this.setNom(n);
    	this.setForum(f);
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

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
