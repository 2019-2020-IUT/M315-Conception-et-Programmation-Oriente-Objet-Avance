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

	public void envoyerMessage() {
		// TODO
	}

	public void effacerMessage() {
		// TODO
	}

	public void lireMessage() {
		// TODO
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
}
