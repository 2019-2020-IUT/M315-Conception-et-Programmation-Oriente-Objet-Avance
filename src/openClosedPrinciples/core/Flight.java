package openClosedPrinciples.core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/**
 * @author Mireille Blay-Fornarino
 *
 * 6 oct. 2018
 */
public class Flight extends PayingItem {
	private LocalDate departDate;
	private String departAirport;
	private String arrivalAirport;
	private LocalTime departTime;
	
	
	/// Constructeurs 
	
	public Flight(String departAirport) {
		this(-1, LocalDate.now(), LocalTime.now(), departAirport, "Paris");
	}
	
	public Flight(double price, LocalDate departDate, LocalTime departTime, String departAirport, String arrivalAirport) {
		super(price);
		this.departDate = departDate;
		this.departAirport = departAirport;
		this.arrivalAirport = arrivalAirport;
		this.departTime= departTime;
	}
	
	
	/// Accesseurs et mutateurs 
	
	public LocalTime getDepartTime() {
		return departTime;
	}
	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}
	public LocalDate getDepartDate() {
		return departDate;
	}
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	
	public String getDepartAirport() {
		return departAirport;
	}
	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}

	public double getPrice() {
		if (super.price == -1) {
		double start = 10;
		double end = 1000;
		double random = new Random().nextDouble();
		super.setPrice(start + (random * (end - start)));
		}
		return super.price;
	}

	
	/// Méthodes 
	
	// On voit si le vol correspond à celui entré en paramètres 
	public boolean match(LocalDate d, String from, String to) {
			return getDepartDate().equals(d) && getDepartAirport().equals(from) && getArrivalAirport().equals(to);
	}


	// Affichage 
	@Override
	public String toString() {
		return "Flight [price=" + super.toString() + ", departDate=" + departDate + ", departAirport=" + departAirport
				+ ", arrivalAirport=" + arrivalAirport + ", departTime=" + departTime + "]";
	}
}
