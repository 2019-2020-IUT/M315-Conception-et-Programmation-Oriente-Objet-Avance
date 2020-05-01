package designPattern.reseauSocial.core;

import designPattern.grapheX.Sommet;

public class Member extends Sommet implements MemberInterface  {

	private String localisation;
	private Enum<Strength> force;

	public Member(String nn) {
		super(nn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getLocation() {
		return this.localisation;
	}

	@Override
	public void setLocation(String s) {
		this.localisation = s;
	}

	@Override
	public String getName() {
		return super.toString();
	}

	public Enum<Strength> getForce() {
		return force;
	}

	public void setForce(Enum<Strength> force) {
		this.force = force;
	}
	
	public void addMember(String nom, String location, SocialNetworkInterface<Member> reseau) {
		Member m = new Member(nom);
		m.setLocation(location);
        reseau.addMember(m);
	}
	
}
