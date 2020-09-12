package TD1;

import java.util.ArrayList;
import java.util.List;

public class Member {

	private String nom;
	private List<Message> msg = new ArrayList<Message>();

	public Member() {
		this(null, null);
	}
	
	public Member(String n) {
		this(n, null);
	}
	
	public Member(String n, List<Message> m) {
		this.nom = n;
		this.msg = m;
	}
	
	// Operations

	public void envoyerMessage(Message m) {
		this.msg.add(m);
	}

	public boolean effacerMessage(Message m) {
		return this.nom.equalsIgnoreCase(m.getAuthor().getNom());
	}

	public void lireMessage(List<Message> l) {
		System.out.println(l.toString());
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Message> getMsg() {
		return msg;
	}

	public void setMsg(List<Message> msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Membre " + this.getNom() + "\n";
	}
}
