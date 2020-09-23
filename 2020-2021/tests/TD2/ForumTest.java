package TD2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ForumTest {

	@Test
	void scenCreateForum() throws InterruptedException {
		//Un administrateur créer un forum en précisant le nom du forum. Il est alors administrateur du forum.
		ForumManager fm = new ForumManager();
		Admin stade = new Admin("oogle-stade", fm.createForum("OGCN"));
		stade.getForum().setAdmin(stade);	
		assertEquals("oogle-stade", stade.getForum().getAdmin().getNom());
	}
	
	@Test
	void scenCreateExistantForum() throws InterruptedException {
		//Un administrateur créer un forum mais un forum avec ce nom existe déjà donc on renvoi le forum existant.
		ForumManager fm = new ForumManager();
		Forum abcd = new Forum("abcd");	
		Admin stade = new Admin("oogle-stade", fm.createForum("abcd"));
		assertEquals(abcd, stade.getForum());
	}
	
	@Test
	void internauteDevientMembre() throws InterruptedException {
		ForumManager fm = new ForumManager();
		Admin stade = new Admin("oogle-stade", fm.createForum("OGCN"));
		stade.getForum().setFm(fm);
		stade.getForum().createUser("unPseudo");
	}
	
	@Test
	void forumHasCanal() throws InterruptedException {
		
	}
	


}
