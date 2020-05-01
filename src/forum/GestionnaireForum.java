package forum;

import java.util.HashMap;

public class GestionnaireForum {
	
	private static HashMap<String, Forum> forum = new HashMap<String, Forum>();

	public Forum getForum(String nomForum) {
		return forum.get(nomForum);
	}
	
	public void addForum(String nomForum) {
		if (!doesExist(nomForum)) {
			forum.put(nomForum, new Forum(nomForum));
			
		} else {
			System.out.println("erreur : Un forum du m�me nom existe d�j�.");
		}
	}
	
	public static boolean doesExist(String nom) {
		if (forum.containsKey(nom)) {
			return true;
		}
		return false;
	}
	
}
