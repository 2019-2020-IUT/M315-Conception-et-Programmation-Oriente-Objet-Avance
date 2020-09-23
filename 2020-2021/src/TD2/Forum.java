package TD2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Forum {
	private String nom;
	private Admin admin;
	private MessageManager mg;
	private ForumManager fm;
	private List<Member> member = new ArrayList<Member>();
	private List<Canal> canaux = new ArrayList<Canal>();
	
	
	public Forum(String n) {
		this(n, null);
	}
	
	public Forum(String n, MessageManager msgManager) {
		this.setNom(n);
		this.setMessageManager(msgManager);
	}
	
	public Message createMessage(String content, Member auth) {
		return this.getMessageManager().createMessage(content, auth);
	}

	public void addMessage(Message msg, String nomCanal) {
		this.getCanaux().get(getCanalId(nomCanal)).addMessage(msg);
	}

	public void createUser(String i) {
			boolean isAvaible = true;
			for (Member m : this.getMembers()) {
				if(m.getNom().equalsIgnoreCase(i)) {
					System.err.println("Un utilisateur a déja prit ce nom");
					isAvaible = !isAvaible;
				}
			}
			if(isAvaible) {
				this.addMember(new Member(i));
			}
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

	
	public List<Message> getLatestmsg(Member m, String canalName) {
		List<Message> l = new ArrayList<Message>();
			for (Message msg : this.getCanaux().get(getCanalId(canalName)).getLmsg()) {
				if(msg.getCreationDate().compareTo(Date.from(Instant.now() )) <= 10) {
					l.add(msg);
				}
			}
		m.lireMessage(l);
		return l;
	}
	
	public ForumManager getFm() {
		return fm;
	}

	public void setFm(ForumManager fm) {
		this.fm = fm;
	}
	

	@Override
	public String toString() {
		return this.getNom();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
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
		Forum other = (Forum) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public int getCanalId(String nomCanal) {
		int index = -1;
		for(int i = 0; i < this.getCanaux().size(); i++) {
			if(this.getCanaux().get(i).getNomCanal().equalsIgnoreCase(nomCanal)) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * @return the canal
	 */
	public List<Canal> getCanaux() {
		return canaux;
	}

	/**
	 * @param canaux the canal to set
	 */
	public void setCanaux(List<Canal> canaux) {
		this.canaux = canaux;
	}
	
}
