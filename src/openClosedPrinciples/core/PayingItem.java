package openClosedPrinciples.core;

public abstract class PayingItem {
	protected double price; 
	
	/// Constructeurs 
	
	public PayingItem(double price) {
		this.price = price; 
	}

	
	/// Accesseurs et mutateurs 
	
	// Méthode abstraite parce que le calcul du prix n'est pas le même pour une voiture et pour une vol 
	public abstract double getPrice();

	public void setPrice(double price) {
		this.price = price;
	}

	
	/// Méthodes
	
	// Affichage 
	@Override
	public String toString() {
		return "" + price;
	}
}
