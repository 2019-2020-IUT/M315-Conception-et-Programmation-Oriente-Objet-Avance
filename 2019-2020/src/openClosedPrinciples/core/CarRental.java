package openClosedPrinciples.core;

import java.time.LocalDate;

/**
 * @author Mireille Blay-Fornarino
 *
 * 6 oct. 2018
 */
public class CarRental extends PayingItem {
	private String carNumber;
	private int duration;
	private LocalDate beginDate;
	
	
	/// Constructeurs 
	
	private CarRental(String carNumber, double dayPrice, int duration, LocalDate beginDate) {
		super(dayPrice);
		this.carNumber = carNumber;
		this.duration = duration;
		this.beginDate = beginDate;
	}
	
	public CarRental(Car c, LocalDate beginDate, int duration) {
		//On considere que le prix de la location ne doit plus bouger même si le prix de la voiture change
		this(c.getNumberPlate(),c.getDayPrice(),duration,beginDate);
	}

	
	/// Accesseurs et mutateurs 
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}
	
	
	/// Méthodes 
	
	// Récupérer le prix 
	public double getPrice() {
		return super.price*duration;
	}

	// Rechercher si dispo un jour 
	public boolean includeADate(LocalDate[] dates) {
		for (LocalDate d : dates) {
			if (d.equals(beginDate)) 
				return true;
			if ( (d.isAfter(beginDate)) && 
					(d.isBefore(beginDate.plusDays(duration) ) ) )
				return true;
		}
		return false;
	}

	// Afficher 
	@Override
	public String toString() {
		return "CarRental [carNumber=" + carNumber.toString() + ", duration=" + duration + ", beginDate=" + beginDate + ", price=" +super.toString() + "]";
	}
}
