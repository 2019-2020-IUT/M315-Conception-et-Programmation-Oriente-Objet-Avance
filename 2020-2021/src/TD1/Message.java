package TD1;

import java.time.Instant;
import java.util.Date;

public class Message {

    private String content;
    private Member destinator;
    private Date creationDate;
   
    public Message() {
    	this(null);
    }
    
    public Message(String c) {
    	this(c, null);
    }
    
    public Message(String c, Member d) {
    	this.content = c;
    	this.setDestinator(d);
    	this.creationDate = Date.from(Instant.now());
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

	public Member getDestinator() {
		return destinator;
	}

	public void setDestinator(Member destinator) {
		this.destinator = destinator;
	}    
}
