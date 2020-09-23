package TD2;

import java.util.ArrayList;
import java.util.List;

public class ForumManager {

	private List<Forum> l;
	
	public ForumManager() {
		l = new ArrayList<Forum>(1);
	}
	
	public Forum createForum(String s) {//On veut créer un forum en précisant le nom du forum.
		boolean doesExist = false;
		int index = -1;
		
		for (int i = 0; i < l.size(); i++) {
			if(l.get(i).getNom().equalsIgnoreCase(s) ) {
				doesExist = !doesExist;
				index = i;
			}
		}
		
		if(!doesExist) { //Si le forum n'existe pas, on le créer.
			return new Forum(s, new MessageManager());
		} else { //Si un forum avec ce nom existe déjà, il ne se passe rien. (On renvoi le Forum déjà existant 
			return l.get(index);
		}
	} 
	
	public List<Forum> getListeForum() {
		return this.l;
	}
	
}
