package TD1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ForumTest {

	@Test
	void testMainScenario() throws InterruptedException {
		//L'agence “oogle-stade” (Administrateur) crée un forum “OGCN”.
		Admin stade = new Admin("oogle-stade", new Forum("OGCN", new MessageManager()));
		stade.getForum().setAdmin(stade);
		
		//Initialisation du Forum avec les membres
		Member mario = new Member("Mario");
		Member walter = new Member("Walter");
		Member alban = new Member("Alban");
		stade.getForum().addMember(mario);
		stade.getForum().addMember(walter);
		stade.getForum().addMember(alban);
		List<Member> members = stade.getForum().getMembers();
		assertEquals(3, members.size());
		
		//Mario (Membre) poste un message WaitAndSee: “a quoi cela sert de courir?” sur le forum “OGCN”. 
		Message wait = stade.getForum().createMessage("a quoi cela sert de courir?", mario);
		stade.getForum().addMessage(wait);
		assertEquals(1, stade.getForum().getLmsg().size());
	
		//Walter (Membre) demande s'il y a de nouvelles informations sur le forum et obtient le message WaitAndSee. 
		//Il pose la même question un peu plus tard, et le système lui répond qu'il n'y a pas de nouveaux messages. 
		//Walter demande à lire tous les messages. 
		//Walter poste un message Yes : “Tout à fait d'accord!”. 
		List<Message> messages = stade.getForum().getLatestmsg(walter);
		assertTrue(messages.contains(wait));
		messages = stade.getForum().getLatestmsg(walter);
		assertEquals(0, messages.size());
		assertEquals(1, stade.getForum().getLmsg().size());
		Message yes = stade.getForum().createMessage("Tout à fait d'accord!", walter);
		stade.getForum().addMessage(yes);
		

		//Alban (Membre) demande s'il y a de nouveaux messages et obtient les messages WaitAndSee and Yes.
		messages = stade.getForum().getLatestmsg(alban);
		assertTrue(messages.contains(wait));
		assertTrue(messages.contains(yes));
		
		//Youcef s'inscrit sur le forum puis poste un message PFFF : “Vous rigolez?”. 
		Member youcef = new Member("Youcef");
		stade.getForum().addMember(youcef);
		Message pfff = stade.getForum().createMessage("Vous rigolez?", youcef);
		stade.getForum().addMessage(pfff);
		messages = stade.getForum().getLatestmsg(youcef);
		assertEquals(3, messages.size());
		messages = stade.getForum().getLatestmsg(youcef);
		assertEquals(0, messages.size());
		
		//Walter demande à lire les nouveaux messages.
		messages = stade.getForum().getLatestmsg(walter);
		assertEquals(2, messages.size());
		
		//Walter demande à effacer le message réalisé par Youcef, il n'a pas le droit, cela ne fait rien.
		messages = stade.getForum().getLmsg();
		int numberOfMessages = messages.size();
		
		boolean removed = stade.getForum().getMessageManager().deleteMessage(pfff, walter);
		assertFalse(removed);
		messages = stade.getForum().getLmsg();
		assertEquals(numberOfMessages,messages.size());
		
		//Youcef efface son message
		removed = stade.getForum().getMessageManager().deleteMessage(pfff, youcef);
		assertTrue(removed);
		messages = stade.getForum().getLmsg();
		assertEquals(numberOfMessages-1,messages.size(),"le message a bien été effacé");
		
		assertFalse(pfff.isOutOfDate(2));
		Thread.sleep(2001);
		assertTrue(pfff.isOutOfDate(2));
		//Les messages postés il y a plus de 10mn (adapté la durée pour les tests) sont détruits par “oogle-stade”.
	}

}
