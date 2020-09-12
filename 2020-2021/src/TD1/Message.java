package TD1;

import java.time.Instant;
import java.util.Date;

public class Message {

    private String content;
    private Member author;
    private Date creationDate;
   
    public Message() {
    	this(null);
    }
    
    public Message(String c) {
    	this(c, null);
    }
    
    public Message(String c, Member a) {
    //Un message a un contenu et un'e aut'eur'rice
    	this.content = c;
    	this.setAuthor(a);
    	this.creationDate = Date.from(Instant.now());
	}
    
    @Override
    public String toString() {
    	return "Message de <<" + this.getAuthor() + ">> : " + this.getContent() + "\n";
    }

	public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

	public Member getAuthor() {
		return this.author;
	}

	public void setAuthor(Member author) {
		this.author = author;
	}
	
	public boolean isOutOfDate(Date creationDate, int secondsElapsed) {
		Date d = new Date();
        long ms = d.getTime();
        ms = ms - secondsElapsed*1000;
        d.setTime(ms);
        return creationDate.before(d);
	}
}
