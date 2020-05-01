package forum;

import java.util.ArrayList;

public class Canal {
	
    private int maxMessage;
    private String nomCanal;
    private Message message;
    ArrayList canal = new ArrayList();
    
    public Canal(String nomCanal, int maxMessage) {
    	this.nomCanal = nomCanal;
    	this.maxMessage = maxMessage;
    }

}
