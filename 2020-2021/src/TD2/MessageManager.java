package TD2;

public class MessageManager {
	
	public MessageManager() {
	}
	
	public Message createMessage(String msg, Member auth) {
        Message m = new Message(msg, auth);
        auth.envoyerMessage(m);
        return m;
    }
    
    public boolean deleteMessage(Message msg, Member m) {
        if(m.effacerMessage(msg)) {
        	msg = null;
        	return true;
        } else {
        	return false;
        }
    }
    
    public void posterMessage() {
        //TODO
    }
    
}
