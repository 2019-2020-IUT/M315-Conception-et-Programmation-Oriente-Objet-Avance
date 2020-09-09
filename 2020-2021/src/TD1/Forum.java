package TD1;

import java.util.ArrayList;
import java.util.List;

public class Forum {
	private String nom;
	private Admin admin;
	private MessageManager messageManager;
	private List<Member> member = new ArrayList<Member>();

	public Forum() {
		this(null, null, null, null);
	}
	
	public Forum(String n) {
		this(n, null, null, null);
	}
	
	public Forum(String n,Admin a, MessageManager mg, List<Member> m) {
		this.setNom(n);
		this.admin=a;
		this.messageManager=mg;
		this.member=m;
	}
	
	public void createMessage() {
		// TODO
	}

	public void createMessageManager() {
		// TODO
	}

	public void createUser() {
		// TODO
	}
	
	public void addMember(Member m) {
		this.getMembers().add(m);
	}

	
	public List<Member> getMembers() {
		return this.member;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public MessageManager getMessageManager() {
		return this.messageManager;
	}

	// Operations

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
