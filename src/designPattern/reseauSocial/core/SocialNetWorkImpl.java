package designPattern.reseauSocial.core;

import java.util.Collection;
import java.util.Observable;
import java.util.Set;

import designPattern.facebookGhost.FacebookGhostNetwork;
import designPattern.grapheSimple.GrapheSimple;

@SuppressWarnings("deprecation")
public class SocialNetWorkImpl implements SocialNetworkInterface<Member>{

	private String nom;
	private GrapheSimple<Member> reseau;
	
	public SocialNetWorkImpl() {
		this("Default");
	}
	
	public SocialNetWorkImpl(String n) {
		this.nom = n;
		reseau = new GrapheSimple<Member>();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member getMember(String identifier) {
		return reseau.getSommet(identifier);
	}

	@Override
	public Collection<Member> getMembers() {
		return reseau.sommets();
	}

	@Override
	public void addMember(Member m) {
		reseau.ajouterSommet(m);
	}

	@Override
	public Member addMember(String ident, FacebookGhostNetwork fg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member addMember(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void relate(Strength force, Member member, Member friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Member> relatedToRank(Member member, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int distance(Member member1, Member member2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}
	
	
}
