package TD4.travel;

public class Trip implements Product {
	
	private Description desc;
	
	public Trip(Description d) {
		this.setDesc(d);
	}
	
	public double getPrice() {
		return .0;	
	}
	
	public void addItem() {
		
	}

	/**
	 * @return the desc
	 */
	public Description getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(Description desc) {
		this.desc = desc;
	}
}
