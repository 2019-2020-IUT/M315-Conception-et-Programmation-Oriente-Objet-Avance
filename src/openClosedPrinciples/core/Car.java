package openClosedPrinciples.core;

/**
 * @author Mireille Blay-Fornarino
 *
 */

public class Car {
	private String numberPlate;
	private double dayPrice;
	
	
	/// Constructeurs 
	
	public Car(String numberPlate, double dayPrice) {
		super(); 
		this.numberPlate = numberPlate;
		this.dayPrice = dayPrice;
	}
	
	
	/// Accesseurs et mutateurs 
	
	public String getNumberPlate() {
		return numberPlate;
	}
	
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	
	public double getDayPrice() {
		return dayPrice;
	}
	
	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
	}

	
	/// Méthodes
	
	// Afficher 
	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + // ", rentals=" + rentals + 
				", dayPrice=" + super.toString() + "]";
	}
	
}
