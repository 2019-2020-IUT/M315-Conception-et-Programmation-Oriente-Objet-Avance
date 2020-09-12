package TD1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Forum {
	private String nom;
	private Admin admin;
	private MessageManager mg;
	private List<Member> member = new ArrayList<Member>();
	private List<Message> lmsg = new ArrayList<Message>();
	
	public Forum(String n, MessageManager msgManager) {
		this.setNom(n);
		this.setMessageManager(msgManager);
	}
	
	public void createMessageManager() {
		this.mg = new MessageManager();
	}
	
	public Message createMessage(String content, Member auth) {
		return this.getMessageManager().createMessage(content, auth);
	}

	public void addMessage(Message msg) {
		this.getLmsg().add(msg);
	}

	public void createUser(String name) {
		this.addMember(new Member(name));
	}
	
	protected void addMember(Member m) {
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
		return this.mg;
	}
	
	private void setMessageManager(MessageManager msgManager) {
		this.mg = msgManager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Message> getLmsg() {
		return this.lmsg;
	}
	
	public List<Message> getLatestmsg(Member m) {
		List<Message> l = new ArrayList<Message>();
		for (Message msg : this.getLmsg()) {
			if(msg.getCreationDate().compareTo(Date.from(Instant.now() )) <= 10) {
				l.add(msg);
			}
		}
		m.lireMessage(l);
		return l;
	}

}
