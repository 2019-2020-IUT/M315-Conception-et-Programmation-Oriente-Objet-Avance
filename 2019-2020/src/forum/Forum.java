package forum;

public class Forum {

	private String title;
	private CanalParDefaut defaultCanal;

	public Forum(String nomForum) {
		this.title = nomForum;
		this.defaultCanal = new CanalParDefaut("defaut"); 
	}

	public String getTitle() {
		return title;
	}
	
}
