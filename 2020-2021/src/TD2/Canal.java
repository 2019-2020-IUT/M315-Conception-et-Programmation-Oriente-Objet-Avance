package TD2;

import java.util.ArrayList;
import java.util.List;

public class Canal {
	
    private int maxMessage;
    private String nomCanal;
    private Forum forum;
    private List<Message> lmsg = new ArrayList<Message>();
    
    public Canal(String nc, int mm) {
    	this.setNomCanal(nc);
    	this.setMaxMessage(mm);
    }
    
    public Canal(String nc) {
    	this(nc, 1000);
    }

    public void addMessage(Message m) {
    	this.getLmsg().add(m);
    }
    
	/**
	 * @return the maxMessage
	 */
	public int getMaxMessage() {
		return maxMessage;
	}

	/**
	 * @param maxMessage the maxMessage to set
	 */
	public void setMaxMessage(int maxMessage) {
		this.maxMessage = maxMessage;
	}

	/**
	 * @return the nomCanal
	 */
	public String getNomCanal() {
		return nomCanal;
	}

	/**
	 * @param nomCanal the nomCanal to set
	 */
	public void setNomCanal(String nomCanal) {
		this.nomCanal = nomCanal;
	}

	/**
	 * @return the lmsg
	 */
	public List<Message> getLmsg() {
		return lmsg;
	}

	/**
	 * @param lmsg the lmsg to set
	 */
	public void setLmsg(List<Message> lmsg) {
		this.lmsg = lmsg;
	}



}
