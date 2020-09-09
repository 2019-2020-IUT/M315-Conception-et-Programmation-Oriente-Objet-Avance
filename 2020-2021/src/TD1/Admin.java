package TD1;

public class Admin {

    private String nom;

    public Admin() {
    	this(null);
    }
    
    public Admin(String n) {
    	this.nom = n;
    }
    
    //                          Operations                                  
    
    public void knowMembers() {
        //TODO
    }
    
    
    public String getForum() {
        return this.nom;
    }
    
    public void setForum(String n) {
        this.nom = n;
    }
}
