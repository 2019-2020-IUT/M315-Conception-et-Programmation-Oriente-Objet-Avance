package openClosedPrinciples.core;

import java.util.ArrayList;
import java.util.List;

public class Trip {
	private Description description; 
	private List<PayingItem> items; 
	
	/// Constructeurs
	
	// Vide
	public Trip() {
		description = null; 
		items = new ArrayList(); 
	}
	
	// Avec la description 
	public Trip(Description description) {
		this.description = description; 
		items = new ArrayList(); 
	}
	
	
	/// Accesseurs et mutateurs 

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public List<PayingItem> getItems() {
		return items;
	}

	public void setItems(List<PayingItem> items) {
		this.items = items;
	}
	
	
	/// Méthodes
	
	public void addItem(PayingItem item) {
		items.add(item); 
	}
}
